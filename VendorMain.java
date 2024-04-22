
import java.sql.*;
import java.util.Scanner;

public class VendorMain {

public static void addSchedules() {
    Scanner scanner = new Scanner(System.in);
    
    while (true) {
        System.out.println("Enter 1 to  Allocate movies and timings, 2 to exit  :");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        if (choice == 1) {
            //String query = "SELECT * FROM MovieSchedule";

            String insertSQL = "INSERT INTO MovieSchedule (MovieName, AvlSeats, TimeSlot, ticket_price) VALUES (?, ?, ?, ?)";
            
            
            // Prompt user to enter event details
            System.out.println("Enter movie name:");
            String movieName = scanner.nextLine();
 
            System.out.println("Enter total number of seats available:");
            int seats = scanner.nextInt();
             
            scanner.nextLine();
 
            System.out.println("Enter the time slot in foramt '03:00 PM' ie 'HH:MM AM/PM':");
            String timeSlot = scanner.nextLine();
 
            System.out.println("Enter ticket price for a single ticket:");
            int ticketPrice = scanner.nextInt();
 
 
            // Insert event details into the table
            //insertMovieDetails(movieName, seats, timeSlot, ticketPrice);


        try(Connection conn = DBConnection.getConnection();
                    PreparedStatement preparedStatement = conn.prepareStatement(insertSQL)){
                    preparedStatement.setString(1, movieName);
                    preparedStatement.setInt(2, seats);
                    preparedStatement.setString(3, timeSlot);
                    preparedStatement.setInt(4, ticketPrice);
                    int in  = preparedStatement.executeUpdate();
                    System.out.println(in);
                    System.out.println("Movie Scheduled created and movie details inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            }
        } 
        else if (choice == 2) {
            System.out.println("Exiting application.");
            break;
        } else {
            System.out.println("Invalid choice. Please enter 1 or 2.");
        }
    }   
    scanner.close();
}
}




