import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentListController {

    private StudentListGUI view;

    // Default constructor
    public StudentListController() {
        // You can initialize the view later using a setter method if needed
    }

    // Constructor with a view parameter
    public StudentListController(StudentListGUI view) {
        this.view = view;
        view.getJButton1().addActionListener(e -> listStudents());
    }

    // Setter method for the view
    public void setView(StudentListGUI view) {
        this.view = view;
        view.getJButton1().addActionListener(e -> listStudents());
    }

    public StudentListGUI getView() {
        return view;
    }

    public void listStudents() {
        String selectedClass = JOptionPane.showInputDialog("Enter class:");
        if (selectedClass != null) {
            List<String> students = getStudentsByClass(selectedClass);
            displayStudents(students);
        }
    }

    private List<String> getStudentsByClass(String selectedClass) {
        List<String> students = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "SELECT Student.studentID, firstName, lastName \n" +
                    "FROM Student, studentclassassociation \n" +
                    "WHERE studentclassassociation.classID = ? \n" +
                    "AND Student.studentID=studentclassassociation.studentID\n";

// Set values for the prepared statement, used to execute parameterised SQL queries
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, selectedClass);
//Result set is for the output of a query execution against a database
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String studentName = resultSet.getString("firstName") + " " + resultSet.getString("lastName");
                        students.add(studentName);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return students;
    }

    private void displayStudents(List<String> students) {
        StringBuilder studentsText = new StringBuilder();
        for (String student : students) {
            studentsText.append(student).append("\n");
        }
        view.getJTextArea1().setText(studentsText.toString());
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            StudentListController controller = new StudentListController();
            StudentListGUI gui = new StudentListGUI(controller);
            controller.setView(gui);
            gui.setVisible(true);
        });
    }
}
