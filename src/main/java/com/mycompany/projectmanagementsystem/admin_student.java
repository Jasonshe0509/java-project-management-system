package com.mycompany.projectmanagementsystem;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;

public class admin_student extends javax.swing.JFrame {

    
    public admin_student() {
        initComponents();
        setIconImage();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        admin_header = new javax.swing.JPanel();
        admin_lecturer = new javax.swing.JLabel();
        admin_student = new javax.swing.JLabel();
        admin_report = new javax.swing.JLabel();
        admin_profile = new javax.swing.JLabel();
        admin_logout = new javax.swing.JLabel();
        admin_logo = new javax.swing.JLabel();
        admin_intakei = new javax.swing.JLabel();
        admin_reg_intake = new javax.swing.JLabel();
        intake_background = new javax.swing.JLabel();
        admin_studenti = new javax.swing.JLabel();
        admin_reg_student = new javax.swing.JLabel();
        regstu_background = new javax.swing.JLabel();
        admin_eci = new javax.swing.JLabel();
        admin_ec_management = new javax.swing.JLabel();
        ecmanage_background = new javax.swing.JLabel();
        admin_stu_managementi = new javax.swing.JLabel();
        admin_stu_management = new javax.swing.JLabel();
        stumanage_background = new javax.swing.JLabel();
        admin_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin: Student Management");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        admin_logo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 300, Short.MAX_VALUE)
                .addComponent(admin_lecturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addGroup(admin_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admin_logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(admin_profile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(admin_report, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(admin_student, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(admin_lecturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(admin_headerLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(admin_logo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(admin_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        admin_intakei.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Intake_icon.png"))); // NOI18N
        getContentPane().add(admin_intakei, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        admin_reg_intake.setBackground(new Color(76, 127, 174, 0));
        admin_reg_intake.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        admin_reg_intake.setForeground(new java.awt.Color(2, 50, 99));
        admin_reg_intake.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_reg_intake.setText("Register New Intake");
        admin_reg_intake.setBorder(new LineBorder(new Color(192, 192, 192, 90), 15, true));
        admin_reg_intake.setMaximumSize(new java.awt.Dimension(380, 240));
        admin_reg_intake.setMinimumSize(new java.awt.Dimension(380, 240));
        admin_reg_intake.setOpaque(true);
        admin_reg_intake.setPreferredSize(new java.awt.Dimension(380, 240));
        admin_reg_intake.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_reg_intakeMouseClicked(evt);
            }
        });
        getContentPane().add(admin_reg_intake, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        intake_background.setBackground(new Color(192, 192, 192, 90));
        intake_background.setOpaque(true);
        getContentPane().add(intake_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 360, 220));
        intake_background.getAccessibleContext().setAccessibleName("intake_background");

        admin_studenti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Student_icon.png"))); // NOI18N
        getContentPane().add(admin_studenti, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, -1, -1));

        admin_reg_student.setBackground(new Color(192, 192, 192, 90));
        admin_reg_student.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        admin_reg_student.setForeground(new java.awt.Color(2, 50, 99));
        admin_reg_student.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_reg_student.setText("Register New Student");
        admin_reg_student.setBorder(new LineBorder(new Color(192, 192, 192, 90), 15, true));
        admin_reg_student.setMaximumSize(new java.awt.Dimension(380, 240));
        admin_reg_student.setMinimumSize(new java.awt.Dimension(380, 240));
        admin_reg_student.setOpaque(true);
        admin_reg_student.setPreferredSize(new java.awt.Dimension(380, 240));
        admin_reg_student.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_reg_studentMouseClicked(evt);
            }
        });
        getContentPane().add(admin_reg_student, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, -1, -1));

        regstu_background.setBackground(new Color(192, 192, 192, 90));
        regstu_background.setOpaque(true);
        getContentPane().add(regstu_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 360, 220));

        admin_eci.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EC_icon.png"))); // NOI18N
        getContentPane().add(admin_eci, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, -1, -1));

        admin_ec_management.setBackground(new Color(192, 192, 192, 90));
        admin_ec_management.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        admin_ec_management.setForeground(new java.awt.Color(2, 50, 99));
        admin_ec_management.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_ec_management.setText("EC Management");
        admin_ec_management.setBorder(new LineBorder(new Color(192, 192, 192, 90), 15, true));
        admin_ec_management.setMaximumSize(new java.awt.Dimension(380, 240));
        admin_ec_management.setMinimumSize(new java.awt.Dimension(380, 240));
        admin_ec_management.setOpaque(true);
        admin_ec_management.setPreferredSize(new java.awt.Dimension(380, 240));
        admin_ec_management.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_ec_managementMouseClicked(evt);
            }
        });
        getContentPane().add(admin_ec_management, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, -1, -1));

        ecmanage_background.setBackground(new Color(192, 192, 192, 90));
        ecmanage_background.setOpaque(true);
        getContentPane().add(ecmanage_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 360, 220));
        ecmanage_background.getAccessibleContext().setAccessibleName("ecmanage_background");

        admin_stu_managementi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Setting_icon.png"))); // NOI18N
        getContentPane().add(admin_stu_managementi, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, -1, -1));
        admin_stu_managementi.getAccessibleContext().setAccessibleDescription("");

        admin_stu_management.setBackground(new Color(192, 192, 192, 90));
        admin_stu_management.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        admin_stu_management.setForeground(new java.awt.Color(2, 50, 99));
        admin_stu_management.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_stu_management.setText("View Intale/ Student");
        admin_stu_management.setBorder(new LineBorder(new Color(192, 192, 192, 90), 15, true));
        admin_stu_management.setMaximumSize(new java.awt.Dimension(380, 240));
        admin_stu_management.setMinimumSize(new java.awt.Dimension(380, 240));
        admin_stu_management.setOpaque(true);
        admin_stu_management.setPreferredSize(new java.awt.Dimension(380, 240));
        admin_stu_management.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_stu_managementMouseClicked(evt);
            }
        });
        getContentPane().add(admin_stu_management, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, -1, -1));

        stumanage_background.setBackground(new Color(192, 192, 192, 90));
        stumanage_background.setOpaque(true);
        getContentPane().add(stumanage_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 380, 360, 220));

        admin_background.setBackground(new java.awt.Color(76, 127, 174));
        admin_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        admin_background.setText("Good Day Admin!");
        admin_background.setMaximumSize(new java.awt.Dimension(1000, 700));
        admin_background.setMinimumSize(new java.awt.Dimension(1000, 700));
        admin_background.setOpaque(true);
        admin_background.setPreferredSize(new java.awt.Dimension(1000, 700));
        getContentPane().add(admin_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void admin_reg_intakeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_reg_intakeMouseClicked
//        // TODO add your handling code here:
//        admin_register_intake admin_regintake = new admin_register_intake();
//        admin_regintake.show();
        
    }//GEN-LAST:event_admin_reg_intakeMouseClicked

    private void admin_reg_studentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_reg_studentMouseClicked
