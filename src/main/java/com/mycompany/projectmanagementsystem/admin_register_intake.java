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
        education_lvl_title = new javax.swing.JLabel();
        enrolleddate_title = new javax.swing.JLabel();
        schoolwise_dropbox = new javax.swing.JComboBox<>();
        education_level_dropbox = new javax.swing.JComboBox<>();
        schoolwise_title = new javax.swing.JLabel();
        enrolledmonth_chooser = new com.toedter.calendar.JMonthChooser();
        enrolledyear_chooser = new com.toedter.calendar.JYearChooser();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Register Intake");
        setMinimumSize(new java.awt.Dimension(500, 300));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admin_register_intake_title.setFont(new java.awt.Font("Bell MT", 1, 28)); // NOI18N
        admin_register_intake_title.setForeground(new java.awt.Color(2, 50, 99));
        admin_register_intake_title.setText("Register New Intake");
        getContentPane().add(admin_register_intake_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        education_lvl_title.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        education_lvl_title.setForeground(new java.awt.Color(2, 50, 99));
        education_lvl_title.setText("Level Of Education");
        getContentPane().add(education_lvl_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        enrolleddate_title.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        enrolleddate_title.setForeground(new java.awt.Color(2, 50, 99));
        enrolleddate_title.setText("Enrolled Date");
        getContentPane().add(enrolleddate_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        schoolwise_dropbox.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        schoolwise_dropbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(schoolwise_dropbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 290, 30));

        education_level_dropbox.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        education_level_dropbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        education_level_dropbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                education_level_dropboxActionPerformed(evt);
            }
        });
        getContentPane().add(education_level_dropbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 290, 30));

        schoolwise_title.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        schoolwise_title.setForeground(new java.awt.Color(2, 50, 99));
        schoolwise_title.setText("School Wise");
        getContentPane().add(schoolwise_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        enrolledmonth_chooser.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        getContentPane().add(enrolledmonth_chooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 190, 30));

        enrolledyear_chooser.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        getContentPane().add(enrolledyear_chooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 100, 30));

        jButton1.setBackground(new java.awt.Color(76, 127, 174));
        jButton1.setFont(new java.awt.Font("Bell MT", 1, 19)); // NOI18N
        jButton1.setText("SUBMIT");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(500, 300));
        jLabel1.setMinimumSize(new java.awt.Dimension(500, 300));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(500, 300));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void education_level_dropboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_education_level_dropboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_education_level_dropboxActionPerformed

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
    private javax.swing.JComboBox<String> education_level_dropbox;
    private javax.swing.JLabel education_lvl_title;
    private javax.swing.JLabel enrolleddate_title;
    private com.toedter.calendar.JMonthChooser enrolledmonth_chooser;
    private com.toedter.calendar.JYearChooser enrolledyear_chooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> schoolwise_dropbox;
    private javax.swing.JLabel schoolwise_title;
    // End of variables declaration//GEN-END:variables
}
