package com.mycompany.projectmanagementsystem;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import com.mycompany.projectmanagementsystem.User.UserController;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class admin_register_lecturer extends javax.swing.JFrame {
    List<String> gender, schoolWiseList;

    
    public admin_register_lecturer() {
        initComponents();
        setIconImage();
        dropbox_Gender(gender);
        dropbox_SchoolWise(schoolWiseList);
        
    }
    public void dropbox_Gender(List<String> genderList) {
        lecturer_gender_selection.addItem("");
        lecturer_gender_selection.addItem("Female");
        lecturer_gender_selection.addItem("Male");
    }

    public void dropbox_SchoolWise(List<String> schoolWiseList) {
        schoolWiseList = FileHandler.readFile("school_wise.txt");
        Object[] lines = schoolWiseList.toArray();
        schoolwise_dropbox.addItem("");

        for (int i = 0; i < lines.length; i++) {
            String schoolWise = lines[i].toString();
            schoolwise_dropbox.addItem(schoolWise);
        }
    }


   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        register_lecturer = new javax.swing.JLabel();
        lecturer_gender = new javax.swing.JLabel();
        lecturer_gender_selection = new javax.swing.JComboBox<>();
        lecturer_dob_title = new javax.swing.JLabel();
        lecturer_empno_title = new javax.swing.JLabel();
        emp_tpno = new javax.swing.JTextField();
        lecturer_contact_title = new javax.swing.JLabel();
        lecturer_contact = new javax.swing.JTextField();
        lecturer_address_title = new javax.swing.JLabel();
        lecturer_address = new javax.swing.JTextField();
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
        dob_chooser = new com.toedter.calendar.JDateChooser();
        schoolwise_dropbox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Register Lecturer");
        setMaximumSize(new java.awt.Dimension(700, 520));
        setMinimumSize(new java.awt.Dimension(700, 520));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        register_lecturer.setFont(new java.awt.Font("Bell MT", 1, 26)); // NOI18N
        register_lecturer.setForeground(new java.awt.Color(2, 50, 99));
        register_lecturer.setText("Register New Lecturer");
        getContentPane().add(register_lecturer, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        lecturer_gender.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_gender.setForeground(new java.awt.Color(2, 50, 99));
        lecturer_gender.setText("Gender");
        getContentPane().add(lecturer_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, -1, -1));

        lecturer_gender_selection.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_gender_selection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecturer_gender_selectionActionPerformed(evt);
            }
        });
        getContentPane().add(lecturer_gender_selection, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 190, 50));

        lecturer_dob_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_dob_title.setForeground(new java.awt.Color(2, 50, 99));
        lecturer_dob_title.setText("Date Of Birth\n");
        getContentPane().add(lecturer_dob_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 110, 40));

        lecturer_empno_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_empno_title.setForeground(new java.awt.Color(2, 50, 99));
        lecturer_empno_title.setText("EMP ID");
        getContentPane().add(lecturer_empno_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 80, -1));

        emp_tpno.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        emp_tpno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_tpnoActionPerformed(evt);
            }
        });
        getContentPane().add(emp_tpno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 190, 50));

        lecturer_contact_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_contact_title.setForeground(new java.awt.Color(2, 50, 99));
        lecturer_contact_title.setText("<html><div style = 'text-align: center; width:90px;'>Phone Number </div></html>");
        lecturer_contact_title.setToolTipText("");
        getContentPane().add(lecturer_contact_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 90, -1));

        lecturer_contact.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecturer_contactActionPerformed(evt);
            }
        });
        getContentPane().add(lecturer_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 190, 50));

        lecturer_address_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_address_title.setForeground(new java.awt.Color(2, 50, 99));
        lecturer_address_title.setText("Address");
        getContentPane().add(lecturer_address_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, -1, -1));

        lecturer_address.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecturer_addressActionPerformed(evt);
            }
        });
        getContentPane().add(lecturer_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 190, 50));

        lecturer_email_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_email_title.setForeground(new java.awt.Color(2, 50, 99));
        lecturer_email_title.setText("<html><div style = 'text-align: center; width:90px;'>Email Address</div></html>");
        getContentPane().add(lecturer_email_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 120, 50));

        lecturer_email.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecturer_emailActionPerformed(evt);
            }
        });
        getContentPane().add(lecturer_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 190, 50));

        register_lecturer_submit.setBackground(new java.awt.Color(2, 50, 99));
        register_lecturer_submit.setFont(new java.awt.Font("Bell MT", 1, 19)); // NOI18N
        register_lecturer_submit.setForeground(new java.awt.Color(255, 255, 255));
        register_lecturer_submit.setText("SUBMIT");
        register_lecturer_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register_lecturer_submitActionPerformed(evt);
            }
        });
        getContentPane().add(register_lecturer_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, -1, -1));

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
        getContentPane().add(lecturer_name_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 90, -1));

        lecturer_name.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lecturer_name.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
        lecturer_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecturer_nameActionPerformed(evt);
            }
        });
        getContentPane().add(lecturer_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 190, 50));

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
        lecturer_schoolwise_title.setText("<html><div style= 'text-align: center; width: 50px;'>School Wise</div></html>");
        getContentPane().add(lecturer_schoolwise_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 80, -1));

        dob_chooser.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        getContentPane().add(dob_chooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 190, 50));

        schoolwise_dropbox.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        schoolwise_dropbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schoolwise_dropboxActionPerformed(evt);
            }
        });
        getContentPane().add(schoolwise_dropbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 190, 50));

        jLabel1.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(2, 50, 99));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back.png"))); // NOI18N
        jLabel1.setText("BACK");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        background.setToolTipText("");
        background.setMaximumSize(new java.awt.Dimension(700, 520));
        background.setMinimumSize(new java.awt.Dimension(700, 520));
        background.setPreferredSize(new java.awt.Dimension(700, 520));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lecturer_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecturer_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturer_addressActionPerformed

    private void emp_tpnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_tpnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_tpnoActionPerformed

    private void lecturer_gender_selectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecturer_gender_selectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturer_gender_selectionActionPerformed

    private void lecturer_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecturer_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturer_emailActionPerformed

    private void register_lecturer_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register_lecturer_submitActionPerformed
        while (true) {
            try {
                String[] userInput = new String[11];
                userInput[0] = lecturer_name.getText().toUpperCase().trim();
                userInput[1] = lecturer_gender_selection.getSelectedItem().toString();

                Date date = dob_chooser.getDate();
                if (date == null) {
                    throw new Exception();
                }
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                userInput[2] = dateFormat.format(date).trim();
                userInput[3] = emp_tpno.getText().toUpperCase().trim();
                userInput[4] = lecturer_address.getText().toUpperCase().trim();
                userInput[5] = lecturer_contact.getText().trim();
                userInput[6] = lecturer_nric.getText().trim();
                userInput[7] = lecturer_nation.getText().toUpperCase().trim();
                userInput[8] = lecturer_email.getText().toLowerCase().trim();
                userInput[9] = "lecturer";
                userInput[10] = schoolwise_dropbox.getSelectedItem().toString();
                UserController.userCreate(userInput);
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please Fill In Date!", "Error: Missing Value(s)", JOptionPane.ERROR_MESSAGE);
                break;
            }
        }
    }//GEN-LAST:event_register_lecturer_submitActionPerformed

    private void lecturer_nationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecturer_nationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturer_nationActionPerformed

    private void lecturer_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecturer_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturer_contactActionPerformed

    private void lecturer_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecturer_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturer_nameActionPerformed

    private void lecturer_nricActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecturer_nricActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturer_nricActionPerformed

    private void schoolwise_dropboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schoolwise_dropboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_schoolwise_dropboxActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_register_lecturer().setVisible(true);
            }
        });
    }
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon_with_background.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private com.toedter.calendar.JDateChooser dob_chooser;
    private javax.swing.JTextField emp_tpno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField lecturer_address;
    private javax.swing.JLabel lecturer_address_title;
    private javax.swing.JTextField lecturer_contact;
    private javax.swing.JLabel lecturer_contact_title;
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
    private javax.swing.JLabel lecturer_schoolwise_title;
    private javax.swing.JLabel register_lecturer;
    private javax.swing.JButton register_lecturer_submit;
    private javax.swing.JComboBox<String> schoolwise_dropbox;
    // End of variables declaration//GEN-END:variables
}
