/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projectmanagementsystem;

import java.awt.Color;
import java.awt.Toolkit;

/**
 *
 * @author ASUS
 */
public class StudentEcSubmissionPage extends javax.swing.JFrame {

    /**
     * Creates new form StudentEcSubmissionPage
     */
    public StudentEcSubmissionPage() {
        initComponents();
        setIconImage();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        studentHeader = new javax.swing.JPanel();
        studentLogo = new javax.swing.JLabel();
        studentEcSubmission = new javax.swing.JLabel();
        studentNotification = new javax.swing.JLabel();
        studentProfile = new javax.swing.JLabel();
        studentLogout = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student EC Submission");
        setMaximumSize(new java.awt.Dimension(1000, 700));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(27, 61, 96));
        jButton1.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Create");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 90, 100, 40));

        jLabel7.setFont(new java.awt.Font("Bell MT", 1, 28)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(2, 50, 99));
        jLabel7.setText("EC Submission");
        jLabel7.setMaximumSize(new java.awt.Dimension(275, 47));
        jLabel7.setMinimumSize(new java.awt.Dimension(275, 47));
        jLabel7.setPreferredSize(new java.awt.Dimension(275, 47));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 275, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "EC ID", "EC Reason", "Assessment", "Submitted Link", "Status", "Action"
            }
        ));
        jTable1.setMaximumSize(new java.awt.Dimension(961, 532));
        jTable1.setMinimumSize(new java.awt.Dimension(961, 532));
        jTable1.setPreferredSize(new java.awt.Dimension(961, 532));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 940, 530));

        studentHeader.setBackground(new Color(255, 255, 255, 90));
        studentHeader.setToolTipText("");
        studentHeader.setMaximumSize(new java.awt.Dimension(1000, 73));
        studentHeader.setMinimumSize(new java.awt.Dimension(1000, 73));

        studentLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sysco_logo.png"))); // NOI18N
        studentLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentLogoMouseClicked(evt);
            }
        });

        studentEcSubmission.setBackground(new Color(255, 255, 255, 0));
        studentEcSubmission.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        studentEcSubmission.setForeground(new java.awt.Color(2, 50, 99));
        studentEcSubmission.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentEcSubmission.setText("EC Submission");
        studentEcSubmission.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentEcSubmission.setMaximumSize(new java.awt.Dimension(96, 73));
        studentEcSubmission.setMinimumSize(new java.awt.Dimension(96, 73));
        studentEcSubmission.setPreferredSize(new java.awt.Dimension(96, 73));

        studentNotification.setBackground(new Color(255, 255, 255, 0));
        studentNotification.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        studentNotification.setForeground(new java.awt.Color(2, 50, 99));
        studentNotification.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentNotification.setText("Notification");
        studentNotification.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentNotification.setMaximumSize(new java.awt.Dimension(96, 73));
        studentNotification.setMinimumSize(new java.awt.Dimension(96, 73));
        studentNotification.setPreferredSize(new java.awt.Dimension(96, 73));

        studentProfile.setBackground(new Color(255, 255, 255, 0));
        studentProfile.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        studentProfile.setForeground(new java.awt.Color(2, 50, 99));
        studentProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentProfile.setText("Profile");
        studentProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentProfile.setMaximumSize(new java.awt.Dimension(96, 73));
        studentProfile.setMinimumSize(new java.awt.Dimension(96, 73));
        studentProfile.setPreferredSize(new java.awt.Dimension(96, 73));

        studentLogout.setBackground(new Color(255, 255, 255, 0));
        studentLogout.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        studentLogout.setForeground(new java.awt.Color(2, 50, 99));
        studentLogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentLogout.setText("Log Out");
        studentLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentLogout.setMaximumSize(new java.awt.Dimension(96, 73));
        studentLogout.setMinimumSize(new java.awt.Dimension(96, 73));
        studentLogout.setPreferredSize(new java.awt.Dimension(96, 73));

        javax.swing.GroupLayout studentHeaderLayout = new javax.swing.GroupLayout(studentHeader);
        studentHeader.setLayout(studentHeaderLayout);
        studentHeaderLayout.setHorizontalGroup(
            studentHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(studentLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 352, Short.MAX_VALUE)
                .addComponent(studentEcSubmission, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(studentNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        studentHeaderLayout.setVerticalGroup(
            studentHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentHeaderLayout.createSequentialGroup()
                .addGroup(studentHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentNotification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentEcSubmission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(studentHeaderLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(studentLogo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(studentHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void studentLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentLogoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_studentLogoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentEcSubmissionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentEcSubmissionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentEcSubmissionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentEcSubmissionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentEcSubmissionPage().setVisible(true);
            }
        });
    }
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon_with_background.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel studentEcSubmission;
    private javax.swing.JPanel studentHeader;
    private javax.swing.JLabel studentLogo;
    private javax.swing.JLabel studentLogout;
    private javax.swing.JLabel studentNotification;
    private javax.swing.JLabel studentProfile;
    // End of variables declaration//GEN-END:variables
}
