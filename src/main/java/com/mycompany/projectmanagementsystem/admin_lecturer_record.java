package com.mycompany.projectmanagementsystem;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class admin_lecturer_record extends javax.swing.JFrame {

    int numOfSchoolWise, numOfLecturer, numOfProjectManager;

    public admin_lecturer_record() {
        initComponents();
        setIconImage();
        readNumOfSchoolWise();
        readNumOfLecturer();
        printSchoolWiseTable();
        printLecturerTable();
    }

    private void readNumOfSchoolWise() {
        List<String> data = FileHandler.readFile("school_wise.txt");
        Object[] lines = data.toArray();
        numOfSchoolWise = lines.length;
        numSchoolWise.setText(String.valueOf(numOfSchoolWise));
    }

    private void readNumOfLecturer() {
        List<String> data = FileHandler.readFile("user.txt");
        Object[] lines = data.toArray();
        int countLecturer = 0;
        int countProjectManager = 0;
        for (int i = 0; i < lines.length; i++) {
            String record = lines[i].toString();
            String[] userData = record.split(";");

            String user = userData[10];
            if (user.equals("lecturer") || user.equals("project manager")) {
                countLecturer++;
                if (user.equals("project manager")) {
                    countProjectManager++;
                }
            }
        }
        numOfLecturer = countLecturer;
        numOfProjectManager = countProjectManager;
        numlecturer.setText(String.valueOf(numOfLecturer));
        numprojectmanager.setText(String.valueOf(numOfProjectManager));
    }

    public void printSchoolWiseTable() {
        DefaultTableModel model = (DefaultTableModel) school_wise_table.getModel();
        List<String> data = FileHandler.readFile("school_wise.txt");
        Object[] records = data.toArray();
        for(int i = 0; i<records.length; i++){
            String record = records[i].toString();
            String[] schoolWiseRow = {record};
            model.addRow(schoolWiseRow);
        }
        
    }
    
    public void printLecturerTable(){
        DefaultTableModel model = (DefaultTableModel) lecturer_table.getModel();
        DefaultTableModel model1 = (DefaultTableModel) projectmanager_table.getModel();
        List<String> data = FileHandler.readFile("user.txt");
        Object[] records = data.toArray();
        
        for(int i = 0; i<records.length; i++){
            String record = records[i].toString();
            String[] userData = record.split(";");
            String user = userData[10];
            if(user.equals("lecturer") || user.equals("project manager")){
                String[] lecturerRow = {userData[0], userData[1], userData[11], userData[8], userData[3]};
                model.addRow(lecturerRow);
                if(user.equals("project manager")){
                    String[] projectManagerRow = {userData[0], userData[1], userData[11], userData[8], userData[3]};
                    model1.addRow(projectManagerRow);
                    
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        admin_header = new javax.swing.JPanel();
        admin_lecturer = new javax.swing.JLabel();
        admin_student = new javax.swing.JLabel();
        admin_report = new javax.swing.JLabel();
        admin_profile = new javax.swing.JLabel();
        admin_logout = new javax.swing.JLabel();
        admin_logo = new javax.swing.JLabel();
        numprojectmanager = new javax.swing.JLabel();
        numlecturer = new javax.swing.JLabel();
        numSchoolWise = new javax.swing.JLabel();
        totallec_border = new javax.swing.JLabel();
        totallec_background = new javax.swing.JLabel();
        totalschool_background = new javax.swing.JLabel();
        totalschool_border = new javax.swing.JLabel();
        lecturer_record = new javax.swing.JTabbedPane();
        javax.swing.JScrollPane lectuter_record = new javax.swing.JScrollPane();
        lecturer_table = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        projectmanager_table = new javax.swing.JTable();
        javax.swing.JScrollPane schoolwise_record = new javax.swing.JScrollPane();
        school_wise_table = new javax.swing.JTable();
        totalpm_background = new javax.swing.JLabel();
        totalpm_border = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Record");
        setMaximumSize(new java.awt.Dimension(1000, 700));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(2, 50, 99));
        jLabel1.setText("Lecturer Record");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 250, 30));

        admin_header.setBackground(new Color(255, 255, 255, 90));
        admin_header.setToolTipText("");
        admin_header.setMaximumSize(new java.awt.Dimension(1000, 73));
        admin_header.setMinimumSize(new java.awt.Dimension(1000, 73));

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

        numprojectmanager.setFont(new java.awt.Font("Bell MT", 1, 48)); // NOI18N
        numprojectmanager.setForeground(new java.awt.Color(2, 50, 99));
        numprojectmanager.setText("jLabel2");
        getContentPane().add(numprojectmanager, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 130, 80, 50));

        numlecturer.setFont(new java.awt.Font("Bell MT", 1, 48)); // NOI18N
        numlecturer.setForeground(new java.awt.Color(2, 50, 99));
        numlecturer.setText("jLabel2");
        getContentPane().add(numlecturer, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 80, 40));

        numSchoolWise.setFont(new java.awt.Font("Bell MT", 1, 48)); // NOI18N
        numSchoolWise.setForeground(new java.awt.Color(2, 50, 99));
        numSchoolWise.setText("jLabel2");
        getContentPane().add(numSchoolWise, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 80, 40));

        totallec_border.setBackground(new Color(2, 50, 99, 0));
        totallec_border.setBorder(new LineBorder(new Color(192, 192, 192, 90), 15, true));
        totallec_border.setMaximumSize(new java.awt.Dimension(440, 125));
        totallec_border.setMinimumSize(new java.awt.Dimension(440, 125));
        totallec_border.setPreferredSize(new java.awt.Dimension(440, 125));
        getContentPane().add(totallec_border, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 300, 90));

        totallec_background.setBackground(new Color(192, 192, 192, 90));
        totallec_background.setFont(new java.awt.Font("Bell MT", 1, 20)); // NOI18N
        totallec_background.setForeground(new java.awt.Color(2, 50, 99));
        totallec_background.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        totallec_background.setText("Total Lecturer");
        totallec_background.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        totallec_background.setMaximumSize(new java.awt.Dimension(418, 123));
        totallec_background.setMinimumSize(new java.awt.Dimension(418, 123));
        totallec_background.setOpaque(true);
        totallec_background.setPreferredSize(new java.awt.Dimension(418, 123));
        getContentPane().add(totallec_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 280, 70));

        totalschool_background.setBackground(new Color(192, 192, 192, 90));
        totalschool_background.setFont(new java.awt.Font("Bell MT", 1, 20)); // NOI18N
        totalschool_background.setForeground(new java.awt.Color(2, 50, 99));
        totalschool_background.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        totalschool_background.setText("Total School Wise");
        totalschool_background.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        totalschool_background.setMaximumSize(new java.awt.Dimension(418, 123));
        totalschool_background.setMinimumSize(new java.awt.Dimension(418, 123));
        totalschool_background.setOpaque(true);
        totalschool_background.setPreferredSize(new java.awt.Dimension(418, 123));
        getContentPane().add(totalschool_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 280, 70));

        totalschool_border.setBackground(new Color(2, 50, 99, 0));
        totalschool_border.setBorder(new LineBorder(new Color(192, 192, 192, 90), 15, true));
        totalschool_border.setMaximumSize(new java.awt.Dimension(440, 125));
        totalschool_border.setMinimumSize(new java.awt.Dimension(440, 125));
        totalschool_border.setPreferredSize(new java.awt.Dimension(440, 125));
        getContentPane().add(totalschool_border, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 300, 90));

        lecturer_record.setOpaque(true);

        lecturer_table.setBackground(new java.awt.Color(192, 192, 192));
        lecturer_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "Name", "School Wise", "Email", "Contact Number", "Assign Project Manager", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        lectuter_record.setViewportView(lecturer_table);

        lecturer_record.addTab("Lecturer", lectuter_record);

        projectmanager_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "Name", "School Wise", "Email", "Contact Number", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(projectmanager_table);

        lecturer_record.addTab("Project Manager", jScrollPane1);

        school_wise_table.setBackground(new java.awt.Color(192, 192, 192));
        school_wise_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "School Wise", "Number Of Lecturer", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        school_wise_table.setRowHeight(30);
        schoolwise_record.setViewportView(school_wise_table);

        lecturer_record.addTab("School Wise List", schoolwise_record);

        getContentPane().add(lecturer_record, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 920, 370));
        lecturer_record.getAccessibleContext().setAccessibleName("\"student_record\"");
        lecturer_record.getAccessibleContext().setAccessibleDescription("");

        totalpm_background.setBackground(new Color(192, 192, 192, 90));
        totalpm_background.setFont(new java.awt.Font("Bell MT", 1, 20)); // NOI18N
        totalpm_background.setForeground(new java.awt.Color(2, 50, 99));
        totalpm_background.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        totalpm_background.setText("<html><div style= 'text-align: center; width: 100px;'>Total Project Manager</div></html>");
        totalpm_background.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        totalpm_background.setMaximumSize(new java.awt.Dimension(418, 123));
        totalpm_background.setMinimumSize(new java.awt.Dimension(418, 123));
        totalpm_background.setOpaque(true);
        totalpm_background.setPreferredSize(new java.awt.Dimension(418, 123));
        getContentPane().add(totalpm_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, 280, 70));

        totalpm_border.setBackground(new Color(2, 50, 99, 0));
        totalpm_border.setBorder(new LineBorder(new Color(192, 192, 192, 90), 15, true));
        totalpm_border.setMaximumSize(new java.awt.Dimension(440, 125));
        totalpm_border.setMinimumSize(new java.awt.Dimension(440, 125));
        totalpm_border.setPreferredSize(new java.awt.Dimension(440, 125));
        getContentPane().add(totalpm_border, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 110, 300, 90));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void admin_studentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_studentMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_admin_studentMouseClicked

    private void admin_logoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_logoMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_admin_logoMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_lecturer_record().setVisible(true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane lecturer_record;
    private javax.swing.JTable lecturer_table;
    private javax.swing.JLabel numSchoolWise;
    private javax.swing.JLabel numlecturer;
    private javax.swing.JLabel numprojectmanager;
    private javax.swing.JTable projectmanager_table;
    private javax.swing.JTable school_wise_table;
    private javax.swing.JLabel totallec_background;
    private javax.swing.JLabel totallec_border;
    private javax.swing.JLabel totalpm_background;
    private javax.swing.JLabel totalpm_border;
    private javax.swing.JLabel totalschool_background;
    private javax.swing.JLabel totalschool_border;
    // End of variables declaration//GEN-END:variables
}
