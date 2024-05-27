/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projectmanagementsystem;

import com.mycompany.projectmanagementsystem.Assessment.AssessmentController;
import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import com.mycompany.projectmanagementsystem.GeneralFunction.SessionManager;
import com.mycompany.projectmanagementsystem.Notification.NotificationController;
import com.mycompany.projectmanagementsystem.User.User;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class StudentSubmissionPage extends javax.swing.JFrame {

    /**
     * Creates new form StudentSubmissionPage
     */
    private String action;
    private String assessmentID;
    private String assessmentType;
    private StudentAssessmentDetailPage parentpage;

    private final SessionManager sessionManager = SessionManager.getInstance();
    User user = sessionManager.getCurrentUser();

    public StudentSubmissionPage(String action, String assessmentID, String assessmentType, StudentAssessmentDetailPage parentpage) {
        initComponents();
        setIconImage();
        this.action = action;
        this.assessmentID = assessmentID;
        this.assessmentType = assessmentType;
        this.parentpage = parentpage;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        email = new javax.swing.JLabel();
        moodleLinkField = new javax.swing.JTextField();
        admin_register_intake_title = new javax.swing.JLabel();
        submitBtn = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Submission");
        setMinimumSize(new java.awt.Dimension(500, 300));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        email.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        email.setForeground(new java.awt.Color(2, 50, 99));
        email.setText("Moodle Link:");
        email.setMaximumSize(new java.awt.Dimension(78, 36));
        email.setMinimumSize(new java.awt.Dimension(78, 36));
        email.setPreferredSize(new java.awt.Dimension(78, 36));
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 140, -1));

        moodleLinkField.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        moodleLinkField.setMaximumSize(new java.awt.Dimension(335, 40));
        moodleLinkField.setMinimumSize(new java.awt.Dimension(335, 40));
        moodleLinkField.setPreferredSize(new java.awt.Dimension(335, 40));
        getContentPane().add(moodleLinkField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 260, -1));

        admin_register_intake_title.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        admin_register_intake_title.setForeground(new java.awt.Color(2, 50, 99));
        admin_register_intake_title.setText("Moodle Link Submission");
        getContentPane().add(admin_register_intake_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        submitBtn.setBackground(new java.awt.Color(27, 61, 96));
        submitBtn.setFont(new java.awt.Font("Bell MT", 1, 19)); // NOI18N
        submitBtn.setForeground(new java.awt.Color(255, 255, 255));
        submitBtn.setText("SUBMIT");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });
        getContentPane().add(submitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        background.setText("jLabel1");
        background.setMaximumSize(new java.awt.Dimension(500, 300));
        background.setMinimumSize(new java.awt.Dimension(500, 300));
        background.setPreferredSize(new java.awt.Dimension(500, 300));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        List<String> data = FileHandler.readFile("assessment.txt");
        AssessmentController assmtAction = new AssessmentController();
        String assessmentName = null;
        for (String line : data) {
            String[] list = line.split(";");
            if (list[0].equals(assessmentID)) {
                assessmentName = assmtAction.assessmentType(list[1]);
            }
        }
        String[] assessmentInput = new String[2];
        assessmentInput[0] = assessmentID;
        assessmentInput[1] = moodleLinkField.getText();
        boolean result = assmtAction.submitAssessment(action, assessmentInput);
        if (result) {
            switch (action) {
                case "submit" -> {
                    JOptionPane.showMessageDialog(null, "Successfully submit the" + assessmentName);
                    NotificationController.create(user.getUserID(), "Successfully submit the" + assessmentName);
                }
                case "modify" -> {
                    JOptionPane.showMessageDialog(null, "Successfully modify the submission for" + assessmentName);
                    NotificationController.create(user.getUserID(), "Successfully modify the submission for" + assessmentName);
                }
                case "resubmit" -> {
                    JOptionPane.showMessageDialog(null, "Successfully resubmit the" + assessmentName);
                    NotificationController.create(user.getUserID(), "Successfully resubmit the" + assessmentName);
                }
            }
            this.setVisible(false);
            parentpage.setVisible(false);
            StudentAssessmentDetailPage page = new StudentAssessmentDetailPage(assessmentID,assessmentType);
            page.setVisible(true);
        }
    }//GEN-LAST:event_submitBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentSubmissionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentSubmissionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentSubmissionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentSubmissionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentSubmissionPage("submit", "A0001","internship_report",null).setVisible(true);
            }
        });
    }

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon_with_background.png")));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel admin_register_intake_title;
    private javax.swing.JLabel background;
    private javax.swing.JLabel email;
    private javax.swing.JTextField moodleLinkField;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables
}
