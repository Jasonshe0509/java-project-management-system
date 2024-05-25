package com.mycompany.projectmanagementsystem;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import com.mycompany.projectmanagementsystem.User.UserController;
import java.awt.Color;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class admin_modify_studentrecord extends javax.swing.JFrame {

    List<String> genderList, intakeRecord;
    public admin_modify_studentrecord() {
        initComponents();
        setIconImage();
        dropbox_Gender(genderList);
        dropbox_IntakeCode(intakeRecord);
    }
    
    public void dropbox_Gender(List<String> genderList) {
        student_gender_selection.addItem("");
        student_gender_selection.addItem("Female");
        student_gender_selection.addItem("Male");
    }
    public void dropbox_IntakeCode(List<String> intakeRecord) {
        intakeRecord = FileHandler.readFile("intake.txt");
        Object[] lines = intakeRecord.toArray();
        student_intake_selection.addItem("");

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].toString();
            String[] results = line.split(";");
            String intakeCode = results[0];
            student_intake_selection.addItem(intakeCode);
        }

    }
    public void displayStudentDetails(ArrayList<String> list){
        
        student_tpno.setText(list.get(0));
        student_name.setText(list.get(1));
        student_gender_selection.setSelectedItem(list.get(2));
        student_contact.setText(list.get(3));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateFormat.parse(list.get(4)); // Parse the date string to a Date object
            dob_chooser.setDate(date); // Set the Date object to the date chooser
        } catch (ParseException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        student_address.setText(list.get(5));
        student_nric.setText(list.get(6));
        student_nation.setText(list.get(7));
        student_email.setText(list.get(8));
        student_password.setText("**********");
        student_intake_selection.setSelectedItem(list.get(11));
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        student_name_title = new javax.swing.JLabel();
        student_name = new javax.swing.JTextField();
        student_gender_selection = new javax.swing.JComboBox<>();
        student_tpno = new javax.swing.JTextField();
        student_tpno_title = new javax.swing.JLabel();
        student_dob_title = new javax.swing.JLabel();
        dob_chooser = new com.toedter.calendar.JDateChooser();
        student_address_title = new javax.swing.JLabel();
        student_address = new javax.swing.JTextField();
        student_contact_title = new javax.swing.JLabel();
        student_contact = new javax.swing.JTextField();
        student_nation = new javax.swing.JTextField();
        student_nation_title = new javax.swing.JLabel();
        student_password_title = new javax.swing.JLabel();
        student_password = new javax.swing.JTextField();
        student_nric = new javax.swing.JTextField();
        student_email = new javax.swing.JTextField();
        student_email_title = new javax.swing.JLabel();
        student_nric_title = new javax.swing.JLabel();
        student_gender1 = new javax.swing.JLabel();
        student_intake_selection = new javax.swing.JComboBox<>();
        student_gender = new javax.swing.JLabel();
        student_image = new javax.swing.JLabel();
        student_details_background = new javax.swing.JLabel();
        student_details_border = new javax.swing.JLabel();
        admin_viewstudent_back = new javax.swing.JButton();
        admin_modify_student_save = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("View Student Record");
        setMaximumSize(new java.awt.Dimension(700, 570));
        setMinimumSize(new java.awt.Dimension(700, 570));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        student_name_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_name_title.setForeground(new java.awt.Color(2, 50, 99));
        student_name_title.setText("Full Name");
        getContentPane().add(student_name_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 90, -1));

        student_name.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_name.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
        student_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_nameActionPerformed(evt);
            }
        });
        getContentPane().add(student_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 190, 50));

        student_gender_selection.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_gender_selection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Female", "Male"}));
        student_gender_selection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_gender_selectionActionPerformed(evt);
            }
        });
        getContentPane().add(student_gender_selection, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 190, 50));

        student_tpno.setEditable(false);
        student_tpno.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_tpno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_tpnoActionPerformed(evt);
            }
        });
        getContentPane().add(student_tpno, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 190, 50));

        student_tpno_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_tpno_title.setForeground(new java.awt.Color(2, 50, 99));
        student_tpno_title.setText("TP Number");
        getContentPane().add(student_tpno_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        student_dob_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_dob_title.setForeground(new java.awt.Color(2, 50, 99));
        student_dob_title.setText("Date Of Birth\n");
        getContentPane().add(student_dob_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 110, 40));
        getContentPane().add(dob_chooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 190, 50));

        student_address_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_address_title.setForeground(new java.awt.Color(2, 50, 99));
        student_address_title.setText("Address");
        getContentPane().add(student_address_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, -1, -1));

        student_address.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_addressActionPerformed(evt);
            }
        });
        getContentPane().add(student_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 190, 50));

        student_contact_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_contact_title.setForeground(new java.awt.Color(2, 50, 99));
        student_contact_title.setText("<html><div style = 'text-align: center; width:90px;'>Phone Number </div></html>");
        student_contact_title.setToolTipText("");
        getContentPane().add(student_contact_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, 90, -1));

        student_contact.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_contactActionPerformed(evt);
            }
        });
        getContentPane().add(student_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 190, 50));

        student_nation.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_nation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_nationActionPerformed(evt);
            }
        });
        getContentPane().add(student_nation, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 190, 50));

        student_nation_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_nation_title.setForeground(new java.awt.Color(2, 50, 99));
        student_nation_title.setText("Nationality");
        getContentPane().add(student_nation_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, -1, -1));

        student_password_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_password_title.setForeground(new java.awt.Color(2, 50, 99));
        student_password_title.setText("Password");
        getContentPane().add(student_password_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 420, -1, -1));

        student_password.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(student_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, 190, 50));

        student_nric.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_nric.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_nricActionPerformed(evt);
            }
        });
        getContentPane().add(student_nric, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 190, 50));

        student_email.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_emailActionPerformed(evt);
            }
        });
        getContentPane().add(student_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 190, 50));

        student_email_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_email_title.setForeground(new java.awt.Color(2, 50, 99));
        student_email_title.setText("Email Address");
        getContentPane().add(student_email_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        student_nric_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_nric_title.setForeground(new java.awt.Color(2, 50, 99));
        student_nric_title.setText("<html><div style= 'text-align: center; width: 90px;'>NRIC/ Passoport No</div></html>");
        getContentPane().add(student_nric_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 120, -1));

        student_gender1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_gender1.setForeground(new java.awt.Color(2, 50, 99));
        student_gender1.setText("Intake Code");
        getContentPane().add(student_gender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, -1, -1));

        student_intake_selection.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_intake_selection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Female", "Male"}));
        student_intake_selection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_intake_selectionActionPerformed(evt);
            }
        });
        getContentPane().add(student_intake_selection, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 190, 50));

        student_gender.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_gender.setForeground(new java.awt.Color(2, 50, 99));
        student_gender.setText("Gender");
        getContentPane().add(student_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, -1, -1));

        student_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_image.png"))); // NOI18N
        getContentPane().add(student_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 360, -1, -1));

        student_details_background.setBackground(new Color(192, 192, 192, 90));
        student_details_background.setMaximumSize(new java.awt.Dimension(550, 350));
        student_details_background.setMinimumSize(new java.awt.Dimension(550, 350));
        student_details_background.setName(""); // NOI18N
        student_details_background.setOpaque(true);
        student_details_background.setPreferredSize(new java.awt.Dimension(550, 350));
        getContentPane().add(student_details_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 630, 400));

        student_details_border.setBackground(new Color(255, 255, 255, 0));
        student_details_border.setBorder(new LineBorder(new Color(192, 192, 192, 90), 15, true));
        student_details_border.setMaximumSize(new java.awt.Dimension(600, 400));
        student_details_border.setMinimumSize(new java.awt.Dimension(600, 400));
        student_details_border.setOpaque(true);
        student_details_border.setPreferredSize(new java.awt.Dimension(600, 400));
        getContentPane().add(student_details_border, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 650, 420));

        admin_viewstudent_back.setBackground(new java.awt.Color(76, 127, 174));
        admin_viewstudent_back.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        admin_viewstudent_back.setForeground(new java.awt.Color(2, 50, 99));
        admin_viewstudent_back.setText("BACK");
        admin_viewstudent_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_viewstudent_backActionPerformed(evt);
            }
        });
        getContentPane().add(admin_viewstudent_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 500, -1, -1));

        admin_modify_student_save.setBackground(new java.awt.Color(76, 127, 174));
        admin_modify_student_save.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        admin_modify_student_save.setForeground(new java.awt.Color(2, 50, 99));
        admin_modify_student_save.setText("SAVE CHANGES");
        admin_modify_student_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_modify_student_saveActionPerformed(evt);
            }
        });
        getContentPane().add(admin_modify_student_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 500, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        background.setMaximumSize(new java.awt.Dimension(700, 500));
        background.setMinimumSize(new java.awt.Dimension(700, 500));
        background.setPreferredSize(new java.awt.Dimension(700, 500));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 570));
        background.getAccessibleContext().setAccessibleName("background");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void admin_viewstudent_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_viewstudent_backActionPerformed
        // TODO add your handling code here:
        admin_view_studentrecord admin_view_sturecord = new admin_view_studentrecord();
        admin_view_sturecord.show();
        dispose();
    }//GEN-LAST:event_admin_viewstudent_backActionPerformed

    private void student_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_nameActionPerformed

    private void student_gender_selectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_gender_selectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_gender_selectionActionPerformed

    private void student_tpnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_tpnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_tpnoActionPerformed

    private void student_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_addressActionPerformed

    private void student_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_contactActionPerformed

    private void student_nationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_nationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_nationActionPerformed

    private void student_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_passwordActionPerformed

    private void student_nricActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_nricActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_nricActionPerformed

    private void student_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_emailActionPerformed

    private void student_intake_selectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_intake_selectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_intake_selectionActionPerformed

    private void admin_modify_student_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_modify_student_saveActionPerformed
        while (true) {
            try {
                String[] userInput = new String[12];
                userInput[0] = student_name.getText().toUpperCase().trim();
                userInput[1] = student_gender_selection.getSelectedItem().toString();

                Date date = dob_chooser.getDate();
                if (date == null) {
                    throw new Exception();
                }
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                userInput[2] = dateFormat.format(date).trim();
                userInput[3] = student_tpno.getText().toUpperCase().trim();
                userInput[4] = student_address.getText().toUpperCase().trim();
                userInput[5] = student_contact.getText().trim();
                userInput[6] = student_nric.getText().trim();
                userInput[7] = student_nation.getText().toUpperCase().trim();
                userInput[8] = student_email.getText().toLowerCase().trim();
                userInput[9] = "student";
                userInput[10] = student_intake_selection.getSelectedItem().toString();
                userInput[11] = student_password.getText().trim();
                
                UserController.modifyUser(userInput);
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please Fill In Date!", "Error: Missing Value(s)", JOptionPane.ERROR_MESSAGE);
                break;
            }
        }
    }//GEN-LAST:event_admin_modify_student_saveActionPerformed
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_modify_studentrecord().setVisible(true);
            }
        });
    }
        private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon_with_background.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton admin_modify_student_save;
    private javax.swing.JButton admin_viewstudent_back;
    private javax.swing.JLabel background;
    private com.toedter.calendar.JDateChooser dob_chooser;
    private javax.swing.JTextField student_address;
    private javax.swing.JLabel student_address_title;
    private javax.swing.JTextField student_contact;
    private javax.swing.JLabel student_contact_title;
    private javax.swing.JLabel student_details_background;
    private javax.swing.JLabel student_details_border;
    private javax.swing.JLabel student_dob_title;
    private javax.swing.JTextField student_email;
    private javax.swing.JLabel student_email_title;
    private javax.swing.JLabel student_gender;
    private javax.swing.JLabel student_gender1;
    private javax.swing.JComboBox<String> student_gender_selection;
    private javax.swing.JLabel student_image;
    private javax.swing.JComboBox<String> student_intake_selection;
    private javax.swing.JTextField student_name;
    private javax.swing.JLabel student_name_title;
    private javax.swing.JTextField student_nation;
    private javax.swing.JLabel student_nation_title;
    private javax.swing.JTextField student_nric;
    private javax.swing.JLabel student_nric_title;
    private javax.swing.JTextField student_password;
    private javax.swing.JLabel student_password_title;
    private javax.swing.JTextField student_tpno;
    private javax.swing.JLabel student_tpno_title;
    // End of variables declaration//GEN-END:variables
}
