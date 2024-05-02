package com.mycompany.projectmanagementsystem;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;

public class admin_modify_lecturerrecord extends javax.swing.JFrame {

    public admin_modify_lecturerrecord() {
        initComponents();
        setIconImage();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lec_name_title = new javax.swing.JLabel();
        lec_name = new javax.swing.JTextField();
        lec_gender_selection = new javax.swing.JComboBox<>();
        lec_empno = new javax.swing.JTextField();
        lec_empno_title = new javax.swing.JLabel();
        lec_dob = new javax.swing.JTextField();
        lec_dob_title = new javax.swing.JLabel();
        lec_address_title = new javax.swing.JLabel();
        lec_address = new javax.swing.JTextField();
        lec_contact_title = new javax.swing.JLabel();
        lec_contact = new javax.swing.JTextField();
        lec_nation = new javax.swing.JTextField();
        lec_nation_title = new javax.swing.JLabel();
        lec_password_title = new javax.swing.JLabel();
        lec_password = new javax.swing.JTextField();
        lec_nric = new javax.swing.JTextField();
        lec_email = new javax.swing.JTextField();
        lec_email_title = new javax.swing.JLabel();
        lec_nric_title = new javax.swing.JLabel();
        lec_gender = new javax.swing.JLabel();
        lec_schoolwise_title = new javax.swing.JLabel();
        lec_school_wise = new javax.swing.JComboBox<>();
        lec_details_background = new javax.swing.JLabel();
        lec_details_border = new javax.swing.JLabel();
        admin_viewlec_back = new javax.swing.JButton();
        admin_modify_lec_save = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modify Lecturer Record");
        setMaximumSize(new java.awt.Dimension(700, 580));
        setMinimumSize(new java.awt.Dimension(700, 580));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lec_name_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_name_title.setForeground(new java.awt.Color(2, 50, 99));
        lec_name_title.setText("Full Name");
        getContentPane().add(lec_name_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 90, -1));

