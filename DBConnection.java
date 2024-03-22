package movies;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//shobana
public class DBConnection {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e ) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/bookmyshow"; // Change according to your database
        String username = "root";
        String password = "Root";

        return DriverManager.getConnection(url, username, password);
    }
}
