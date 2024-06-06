package com.mycompany.projectmanagementsystem;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.border.LineBorder;

public class admin_ec_details extends javax.swing.JFrame {

    public admin_ec_details() {
        initComponents();
        setIconImage();
    }
    
    public void displayECDetails (String[] ecDetails){
        String studentID = ecDetails[1];
        List<String> data = FileHandler.readFile("user.txt");
        for(String line: data){
            String[] studentDetails = line.split(";");
            if(studentDetails.length >11 && line.startsWith(studentID)){
                
               
                student_ID.setText(studentDetails[0]);
                student_name.setText(studentDetails[1]);
                student_intakecode.setText(studentDetails[11]);
                student_email.setText(studentDetails[8]);
                student_contact.setText(studentDetails[3]);
            }
        }
        List<String> ecdata = FileHandler.readFile("ec.txt");
        for(String ecline: ecdata){
            if(ecline.startsWith(ecDetails[0])){
                String[] eclines = ecline.split(";");
                
                ec_id.setText(eclines[0]);
                assessment_id.setText(eclines[2]);
                applied_reason.setText(eclines[3]);
                ecdocument_link.setText(eclines[4]);
                ec_status.setText(eclines[5]);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        student_details = new javax.swing.JLabel();
        student_name_title = new javax.swing.JLabel();
        student_name = new javax.swing.JTextField();
        student_ID_title = new javax.swing.JLabel();
        student_ID = new javax.swing.JTextField();
        student_intakecode_title = new javax.swing.JLabel();
        student_intakecode = new javax.swing.JTextField();
        student_email_title = new javax.swing.JLabel();
        student_email = new javax.swing.JTextField();
        student_contact_title = new javax.swing.JLabel();
        student_contact = new javax.swing.JTextField();
        ec_id = new javax.swing.JTextField();
        ec_id_title = new javax.swing.JLabel();
        student_details_background = new javax.swing.JLabel();
        student_details_border = new javax.swing.JLabel();
        ec_details = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ec_status = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        assessment_id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        applied_reason = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ecdocument_link = new javax.swing.JTextField();
        ecdertail_background = new javax.swing.JLabel();
        ecdetail_border = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EC Details");
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        student_details.setBackground(new Color(76, 127, 174, 90));
        student_details.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        student_details.setForeground(new java.awt.Color(2, 50, 99));
        student_details.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        student_details.setText("Student Details");
        student_details.setToolTipText("");
        student_details.setMaximumSize(new java.awt.Dimension(150, 190));
        student_details.setMinimumSize(new java.awt.Dimension(150, 190));
        student_details.setName(""); // NOI18N
        student_details.setOpaque(true);
        student_details.setPreferredSize(new java.awt.Dimension(150, 190));
        getContentPane().add(student_details, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 180, 180));

        student_name_title.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        student_name_title.setForeground(new java.awt.Color(2, 50, 99));
        student_name_title.setText("Name");
        getContentPane().add(student_name_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, -1));

        student_name.setEditable(false);
        student_name.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        getContentPane().add(student_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 130, 30));

