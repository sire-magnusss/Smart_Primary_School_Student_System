import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentRegistrationGUI extends javax.swing.JFrame {

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel left;

    private StudentRegistrationController controller;

    public StudentRegistrationGUI(StudentRegistrationController controller) {
        this.controller = controller;
        initComponents();
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        left = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Registration");
        setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        left.setBackground(new java.awt.Color(153, 153, 153));
        left.setMinimumSize(new java.awt.Dimension(400, 500));

        jLabel1.setFont(new java.awt.Font("Neue Haas Grotesk Text Pro", 1, 48)); // NOI18N
        jLabel1.setText("Student Registration");

        jButton1.setText("Enter Student Details");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open a new window to gather student details or use JOptionPane for input
                // For simplicity, let's assume you have a method to gather student details
                Student student = gatherStudentDetails();
                // Register the student using the controller
                controller.registerStudent(student);
            }
        });

        GroupLayout leftLayout = new GroupLayout(left);
        left.setLayout(leftLayout);
        leftLayout.setHorizontalGroup(
                leftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(leftLayout.createSequentialGroup()
                                .addContainerGap(191, Short.MAX_VALUE)
                                .addGroup(leftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, leftLayout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(133, 133, 133))
                                        .addGroup(GroupLayout.Alignment.TRAILING, leftLayout.createSequentialGroup()
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(313, 313, 313))))
        );
        leftLayout.setVerticalGroup(
                leftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(leftLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel1)
                                .addGap(117, 117, 117)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(234, Short.MAX_VALUE))
        );

        jPanel1.add(left);
        left.setBounds(0, 0, 800, 500);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }

    private Student gatherStudentDetails() {
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter Age:"));
        String birthCertificateNumber = JOptionPane.showInputDialog("Enter Birth Certificate Number:");
        System.out.println("Birth Certificate Number entered: " + birthCertificateNumber);

        String email = JOptionPane.showInputDialog("Enter Email:");
        String firstName = JOptionPane.showInputDialog("Enter First Name:");
        String lastName = JOptionPane.showInputDialog("Enter Last Name:");
        String gender = JOptionPane.showInputDialog("Enter Gender:");
        String parentFirstName = JOptionPane.showInputDialog("Enter Parent's First Name:");
        int parentID = Integer.parseInt(JOptionPane.showInputDialog("Enter Parent ID:"));
        String parentLastName = JOptionPane.showInputDialog("Enter Parent's Last Name:");
        String physicalAddress = JOptionPane.showInputDialog("Enter Physical Address:");
        String postalAddress = JOptionPane.showInputDialog("Enter Postal Address:");
        int studentID = Integer.parseInt(JOptionPane.showInputDialog("Enter Student ID:"));
        int userID = Integer.parseInt(JOptionPane.showInputDialog("Enter User ID:"));
        String password = JOptionPane.showInputDialog("Enter Password:");

        return new Student(age, birthCertificateNumber, email, firstName, gender, lastName,
                parentFirstName, parentID, parentLastName, physicalAddress, postalAddress,
                studentID, userID, password);
    }


    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentRegistrationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            // Create an instance of StudentRegistrationController and pass it to the GUI
            StudentRegistrationController controller = new StudentRegistrationController(new DatabaseConnector());
            new StudentRegistrationGUI(controller).setVisible(true);
        });
    }
}
