import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    // Method for student login
    public boolean studentLogin(int userID, String password) {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM User WHERE userID = ? AND password = ? AND userType = 'registrar'";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, userID);
                preparedStatement.setString(2, password);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Login successful
                        openDashboard("Student");  // You can pass the user type for customization
                        return true;
                    } else {
                        // Login failed
                        return false;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Handle exceptions appropriately in your application
            return false;
        }
    }

    // Other methods for different types of logins can be added here

    private void openDashboard(String userType) {



        DashboardGUI dashboard = new DashboardGUI();
        dashboard.setVisible(true);
    }
}
