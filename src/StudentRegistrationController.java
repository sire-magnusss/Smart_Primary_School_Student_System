import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentRegistrationController {
    private DatabaseConnector databaseConnector;

    public StudentRegistrationController(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    public void registerStudent(Student student) {
        try (Connection connection = databaseConnector.getConnection()) {
            String query = "INSERT INTO student (age, birthCertificateNumber, email, firstName, gender, lastName, " +
                    "parentFirstName, parentID, parentLastName, physicalAddress, postalAddress, studentID, userID, password) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                // Set values for the prepared statement, used to execute parameterised SQL queries
                preparedStatement.setInt(1, student.getAge());
                preparedStatement.setString(2, student.getBirthCertificateNumber());
                preparedStatement.setString(3, student.getEmail());
                preparedStatement.setString(4, student.getFirstName());
                preparedStatement.setString(5, student.getGender());
                preparedStatement.setString(6, student.getLastName());
                preparedStatement.setString(7, student.getParentFirstName());
                preparedStatement.setInt(8, student.getParentID());
                preparedStatement.setString(9, student.getParentLastName());
                preparedStatement.setString(10, student.getPhysicalAddress());
                preparedStatement.setString(11, student.getPostalAddress());
                preparedStatement.setInt(12, student.getStudentID());
                preparedStatement.setInt(13, student.getUserID());
                preparedStatement.setString(14, student.getPassword()); // Add password

                // Execute the query
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Student registered successfully!");
                } else {
                    System.out.println("Failed to register student. No rows affected.");
                }
            }
        } catch (SQLException e) {
            // Handle the exception according to your needs
            e.printStackTrace(); // This should be replaced with proper error handling
        }
    }
}
