package movies;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieSearch {
    public static void searchMovie(String movieName) {
        String query = "SELECT * FROM MovieSchedule WHERE MovieName = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, movieName);
            ResultSet result = statement.executeQuery();
            
            if (result.next()) {
                System.out.println("Movie available");
                System.out.println("Available seats: " + result.getInt("AvlSeats"));
                System.out.println("Time slot: " + result.getTime("TimeSlot"));
            } else {
                System.out.println("Movie not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
