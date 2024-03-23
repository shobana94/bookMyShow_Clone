

import java.sql.Connection;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketDisplay {
    
    public static void displayTicket() {
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("     Movie Ticket Bill");
        System.out.println("----------------------------");
        

        try (Connection conn = DBConnection.getConnection();
            Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM BookingDetails");
            if (resultSet.next()) {
                String movieName = resultSet.getString("MovieName");
                int bookedSeats = resultSet.getInt("SeatsBooked");
                //String timeSlot = resultSet.getString("TimeSlot").toString();
                // Display movie details
                System.out.println("Movie: " + movieName);
                System.out.println("Number of Tickets: " + bookedSeats);
                //System.out.println("Showtime: " + timeSlot);
                System.out.println();
                int ticketPrice = 150;
                // Display summary
                System.out.println("----------------------------");
                System.out.println("        Summary");
                System.out.println("----------------------------");
                System.out.println("Total Tickets: " + bookedSeats);
                System.out.println("Ticket Amount: $" + ticketPrice);
                System.out.println("Total Amount: $" + (bookedSeats * ticketPrice));
                System.out.println();
                System.out.println("Thank you for booking with us!");
                System.out.println();
            } else {
                System.out.println("Failed to retrieve booking details.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}