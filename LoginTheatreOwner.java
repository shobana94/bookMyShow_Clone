import java.sql.*;
import java.util.Scanner;
import java.util.*;
import java.sql.*;
public class LoginTheatreOwner {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost/bookmyshow";
        String USER = "root";
        String PASSWORD = "password";
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Scanner scanner = new Scanner(System.in);
            String email =scanner.nextLine();
            String password = scanner.nextLine();
            String query = "SELECT * FROM theatreowner WHERE username = '" + email + "' AND password = '" + password + "'";
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                System.out.println("Successfully logged in.");
            } else {
                System.out.println("Wrong email or password.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}