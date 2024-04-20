/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projectmanagementsystem;

import java.awt.Toolkit;
import java.awt.Color;


/**
 *
 * @author ASUS
 */
public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form LoginPage
     */
    public LoginPage() {
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

        jPanel1 = new javax.swing.JPanel();
        emailField = new javax.swing.JTextField();
        email = new javax.swing.JLabel();
        forgetPassword = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        backButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        showPasswordTickBox = new javax.swing.JCheckBox();
        slogan = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Page");
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new Color(240,240,240,90));
        jPanel1.setMaximumSize(new java.awt.Dimension(680, 390));
        jPanel1.setMinimumSize(new java.awt.Dimension(680, 390));
        jPanel1.setPreferredSize(new java.awt.Dimension(680, 390));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        emailField.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        emailField.setMaximumSize(new java.awt.Dimension(335, 40));
        emailField.setMinimumSize(new java.awt.Dimension(335, 40));
        emailField.setPreferredSize(new java.awt.Dimension(335, 40));
        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });
        jPanel1.add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 47, -1, -1));

        email.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        email.setForeground(new java.awt.Color(2, 50, 99));
        email.setText("Email:");
        email.setMaximumSize(new java.awt.Dimension(78, 36));
        email.setMinimumSize(new java.awt.Dimension(78, 36));
        email.setPreferredSize(new java.awt.Dimension(78, 36));
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 47, -1, -1));

        forgetPassword.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        forgetPassword.setForeground(new java.awt.Color(2, 50, 99));
        forgetPassword.setText("Forget Password?");
        forgetPassword.setMaximumSize(new java.awt.Dimension(78, 22));
        forgetPassword.setMinimumSize(new java.awt.Dimension(78, 22));
        forgetPassword.setPreferredSize(new java.awt.Dimension(78, 22));
        jPanel1.add(forgetPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 197, 150, -1));

        password.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        password.setForeground(new java.awt.Color(2, 50, 99));
        password.setText("Password:");
        password.setMaximumSize(new java.awt.Dimension(78, 36));
        password.setMinimumSize(new java.awt.Dimension(78, 36));
        password.setPreferredSize(new java.awt.Dimension(78, 36));
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 127, 120, -1));

        passwordField.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        passwordField.setMaximumSize(new java.awt.Dimension(335, 40));
        passwordField.setMinimumSize(new java.awt.Dimension(335, 40));
        passwordField.setPreferredSize(new java.awt.Dimension(335, 40));
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });
        jPanel1.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 127, -1, -1));

        backButton.setBackground(new java.awt.Color(27, 61, 96));
        backButton.setFont(new java.awt.Font("Bell MT", 1, 28)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("Back");
        backButton.setMaximumSize(new java.awt.Dimension(120, 45));
        backButton.setMinimumSize(new java.awt.Dimension(120, 45));
        backButton.setPreferredSize(new java.awt.Dimension(120, 45));
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 301, -1, -1));

        loginButton.setBackground(new java.awt.Color(27, 61, 96));
        loginButton.setFont(new java.awt.Font("Bell MT", 1, 28)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("Login");
        loginButton.setMaximumSize(new java.awt.Dimension(120, 45));
        loginButton.setMinimumSize(new java.awt.Dimension(120, 45));
        loginButton.setPreferredSize(new java.awt.Dimension(120, 45));
        jPanel1.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 301, -1, -1));

        showPasswordTickBox.setBackground(new Color(240,240,240,90));
        showPasswordTickBox.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        showPasswordTickBox.setForeground(new java.awt.Color(2, 50, 99));
        showPasswordTickBox.setText("Show Password");
        showPasswordTickBox.setBorder(null);
        showPasswordTickBox.setContentAreaFilled(false);
        showPasswordTickBox.setFocusPainted(false);
        showPasswordTickBox.setFocusable(false);
        showPasswordTickBox.setMaximumSize(new java.awt.Dimension(180, 22));
        showPasswordTickBox.setMinimumSize(new java.awt.Dimension(180, 22));
        showPasswordTickBox.setPreferredSize(new java.awt.Dimension(180, 22));
        showPasswordTickBox.setRequestFocusEnabled(false);
        showPasswordTickBox.setRolloverEnabled(false);
        showPasswordTickBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordTickBoxActionPerformed(evt);
            }
        });
        jPanel1.add(showPasswordTickBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 197, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 256, -1, -1));

        slogan.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        slogan.setForeground(new java.awt.Color(2, 50, 99));
        slogan.setText("Navigating Success Together: Your Path to Project Excellence");
        slogan.setMaximumSize(new java.awt.Dimension(732, 29));
        slogan.setMinimumSize(new java.awt.Dimension(732, 29));
        slogan.setPreferredSize(new java.awt.Dimension(732, 29));
        slogan.setRequestFocusEnabled(false);
        getContentPane().add(slogan, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 660, 670, 30));

        jLabel1.setFont(new java.awt.Font("Bell MT", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(2, 50, 99));
        jLabel1.setText("Login to Sysco");
        jLabel1.setMaximumSize(new java.awt.Dimension(312, 46));
        jLabel1.setMinimumSize(new java.awt.Dimension(312, 46));
        jLabel1.setPreferredSize(new java.awt.Dimension(312, 46));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 270, -1));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo_only.png"))); // NOI18N
        logo.setText("jLabel1");
        logo.setMaximumSize(new java.awt.Dimension(170, 160));
        logo.setMinimumSize(new java.awt.Dimension(170, 160));
        logo.setPreferredSize(new java.awt.Dimension(170, 160));
        getContentPane().add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 0, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        background.setText("background");
        background.setMaximumSize(new java.awt.Dimension(1000, 700));
        background.setMinimumSize(new java.awt.Dimension(1000, 700));
        background.setPreferredSize(new java.awt.Dimension(1000, 700));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void showPasswordTickBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPasswordTickBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showPasswordTickBoxActionPerformed

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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new LoginPage().setVisible(true);
        });
    }
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon_with_background.png")));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel background;
    private javax.swing.JLabel email;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel forgetPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel password;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JCheckBox showPasswordTickBox;
    private javax.swing.JLabel slogan;
    // End of variables declaration//GEN-END:variables
}
