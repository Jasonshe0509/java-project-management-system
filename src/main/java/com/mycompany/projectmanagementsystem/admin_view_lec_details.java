package com.mycompany.projectmanagementsystem;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import com.mycompany.projectmanagementsystem.User.UserController;
import java.awt.Color;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class admin_view_lec_details extends javax.swing.JFrame {

    String[] lecturerRecord;
    
    public admin_view_lec_details() {
        initComponents();
        setIconImage();
    }
    
    public String[] displayLecturerDetails(String[] lecturerDetails){
        
        lecturerRecord = lecturerDetails;
        ArrayList<String> list = new ArrayList();
        for (String detail : lecturerDetails) {
        list.add(detail);
    }
        lec_empno.setText(list.get(0));
        lec_name.setText(list.get(1));
        lec_gender.setText(list.get(2));
        lec_contact.setText(list.get(3));
        lec_dob.setText(list.get(4));
        lec_address.setText(list.get(5));
        lec_nric.setText(list.get(6));
        lec_nation.setText(list.get(7));
        lec_email.setText(list.get(8));
        //lec_password.setText("**********");
        lec_schoolwise.setText(list.get(11));
        
        return lecturerRecord;
        
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lec_name_title = new javax.swing.JLabel();
        lec_name = new javax.swing.JTextField();
        lec_empno = new javax.swing.JTextField();
        lec_empno_title = new javax.swing.JLabel();
        lec_dob = new javax.swing.JTextField();
        lec_dob_title = new javax.swing.JLabel();
        lec_address_title = new javax.swing.JLabel();
        lec_address = new javax.swing.JTextField();
        lec_contact_title = new javax.swing.JLabel();
        lec_gender = new javax.swing.JTextField();
        lec_schoolwise = new javax.swing.JTextField();
        lec_contact = new javax.swing.JTextField();
        lec_nation = new javax.swing.JTextField();
        lec_nation_title = new javax.swing.JLabel();
        lec_nric = new javax.swing.JTextField();
        lec_email = new javax.swing.JTextField();
        lec_email_title = new javax.swing.JLabel();
        lec_nric_title = new javax.swing.JLabel();
        lec_gender_title = new javax.swing.JLabel();
        lec_schoolwise_title = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lec_details_background = new javax.swing.JLabel();
        lec_details_border = new javax.swing.JLabel();
        modify_lecturer = new javax.swing.JButton();
        assign_projectmanager = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("View Lecturer Record");
        setMaximumSize(new java.awt.Dimension(700, 580));
        setMinimumSize(new java.awt.Dimension(700, 580));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lec_name_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_name_title.setForeground(new java.awt.Color(2, 50, 99));
        lec_name_title.setText("Full Name");
        getContentPane().add(lec_name_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 90, -1));

        lec_name.setEditable(false);
        lec_name.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_name.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
        lec_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lec_nameActionPerformed(evt);
            }
        });
        getContentPane().add(lec_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 190, 50));

        lec_empno.setEditable(false);
        lec_empno.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_empno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lec_empnoActionPerformed(evt);
            }
        });
        getContentPane().add(lec_empno, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 190, 50));

        lec_empno_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_empno_title.setForeground(new java.awt.Color(2, 50, 99));
        lec_empno_title.setText("<html><div style = \"text-align: center; width: 50px;\">EMP Number</div></html>");
        getContentPane().add(lec_empno_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 70, -1));

        lec_dob.setEditable(false);
        lec_dob.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_dob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lec_dobActionPerformed(evt);
            }
        });
        getContentPane().add(lec_dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 190, 50));

        lec_dob_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_dob_title.setForeground(new java.awt.Color(2, 50, 99));
        lec_dob_title.setText("Date Of Birth");
        getContentPane().add(lec_dob_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 110, 40));

        lec_address_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_address_title.setForeground(new java.awt.Color(2, 50, 99));
        lec_address_title.setText("Address");
        getContentPane().add(lec_address_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 370, -1, -1));

        lec_address.setEditable(false);
        lec_address.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lec_addressActionPerformed(evt);
            }
        });
        getContentPane().add(lec_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 190, 50));

        lec_contact_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_contact_title.setForeground(new java.awt.Color(2, 50, 99));
        lec_contact_title.setText("<html><div style = 'text-align: center; width:90px;'>Phone Number </div></html>");
        lec_contact_title.setToolTipText("");
        getContentPane().add(lec_contact_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 90, -1));

        lec_gender.setEditable(false);
        lec_gender.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lec_genderActionPerformed(evt);
            }
        });
        getContentPane().add(lec_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 190, 50));

        lec_schoolwise.setEditable(false);
        lec_schoolwise.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_schoolwise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lec_schoolwiseActionPerformed(evt);
            }
        });
        getContentPane().add(lec_schoolwise, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 190, 50));

        lec_contact.setEditable(false);
        lec_contact.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lec_contactActionPerformed(evt);
            }
        });
        getContentPane().add(lec_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 190, 50));

        lec_nation.setEditable(false);
        lec_nation.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_nation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lec_nationActionPerformed(evt);
            }
        });
        getContentPane().add(lec_nation, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 190, 50));

        lec_nation_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_nation_title.setForeground(new java.awt.Color(2, 50, 99));
        lec_nation_title.setText("Nationality");
        getContentPane().add(lec_nation_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, -1, -1));

        lec_nric.setEditable(false);
        lec_nric.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_nric.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lec_nricActionPerformed(evt);
            }
        });
        getContentPane().add(lec_nric, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 190, 50));

        lec_email.setEditable(false);
        lec_email.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lec_emailActionPerformed(evt);
            }
        });
        getContentPane().add(lec_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 190, 50));

        lec_email_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_email_title.setForeground(new java.awt.Color(2, 50, 99));
        lec_email_title.setText("<html><div style = \"text-align: center; width: 50px;\">Email Address</div></html>");
        getContentPane().add(lec_email_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, -1, -1));

        lec_nric_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_nric_title.setForeground(new java.awt.Color(2, 50, 99));
        lec_nric_title.setText("<html><div style= 'text-align: center; width: 90px;'>NRIC/ Passoport No</div></html>");
        getContentPane().add(lec_nric_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 120, -1));

        lec_gender_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_gender_title.setForeground(new java.awt.Color(2, 50, 99));
        lec_gender_title.setText("Gender");
        getContentPane().add(lec_gender_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, -1, -1));

        lec_schoolwise_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_schoolwise_title.setForeground(new java.awt.Color(2, 50, 99));
        lec_schoolwise_title.setText("<html><div style = 'text-align: center; width:50px;'>School Wise</div></html>");
        getContentPane().add(lec_schoolwise_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 60, -1));

        jLabel1.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(2, 50, 99));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back.png"))); // NOI18N
        jLabel1.setText("BACK");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lec_details_background.setBackground(new Color(192, 192, 192, 90));
        lec_details_background.setMaximumSize(new java.awt.Dimension(550, 350));
        lec_details_background.setMinimumSize(new java.awt.Dimension(550, 350));
        lec_details_background.setName(""); // NOI18N
        lec_details_background.setOpaque(true);
        lec_details_background.setPreferredSize(new java.awt.Dimension(550, 350));
        getContentPane().add(lec_details_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 630, 360));

        lec_details_border.setBackground(new Color(255, 255, 255, 0));
        lec_details_border.setBorder(new LineBorder(new Color(192, 192, 192, 90), 15, true));
        lec_details_border.setMaximumSize(new java.awt.Dimension(600, 400));
        lec_details_border.setMinimumSize(new java.awt.Dimension(600, 400));
        lec_details_border.setOpaque(true);
        lec_details_border.setPreferredSize(new java.awt.Dimension(600, 400));
        getContentPane().add(lec_details_border, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 650, 380));

        modify_lecturer.setBackground(new java.awt.Color(2, 50, 99));
        modify_lecturer.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        modify_lecturer.setForeground(new java.awt.Color(255, 255, 255));
        modify_lecturer.setText("MODIFY");
        modify_lecturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modify_lecturerActionPerformed(evt);
            }
        });
        getContentPane().add(modify_lecturer, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 470, 110, -1));

        assign_projectmanager.setBackground(new java.awt.Color(2, 50, 99));
        assign_projectmanager.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        assign_projectmanager.setForeground(new java.awt.Color(255, 255, 255));
        assign_projectmanager.setText("<html><div style = 'text-align: center; width: 100px;'>Assign Project Manager</div></html>");
        assign_projectmanager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assign_projectmanagerActionPerformed(evt);
            }
        });
        getContentPane().add(assign_projectmanager, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, 150, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        background.setMaximumSize(new java.awt.Dimension(700, 580));
        background.setMinimumSize(new java.awt.Dimension(700, 580));
        background.setPreferredSize(new java.awt.Dimension(700, 580));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 540));
        background.getAccessibleContext().setAccessibleName("background");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lec_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lec_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lec_nameActionPerformed

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

    private void lec_nricActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lec_nricActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lec_nricActionPerformed

    private void lec_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lec_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lec_emailActionPerformed

    private void lec_genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lec_genderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lec_genderActionPerformed

    private void lec_schoolwiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lec_schoolwiseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lec_schoolwiseActionPerformed

    private void assign_projectmanagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assign_projectmanagerActionPerformed
        String userID = lecturerRecord[0];
        UserController addPM = new UserController();
        addPM.projectmanagerAdd(userID);
        dispose();
        

    }//GEN-LAST:event_assign_projectmanagerActionPerformed

    private void modify_lecturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modify_lecturerActionPerformed
        admin_modify_lecturerrecord modifyLecturerDetails = new admin_modify_lecturerrecord();
        modifyLecturerDetails.displayLecturerDetails(lecturerRecord);
        modifyLecturerDetails.show();
        hide();
    }//GEN-LAST:event_modify_lecturerActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_view_lec_details().setVisible(true);
            }
        });
    }
        private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon_with_background.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assign_projectmanager;
    private javax.swing.JLabel background;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JTextField lec_gender;
    private javax.swing.JLabel lec_gender_title;
    private javax.swing.JTextField lec_name;
    private javax.swing.JLabel lec_name_title;
    private javax.swing.JTextField lec_nation;
    private javax.swing.JLabel lec_nation_title;
    private javax.swing.JTextField lec_nric;
    private javax.swing.JLabel lec_nric_title;
    private javax.swing.JTextField lec_schoolwise;
    private javax.swing.JLabel lec_schoolwise_title;
    private javax.swing.JButton modify_lecturer;
    // End of variables declaration//GEN-END:variables
}
