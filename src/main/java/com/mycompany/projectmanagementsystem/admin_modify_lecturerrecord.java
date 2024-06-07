package com.mycompany.projectmanagementsystem;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import com.mycompany.projectmanagementsystem.User.UserController;
import java.awt.Color;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.border.LineBorder;

public class admin_modify_lecturerrecord extends javax.swing.JFrame {

    List<String> genderList, schoolWiseList;
    String lecRole;

    public admin_modify_lecturerrecord() {
        initComponents();
        setIconImage();
        dropbox_Gender(genderList);
        dropbox_SchoolWise(schoolWiseList);
    }

    public void dropbox_Gender(List<String> genderList) {
        lecturer_gender_selection.addItem("Female");
        lecturer_gender_selection.addItem("Male");
    }

    public void dropbox_SchoolWise(List<String> schoolWiseList) {
        schoolWiseList = FileHandler.readFile("school_wise.txt");
        Object[] lines = schoolWiseList.toArray();

        for (int i = 0; i < lines.length; i++) {
            String schoolWise = lines[i].toString();
            schoolwise_dropbox.addItem(schoolWise);
        }
    }

    public String displayLecturerDetails(String[] lecturerDetails) {
        lec_empno.setText(lecturerDetails[0]);
        lec_name.setText(lecturerDetails[1]);
        lecturer_gender_selection.setSelectedItem(lecturerDetails[2]);
        lec_contact.setText(lecturerDetails[3]);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateFormat.parse(lecturerDetails[4]);
            lec_dob.setDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        lec_address.setText(lecturerDetails[5]);
        lec_nric.setText(lecturerDetails[6]);
        lec_nation.setText(lecturerDetails[7]);
        lec_email.setText(lecturerDetails[8]);
        lec_password.setText(lecturerDetails[9]);
        lec_password.setEchoChar('*');
        schoolwise_dropbox.setSelectedItem(lecturerDetails[11]);
        lecRole = lecturerDetails[10];

        return lecRole;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lec_name_title = new javax.swing.JLabel();
        lec_name = new javax.swing.JTextField();
        lecturer_gender_selection = new javax.swing.JComboBox<>();
        lec_empno = new javax.swing.JTextField();
        lec_empno_title = new javax.swing.JLabel();
        lec_dob = new com.toedter.calendar.JDateChooser();
        lec_dob_title = new javax.swing.JLabel();
        lec_address_title = new javax.swing.JLabel();
        lec_address = new javax.swing.JTextField();
        lec_contact_title = new javax.swing.JLabel();
        lec_contact = new javax.swing.JTextField();
        lec_nation = new javax.swing.JTextField();
        lec_nation_title = new javax.swing.JLabel();
        lec_password_title = new javax.swing.JLabel();
        lec_password = new javax.swing.JPasswordField();
        lec_nric = new javax.swing.JTextField();
        lec_email = new javax.swing.JTextField();
        lec_email_title = new javax.swing.JLabel();
        lec_nric_title = new javax.swing.JLabel();
        lec_gender = new javax.swing.JLabel();
        lec_schoolwise_title = new javax.swing.JLabel();
        schoolwise_dropbox = new javax.swing.JComboBox<>();
        lec_details_background = new javax.swing.JLabel();
        lec_details_border = new javax.swing.JLabel();
        admin_modify_lec_save = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
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
        getContentPane().add(lec_name_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 90, -1));

