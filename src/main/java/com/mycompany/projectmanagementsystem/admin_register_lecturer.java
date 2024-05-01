package com.mycompany.projectmanagementsystem;

import java.awt.Toolkit;

public class admin_register_lecturer extends javax.swing.JFrame {

    
    public admin_register_lecturer() {
        initComponents();
        setIconImage();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        register_lecturer = new javax.swing.JLabel();
        lecturer_gender = new javax.swing.JLabel();
        lecturer_gender_selection = new javax.swing.JComboBox<>();
        lecturer_dob_title = new javax.swing.JLabel();
        lecturer_dob = new javax.swing.JTextField();
        lecturer_empno_title = new javax.swing.JLabel();
        student_tpno = new javax.swing.JTextField();
        lecturer_password_title = new javax.swing.JLabel();
        lecturer_password = new javax.swing.JTextField();
        lecturer_contact_title = new javax.swing.JLabel();
        student_contact = new javax.swing.JTextField();
        lecturer_address_title = new javax.swing.JLabel();
        student_address = new javax.swing.JTextField();
        lecturer_email_title = new javax.swing.JLabel();
        lecturer_email = new javax.swing.JTextField();
        register_lecturer_submit = new javax.swing.JButton();
        lecturer_nation_title = new javax.swing.JLabel();
        lecturer_nation = new javax.swing.JTextField();
        lecturer_name_title = new javax.swing.JLabel();
        lecturer_name = new javax.swing.JTextField();
        lecturer_nric_title = new javax.swing.JLabel();
        lecturer_nric = new javax.swing.JTextField();
        lecturer_schoolwise_title = new javax.swing.JLabel();
        lecturer_schoolwise = new javax.swing.JTextField();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Register Student");
        setMaximumSize(new java.awt.Dimension(700, 580));
        setMinimumSize(new java.awt.Dimension(700, 580));
        setPreferredSize(new java.awt.Dimension(700, 580));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        register_lecturer.setFont(new java.awt.Font("Bell MT", 1, 26)); // NOI18N
        register_lecturer.setForeground(new java.awt.Color(2, 50, 99));
        register_lecturer.setText("Register New Lecturer");
        getContentPane().add(register_lecturer, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        lecturer_gender.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_gender.setForeground(new java.awt.Color(2, 50, 99));
        lecturer_gender.setText("Gender");
        getContentPane().add(lecturer_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, -1, -1));

        lecturer_gender_selection.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_gender_selection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Female", "Male"}));
        lecturer_gender_selection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecturer_gender_selectionActionPerformed(evt);
            }
        });
        getContentPane().add(lecturer_gender_selection, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 190, 50));

        lecturer_dob_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_dob_title.setForeground(new java.awt.Color(2, 50, 99));
        lecturer_dob_title.setText("Date Of Birth\n");
        getContentPane().add(lecturer_dob_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 110, 40));

        lecturer_dob.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_dob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecturer_dobActionPerformed(evt);
            }
        });
        getContentPane().add(lecturer_dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 190, 50));

        lecturer_empno_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_empno_title.setForeground(new java.awt.Color(2, 50, 99));
        lecturer_empno_title.setText("<html><div style = 'text-align: center; width:90px;'>EMP No</div></html>");
        getContentPane().add(lecturer_empno_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 110, -1));

        student_tpno.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_tpno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_tpnoActionPerformed(evt);
            }
        });
        getContentPane().add(student_tpno, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 190, 50));

        lecturer_password_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_password_title.setForeground(new java.awt.Color(2, 50, 99));
        lecturer_password_title.setText("Password");
        getContentPane().add(lecturer_password_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, -1, -1));

        lecturer_password.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecturer_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(lecturer_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 190, 50));

        lecturer_contact_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_contact_title.setForeground(new java.awt.Color(2, 50, 99));
        lecturer_contact_title.setText("<html><div style = 'text-align: center; width:90px;'>Phone Number </div></html>");
        lecturer_contact_title.setToolTipText("");
        getContentPane().add(lecturer_contact_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 90, -1));

        student_contact.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_contactActionPerformed(evt);
            }
        });
        getContentPane().add(student_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 190, 50));

        lecturer_address_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_address_title.setForeground(new java.awt.Color(2, 50, 99));
        lecturer_address_title.setText("Address");
        getContentPane().add(lecturer_address_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        student_address.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_addressActionPerformed(evt);
            }
        });
        getContentPane().add(student_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 190, 50));

        lecturer_email_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_email_title.setForeground(new java.awt.Color(2, 50, 99));
        lecturer_email_title.setText("<html><div style = 'text-align: center; width:90px;'>Email Address</div></html>");
        getContentPane().add(lecturer_email_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, -1, -1));

        lecturer_email.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecturer_emailActionPerformed(evt);
            }
        });
        getContentPane().add(lecturer_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 190, 50));

        register_lecturer_submit.setBackground(new java.awt.Color(76, 127, 174));
        register_lecturer_submit.setFont(new java.awt.Font("Bell MT", 1, 19)); // NOI18N
        register_lecturer_submit.setText("SUBMIT");
        register_lecturer_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register_lecturer_submitActionPerformed(evt);
            }
        });
        getContentPane().add(register_lecturer_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 500, -1, -1));

        lecturer_nation_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_nation_title.setForeground(new java.awt.Color(2, 50, 99));
        lecturer_nation_title.setText("Nationality");
        getContentPane().add(lecturer_nation_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, -1, -1));

        lecturer_nation.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_nation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecturer_nationActionPerformed(evt);
            }
        });
        getContentPane().add(lecturer_nation, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 190, 50));

        lecturer_name_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_name_title.setForeground(new java.awt.Color(2, 50, 99));
        lecturer_name_title.setText("Full Name");
        getContentPane().add(lecturer_name_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 90, -1));

        lecturer_name.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_name.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
        lecturer_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecturer_nameActionPerformed(evt);
            }
        });
        getContentPane().add(lecturer_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 190, 50));

        lecturer_nric_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_nric_title.setForeground(new java.awt.Color(2, 50, 99));
        lecturer_nric_title.setText("<html><div style= 'text-align: center; width: 90px;'>NRIC/ Passoport No</div></html>");
        getContentPane().add(lecturer_nric_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 120, -1));

        lecturer_nric.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_nric.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecturer_nricActionPerformed(evt);
            }
        });
        getContentPane().add(lecturer_nric, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 190, 50));

        lecturer_schoolwise_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_schoolwise_title.setForeground(new java.awt.Color(2, 50, 99));
        lecturer_schoolwise_title.setText("School Wise");
        getContentPane().add(lecturer_schoolwise_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        lecturer_schoolwise.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_schoolwise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecturer_schoolwiseActionPerformed(evt);
            }
        });
        getContentPane().add(lecturer_schoolwise, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 190, 50));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        background.setToolTipText("");
        background.setMaximumSize(new java.awt.Dimension(700, 580));
        background.setMinimumSize(new java.awt.Dimension(700, 580));
        background.setPreferredSize(new java.awt.Dimension(700, 580));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void student_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_addressActionPerformed

    private void lecturer_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecturer_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturer_passwordActionPerformed

    private void student_tpnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_tpnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_tpnoActionPerformed

    private void lecturer_gender_selectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecturer_gender_selectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturer_gender_selectionActionPerformed

    private void lecturer_dobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecturer_dobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturer_dobActionPerformed

    private void lecturer_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecturer_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturer_emailActionPerformed

    private void register_lecturer_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register_lecturer_submitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_register_lecturer_submitActionPerformed

    private void lecturer_nationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecturer_nationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturer_nationActionPerformed

    private void student_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_contactActionPerformed

    private void lecturer_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecturer_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturer_nameActionPerformed

    private void lecturer_nricActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecturer_nricActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturer_nricActionPerformed

    private void lecturer_schoolwiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecturer_schoolwiseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturer_schoolwiseActionPerformed

    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_register_lecturer().setVisible(true);
            }
        });
    }
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel lecturer_address_title;
    private javax.swing.JLabel lecturer_contact_title;
    private javax.swing.JTextField lecturer_dob;
    private javax.swing.JLabel lecturer_dob_title;
    private javax.swing.JTextField lecturer_email;
    private javax.swing.JLabel lecturer_email_title;
    private javax.swing.JLabel lecturer_empno_title;
    private javax.swing.JLabel lecturer_gender;
    private javax.swing.JComboBox<String> lecturer_gender_selection;
    private javax.swing.JTextField lecturer_name;
    private javax.swing.JLabel lecturer_name_title;
    private javax.swing.JTextField lecturer_nation;
    private javax.swing.JLabel lecturer_nation_title;
    private javax.swing.JTextField lecturer_nric;
    private javax.swing.JLabel lecturer_nric_title;
    private javax.swing.JTextField lecturer_password;
    private javax.swing.JLabel lecturer_password_title;
    private javax.swing.JTextField lecturer_schoolwise;
    private javax.swing.JLabel lecturer_schoolwise_title;
    private javax.swing.JLabel register_lecturer;
    private javax.swing.JButton register_lecturer_submit;
    private javax.swing.JTextField student_address;
    private javax.swing.JTextField student_contact;
    private javax.swing.JTextField student_tpno;
    // End of variables declaration//GEN-END:variables
}
