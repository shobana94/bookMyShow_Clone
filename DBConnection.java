
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // static {
    //     try {
    //         Class.forName("com.mysql.cj.jdbc.Driver");
    //     } catch (ClassNotFoundException e ) {
    //         e.printStackTrace();
    //     }
    // }

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost/bookmyshow"; 
        String username = "root";
        String password = "examly";

        return DriverManager.getConnection(url, username, password);
    }
}

