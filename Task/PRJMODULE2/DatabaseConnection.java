package Task.PRJMODULE2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Adjust configurations below based on local engine properties
    private static final String URL = "jdbc:mysql://localhost/gcash_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("JDBC Driver footprint not found in path setup.", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
