public class StudentClassAssociation {
    private int studentID;  // Foreign Key referencing StudentTable
    private int classID;    // Foreign Key referencing ClassTable

    // Constructors
    public StudentClassAssociation() {
        // Default constructor
    }

    public StudentClassAssociation(int studentID, int classID) {
        this.studentID = studentID;
        this.classID = classID;
    }

    // Getters and Setters
    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    // Additional Methods (You can add more based on your requirements)
    @Override
    public String toString() {
        return "StudentClassAssociation{" +
                "studentID=" + studentID +
                ", classID=" + classID +
                '}';
    }
}
