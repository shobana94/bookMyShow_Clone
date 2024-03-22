import java.sql.*;

public class App {

    // JDBC URL, username, and password of MySQL server
    private static final String URL = "jdbc:mysql://localhost:3306/bookmyshow";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // JDBC variables for opening, closing, and managing connection
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void main(String[] args) {
        try {
            // Connect to MySQL database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create statement
            statement = connection.createStatement();

            // Get email and password from customer
            String email = "goku2@gmail.com";
            String password = "kamehameha";

            // SQL query to check if the user exists in the signup table
            String query = "SELECT * FROM customer WHERE email = '" + email + "' AND password = '" + password + "'";

            // Execute the query
            resultSet = statement.executeQuery(query);

            // Check if the result set contains any rows
            if (resultSet.next()) {
                // User exists, login successful
                System.out.println("Successfully logged in.");
            } else {
                // User does not exist or incorrect credentials
                System.out.println("Wrong email or password.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close JDBC objects in finally block to ensure they're closed even if an exception occurs
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
