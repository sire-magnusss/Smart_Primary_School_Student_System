import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassAssociationController {

    // Method to associate a student with a class
    public boolean associateStudentWithClass(int classID,int studentID) {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "INSERT INTO StudentClassAssociation (classID, studentID) VALUES (?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, studentID);
                preparedStatement.setInt(2, classID);

                // Execute the update
                int rowsAffected = preparedStatement.executeUpdate();

                // If rowsAffected > 0, it means the association was successful
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Handle exceptions appropriately in your application
            return false;
        }
    }

    // Method to get students associated with a class
    public List<Student> getStudentsInClass(int classID) {
        List<Student> studentList = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {

// Assuming i have a StudentClassAssociation table with columns userID and classID
            String query = "SELECT * FROM StudentClassAssociation " +
                    "JOIN Student ON StudentClassAssociation.studentID = Student.studentID " +
                    "WHERE StudentClassAssociation.classID = ?";




            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, classID);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Student student = new Student();
                        student.setStudentID(resultSet.getInt("studentID"));
                        student.setFirstName(resultSet.getString("firstName"));
                        student.setLastName(resultSet.getString("lastName"));
                        student.setAge(resultSet.getInt("age"));
                        student.setBirthCertificateNumber(resultSet.getString("birthCertificateNumber"));
                        student.setEmail(resultSet.getString("email"));
                        student.setGender(resultSet.getString("gender"));
                        student.setParentFirstName(resultSet.getString("parentFirstName"));
                        student.setParentID(resultSet.getInt("parentID"));
                        student.setParentLastName(resultSet.getString("parentLastName"));
                        student.setPassword(resultSet.getString("password"));
                        student.setPhysicalAddress(resultSet.getString("physicalAddress"));
                        student.setPostalAddress(resultSet.getString("postalAddress"));
                        student.setUserID(resultSet.getInt("userID"));
                        // Set other attributes as needed

                        studentList.add(student);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Handle exceptions appropriately in your application
        }

        return studentList;
    }

    // You can add other methods related to class associations here
}
