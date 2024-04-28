package com.mycompany.projectmanagementsystem;

import java.awt.Toolkit;

public class admin_register_student extends javax.swing.JFrame {

    
    public admin_register_student() {
        initComponents();
        setIconImage();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        register_student = new javax.swing.JLabel();
        student_gender = new javax.swing.JLabel();
        student_gender_selection = new javax.swing.JComboBox<>();
        student_dob_title = new javax.swing.JLabel();
        student_do = new javax.swing.JTextField();
        student_tpno_title = new javax.swing.JLabel();
        student_tpno = new javax.swing.JTextField();
        student_password_title = new javax.swing.JLabel();
        student_password = new javax.swing.JTextField();
        student_contact_title = new javax.swing.JLabel();
        student_contact = new javax.swing.JTextField();
        student_address_title = new javax.swing.JLabel();
        student_address = new javax.swing.JTextField();
        student_email_title = new javax.swing.JLabel();
        student_email = new javax.swing.JTextField();
        register_student_submit = new javax.swing.JButton();
        student_nation_title = new javax.swing.JLabel();
        student_nation = new javax.swing.JTextField();
        student_name_title = new javax.swing.JLabel();
        student_name = new javax.swing.JTextField();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Register Student");
        setMinimumSize(new java.awt.Dimension(700, 480));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        register_student.setFont(new java.awt.Font("Bell MT", 1, 26)); // NOI18N
        register_student.setForeground(new java.awt.Color(2, 50, 99));
        register_student.setText("Register New Student");
        getContentPane().add(register_student, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        student_gender.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_gender.setForeground(new java.awt.Color(2, 50, 99));
        student_gender.setText("Gender");
        getContentPane().add(student_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, -1));

        student_gender_selection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Female", "Male"}));
        student_gender_selection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_gender_selectionActionPerformed(evt);
            }
        });
        getContentPane().add(student_gender_selection, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, 30));

        student_dob_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_dob_title.setForeground(new java.awt.Color(2, 50, 99));
        student_dob_title.setText("<html>Date Of Birth</html>");
        getContentPane().add(student_dob_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 70, 40));

        student_do.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_do.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_doActionPerformed(evt);
            }
        });
        getContentPane().add(student_do, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 110, 30));

        student_tpno_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_tpno_title.setForeground(new java.awt.Color(2, 50, 99));
        student_tpno_title.setText("TP Number");
        getContentPane().add(student_tpno_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        student_tpno.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_tpno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_tpnoActionPerformed(evt);
            }
        });
        getContentPane().add(student_tpno, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 110, 30));

        student_password_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_password_title.setForeground(new java.awt.Color(2, 50, 99));
        student_password_title.setText("Password");
        getContentPane().add(student_password_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, -1, -1));

        student_password.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(student_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, 190, 30));

        student_contact_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_contact_title.setForeground(new java.awt.Color(2, 50, 99));
        student_contact_title.setText("Phone Number ");
        getContentPane().add(student_contact_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, -1, -1));

        student_contact.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_contactActionPerformed(evt);
            }
        });
        getContentPane().add(student_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 110, 30));

        student_address_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_address_title.setForeground(new java.awt.Color(2, 50, 99));
        student_address_title.setText("Address");
        getContentPane().add(student_address_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));

        student_address.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_addressActionPerformed(evt);
            }
        });
        getContentPane().add(student_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 290, 60));

        student_email_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_email_title.setForeground(new java.awt.Color(2, 50, 99));
        student_email_title.setText("Email Address");
        getContentPane().add(student_email_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        student_email.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_emailActionPerformed(evt);
            }
        });
        getContentPane().add(student_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 190, 30));

        register_student_submit.setBackground(new java.awt.Color(76, 127, 174));
        register_student_submit.setFont(new java.awt.Font("Bell MT", 1, 19)); // NOI18N
        register_student_submit.setText("SUBMIT");
        register_student_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register_student_submitActionPerformed(evt);
            }
        });
        getContentPane().add(register_student_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, -1, -1));

        student_nation_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_nation_title.setForeground(new java.awt.Color(2, 50, 99));
        student_nation_title.setText("Nationality");
        getContentPane().add(student_nation_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        student_nation.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_nation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_nationActionPerformed(evt);
            }
        });
        getContentPane().add(student_nation, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 110, 30));

        student_name_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_name_title.setForeground(new java.awt.Color(2, 50, 99));
        student_name_title.setText("Full Name");
        getContentPane().add(student_name_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        student_name.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_nameActionPerformed(evt);
            }
        });
        getContentPane().add(student_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 110, 30));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        background.setToolTipText("");
        background.setMaximumSize(new java.awt.Dimension(700, 480));
        background.setMinimumSize(new java.awt.Dimension(700, 480));
        background.setPreferredSize(new java.awt.Dimension(700, 480));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 440));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void student_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_addressActionPerformed

    private void student_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_passwordActionPerformed

    private void student_tpnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_tpnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_tpnoActionPerformed

    private void student_gender_selectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_gender_selectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_gender_selectionActionPerformed

    private void student_doActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_doActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_doActionPerformed

    private void student_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_emailActionPerformed

    private void register_student_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register_student_submitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_register_student_submitActionPerformed

    private void student_nationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_nationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_nationActionPerformed

    private void student_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_contactActionPerformed

    private void student_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_nameActionPerformed

    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_register_student().setVisible(true);
            }
        });
    }
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon_with_background.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel register_student;
    private javax.swing.JButton register_student_submit;
    private javax.swing.JTextField student_address;
    private javax.swing.JLabel student_address_title;
    private javax.swing.JTextField student_contact;
    private javax.swing.JLabel student_contact_title;
    private javax.swing.JTextField student_do;
    private javax.swing.JLabel student_dob_title;
    private javax.swing.JTextField student_email;
    private javax.swing.JLabel student_email_title;
    private javax.swing.JLabel student_gender;
    private javax.swing.JComboBox<String> student_gender_selection;
    private javax.swing.JTextField student_name;
    private javax.swing.JLabel student_name_title;
    private javax.swing.JTextField student_nation;
    private javax.swing.JLabel student_nation_title;
    private javax.swing.JTextField student_password;
    private javax.swing.JLabel student_password_title;
    private javax.swing.JTextField student_tpno;
    private javax.swing.JLabel student_tpno_title;
    // End of variables declaration//GEN-END:variables
}
