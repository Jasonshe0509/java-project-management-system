package com.mycompany.projectmanagementsystem;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;

public class admin_ec_details extends javax.swing.JFrame {

    public admin_ec_details() {
        initComponents();
        setIconImage();
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
        student_details_background = new javax.swing.JLabel();
        student_details_border = new javax.swing.JLabel();
        ec_details = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        ecdertail_background = new javax.swing.JLabel();
        ecdetail_border = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EC Details");
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
        getContentPane().add(student_name_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        student_name.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        student_name.setText("jTextField1");
        getContentPane().add(student_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 130, 30));

        student_ID_title.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        student_ID_title.setForeground(new java.awt.Color(2, 50, 99));
        student_ID_title.setText("TP Number");
        getContentPane().add(student_ID_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        student_ID.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        student_ID.setText("jTextField1");
        student_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_IDActionPerformed(evt);
            }
        });
        getContentPane().add(student_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 130, 30));

        student_intakecode_title.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        student_intakecode_title.setForeground(new java.awt.Color(2, 50, 99));
        student_intakecode_title.setText("Intake Code");
        getContentPane().add(student_intakecode_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, -1, -1));

        student_intakecode.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        student_intakecode.setText("jTextField1");
        student_intakecode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_intakecodeActionPerformed(evt);
            }
        });
        getContentPane().add(student_intakecode, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 130, 30));

        student_email_title.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        student_email_title.setForeground(new java.awt.Color(2, 50, 99));
        student_email_title.setText("Email");
        getContentPane().add(student_email_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        student_email.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        student_email.setText("jTextField1");
        student_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_emailActionPerformed(evt);
            }
        });
        getContentPane().add(student_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 130, 30));

        student_contact_title.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        student_contact_title.setForeground(new java.awt.Color(2, 50, 99));
        student_contact_title.setText("Contact Number");
        getContentPane().add(student_contact_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, -1, -1));

        student_contact.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        student_contact.setText("jTextField1");
        student_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_contactActionPerformed(evt);
            }
        });
        getContentPane().add(student_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 130, 30));

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
        getContentPane().add(ec_details, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 160, 200));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(2, 50, 99));
        jLabel2.setText("Project Code");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, -1, -1));

        jTextField2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextField2.setText("jTextField1");
        jTextField2.setMaximumSize(new java.awt.Dimension(82, 30));
        jTextField2.setMinimumSize(new java.awt.Dimension(82, 30));
        jTextField2.setPreferredSize(new java.awt.Dimension(82, 30));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 130, 30));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(2, 50, 99));
        jLabel1.setText("Appplied Date");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, -1, -1));

        jTextField1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextField1.setText("jTextField1");
        jTextField1.setMaximumSize(new java.awt.Dimension(82, 30));
        jTextField1.setMinimumSize(new java.awt.Dimension(82, 30));
        jTextField1.setPreferredSize(new java.awt.Dimension(82, 30));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, 130, 30));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(2, 50, 99));
        jLabel3.setText("Applied Reason");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, -1, -1));

        jTextField3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextField3.setText("jTextField1");
        jTextField3.setMaximumSize(new java.awt.Dimension(82, 30));
        jTextField3.setMinimumSize(new java.awt.Dimension(82, 30));
        jTextField3.setPreferredSize(new java.awt.Dimension(82, 30));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, 240, 30));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(2, 50, 99));
        jLabel4.setText("Submission Link?");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 351, -1, 20));

        jTextField4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextField4.setText("jTextField1");
        jTextField4.setMaximumSize(new java.awt.Dimension(82, 30));
        jTextField4.setMinimumSize(new java.awt.Dimension(82, 30));
        jTextField4.setPreferredSize(new java.awt.Dimension(82, 30));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, 230, 30));

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
    private javax.swing.JLabel background;
    private javax.swing.JLabel ec_details;
    private javax.swing.JLabel ecdertail_background;
    private javax.swing.JLabel ecdetail_border;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
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
