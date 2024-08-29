public class Teacher {
    private int teacherID;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String qualifications;

    // Constructors
    public Teacher() {
        // Default constructor
    }

    public Teacher(int teacherID, String firstName, String lastName, int age, String gender, String qualifications) {
        this.teacherID = teacherID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.qualifications = qualifications;
    }

    // Getters and Setters
    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    // Additional Methods (You can add more based on your requirements)
    @Override
    public String toString() {
        return "Teacher{" +
                "teacherID=" + teacherID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", qualifications='" + qualifications + '\'' +
                '}';
    }
}
