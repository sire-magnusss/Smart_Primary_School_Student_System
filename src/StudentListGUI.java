import javax.swing.*;
import java.awt.*;

public class StudentListGUI extends JFrame {

    private JPanel jPanel1;
    private JPanel left;
    private JLabel jLabel1;
    private JButton jButton1;
    private JTextArea jTextArea1; // Updated to use JTextArea for displaying student names

    private StudentListController controller;

    public StudentListGUI(StudentListController controller) {
        this.controller = controller;
        initComponents();
    }

    private void initComponents() {
        jPanel1 = new JPanel();
        left = new JPanel();
        jLabel1 = new JLabel();
        jButton1 = new JButton();
        jTextArea1 = new JTextArea(); // Updated to use JTextArea
        JScrollPane scrollPane = new JScrollPane(jTextArea1); // Add a scroll pane for JTextArea

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student List");
        setPreferredSize(new Dimension(800, 500));

        jPanel1.setBackground(new Color(204, 204, 204));
        jPanel1.setPreferredSize(new Dimension(800, 500));
        jPanel1.setLayout(new GridLayout(1, 2));

        left.setBackground(new Color(153, 153, 153));
        left.setMinimumSize(new Dimension(400, 500));

        jLabel1.setFont(new Font("Neue Haas Grotesk Text Pro", Font.BOLD, 48));
        jLabel1.setText("Student List");

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new Color(102, 102, 102));
        jTextArea1.setText("Student names will be displayed here."); // Initial text

        jButton1.setText("List Students Per Class");
        jButton1.addActionListener(e -> controller.listStudents());

        GroupLayout leftLayout = new GroupLayout(left);
        left.setLayout(leftLayout);
        leftLayout.setHorizontalGroup(
                leftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(leftLayout.createSequentialGroup()
                                .addContainerGap(275, Short.MAX_VALUE)
                                .addGroup(leftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, leftLayout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(251, 251, 251))
                                        .addGroup(GroupLayout.Alignment.TRAILING, leftLayout.createSequentialGroup()
                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
                                                .addGap(224, 224, 224))
                                        .addGroup(GroupLayout.Alignment.TRAILING, leftLayout.createSequentialGroup()
                                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                                                .addGap(302, 302, 302))))
        );
        leftLayout.setVerticalGroup(
                leftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(leftLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel1)
                                .addGap(34, 34, 34)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(88, Short.MAX_VALUE))
        );

        jPanel1.add(left);

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

        getAccessibleContext().setAccessibleName("StudentList");

        pack();
    }

    public JButton getJButton1() {
        return jButton1;
    }

    // Getter for the JTextArea
    public JTextArea getJTextArea1() {
        return jTextArea1;
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
            java.util.logging.Logger.getLogger(StudentListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            StudentListController controller = new StudentListController();
            StudentListGUI gui = new StudentListGUI(controller);
            controller.setView(gui); // Make sure to set the view here
            gui.setVisible(true);
        });
    }
}
