import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TicketBooking {
    
    public static void bookTicket(String movieName, int seats) {
        String updateQuery = "UPDATE MovieSchedule SET AvlSeats = AvlSeats - ? WHERE MovieName = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(updateQuery)) {
            statement.setInt(1, seats);
            statement.setString(2, movieName);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0 ) {
                System.out.println("Ticket booked successfully for " + movieName);
            } else {
                System.out.println("Failed to book ticket.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateBookingDetails(String movieName, int seats) {
        String updateQuery = "INSERT INTO BookingDetails (MovieName, SeatsBooked) VALUES (?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(updateQuery)) {
                statement.setString(1, movieName);
                statement.setInt(2, seats);
                //statement.setString(3, timeSlot);
            int colsUpdated = statement.executeUpdate();
            if (colsUpdated > 0) {
                System.out.println();
            } else {
                System.out.println("Failed to book ticket.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
