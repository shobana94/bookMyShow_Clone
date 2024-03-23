import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class VendorCheck {
    
    //static final String DB_NAME = "EventMgtDB";
    
    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost/bookmyshow";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "examly";

    // JDBC variables for opening, closing and managing connection
    private static Connection connection;
 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("aa gya");
            // Open a connection
            // Class.forName("com.jdbc.mysql.driver");
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Create a table to store event details if not exists
            //createMovieTable();

            // Prompt user to enter event details
            System.out.println("Enter movie name:");
            String movieName = scanner.nextLine();

            System.out.println("Enter total number of seats available:");
            int seats = scanner.nextInt();
            
            scanner.nextLine();

            System.out.println("Enter the time slot in foramt '03:00 PM' ie 'HH:MM AM/PM':");
            String timeSlot = scanner.nextLine();


            // Insert event details into the table
            insertMovieDetails(movieName, seats, timeSlot);

            System.out.println("Movie Scheduled created and movie details inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection and scanner
            try {
                if (connection != null) {
                    connection.close();
                }
                scanner.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // private static void createMovieTable() throws SQLException {
    //     String createTableSQL = "CREATE TABLE IF NOT EXISTS MovieSchedule (" +
    //                             "sId INT AUTO_INCREMENT PRIMARY KEY," +
    //                             "MovieName VARCHAR(255)," +
    //                             "AvlSeats VARCHAR(255)," +
    //                             "TimeSlot VARCHAR(255))";
        
    // //     PreparedStatement preparedStatement = connection.prepareStatement(createMovieTable);
    // //     preparedStatement.executeUpdate();
    // }

    private static void insertMovieDetails(String movieName, int seats, String timeSlot) throws SQLException {
        String insertSQL = "INSERT INTO MovieSchedule (MovieName, AvlSeats, TimeSlot) VALUES (?, ?, ?)";
        
        PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
        preparedStatement.setString(1, movieName);
        preparedStatement.setInt(2, seats);
        preparedStatement.setString(3, timeSlot);
        int in  = preparedStatement.executeUpdate();
        System.out.println(in);
    }
}