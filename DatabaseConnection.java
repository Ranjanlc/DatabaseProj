import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Default master authentication profile values for local XAMPP servers
    private static final String DB_USER = "root";
    private static final String DB_PASS = ""; // Intentionally left blank for XAMPP defaults
    private static Connection connection = null;

    /**
     * Initializes or switches the global connection database target instance
     */
    public static Connection connect(String dbName) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
        
        // standard XAMPP network address targeting port 3306 
        String url = "jdbc:mysql://localhost:3306/" + dbName;
        connection = DriverManager.getConnection(url, DB_USER, DB_PASS);
        return connection;
    }

    /**
     * Safely retrieves the current active database connection instance
     */
    public static Connection getConnection() {
        return connection;
    }
}
