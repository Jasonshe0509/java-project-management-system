   package com.mycompany.projectmanagementsystem;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import com.mycompany.projectmanagementsystem.Intake.IntakeController;
import com.mycompany.projectmanagementsystem.Intake.IntakeTableActionEvent;
import com.mycompany.projectmanagementsystem.IntakeTableActionPanel.IntakeTableActionCellEditor;
import com.mycompany.projectmanagementsystem.User.UserController;
import com.mycompany.projectmanagementsystem.User.UserTableActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class admin_student_management extends javax.swing.JFrame {

    private static admin_student_management instance;
    
    admin_view_studentrecord studentRecordInstace;
    int numOfIntake, numOfStudent;

    public admin_student_management() {
        initComponents();
        setIconImage();
        printStudentTable();
        printIntakeTable();
        readNumOfIntake();
        readNumOfStudent();

        IntakeTableActionPanel intakeAcitonPanel = new IntakeTableActionPanel();
        IntakeTableActionEvent intakeEvent;
        intakeEvent = new IntakeTableActionEvent() {

            public void intakeDelete(int row, Object value) {
                DefaultTableModel model = (DefaultTableModel) intake_table.getModel();
                int columnIndex = 0;
                String intakeID = (String) model.getValueAt(row, columnIndex);
                IntakeController action = new IntakeController();
                boolean result = action.intakeDelete(intakeID);
                if (result) {
                    JOptionPane.showMessageDialog(null, "Successfully delete the Intake: " + intakeID);
                    DefaultTableModel umodel = (DefaultTableModel) intake_table.getModel();
                    model.setNumRows(0);
                    printIntakeTable();
                    readNumOfIntake();
                }

            }
        };

        UserTableActionPanel actionPanel = new UserTableActionPanel();
        UserTableActionEvent event;
        event = new UserTableActionEvent() {

            @Override
            public void userView(int row, Object value) {

                DefaultTableModel model = (DefaultTableModel) student_table.getModel();
                int columnIndex = 0;
                String userID = (String) model.getValueAt(row, columnIndex);
                UserController action = new UserController();
                
                action.viewUser(userID);
                
                dispose();
                //System.out.print(Arrays.toString(userDetails));
                //admin_view_studentrecord studentDetails = new admin_view_studentrecord();
                //admin_view_studentrecord.displayStudentDetails(userDetails);
                //studentDetails.show();
            }

            @Override
            public void userDelete(int row, Object value) {
                DefaultTableModel model = (DefaultTableModel) student_table.getModel();
                int columnIndex = 0;
                String userID = (String) model.getValueAt(row, columnIndex);
                UserController action = new UserController();
                boolean result = action.userDelete(userID);
                if (result) {
                    JOptionPane.showMessageDialog(null, "Successfully delete the Student: " + userID);
                    DefaultTableModel umodel = (DefaultTableModel) student_table.getModel();
                    umodel.setNumRows(0);
                    printStudentTable();
                    readNumOfStudent();
                }
            }
        };
        student_table.getColumnModel().getColumn(5).setCellRenderer(actionPanel.new rPanelActionRenderer());
        student_table.getColumnModel().getColumn(5).setCellEditor(actionPanel.new UserTableActionCellEditor(event));
        
        intake_table.getColumnModel().getColumn(5).setCellRenderer(intakeAcitonPanel.new rPanelActionRenderer());
        intake_table.getColumnModel().getColumn(5).setCellEditor(intakeAcitonPanel.new IntakeTableActionCellEditor(intakeEvent));
    }

    private void readNumOfIntake() {
        List<String> data = FileHandler.readFile("intake.txt");
        Object[] lines = data.toArray();
        numOfIntake = lines.length;
        label_num_intake.setText(String.valueOf(numOfIntake));
    }

    private void readNumOfStudent() {
        List<String> data1 = FileHandler.readFile("user.txt");
        Object[] lines1 = data1.toArray();
        int countStudent = 0;
        for (int i = 0; i < lines1.length; i++) {

            String record = lines1[i].toString();
            String[] userData = record.split(";");

            String user = userData[10];
            if (user.equals("student")) {
                countStudent++;
            }

        }
        numOfStudent = countStudent;
        label_num_student.setText(String.valueOf(numOfStudent));
    }

    public void printIntakeTable() {

        DefaultTableModel model = (DefaultTableModel) intake_table.getModel();
        model.setRowCount(0);
        List<String> data = FileHandler.readFile("intake.txt");
        Object[] records = data.toArray();

        for (int i = 0; i < records.length; i++) {
            String record = records[i].toString();
            String[] intakeData = record.split(";");
            String intakeDate = intakeData[4] + "/" + intakeData[5];
            String[] intakeRow = {intakeData[0], intakeData[1], intakeData[2], intakeData[3], intakeDate};
            model.addRow(intakeRow);

        }
    }

    public void printStudentTable() {

        DefaultTableModel model = (DefaultTableModel) student_table.getModel();
        model.setRowCount(0);
        List<String> data = FileHandler.readFile("user.txt");
        Object[] records = data.toArray();

        for (int i = 0; i < records.length; i++) {
            String record = records[i].toString();
            String[] userData = record.split(";");

            String user = userData[10];
            if (user.equals("student")) {
                String[] studentRow = {userData[0], userData[1], userData[11], userData[8], userData[3]};
                model.addRow(studentRow);
            }

        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_num_student = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        admin_header = new javax.swing.JPanel();
        admin_lecturer = new javax.swing.JLabel();
        admin_student = new javax.swing.JLabel();
        admin_report = new javax.swing.JLabel();
        admin_profile = new javax.swing.JLabel();
        admin_logout = new javax.swing.JLabel();
        admin_logo = new javax.swing.JLabel();
        label_num_intake = new javax.swing.JLabel();
        totalstudent_border = new javax.swing.JLabel();
        totalintake_background = new javax.swing.JLabel();
        totalstudent_background = new javax.swing.JLabel();
        totalintake_border = new javax.swing.JLabel();
        student_record = new javax.swing.JTabbedPane();
        javax.swing.JScrollPane ec_approved_record = new javax.swing.JScrollPane();
        intake_table = new javax.swing.JTable();
        ec_rejeceted_record = new javax.swing.JScrollPane();
        student_table = new javax.swing.JTable();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Record");
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_num_student.setFont(new java.awt.Font("Bell MT", 1, 100)); // NOI18N
        label_num_student.setForeground(new java.awt.Color(2, 50, 99));
        label_num_student.setText("jLabel2");
        getContentPane().add(label_num_student, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 140, 130, 90));

        jLabel1.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(2, 50, 99));
        jLabel1.setText("Student Record");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 250, 30));

        admin_header.setBackground(new Color(255, 255, 255, 90));
        admin_header.setToolTipText("");
        admin_header.setMaximumSize(new java.awt.Dimension(1000, 73));
        admin_header.setMinimumSize(new java.awt.Dimension(1000, 73));
        admin_header.setPreferredSize(new java.awt.Dimension(1000, 73));

        admin_lecturer.setBackground(new Color(255, 255, 255, 0));
        admin_lecturer.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        admin_lecturer.setForeground(new java.awt.Color(2, 50, 99));
        admin_lecturer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_lecturer.setText("Lecturer");
        admin_lecturer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admin_lecturer.setMaximumSize(new java.awt.Dimension(96, 73));
        admin_lecturer.setMinimumSize(new java.awt.Dimension(96, 73));
        admin_lecturer.setPreferredSize(new java.awt.Dimension(96, 73));

        admin_student.setBackground(new Color(255, 255, 255, 0));
        admin_student.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        admin_student.setForeground(new java.awt.Color(2, 50, 99));
        admin_student.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_student.setText("Student");
        admin_student.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admin_student.setMaximumSize(new java.awt.Dimension(96, 73));
        admin_student.setMinimumSize(new java.awt.Dimension(96, 73));
        admin_student.setPreferredSize(new java.awt.Dimension(96, 73));
        admin_student.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_studentMouseClicked(evt);
            }
        });

        admin_report.setBackground(new Color(255, 255, 255, 0));
        admin_report.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        admin_report.setForeground(new java.awt.Color(2, 50, 99));
        admin_report.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_report.setText("Report");
        admin_report.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admin_report.setMaximumSize(new java.awt.Dimension(96, 73));
        admin_report.setMinimumSize(new java.awt.Dimension(96, 73));
        admin_report.setPreferredSize(new java.awt.Dimension(96, 73));

        admin_profile.setBackground(new Color(255, 255, 255, 0));
        admin_profile.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        admin_profile.setForeground(new java.awt.Color(2, 50, 99));
        admin_profile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_profile.setText("Profile");
        admin_profile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admin_profile.setMaximumSize(new java.awt.Dimension(96, 73));
        admin_profile.setMinimumSize(new java.awt.Dimension(96, 73));
        admin_profile.setPreferredSize(new java.awt.Dimension(96, 73));

        admin_logout.setBackground(new Color(255, 255, 255, 0));
        admin_logout.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        admin_logout.setForeground(new java.awt.Color(2, 50, 99));
        admin_logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_logout.setText("Log Out");
        admin_logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admin_logout.setMaximumSize(new java.awt.Dimension(96, 73));
        admin_logout.setMinimumSize(new java.awt.Dimension(96, 73));
        admin_logout.setPreferredSize(new java.awt.Dimension(96, 73));

        admin_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sysco_logo.png"))); // NOI18N
        admin_logo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_logoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout admin_headerLayout = new javax.swing.GroupLayout(admin_header);
        admin_header.setLayout(admin_headerLayout);
        admin_headerLayout.setHorizontalGroup(
            admin_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(admin_headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(admin_logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 294, Short.MAX_VALUE)
                .addComponent(admin_lecturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(admin_student, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(admin_report, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(admin_profile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(admin_logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        admin_headerLayout.setVerticalGroup(
            admin_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(admin_headerLayout.createSequentialGroup()
                .addGroup(admin_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(admin_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(admin_report, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(admin_profile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(admin_logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, admin_headerLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(admin_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(admin_student, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(admin_lecturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(admin_headerLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(admin_logo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(admin_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        label_num_intake.setFont(new java.awt.Font("Bell MT", 1, 100)); // NOI18N
        label_num_intake.setForeground(new java.awt.Color(2, 50, 99));
        label_num_intake.setText("jLabel2");
        getContentPane().add(label_num_intake, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 130, 90));

        totalstudent_border.setBackground(new Color(2, 50, 99, 0));
        totalstudent_border.setBorder(new LineBorder(new Color(192, 192, 192, 90), 15, true));
        totalstudent_border.setMaximumSize(new java.awt.Dimension(440, 125));
        totalstudent_border.setMinimumSize(new java.awt.Dimension(440, 125));
        totalstudent_border.setPreferredSize(new java.awt.Dimension(440, 125));
        getContentPane().add(totalstudent_border, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 460, 150));

        totalintake_background.setBackground(new Color(192, 192, 192, 90));
        totalintake_background.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        totalintake_background.setForeground(new java.awt.Color(2, 50, 99));
        totalintake_background.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        totalintake_background.setText("Total Intake");
        totalintake_background.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        totalintake_background.setMaximumSize(new java.awt.Dimension(418, 123));
        totalintake_background.setMinimumSize(new java.awt.Dimension(418, 123));
        totalintake_background.setOpaque(true);
        totalintake_background.setPreferredSize(new java.awt.Dimension(418, 123));
        getContentPane().add(totalintake_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 440, 130));

        totalstudent_background.setBackground(new Color(192, 192, 192, 90));
        totalstudent_background.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        totalstudent_background.setForeground(new java.awt.Color(2, 50, 99));
        totalstudent_background.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        totalstudent_background.setText("Total Student");
        totalstudent_background.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        totalstudent_background.setMaximumSize(new java.awt.Dimension(418, 123));
        totalstudent_background.setMinimumSize(new java.awt.Dimension(418, 123));
        totalstudent_background.setOpaque(true);
        totalstudent_background.setPreferredSize(new java.awt.Dimension(418, 123));
        getContentPane().add(totalstudent_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, 440, 130));

        totalintake_border.setBackground(new Color(2, 50, 99, 0));
        totalintake_border.setBorder(new LineBorder(new Color(192, 192, 192, 90), 15, true));
        totalintake_border.setMaximumSize(new java.awt.Dimension(440, 125));
        totalintake_border.setMinimumSize(new java.awt.Dimension(440, 125));
        totalintake_border.setPreferredSize(new java.awt.Dimension(440, 125));
        getContentPane().add(totalintake_border, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 460, 150));

        student_record.setOpaque(true);

        intake_table.setBackground(new java.awt.Color(192, 192, 192));
        intake_table.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        intake_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Intake Code", "School Wise", "Level Of Education", "Course Name", "Enrolled Date", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        intake_table.setRowHeight(30);
        ec_approved_record.setViewportView(intake_table);

        student_record.addTab("Intake", ec_approved_record);

        student_table.setBackground(new java.awt.Color(192, 192, 192));
        student_table.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        student_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Intake Code", "Email Address", "Contact Number", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        student_table.setRowHeight(30);
        ec_rejeceted_record.setViewportView(student_table);

        student_record.addTab("Student", ec_rejeceted_record);

        getContentPane().add(student_record, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 920, 300));
        student_record.getAccessibleContext().setAccessibleName("\"student_record\"");
        student_record.getAccessibleContext().setAccessibleDescription("");

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void admin_studentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_studentMouseClicked
        // TODO add your handling code here:
        admin_student admin_stu = new admin_student();
        admin_stu.show();
        dispose();
    }//GEN-LAST:event_admin_studentMouseClicked

    private void admin_logoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_logoMouseClicked
        // TODO add your handling code here:
        admin_mainpage admin_main = new admin_mainpage();
        admin_main.show();
        dispose();
    }//GEN-LAST:event_admin_logoMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_student_management().setVisible(true);
            }
        });
    }

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon_with_background.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel admin_header;
    private javax.swing.JLabel admin_lecturer;
    private javax.swing.JLabel admin_logo;
    private javax.swing.JLabel admin_logout;
    private javax.swing.JLabel admin_profile;
    private javax.swing.JLabel admin_report;
    private javax.swing.JLabel admin_student;
    private javax.swing.JLabel background;
    private javax.swing.JScrollPane ec_rejeceted_record;
    private javax.swing.JTable intake_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel label_num_intake;
    private javax.swing.JLabel label_num_student;
    private javax.swing.JTabbedPane student_record;
    private javax.swing.JTable student_table;
    private javax.swing.JLabel totalintake_background;
    private javax.swing.JLabel totalintake_border;
    private javax.swing.JLabel totalstudent_background;
    private javax.swing.JLabel totalstudent_border;
    // End of variables declaration//GEN-END:variables
}
