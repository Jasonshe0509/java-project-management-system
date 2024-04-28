package com.mycompany.projectmanagementsystem;

import java.awt.Toolkit;

public class admin_register_intake extends javax.swing.JFrame {

    public admin_register_intake() {
        initComponents();
        setIconImage();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        admin_register_intake_title = new javax.swing.JLabel();
        intake_code = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Register Intake");
        setMinimumSize(new java.awt.Dimension(500, 300));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admin_register_intake_title.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        admin_register_intake_title.setForeground(new java.awt.Color(2, 50, 99));
        admin_register_intake_title.setText("Register New Intake");
        getContentPane().add(admin_register_intake_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        intake_code.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        intake_code.setForeground(new java.awt.Color(2, 50, 99));
        intake_code.setText("Intake Code:");
        getContentPane().add(intake_code, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));

        jTextField1.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(2, 50, 99));
        jTextField1.setToolTipText("e.g. APU2F2402CS");
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 150, -1));

        jButton1.setBackground(new java.awt.Color(76, 127, 174));
        jButton1.setFont(new java.awt.Font("Bell MT", 1, 19)); // NOI18N
        jButton1.setText("SUBMIT");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, -1, -1));

        jLabel1.setMaximumSize(new java.awt.Dimension(500, 300));
        jLabel1.setMinimumSize(new java.awt.Dimension(500, 300));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(500, 300));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_register_intake().setVisible(true);
            }
        });
    }
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon_with_background.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel admin_register_intake_title;
    private javax.swing.JLabel intake_code;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
