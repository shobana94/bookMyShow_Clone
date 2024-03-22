package movies;
import java.sql.*;
import java.util.Scanner;

public class signUpmodule {
    // JDBC URL, username, and password of MySQL server
    private static final String URL = "jdbc:mysql://localhost:3306/bookmyshow";
    private static final String USER = "root";
    private static final String PASSWORD = "Chandu@23";

    // JDBC variables for opening, closing, and managing connection
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // Connect to MySQL database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create statement
            statement = connection.createStatement();

            // Get user details for signup
            System.out.println("Enter your name:");
            String name = sc.nextLine();

            System.out.println("Enter your phone number:");
            String phoneNumber = sc.nextLine();

            System.out.println("Enter your email ID:");
            String email = sc.nextLine();

            System.out.println("Enter your password:");
            String password = sc.nextLine();

            System.out.println("Confirm your password:");
            String confirmPassword = sc.nextLine();

            // Check if passwords match
            if (!password.equals(confirmPassword)) {
                System.out.println("Passwords do not match. Signup failed.");
                return; // Exit the program if passwords don't match
            }

            // SQL query to insert user details into the customer table
            String query = "INSERT INTO customer (Cname, Cphn, Cmail, Cpass, CconfirmPass) VALUES (?, ?, ?, ?, ?)";

            // Create PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phoneNumber);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, confirmPassword);
            sc.close();
            // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Signup successful.");
            } else {
                System.out.println("Signup failed. Please try again.");
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

