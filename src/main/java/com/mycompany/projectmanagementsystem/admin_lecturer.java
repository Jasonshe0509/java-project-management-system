package com.mycompany.projectmanagementsystem;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;

public class admin_lecturer extends javax.swing.JFrame {

    
    public admin_lecturer() {
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
        admin_school_wise = new javax.swing.JLabel();
        admin_reg_school = new javax.swing.JLabel();
        school_background = new javax.swing.JLabel();
        admin_lectureri = new javax.swing.JLabel();
        admin_reg_lecturer = new javax.swing.JLabel();
        reglec_background = new javax.swing.JLabel();
        project_managei = new javax.swing.JLabel();
        admin_projectmanager = new javax.swing.JLabel();
        projectmanager_background = new javax.swing.JLabel();
        admin_lec_managementi = new javax.swing.JLabel();
        admin_lec_management = new javax.swing.JLabel();
        lecmanage_background = new javax.swing.JLabel();
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

        admin_school_wise.setIcon(new javax.swing.ImageIcon(getClass().getResource("/School_wise list_icon.png"))); // NOI18N
        getContentPane().add(admin_school_wise, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        admin_reg_school.setBackground(new Color(76, 127, 174, 0));
        admin_reg_school.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        admin_reg_school.setForeground(new java.awt.Color(2, 50, 99));
        admin_reg_school.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_reg_school.setText("<html><div style='text-align: center; width: 200px;'>Register School Wise List</div></html>");
        admin_reg_school.setBorder(new LineBorder(new Color(192, 192, 192, 90), 15, true));
        admin_reg_school.setMaximumSize(new java.awt.Dimension(380, 240));
        admin_reg_school.setMinimumSize(new java.awt.Dimension(380, 240));
        admin_reg_school.setOpaque(true);
        admin_reg_school.setPreferredSize(new java.awt.Dimension(380, 240));
        admin_reg_school.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_reg_schoolMouseClicked(evt);
            }
        });
        getContentPane().add(admin_reg_school, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        school_background.setBackground(new Color(192, 192, 192, 90));
        school_background.setOpaque(true);
        getContentPane().add(school_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 360, 220));
        school_background.getAccessibleContext().setAccessibleName("intake_background");

        admin_lectureri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Lecturer_icon.png"))); // NOI18N
        getContentPane().add(admin_lectureri, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, -1, -1));

        admin_reg_lecturer.setBackground(new Color(192, 192, 192, 90));
        admin_reg_lecturer.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        admin_reg_lecturer.setForeground(new java.awt.Color(2, 50, 99));
        admin_reg_lecturer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_reg_lecturer.setText("<html><div style='text-align: center; width: 200px;'>Register New Lecturer</div></html>");
        admin_reg_lecturer.setBorder(new LineBorder(new Color(192, 192, 192, 90), 15, true));
        admin_reg_lecturer.setMaximumSize(new java.awt.Dimension(380, 240));
        admin_reg_lecturer.setMinimumSize(new java.awt.Dimension(380, 240));
        admin_reg_lecturer.setOpaque(true);
        admin_reg_lecturer.setPreferredSize(new java.awt.Dimension(380, 240));
        admin_reg_lecturer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_reg_lecturerMouseClicked(evt);
            }
        });
        getContentPane().add(admin_reg_lecturer, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, -1, -1));

        reglec_background.setBackground(new Color(192, 192, 192, 90));
        reglec_background.setOpaque(true);
        getContentPane().add(reglec_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 360, 220));

        project_managei.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_manager_icon.png"))); // NOI18N
        getContentPane().add(project_managei, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, -1, -1));

        admin_projectmanager.setBackground(new Color(192, 192, 192, 90));
        admin_projectmanager.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        admin_projectmanager.setForeground(new java.awt.Color(2, 50, 99));
        admin_projectmanager.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_projectmanager.setText("<html><div style='text-align: center; width: 200px;'>Assign Project Manager</div></html>");
        admin_projectmanager.setBorder(new LineBorder(new Color(192, 192, 192, 90), 15, true));
        admin_projectmanager.setMaximumSize(new java.awt.Dimension(380, 240));
        admin_projectmanager.setMinimumSize(new java.awt.Dimension(380, 240));
        admin_projectmanager.setOpaque(true);
        admin_projectmanager.setPreferredSize(new java.awt.Dimension(380, 240));
        admin_projectmanager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_projectmanagerMouseClicked(evt);
            }
        });
        getContentPane().add(admin_projectmanager, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, -1, -1));

        projectmanager_background.setBackground(new Color(192, 192, 192, 90));
        projectmanager_background.setOpaque(true);
        getContentPane().add(projectmanager_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 360, 220));
        projectmanager_background.getAccessibleContext().setAccessibleName("ecmanage_background");

        admin_lec_managementi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Setting_icon.png"))); // NOI18N
        getContentPane().add(admin_lec_managementi, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 380, 80, 80));
        admin_lec_managementi.getAccessibleContext().setAccessibleName("");
        admin_lec_managementi.getAccessibleContext().setAccessibleDescription("");

        admin_lec_management.setBackground(new Color(192, 192, 192, 90));
        admin_lec_management.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        admin_lec_management.setForeground(new java.awt.Color(2, 50, 99));
        admin_lec_management.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_lec_management.setText("<html><div style='text-align: center; width: 200px;'>View Lecturer/ Project Manager</div></html>");
        admin_lec_management.setBorder(new LineBorder(new Color(192, 192, 192, 90), 15, true));
        admin_lec_management.setMaximumSize(new java.awt.Dimension(380, 240));
        admin_lec_management.setMinimumSize(new java.awt.Dimension(380, 240));
        admin_lec_management.setOpaque(true);
        admin_lec_management.setPreferredSize(new java.awt.Dimension(380, 240));
        admin_lec_management.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_lec_managementMouseClicked(evt);
            }
        });
        getContentPane().add(admin_lec_management, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, -1, -1));

        lecmanage_background.setBackground(new Color(192, 192, 192, 90));
        lecmanage_background.setOpaque(true);
        getContentPane().add(lecmanage_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 380, 360, 220));

        admin_background.setBackground(new java.awt.Color(76, 127, 174));
        admin_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        admin_background.setMaximumSize(new java.awt.Dimension(1000, 700));
        admin_background.setMinimumSize(new java.awt.Dimension(1000, 700));
        admin_background.setOpaque(true);
        admin_background.setPreferredSize(new java.awt.Dimension(1000, 700));
        getContentPane().add(admin_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void admin_reg_schoolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_reg_schoolMouseClicked
        // TODO add your handling code here:
        admin_register_intake admin_regintake = new admin_register_intake();
        admin_regintake.show();
        
    }//GEN-LAST:event_admin_reg_schoolMouseClicked

    private void admin_reg_lecturerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_reg_lecturerMouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_admin_reg_lecturerMouseClicked

    private void admin_projectmanagerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_projectmanagerMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_admin_projectmanagerMouseClicked

    private void admin_lec_managementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_lec_managementMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_admin_lec_managementMouseClicked

    private void admin_logoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_logoMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_admin_logoMouseClicked

    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new admin_lecturer().setVisible(true);
        });
    }
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon_with_background.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel admin_background;
    private javax.swing.JPanel admin_header;
    private javax.swing.JLabel admin_lec_management;
    private javax.swing.JLabel admin_lec_managementi;
    private javax.swing.JLabel admin_lecturer;
    private javax.swing.JLabel admin_lectureri;
    private javax.swing.JLabel admin_logo;
    private javax.swing.JLabel admin_logout;
    private javax.swing.JLabel admin_profile;
    private javax.swing.JLabel admin_projectmanager;
    private javax.swing.JLabel admin_reg_lecturer;
    private javax.swing.JLabel admin_reg_school;
    private javax.swing.JLabel admin_report;
    private javax.swing.JLabel admin_school_wise;
    private javax.swing.JLabel admin_student;
    private javax.swing.JLabel lecmanage_background;
    private javax.swing.JLabel project_managei;
    private javax.swing.JLabel projectmanager_background;
    private javax.swing.JLabel reglec_background;
    private javax.swing.JLabel school_background;
    // End of variables declaration//GEN-END:variables
}
