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

    String userID;
    List<String> genderList, intakeRecord;

    public admin_modify_studentrecord() {
        initComponents();
        setIconImage();
        dropbox_Gender(genderList);
        dropbox_IntakeCode(intakeRecord);
    }

    public void dropbox_Gender(List<String> genderList) {
        student_gender_selection.addItem("Female");
        student_gender_selection.addItem("Male");
    }

    public void dropbox_IntakeCode(List<String> intakeRecord) {
        intakeRecord = FileHandler.readFile("intake.txt");
        Object[] lines = intakeRecord.toArray();

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].toString();
            String[] results = line.split(";");
            String intakeCode = results[0];
            student_intake_selection.addItem(intakeCode);
        }

    }

    public String displayStudentDetails(ArrayList<String> list) {

        student_tpno.setText(list.get(0));
        userID = list.get(0);
        student_name.setText(list.get(1));
        student_gender_selection.setSelectedItem(list.get(2));
        student_contact.setText(list.get(3));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateFormat.parse(list.get(4)); // Parse the date string to a Date object
            student_dob.setDate(date); // Set the Date object to the date chooser
        } catch (ParseException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        student_address.setText(list.get(5));
        student_nric.setText(list.get(6));
        student_nation.setText(list.get(7));
        student_email.setText(list.get(8));
        student_password.setText(list.get(9));
        student_password.setEchoChar('*');
        student_intake_selection.setSelectedItem(list.get(11));

        return userID;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        student_name_title = new javax.swing.JLabel();
        student_name = new javax.swing.JTextField();
        student_gender_selection = new javax.swing.JComboBox<>();
        intake_title = new javax.swing.JLabel();
        student_intake_selection = new javax.swing.JComboBox<>();
        student_tpno = new javax.swing.JTextField();
        student_tpno_title = new javax.swing.JLabel();
        student_dob_title = new javax.swing.JLabel();
        student_address_title = new javax.swing.JLabel();
        student_address = new javax.swing.JTextField();
        student_contact_title = new javax.swing.JLabel();
        student_contact = new javax.swing.JTextField();
        student_nation = new javax.swing.JTextField();
        student_nation_title = new javax.swing.JLabel();
        student_password_title = new javax.swing.JLabel();
        student_password = new javax.swing.JPasswordField();
        student_nric = new javax.swing.JTextField();
        student_email = new javax.swing.JTextField();
        student_email_title = new javax.swing.JLabel();
        student_nric_title = new javax.swing.JLabel();
        student_dob = new com.toedter.calendar.JDateChooser();
        student_gender = new javax.swing.JLabel();
        student_image = new javax.swing.JLabel();
        student_details_background = new javax.swing.JLabel();
        student_details_border = new javax.swing.JLabel();
        admin_viewstudent_back = new javax.swing.JButton();
        admin_modify_student_save = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("View Student Record");
        setMinimumSize(new java.awt.Dimension(700, 550));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        student_name_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_name_title.setForeground(new java.awt.Color(2, 50, 99));
        student_name_title.setText("Full Name");
        getContentPane().add(student_name_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 90, -1));

        student_name.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_name.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
        getContentPane().add(student_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 190, 50));

        student_gender_selection.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        getContentPane().add(student_gender_selection, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 190, 50));

        intake_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        intake_title.setForeground(new java.awt.Color(2, 50, 99));
        intake_title.setText("Intake Code");
        getContentPane().add(intake_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, 30));

        student_intake_selection.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        getContentPane().add(student_intake_selection, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 190, 50));

        student_tpno.setEditable(false);
        student_tpno.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        getContentPane().add(student_tpno, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 190, 50));

        student_tpno_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_tpno_title.setForeground(new java.awt.Color(2, 50, 99));
        student_tpno_title.setText("TP Number");
        getContentPane().add(student_tpno_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        student_dob_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_dob_title.setForeground(new java.awt.Color(2, 50, 99));
        student_dob_title.setText("Date Of Birth\n");
        getContentPane().add(student_dob_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 110, 40));

        student_address_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_address_title.setForeground(new java.awt.Color(2, 50, 99));
        student_address_title.setText("Address");
        getContentPane().add(student_address_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, -1, -1));

        student_address.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        getContentPane().add(student_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, 190, 50));

        student_contact_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_contact_title.setForeground(new java.awt.Color(2, 50, 99));
        student_contact_title.setText("<html><div style = 'text-align: center; width:90px;'>Phone Number </div></html>");
        student_contact_title.setToolTipText("");
        getContentPane().add(student_contact_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 90, -1));

        student_contact.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        getContentPane().add(student_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 190, 50));

        student_nation.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        getContentPane().add(student_nation, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 190, 50));

        student_nation_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_nation_title.setForeground(new java.awt.Color(2, 50, 99));
        student_nation_title.setText("Nationality");
        getContentPane().add(student_nation_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, -1, -1));

        student_password_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_password_title.setForeground(new java.awt.Color(2, 50, 99));
        student_password_title.setText("Password");
        getContentPane().add(student_password_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, -1, -1));

        student_password.setText("jPasswordField1");
        getContentPane().add(student_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, 190, 50));

        student_nric.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        getContentPane().add(student_nric, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 190, 50));

        student_email.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        getContentPane().add(student_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 190, 50));

        student_email_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_email_title.setForeground(new java.awt.Color(2, 50, 99));
        student_email_title.setText("Email Address");
        getContentPane().add(student_email_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        student_nric_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_nric_title.setForeground(new java.awt.Color(2, 50, 99));
        student_nric_title.setText("<html><div style= 'text-align: center; width: 90px;'>NRIC/ Passoport No</div></html>");
        getContentPane().add(student_nric_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 120, -1));
        getContentPane().add(student_dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 190, 50));

        student_gender.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_gender.setForeground(new java.awt.Color(2, 50, 99));
        student_gender.setText("Gender");
        getContentPane().add(student_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, -1, -1));

        student_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_image.png"))); // NOI18N
        getContentPane().add(student_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 350, -1, -1));

        student_details_background.setBackground(new Color(192, 192, 192, 90));
        student_details_background.setMaximumSize(new java.awt.Dimension(550, 350));
        student_details_background.setMinimumSize(new java.awt.Dimension(550, 350));
        student_details_background.setName(""); // NOI18N
        student_details_background.setOpaque(true);
        student_details_background.setPreferredSize(new java.awt.Dimension(550, 350));
        getContentPane().add(student_details_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 630, 410));

        student_details_border.setBackground(new Color(255, 255, 255, 0));
        student_details_border.setBorder(new LineBorder(new Color(192, 192, 192, 90), 15, true));
        student_details_border.setMaximumSize(new java.awt.Dimension(600, 400));
        student_details_border.setMinimumSize(new java.awt.Dimension(600, 400));
        student_details_border.setOpaque(true);
        student_details_border.setPreferredSize(new java.awt.Dimension(600, 400));
        getContentPane().add(student_details_border, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 650, 430));

        admin_viewstudent_back.setBackground(new java.awt.Color(76, 127, 174));
        admin_viewstudent_back.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        admin_viewstudent_back.setForeground(new java.awt.Color(2, 50, 99));
        admin_viewstudent_back.setText("BACK");
        admin_viewstudent_back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admin_viewstudent_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_viewstudent_backActionPerformed(evt);
            }
        });
        getContentPane().add(admin_viewstudent_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 490, -1, -1));

        admin_modify_student_save.setBackground(new java.awt.Color(76, 127, 174));
        admin_modify_student_save.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        admin_modify_student_save.setForeground(new java.awt.Color(2, 50, 99));
        admin_modify_student_save.setText("SAVE CHANGES");
        admin_modify_student_save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admin_modify_student_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_modify_student_saveaActionPerformed(evt);
            }
        });
        getContentPane().add(admin_modify_student_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 490, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        background.setMaximumSize(new java.awt.Dimension(700, 550));
        background.setMinimumSize(new java.awt.Dimension(700, 550));
        background.setPreferredSize(new java.awt.Dimension(700, 550));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 550));
        background.getAccessibleContext().setAccessibleName("background");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void admin_viewstudent_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_viewstudent_backActionPerformed
        UserController viewUser = new UserController();
        viewUser.viewUser(userID);
        dispose();

    }//GEN-LAST:event_admin_viewstudent_backActionPerformed

    private void admin_modify_student_saveaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_modify_student_saveaActionPerformed
        while (true) {
            try {
                String[] userInput = new String[12];
                userInput[0] = student_name.getText().toUpperCase().trim();
                userInput[1] = student_gender_selection.getSelectedItem().toString();

                Date date = student_dob.getDate();
                System.out.println("Date selected: " + date.toString());
                if (date == null) {
                    throw new Exception("Date is null");
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
                JOptionPane.showMessageDialog(null, "NULL!", "Error: Missing Value(s)", JOptionPane.ERROR_MESSAGE);
                break;
            }
        }
    }//GEN-LAST:event_admin_modify_student_saveaActionPerformed

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
    private javax.swing.JLabel intake_title;
    private javax.swing.JTextField student_address;
    private javax.swing.JLabel student_address_title;
    private javax.swing.JTextField student_contact;
    private javax.swing.JLabel student_contact_title;
    private javax.swing.JLabel student_details_background;
    private javax.swing.JLabel student_details_border;
    private com.toedter.calendar.JDateChooser student_dob;
    private javax.swing.JLabel student_dob_title;
    private javax.swing.JTextField student_email;
    private javax.swing.JLabel student_email_title;
    private javax.swing.JLabel student_gender;
    private javax.swing.JComboBox<String> student_gender_selection;
    private javax.swing.JLabel student_image;
    private javax.swing.JComboBox<String> student_intake_selection;
    private javax.swing.JTextField student_name;
    private javax.swing.JLabel student_name_title;
    private javax.swing.JTextField student_nation;
    private javax.swing.JLabel student_nation_title;
    private javax.swing.JTextField student_nric;
    private javax.swing.JLabel student_nric_title;
    private javax.swing.JPasswordField student_password;
    private javax.swing.JLabel student_password_title;
    private javax.swing.JTextField student_tpno;
    private javax.swing.JLabel student_tpno_title;
    // End of variables declaration//GEN-END:variables
}
