package Task.PRJMODULE2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankingService {
     public static void checkBalance(String userId) {
        String sql = "SELECT name, balance FROM users WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Holder: " + rs.getString("name") + " | Balance: PHP " + rs.getDouble("balance"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Balance lookup failed: " + e.getMessage());
        }
    }

    public static void transferFunds(String senderId, String recipientNumber, double amount) {
        String deductSql = "UPDATE users SET balance = balance - ? WHERE id = ? AND balance >= ?";
        String creditSql = "UPDATE users SET balance = balance + ? WHERE number = ?";

        Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false); // Enable manual transaction block boundary

            // 1. Deduct from Sender
            try (PreparedStatement stmtDeduct = conn.prepareStatement(deductSql)) {
                stmtDeduct.setDouble(1, amount);
                stmtDeduct.setString(2, senderId);
                stmtDeduct.setDouble(3, amount);
                int rowsAffected = stmtDeduct.executeUpdate();
                if (rowsAffected == 0) throw new SQLException("Insufficient funds or invalid profile identity.");
            }

            // 2. Add to Recipient
            try (PreparedStatement stmtCredit = conn.prepareStatement(creditSql)) {
                stmtCredit.setDouble(1, amount);
                stmtCredit.setString(2, recipientNumber);
                int rowsAffected = stmtCredit.executeUpdate();
                if (rowsAffected == 0) throw new SQLException("Recipient transfer mobile endpoint not found.");
            }

            conn.commit(); // Push structural modifications atomically
            System.out.println("Transaction Completed Successfully via Database Ledger Commit.");

        } catch (SQLException e) {
            if (conn != null) {
                try { conn.rollback(); System.out.println("Transaction rolled back safely."); } catch (SQLException ex) { ex.printStackTrace(); }
            }
            throw new RuntimeException("Financial Processing Terminated: " + e.getMessage());
        } finally {
            if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
    }

    public static String getGuiBalanceString(String userId) {
        String sql = "SELECT name, account_number, balance FROM users WHERE id = ?";
        try (java.sql.Connection conn = DatabaseConnection.getConnection();
             java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, userId);
            try (java.sql.ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return "Account Holder: " + rs.getString("name") + "\n" +
                            "Account Number: " + rs.getString("account_number") + "\n" +
                            "Available Balance: PHP " + String.format("%.2Fi", rs.getDouble("balance"));
                }
            }
        } catch (Exception e) {
            return "Failed reading data elements: " + e.getMessage();
        }
        return "Identity session expired.";
    }
}