        lec_name.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_name.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
        lec_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lec_nameActionPerformed(evt);
            }
        });
        getContentPane().add(lec_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 190, 50));

        lecturer_gender_selection.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_gender_selection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecturer_gender_selectionActionPerformed(evt);
            }
        });
        getContentPane().add(lecturer_gender_selection, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 190, 50));

        lec_empno.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_empno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lec_empnoActionPerformed(evt);
            }
        });
        getContentPane().add(lec_empno, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 190, 50));

        lec_empno_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_empno_title.setForeground(new java.awt.Color(2, 50, 99));
        lec_empno_title.setText("<html><div style = \"text-align: center; width: 50px;\">EMP Number</div></html>");
        getContentPane().add(lec_empno_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 70, -1));
        getContentPane().add(lec_dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 190, 50));

        lec_dob_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_dob_title.setForeground(new java.awt.Color(2, 50, 99));
        lec_dob_title.setText("Date Of Birth");
        getContentPane().add(lec_dob_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 110, 40));

        lec_address_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_address_title.setForeground(new java.awt.Color(2, 50, 99));
        lec_address_title.setText("Address");
        getContentPane().add(lec_address_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, -1, -1));

        lec_address.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lec_addressActionPerformed(evt);
            }
        });
        getContentPane().add(lec_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 190, 50));

        lec_contact_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_contact_title.setForeground(new java.awt.Color(2, 50, 99));
        lec_contact_title.setText("<html><div style = 'text-align: center; width:90px;'>Phone Number</div></html>");
        lec_contact_title.setToolTipText("");
        getContentPane().add(lec_contact_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 90, -1));

        lec_contact.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lec_contactActionPerformed(evt);
            }
        });
        getContentPane().add(lec_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 190, 50));

        lec_nation.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_nation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lec_nationActionPerformed(evt);
            }
        });
        getContentPane().add(lec_nation, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 190, 50));

        lec_nation_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_nation_title.setForeground(new java.awt.Color(2, 50, 99));
        lec_nation_title.setText("Nationality");
        getContentPane().add(lec_nation_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, -1, -1));

        lec_password_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_password_title.setForeground(new java.awt.Color(2, 50, 99));
        lec_password_title.setText("Password");
        getContentPane().add(lec_password_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, -1, -1));

        lec_password.setText("jPasswordField1");
        getContentPane().add(lec_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, 190, 50));

        lec_nric.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_nric.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lec_nricActionPerformed(evt);
            }
        });
        getContentPane().add(lec_nric, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 190, 50));

        lec_email.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lec_emailActionPerformed(evt);
            }
        });
        getContentPane().add(lec_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 190, 50));

        lec_email_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_email_title.setForeground(new java.awt.Color(2, 50, 99));
        lec_email_title.setText("<html><div style = \"text-align: center; width: 50px;\">Email Address</div></html>");
        getContentPane().add(lec_email_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, -1, -1));

        lec_nric_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_nric_title.setForeground(new java.awt.Color(2, 50, 99));
        lec_nric_title.setText("<html><div style= 'text-align: center; width: 90px;'>NRIC/ Passoport No</div></html>");
        getContentPane().add(lec_nric_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 120, -1));

        lec_gender.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_gender.setForeground(new java.awt.Color(2, 50, 99));
        lec_gender.setText("Gender");
        getContentPane().add(lec_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, -1, -1));

        lec_schoolwise_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lec_schoolwise_title.setForeground(new java.awt.Color(2, 50, 99));
        lec_schoolwise_title.setText("<html><div style = 'text-align: center; width:70px;'>School Wise</div></html>");
        getContentPane().add(lec_schoolwise_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, -1, -1));

        schoolwise_dropbox.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        getContentPane().add(schoolwise_dropbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 190, 50));

        lec_details_background.setBackground(new Color(192, 192, 192, 90));
        lec_details_background.setMaximumSize(new java.awt.Dimension(550, 350));
        lec_details_background.setMinimumSize(new java.awt.Dimension(550, 350));
        lec_details_background.setName(""); // NOI18N
        lec_details_background.setOpaque(true);
        lec_details_background.setPreferredSize(new java.awt.Dimension(550, 350));
        getContentPane().add(lec_details_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 630, 420));

        lec_details_border.setBackground(new Color(255, 255, 255, 0));
        lec_details_border.setBorder(new LineBorder(new Color(192, 192, 192, 90), 15, true));
        lec_details_border.setMaximumSize(new java.awt.Dimension(600, 400));
        lec_details_border.setMinimumSize(new java.awt.Dimension(600, 400));
        lec_details_border.setOpaque(true);
        lec_details_border.setPreferredSize(new java.awt.Dimension(600, 400));
        getContentPane().add(lec_details_border, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 650, 440));

        admin_modify_lec_save.setBackground(new java.awt.Color(2, 50, 99));
        admin_modify_lec_save.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        admin_modify_lec_save.setForeground(new java.awt.Color(255, 255, 255));
        admin_modify_lec_save.setText("SAVE CHANGES");
        admin_modify_lec_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_modify_lec_saveActionPerformed(evt);
            }
        });
        getContentPane().add(admin_modify_lec_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 520, -1, -1));

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

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        background.setMaximumSize(new java.awt.Dimension(700, 580));
        background.setMinimumSize(new java.awt.Dimension(700, 580));
        background.setPreferredSize(new java.awt.Dimension(700, 580));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        background.getAccessibleContext().setAccessibleName("background");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lec_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lec_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lec_nameActionPerformed

    private void lecturer_gender_selectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecturer_gender_selectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturer_gender_selectionActionPerformed

    private void lec_empnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lec_empnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lec_empnoActionPerformed

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

    private void admin_modify_lec_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_modify_lec_saveActionPerformed
        String userID = lec_empno.getText();
        while (true) {
            try {
                String[] userInput = new String[12];
                userInput[0] = lec_name.getText().toUpperCase().trim();
                userInput[1] = lecturer_gender_selection.getSelectedItem().toString();

                Date date = lec_dob.getDate();
                System.out.println("Date selected: " + date.toString());
                if (date == null) {
                    throw new Exception("Date is null");
                }

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                userInput[2] = dateFormat.format(date).trim();
                userInput[3] = lec_empno.getText().toUpperCase().trim();
                userInput[4] = lec_address.getText().toUpperCase().trim();
                userInput[5] = lec_contact.getText().trim();
                userInput[6] = lec_nric.getText().trim();
                userInput[7] = lec_nation.getText().toUpperCase().trim();
                userInput[8] = lec_email.getText().toLowerCase().trim();
                userInput[9] = lecRole;
                userInput[10] = schoolwise_dropbox.getSelectedItem().toString();
                userInput[11] = lec_password.getText().trim();
                UserController.modifyUser(userInput);

                break;
            } catch (Exception e) {
            }
        }

    }//GEN-LAST:event_admin_modify_lec_saveActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        String userID = lec_empno.getText();
        UserController viewuser = new UserController();
        viewuser.viewUser(userID);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

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
    private javax.swing.JLabel background;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField lec_address;
    private javax.swing.JLabel lec_address_title;
    private javax.swing.JTextField lec_contact;
    private javax.swing.JLabel lec_contact_title;
    private javax.swing.JLabel lec_details_background;
    private javax.swing.JLabel lec_details_border;
    private com.toedter.calendar.JDateChooser lec_dob;
    private javax.swing.JLabel lec_dob_title;
    private javax.swing.JTextField lec_email;
    private javax.swing.JLabel lec_email_title;
    private javax.swing.JTextField lec_empno;
    private javax.swing.JLabel lec_empno_title;
    private javax.swing.JLabel lec_gender;
    private javax.swing.JTextField lec_name;
    private javax.swing.JLabel lec_name_title;
    private javax.swing.JTextField lec_nation;
    private javax.swing.JLabel lec_nation_title;
    private javax.swing.JTextField lec_nric;
    private javax.swing.JLabel lec_nric_title;
    private javax.swing.JPasswordField lec_password;
    private javax.swing.JLabel lec_password_title;
    private javax.swing.JLabel lec_schoolwise_title;
    private javax.swing.JComboBox<String> lecturer_gender_selection;
    private javax.swing.JComboBox<String> schoolwise_dropbox;
    // End of variables declaration//GEN-END:variables
}
