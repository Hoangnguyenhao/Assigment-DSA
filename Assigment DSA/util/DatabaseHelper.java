package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {

    // Database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/personal_budget";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Create and return a connection to the database
    public static Connection getConnection() throws SQLException {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Return the connection
            return DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Error while connecting to the database: " + e.getMessage());
        }
    }

    // Optionally, you can add methods for querying the database or closing the connection
}
