import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassAssociationGUI extends JFrame {

    private JButton jButton1;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel left;

    public ClassAssociationGUI() {
        initComponents();
    }

    private void initComponents() {
        jPanel1 = new JPanel();
        left = new JPanel();
        jLabel1 = new JLabel();
        jButton1 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Class Association");
        setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        left.setBackground(new java.awt.Color(153, 153, 153));
        left.setMinimumSize(new java.awt.Dimension(400, 500));

        jLabel1.setFont(new java.awt.Font("Neue Haas Grotesk Text Pro", 1, 48));
        jLabel1.setText("Class Association");

        jButton1.setText("Associate student with class");

        // Add ActionListener to jButton1
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                associateStudentWithClass();
            }
        });

        GroupLayout leftLayout = new GroupLayout(left);
        left.setLayout(leftLayout);
        leftLayout.setHorizontalGroup(
                leftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(leftLayout.createSequentialGroup()
                                .addContainerGap(220, Short.MAX_VALUE)
                                .addGroup(leftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, leftLayout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(172, 172, 172))
                                        .addGroup(GroupLayout.Alignment.TRAILING, leftLayout.createSequentialGroup()
                                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                                                .addGap(294, 294, 294))))
        );
        leftLayout.setVerticalGroup(
                leftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(leftLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel1)
                                .addGap(117, 117, 117)
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
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

        getAccessibleContext().setAccessibleName("ClassAssociation");

        pack();
    }

    private void associateStudentWithClass() {
        // Here you should implement your logic to associate student with a class.
        // For simplicity, let's show a message.

        String studentIDString = JOptionPane.showInputDialog(this, "Enter Student ID:");
        String classIDString = JOptionPane.showInputDialog(this, "Enter Class ID:");

        try {
            int studentID = Integer.parseInt(studentIDString);
            int classID = Integer.parseInt(classIDString);

            ClassAssociationController controller = new ClassAssociationController();
            boolean success = controller.associateStudentWithClass(studentID, classID);

            if (success) {
                JOptionPane.showMessageDialog(this, "Student associated with class successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to associate student with class.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter numeric values for Student ID and Class ID.");
        }
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClassAssociationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new ClassAssociationGUI().setVisible(true);
        });
    }
}