        student_ID_title.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        student_ID_title.setForeground(new java.awt.Color(2, 50, 99));
        student_ID_title.setText("TP Number");
        getContentPane().add(student_ID_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        student_ID.setEditable(false);
        student_ID.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        student_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_IDActionPerformed(evt);
            }
        });
        getContentPane().add(student_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 130, 30));

        student_intakecode_title.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        student_intakecode_title.setForeground(new java.awt.Color(2, 50, 99));
        student_intakecode_title.setText("Intake Code");
        getContentPane().add(student_intakecode_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, -1, -1));

        student_intakecode.setEditable(false);
        student_intakecode.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        student_intakecode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_intakecodeActionPerformed(evt);
            }
        });
        getContentPane().add(student_intakecode, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 130, 30));

        student_email_title.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        student_email_title.setForeground(new java.awt.Color(2, 50, 99));
        student_email_title.setText("Email");
        getContentPane().add(student_email_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        student_email.setEditable(false);
        student_email.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        student_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_emailActionPerformed(evt);
            }
        });
        getContentPane().add(student_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 130, 30));

        student_contact_title.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        student_contact_title.setForeground(new java.awt.Color(2, 50, 99));
        student_contact_title.setText("Contact Number");
        getContentPane().add(student_contact_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, -1, -1));

        student_contact.setEditable(false);
        student_contact.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        student_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_contactActionPerformed(evt);
            }
        });
        getContentPane().add(student_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 130, 30));

        ec_id.setEditable(false);
        ec_id.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        ec_id.setMaximumSize(new java.awt.Dimension(82, 30));
        ec_id.setMinimumSize(new java.awt.Dimension(82, 30));
        ec_id.setPreferredSize(new java.awt.Dimension(82, 30));
        ec_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ec_idActionPerformed(evt);
            }
        });
        getContentPane().add(ec_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 130, 30));

        ec_id_title.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        ec_id_title.setForeground(new java.awt.Color(2, 50, 99));
        ec_id_title.setText("EC ID");
        getContentPane().add(ec_id_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, -1, -1));

        student_details_background.setBackground(new Color(76, 127, 174, 90));
        student_details_background.setMaximumSize(new java.awt.Dimension(790, 190));
        student_details_background.setMinimumSize(new java.awt.Dimension(790, 190));
        student_details_background.setOpaque(true);
        student_details_background.setPreferredSize(new java.awt.Dimension(790, 190));
        getContentPane().add(student_details_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 780, 180));

        student_details_border.setBorder(new LineBorder(new Color(76, 127, 174, 90), 15, true));
        student_details_border.setMaximumSize(new java.awt.Dimension(800, 200));
        student_details_border.setMinimumSize(new java.awt.Dimension(800, 200));
        student_details_border.setPreferredSize(new java.awt.Dimension(800, 200));
        getContentPane().add(student_details_border, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 800, 200));

        ec_details.setBackground(new Color(192, 192, 192,90));
        ec_details.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        ec_details.setForeground(new java.awt.Color(2, 50, 99));
        ec_details.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ec_details.setText("EC Details");
        ec_details.setOpaque(true);
        getContentPane().add(ec_details, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 180, 200));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(2, 50, 99));
        jLabel5.setText("Status");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, -1, -1));

        ec_status.setEditable(false);
        ec_status.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        ec_status.setMaximumSize(new java.awt.Dimension(82, 30));
        ec_status.setMinimumSize(new java.awt.Dimension(82, 30));
        ec_status.setPreferredSize(new java.awt.Dimension(82, 30));
        ec_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ec_statusActionPerformed(evt);
            }
        });
        getContentPane().add(ec_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, 130, 30));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(2, 50, 99));
        jLabel2.setText("Assessment ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, -1, -1));

        assessment_id.setEditable(false);
        assessment_id.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        assessment_id.setMaximumSize(new java.awt.Dimension(82, 30));
        assessment_id.setMinimumSize(new java.awt.Dimension(82, 30));
        assessment_id.setPreferredSize(new java.awt.Dimension(82, 30));
        assessment_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assessment_idActionPerformed(evt);
            }
        });
        getContentPane().add(assessment_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 130, 30));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(2, 50, 99));
        jLabel3.setText("Applied Reason");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, -1, -1));

        applied_reason.setEditable(false);
        applied_reason.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        applied_reason.setMaximumSize(new java.awt.Dimension(82, 30));
        applied_reason.setMinimumSize(new java.awt.Dimension(82, 30));
        applied_reason.setPreferredSize(new java.awt.Dimension(82, 30));
        getContentPane().add(applied_reason, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 330, 60));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(2, 50, 99));
        jLabel4.setText("EC Document");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 350, -1, -1));

        ecdocument_link.setEditable(false);
        ecdocument_link.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        ecdocument_link.setMaximumSize(new java.awt.Dimension(82, 30));
        ecdocument_link.setMinimumSize(new java.awt.Dimension(82, 30));
        ecdocument_link.setPreferredSize(new java.awt.Dimension(82, 30));
        getContentPane().add(ecdocument_link, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, 330, 60));

        ecdertail_background.setBackground(new Color(192, 192, 192, 90));
        ecdertail_background.setMaximumSize(new java.awt.Dimension(790, 190));
        ecdertail_background.setMinimumSize(new java.awt.Dimension(790, 190));
        ecdertail_background.setOpaque(true);
        ecdertail_background.setPreferredSize(new java.awt.Dimension(790, 190));
        ecdertail_background.setRequestFocusEnabled(false);
        getContentPane().add(ecdertail_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 780, 200));

        ecdetail_border.setBorder(new LineBorder(new Color(192, 192, 192, 90), 15, true));
        ecdetail_border.setMaximumSize(new java.awt.Dimension(800, 220));
        ecdetail_border.setMinimumSize(new java.awt.Dimension(800, 220));
        ecdetail_border.setPreferredSize(new java.awt.Dimension(800, 220));
        getContentPane().add(ecdetail_border, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 800, 220));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(2, 50, 99));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back.png"))); // NOI18N
        jLabel1.setText("BACK");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        background.setText("jLabel1");
        background.setMaximumSize(new java.awt.Dimension(800, 500));
        background.setMinimumSize(new java.awt.Dimension(800, 500));
        background.setPreferredSize(new java.awt.Dimension(800, 500));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        background.getAccessibleContext().setAccessibleName("background");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void student_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_IDActionPerformed

    private void student_intakecodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_intakecodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_intakecodeActionPerformed

    private void student_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_emailActionPerformed

    private void student_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_contactActionPerformed

    private void assessment_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assessment_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assessment_idActionPerformed

    private void ec_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ec_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ec_idActionPerformed

    private void ec_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ec_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ec_statusActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked
    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(admin_ec_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_ec_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_ec_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_ec_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_ec_details().setVisible(true);
            }
        });
    }
        private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon_with_background.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField applied_reason;
    private javax.swing.JTextField assessment_id;
    private javax.swing.JLabel background;
    private javax.swing.JLabel ec_details;
    private javax.swing.JTextField ec_id;
    private javax.swing.JLabel ec_id_title;
    private javax.swing.JTextField ec_status;
    private javax.swing.JLabel ecdertail_background;
    private javax.swing.JLabel ecdetail_border;
    private javax.swing.JTextField ecdocument_link;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField student_ID;
    private javax.swing.JLabel student_ID_title;
    private javax.swing.JTextField student_contact;
    private javax.swing.JLabel student_contact_title;
    private javax.swing.JLabel student_details;
    private javax.swing.JLabel student_details_background;
    private javax.swing.JLabel student_details_border;
    private javax.swing.JTextField student_email;
    private javax.swing.JLabel student_email_title;
    private javax.swing.JTextField student_intakecode;
    private javax.swing.JLabel student_intakecode_title;
    private javax.swing.JTextField student_name;
    private javax.swing.JLabel student_name_title;
    // End of variables declaration//GEN-END:variables
}
