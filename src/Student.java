import java.util.List;
// class person does ...
public class Student {
    private  int userID;
    private  String password;
    private int studentID;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String birthCertificateNumber;
    private String parentFirstName;
    private String parentLastName;
    private int parentID;  // Foreign Key referencing ParentTable
    private String email;
    private String postalAddress;
    private String physicalAddress;

    // Constructors
    public Student() {
        // Default constructor
    }

    public Student(int studentID, String firstName, String lastName, int age, String gender,
                   String birthCertificateNumber, String parentFirstName, String parentLastName,
                   int parentID, String email, String postalAddress, String physicalAddress, String password, int userID ) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.birthCertificateNumber = birthCertificateNumber;
        this.parentFirstName = parentFirstName;
        this.parentLastName = parentLastName;
        this.parentID = parentID;
        this.email = email;
        this.postalAddress = postalAddress;
        this.physicalAddress = physicalAddress;
        this.password = password;
        this.userID = userID;
    }

    public Student(int age, String birthCertificateNumber, String email, String firstName, String gender, String lastName, String parentFirstName, int parentID, String parentLastName, String physicalAddress, String postalAddress, int studentID, int userID, String password) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.birthCertificateNumber = birthCertificateNumber;
        this.parentFirstName = parentFirstName;
        this.parentLastName = parentLastName;
        this.parentID = parentID;
        this.email = email;
        this.postalAddress = postalAddress;
        this.physicalAddress = physicalAddress;
        this.password = password;
        this.userID = userID;
    }

    // Getters and Setters
    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthCertificateNumber() {
        return birthCertificateNumber;
    }

    public void setBirthCertificateNumber(String birthCertificateNumber) {
        this.birthCertificateNumber = birthCertificateNumber;
    }

    public String getParentFirstName() {
        return parentFirstName;
    }

    public void setParentFirstName(String parentFirstName) {
        this.parentFirstName = parentFirstName;
    }

    public String getParentLastName() {
        return parentLastName;
    }

    public void setParentLastName(String parentLastName) {
        this.parentLastName = parentLastName;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    // Additional Methods (You can add more based on your requirements)
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", birthCertificateNumber='" + birthCertificateNumber + '\'' +
                ", parentFirstName='" + parentFirstName + '\'' +
                ", parentLastName='" + parentLastName + '\'' +
                ", parentID=" + parentID +
                ", email='" + email + '\'' +
                ", postalAddress='" + postalAddress + '\'' +
                ", physicalAddress='" + physicalAddress + '\'' +
                ",userID='" +userID +'\'' +
                ",password='" + password +
                '}';
    }
}