//        // TODO add your handling code here:
//        admin_register_student admin_regstu = new admin_register_student();
//        admin_regstu.show();
        
    }//GEN-LAST:event_admin_reg_studentMouseClicked

    private void admin_ec_managementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_ec_managementMouseClicked
//        // TODO add your handling code here:
//        admin_ec_management admin_ec_manage = new admin_ec_management();
//        admin_ec_manage.show();
//        dispose();
    }//GEN-LAST:event_admin_ec_managementMouseClicked

    private void admin_stu_managementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_stu_managementMouseClicked
//        // TODO add your handling code here:
//        admin_student_management admin_stumanage = new admin_student_management();
//        admin_stumanage.show();
//        dispose();
    }//GEN-LAST:event_admin_stu_managementMouseClicked

    private void admin_logoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_logoMouseClicked
        // TODO add your handling code here:
        admin_mainpage admin_main = new admin_mainpage();
        admin_main.show();
        dispose();
    }//GEN-LAST:event_admin_logoMouseClicked

    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new admin_student().setVisible(true);
        });
    }
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon_with_background.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel admin_background;
    private javax.swing.JLabel admin_ec_management;
    private javax.swing.JLabel admin_eci;
    private javax.swing.JPanel admin_header;
    private javax.swing.JLabel admin_intakei;
    private javax.swing.JLabel admin_lecturer;
    private javax.swing.JLabel admin_logo;
    private javax.swing.JLabel admin_logout;
    private javax.swing.JLabel admin_profile;
    private javax.swing.JLabel admin_reg_intake;
    private javax.swing.JLabel admin_reg_student;
    private javax.swing.JLabel admin_report;
    private javax.swing.JLabel admin_stu_management;
    private javax.swing.JLabel admin_stu_managementi;
    private javax.swing.JLabel admin_student;
    private javax.swing.JLabel admin_studenti;
    private javax.swing.JLabel ecmanage_background;
    private javax.swing.JLabel intake_background;
    private javax.swing.JLabel regstu_background;
    private javax.swing.JLabel stumanage_background;
    // End of variables declaration//GEN-END:variables
}
