package Task.PRJMODULE2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.regex.Pattern;

public class AuthService {
    private static boolean isValidEmail(String email) {
        return Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$").matcher(email).matches();
    }

    private static boolean isValidNumber(String number) {
        return Pattern.compile("^09\\d{9}$").matcher(number).matches();
    }

    private static boolean isValidPin(String pin) {
        return Pattern.compile("^\\d{4,6}$").matcher(pin).matches();
    }

    private static String hashPin(String pin) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(pin.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Encryption processing failure.");
        }
    }

    // Custom Registration Logic binding directly to Live SQL Tables
    public static void registerUser(String id, String name, String email, String number, String pin, double initialBalance) {
        if (!isValidEmail(email)) throw new IllegalArgumentException("Invalid email pattern.");
        if (!isValidNumber(number)) throw new IllegalArgumentException("Invalid PH mobile formatting.");
        if (!isValidPin(pin)) throw new IllegalArgumentException("PIN constraints violated (4-6 digits required).");

        String secureHash = hashPin(pin);
        String generatedAccNum = "1000" + (int)(Math.random() * 900000);

        String sql = "INSERT INTO users (id, name, email, number, pin, account_number, balance) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.setString(2, name);
            stmt.setString(3, email);
            stmt.setString(4, number);
            stmt.setString(5, secureHash);
            stmt.setString(6, generatedAccNum);
            stmt.setDouble(7, initialBalance);

            stmt.executeUpdate();
            System.out.println("Persistent Data Bound! Registered Identity ID: " + id);

        } catch (SQLException e) {
            throw new RuntimeException("Database Operation Failed: " + e.getMessage());
        }
    }

    // Login Authentication executing over real-time SQL evaluations
    public static String login(String number, String pin) {
        String sql = "SELECT id, pin FROM users WHERE number = ?";
        String enteredHash = hashPin(pin);

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, number);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String storedHash = rs.getString("pin");
                    if (storedHash.equals(enteredHash)) {
                        String userId = rs.getString("id");
                        System.out.println("Database Login Authentication Confirmed for ID: " + userId);
                        return userId;
                    }
                }
            }
            throw new SecurityException("Access Denied: Invalid parameters matched.");
        } catch (SQLException e) {
            throw new RuntimeException("System lookup error: " + e.getMessage());
        }
    }
}
