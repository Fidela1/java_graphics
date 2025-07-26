import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test {
    public static Connection connect() {
        Connection conn = null;
        try {
            // Load the driver (optional in newer versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database URL, username, password
            String url = "jdbc:mysql://localhost:3306/student_db"; // Change DB name
            String user = "root"; // Default XAMPP username
            String pass = "";     // Default XAMPP password is empty

            // Connect
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("✅ Database Connected Successfully!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("❌ Connection Failed: " + e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) {
        connect();
    }
}

