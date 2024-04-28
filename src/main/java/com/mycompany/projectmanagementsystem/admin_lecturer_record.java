package com.mycompany.projectmanagementsystem;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;

public class admin_lecturer_record extends javax.swing.JFrame {

    public admin_lecturer_record() {
        initComponents();
        setIconImage();
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
        totallec_border = new javax.swing.JLabel();
        totallec_background = new javax.swing.JLabel();
        totalschool_background = new javax.swing.JLabel();
        totalschool_border = new javax.swing.JLabel();
        student_record = new javax.swing.JTabbedPane();
        javax.swing.JScrollPane ec_approved_record = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        ec_rejeceted_record = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        totalpm_background = new javax.swing.JLabel();
        totalpm_border = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Record");
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

        student_record.setOpaque(true);

        jTable2.setBackground(new java.awt.Color(192, 192, 192));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null"
            }
        ));
        ec_approved_record.setViewportView(jTable2);

        student_record.addTab("School Wise List", ec_approved_record);

        jTable3.setBackground(new java.awt.Color(192, 192, 192));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ec_rejeceted_record.setViewportView(jTable3);

        student_record.addTab("Lecturer", ec_rejeceted_record);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        student_record.addTab("Project Manager", jScrollPane1);

        getContentPane().add(student_record, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 920, 370));
        student_record.getAccessibleContext().setAccessibleName("\"student_record\"");
        student_record.getAccessibleContext().setAccessibleDescription("");

        totalpm_background.setBackground(new Color(192, 192, 192, 90));
        totalpm_background.setFont(new java.awt.Font("Bell MT", 1, 20)); // NOI18N
        totalpm_background.setForeground(new java.awt.Color(2, 50, 99));
        totalpm_background.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        totalpm_background.setText("Total Project Manager");
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
    private javax.swing.JScrollPane ec_rejeceted_record;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTabbedPane student_record;
    private javax.swing.JLabel totallec_background;
    private javax.swing.JLabel totallec_border;
    private javax.swing.JLabel totalpm_background;
    private javax.swing.JLabel totalpm_border;
    private javax.swing.JLabel totalschool_background;
    private javax.swing.JLabel totalschool_border;
    // End of variables declaration//GEN-END:variables
}