        lec_name.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_name.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
        lec_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lec_nameActionPerformed(evt);
            }
        });
        getContentPane().add(lec_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 190, 50));

        lec_gender_selection.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_gender_selection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Female", "Male"}));
        lec_gender_selection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lec_gender_selectionActionPerformed(evt);
            }
        });
        getContentPane().add(lec_gender_selection, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 190, 50));

        lec_empno.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_empno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lec_empnoActionPerformed(evt);
            }
        });
        getContentPane().add(lec_empno, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 190, 50));

        lec_empno_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_empno_title.setForeground(new java.awt.Color(2, 50, 99));
        lec_empno_title.setText("<html><div style = \"text-align: center; width: 50px;\">EMP Number</div></html>");
        getContentPane().add(lec_empno_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 70, -1));

        lec_dob.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_dob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lec_dobActionPerformed(evt);
            }
        });
        getContentPane().add(lec_dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 190, 50));

        lec_dob_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_dob_title.setForeground(new java.awt.Color(2, 50, 99));
        lec_dob_title.setText("Date Of Birth");
        getContentPane().add(lec_dob_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 110, 40));

        lec_address_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_address_title.setForeground(new java.awt.Color(2, 50, 99));
        lec_address_title.setText("Address");
        getContentPane().add(lec_address_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, -1, -1));

        lec_address.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lec_addressActionPerformed(evt);
            }
        });
        getContentPane().add(lec_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 190, 50));

        lec_contact_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_contact_title.setForeground(new java.awt.Color(2, 50, 99));
        lec_contact_title.setText("<html><div style = 'text-align: center; width:90px;'>Phone Number </div></html>");
        lec_contact_title.setToolTipText("");
        getContentPane().add(lec_contact_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 90, -1));

        lec_contact.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lec_contactActionPerformed(evt);
            }
        });
        getContentPane().add(lec_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 190, 50));

        lec_nation.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_nation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lec_nationActionPerformed(evt);
            }
        });
        getContentPane().add(lec_nation, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 190, 50));

        lec_nation_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_nation_title.setForeground(new java.awt.Color(2, 50, 99));
        lec_nation_title.setText("Nationality");
        getContentPane().add(lec_nation_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, -1, -1));

        lec_password_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_password_title.setForeground(new java.awt.Color(2, 50, 99));
        lec_password_title.setText("Password");
        getContentPane().add(lec_password_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, -1, -1));

        lec_password.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lec_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(lec_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, 190, 50));

        lec_nric.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_nric.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lec_nricActionPerformed(evt);
            }
        });
        getContentPane().add(lec_nric, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 190, 50));

        lec_email.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lec_emailActionPerformed(evt);
            }
        });
        getContentPane().add(lec_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 190, 50));

        lec_email_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_email_title.setForeground(new java.awt.Color(2, 50, 99));
        lec_email_title.setText("<html><div style = \"text-align: center; width: 50px;\">Email Address</div></html>");
        getContentPane().add(lec_email_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, -1, -1));

        lec_nric_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_nric_title.setForeground(new java.awt.Color(2, 50, 99));
        lec_nric_title.setText("<html><div style= 'text-align: center; width: 90px;'>NRIC/ Passoport No</div></html>");
        getContentPane().add(lec_nric_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 120, -1));

        lec_gender.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_gender.setForeground(new java.awt.Color(2, 50, 99));
        lec_gender.setText("Gender");
        getContentPane().add(lec_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        lec_schoolwise_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_schoolwise_title.setForeground(new java.awt.Color(2, 50, 99));
        lec_schoolwise_title.setText("School Wise");
        getContentPane().add(lec_schoolwise_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        lec_school_wise.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_school_wise.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(lec_school_wise, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 190, 50));

        lec_details_background.setBackground(new Color(192, 192, 192, 90));
        lec_details_background.setMaximumSize(new java.awt.Dimension(550, 350));
        lec_details_background.setMinimumSize(new java.awt.Dimension(550, 350));
        lec_details_background.setName(""); // NOI18N
        lec_details_background.setOpaque(true);
        lec_details_background.setPreferredSize(new java.awt.Dimension(550, 350));
        getContentPane().add(lec_details_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 630, 420));

        lec_details_border.setBackground(new Color(255, 255, 255, 0));
        lec_details_border.setBorder(new LineBorder(new Color(192, 192, 192, 90), 15, true));
        lec_details_border.setMaximumSize(new java.awt.Dimension(600, 400));
        lec_details_border.setMinimumSize(new java.awt.Dimension(600, 400));
        lec_details_border.setOpaque(true);
        lec_details_border.setPreferredSize(new java.awt.Dimension(600, 400));
        getContentPane().add(lec_details_border, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 650, 440));

        admin_viewlec_back.setBackground(new java.awt.Color(76, 127, 174));
        admin_viewlec_back.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        admin_viewlec_back.setForeground(new java.awt.Color(2, 50, 99));
        admin_viewlec_back.setText("BACK");
        admin_viewlec_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_viewlec_backActionPerformed(evt);
            }
        });
        getContentPane().add(admin_viewlec_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, -1, -1));

        admin_modify_lec_save.setBackground(new java.awt.Color(76, 127, 174));
        admin_modify_lec_save.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        admin_modify_lec_save.setForeground(new java.awt.Color(2, 50, 99));
        admin_modify_lec_save.setText("SAVE CHANGES");
        getContentPane().add(admin_modify_lec_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 500, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        background.setMaximumSize(new java.awt.Dimension(700, 580));
        background.setMinimumSize(new java.awt.Dimension(700, 580));
        background.setPreferredSize(new java.awt.Dimension(700, 580));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        background.getAccessibleContext().setAccessibleName("background");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void admin_viewlec_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_viewlec_backActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_admin_viewlec_backActionPerformed

    private void lec_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lec_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lec_nameActionPerformed

    private void lec_gender_selectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lec_gender_selectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lec_gender_selectionActionPerformed

    private void lec_empnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lec_empnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lec_empnoActionPerformed

    private void lec_dobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lec_dobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lec_dobActionPerformed

    private void lec_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lec_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lec_addressActionPerformed

    private void lec_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lec_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lec_contactActionPerformed

    private void lec_nationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lec_nationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lec_nationActionPerformed

    private void lec_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lec_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lec_passwordActionPerformed

    private void lec_nricActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lec_nricActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lec_nricActionPerformed

    private void lec_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lec_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lec_emailActionPerformed
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_modify_lecturerrecord().setVisible(true);
            }
        });
    }
        private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon_with_background.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton admin_modify_lec_save;
    private javax.swing.JButton admin_viewlec_back;
    private javax.swing.JLabel background;
    private javax.swing.JTextField lec_address;
    private javax.swing.JLabel lec_address_title;
    private javax.swing.JTextField lec_contact;
    private javax.swing.JLabel lec_contact_title;
    private javax.swing.JLabel lec_details_background;
    private javax.swing.JLabel lec_details_border;
    private javax.swing.JTextField lec_dob;
    private javax.swing.JLabel lec_dob_title;
    private javax.swing.JTextField lec_email;
    private javax.swing.JLabel lec_email_title;
    private javax.swing.JTextField lec_empno;
    private javax.swing.JLabel lec_empno_title;
    private javax.swing.JLabel lec_gender;
    private javax.swing.JComboBox<String> lec_gender_selection;
    private javax.swing.JTextField lec_name;
    private javax.swing.JLabel lec_name_title;
    private javax.swing.JTextField lec_nation;
    private javax.swing.JLabel lec_nation_title;
    private javax.swing.JTextField lec_nric;
    private javax.swing.JLabel lec_nric_title;
    private javax.swing.JTextField lec_password;
    private javax.swing.JLabel lec_password_title;
    private javax.swing.JComboBox<String> lec_school_wise;
    private javax.swing.JLabel lec_schoolwise_title;
    // End of variables declaration//GEN-END:variables
}
