package movies;
import java.sql.Connection;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Enter 1 to book ticket for a movie, 2 to exit:");
            int choice = scanner.nextInt();
            
            if (choice == 1) {
                String query = "SELECT * FROM MovieSchedule";
        
            try (Connection conn = DBConnection.getConnection();
             Statement statement = conn.createStatement()) {
             ResultSet result = statement.executeQuery(query);
            
            System.out.println("Available Movies!");
            while (result.next()) {
                System.out.println(result.getString("MovieName"));}
            // } else {
            //     System.out.println("Movie not found.");
            // }
        } catch (SQLException e) {
            e.printStackTrace();
        }

                System.out.println("Enter the name of the movie:");
                scanner.nextLine(); 
                String movieName = scanner.nextLine();
                MovieSearch.searchMovie(movieName);
                
                System.out.println("Enter the number of seats you want:");
                int seats = scanner.nextInt();
                TicketBooking.bookTicket(movieName, seats);
                
                TicketDisplay.displayTicket(movieName, "Timing"); 
            } else if (choice == 2) {
                System.out.println("Exiting application.");
                break;
            } else {
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        }
        
        scanner.close();
    }
}
