package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:qwerty://localhost:6224/hospital_qb";
    private static final String USER = "qwerty";
    private static final String PASSWORD = "brocode";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("\nDatabase connection established!");
        } catch (SQLException e) {
            System.out.println("\nFailed to connect to database!");
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("\nDatabase connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
