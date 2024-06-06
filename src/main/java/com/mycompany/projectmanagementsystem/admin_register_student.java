package com.mycompany.projectmanagementsystem;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import com.mycompany.projectmanagementsystem.User.UserController;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class admin_register_student extends javax.swing.JFrame {

    List<String> genderList, intakeRecord;

    public admin_register_student() {
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
        intakcode_selection.addItem("");

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].toString();
            String[] results = line.split(";");
            String intakeCode = results[0];
            intakcode_selection.addItem(intakeCode);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        register_student = new javax.swing.JLabel();
        student_gender = new javax.swing.JLabel();
        student_gender_selection = new javax.swing.JComboBox<>();
        student_dob_title = new javax.swing.JLabel();
        student_tpno_title = new javax.swing.JLabel();
        student_ID = new javax.swing.JTextField();
        student_password_title = new javax.swing.JLabel();
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
        student_nric_title = new javax.swing.JLabel();
        dob_chooser = new com.toedter.calendar.JDateChooser();
        student_nric = new javax.swing.JTextField();
        intakcode_selection = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Register Student");
        setMaximumSize(new java.awt.Dimension(700, 500));
        setMinimumSize(new java.awt.Dimension(700, 500));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        register_student.setFont(new java.awt.Font("Bell MT", 1, 26)); // NOI18N
        register_student.setForeground(new java.awt.Color(2, 50, 99));
        register_student.setText("Register New Student");
        getContentPane().add(register_student, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        student_gender.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_gender.setForeground(new java.awt.Color(2, 50, 99));
        student_gender.setText("Gender");
        getContentPane().add(student_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, -1, -1));

        student_gender_selection.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_gender_selection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_gender_selectionActionPerformed(evt);
            }
        });
        getContentPane().add(student_gender_selection, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 190, 50));

        student_dob_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_dob_title.setForeground(new java.awt.Color(2, 50, 99));
        student_dob_title.setText("Date Of Birth\n");
        getContentPane().add(student_dob_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 110, 40));

        student_tpno_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_tpno_title.setForeground(new java.awt.Color(2, 50, 99));
        student_tpno_title.setText("Student ID");
        getContentPane().add(student_tpno_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        student_ID.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_IDActionPerformed(evt);
            }
        });
        getContentPane().add(student_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 190, 50));

        student_password_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_password_title.setForeground(new java.awt.Color(2, 50, 99));
        student_password_title.setText("Intake Code");
        getContentPane().add(student_password_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, -1, -1));

        student_contact_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_contact_title.setForeground(new java.awt.Color(2, 50, 99));
        student_contact_title.setText("<html><div style = 'text-align: center; width:90px;'>Phone Number </div></html>");
        student_contact_title.setToolTipText("");
        getContentPane().add(student_contact_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 90, -1));

        student_contact.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_contactActionPerformed(evt);
            }
        });
        getContentPane().add(student_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 190, 50));

        student_address_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_address_title.setForeground(new java.awt.Color(2, 50, 99));
        student_address_title.setText("Address");
        getContentPane().add(student_address_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, -1, -1));

        student_address.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_addressActionPerformed(evt);
            }
        });
        getContentPane().add(student_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 190, 50));

        student_email_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_email_title.setForeground(new java.awt.Color(2, 50, 99));
        student_email_title.setText("Email Address");
        getContentPane().add(student_email_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        student_email.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_emailActionPerformed(evt);
            }
        });
        getContentPane().add(student_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 190, 50));

        register_student_submit.setBackground(new java.awt.Color(2, 50, 99));
        register_student_submit.setFont(new java.awt.Font("Bell MT", 1, 19)); // NOI18N
        register_student_submit.setForeground(new java.awt.Color(255, 255, 255));
        register_student_submit.setText("SUBMIT");
        register_student_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register_student_submitActionPerformed(evt);
            }
        });
        getContentPane().add(register_student_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 430, -1, -1));

        student_nation_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_nation_title.setForeground(new java.awt.Color(2, 50, 99));
        student_nation_title.setText("Nationality");
        getContentPane().add(student_nation_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, -1, 30));

        student_nation.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_nation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_nationActionPerformed(evt);
            }
        });
        getContentPane().add(student_nation, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 190, 50));

        student_name_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_name_title.setForeground(new java.awt.Color(2, 50, 99));
        student_name_title.setText("Full Name");
        getContentPane().add(student_name_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 90, -1));

        student_name.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_name.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
        student_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_nameActionPerformed(evt);
            }
        });
        getContentPane().add(student_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 190, 50));

        student_nric_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_nric_title.setForeground(new java.awt.Color(2, 50, 99));
        student_nric_title.setText("<html><div style= 'text-align: center; width: 90px;'>NRIC/ Passoport No</div></html>");
        getContentPane().add(student_nric_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 120, -1));

        dob_chooser.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        getContentPane().add(dob_chooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 190, 50));

        student_nric.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_nric.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_nricActionPerformed(evt);
            }
        });
        getContentPane().add(student_nric, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 190, 50));

        intakcode_selection.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        intakcode_selection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intakcode_selectionActionPerformed(evt);
            }
        });
        getContentPane().add(intakcode_selection, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 190, 50));

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
        background.setToolTipText("");
        background.setMaximumSize(new java.awt.Dimension(700, 500));
        background.setMinimumSize(new java.awt.Dimension(700, 500));
        background.setPreferredSize(new java.awt.Dimension(700, 480));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void student_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_addressActionPerformed

    private void student_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_IDActionPerformed

    private void student_gender_selectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_gender_selectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_gender_selectionActionPerformed

    private void student_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_emailActionPerformed

    private void register_student_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register_student_submitActionPerformed
        while (true) {
            try {
                String[] userInput = new String[11];
                userInput[0] = student_name.getText().toUpperCase().trim();
                userInput[1] = student_gender_selection.getSelectedItem().toString();

                Date date = dob_chooser.getDate();
                if (date == null) {
                    throw new Exception();
                }
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                userInput[2] = dateFormat.format(date).trim();
                userInput[3] = student_ID.getText().toUpperCase().trim();
                userInput[4] = student_address.getText().toUpperCase().trim();
                userInput[5] = student_contact.getText().trim();
                userInput[6] = student_nric.getText().trim();
                userInput[7] = student_nation.getText().toUpperCase().trim();
                userInput[8] = student_email.getText().toLowerCase().trim();
                userInput[9] = "student";
                userInput[10] = intakcode_selection.getSelectedItem().toString();
                UserController.userCreate(userInput);
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please Fill In Date!", "Error: Missing Value(s)", JOptionPane.ERROR_MESSAGE);
                break;
            }
        }


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

    private void student_nricActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_nricActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_nricActionPerformed

    private void intakcode_selectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intakcode_selectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_intakcode_selectionActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_register_student().setVisible(true);
            }
        });
    }

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private com.toedter.calendar.JDateChooser dob_chooser;
    private javax.swing.JComboBox<String> intakcode_selection;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel register_student;
    private javax.swing.JButton register_student_submit;
    private javax.swing.JTextField student_ID;
    private javax.swing.JTextField student_address;
    private javax.swing.JLabel student_address_title;
    private javax.swing.JTextField student_contact;
    private javax.swing.JLabel student_contact_title;
    private javax.swing.JLabel student_dob_title;
    private javax.swing.JTextField student_email;
    private javax.swing.JLabel student_email_title;
    private javax.swing.JLabel student_gender;
    private javax.swing.JComboBox<String> student_gender_selection;
    private javax.swing.JTextField student_name;
    private javax.swing.JLabel student_name_title;
    private javax.swing.JTextField student_nation;
    private javax.swing.JLabel student_nation_title;
    private javax.swing.JTextField student_nric;
    private javax.swing.JLabel student_nric_title;
    private javax.swing.JLabel student_password_title;
    private javax.swing.JLabel student_tpno_title;
    // End of variables declaration//GEN-END:variables
}
