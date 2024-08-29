public class Class {
    private int classID;
    private String className;

    // Constructors
    public Class() {
        // Default constructor
    }

    public Class(int classID, String className) {
        this.classID = classID;
        this.className = className;
    }

    // Getters and Setters
    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    // Additional Methods (You can add more based on your requirements)
    @Override
    public String toString() {
        return "Class{" +
                "classID=" + classID +
                ", className='" + className + '\'' +
                '}';
    }
}
