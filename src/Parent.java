public class Parent {
    private int parentID;
    private String parentFirstName;
    private String parentLastName;
    private String email;
    private String postalAddress;
    private String physicalAddress;

    // Constructors
    public Parent() {
        // Default constructor
    }

    public Parent(int parentID, String parentFirstName, String parentLastName,
                  String email, String postalAddress, String physicalAddress) {
        this.parentID = parentID;
        this.parentFirstName = parentFirstName;
        this.parentLastName = parentLastName;
        this.email = email;
        this.postalAddress = postalAddress;
        this.physicalAddress = physicalAddress;
    }

    // Getters and Setters
    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
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
    @Override
    public String toString() {
        return "Parent{" +
                "parentID=" + parentID +
                ", parentFirstName='" + parentFirstName + '\'' +
                ", parentLastName='" + parentLastName + '\'' +
                ", email='" + email + '\'' +
                ", postalAddress='" + postalAddress + '\'' +
                ", physicalAddress='" + physicalAddress + '\'' +
                '}';
    }
}
