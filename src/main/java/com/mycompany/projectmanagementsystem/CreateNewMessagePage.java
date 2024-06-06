/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projectmanagementsystem;

import com.mycompany.projectmanagementsystem.Communication.CommunicationController;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class CreateNewMessagePage extends javax.swing.JFrame {

    /**
     * Creates new form StudentCreateNewDiscussionPage
     */
    private String assessmentID;
    private String assessmentType;
    private String resubject;
    private String channelID;
    private StudentAssessmentDetailPage studentParentPage;
    private LecturerIntakePage lecturerIntakePage;

    public CreateNewMessagePage(String assessmentID, String assessmentType, String resubject, String channelID, StudentAssessmentDetailPage studentParentPage, LecturerIntakePage lecturerIntakePage) {
        initComponents();
        setIconImage();
        this.assessmentID = assessmentID;
        this.assessmentType = assessmentType;
        this.studentParentPage = studentParentPage;
        this.lecturerIntakePage = lecturerIntakePage;
        this.resubject = resubject;
        this.channelID = channelID;
        if (resubject == null) {
            title.setText("Create New Discussion");
            description.setText("Drop the subject and message in the text box below.");
        } else {
            title.setText("Create New Message");
            description.setText("Leave message by entering text in the text box below.");
            subjectField.setEditable(false);
            subjectField.setText(resubject);
        }
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

        title = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        description = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        subjectField = new javax.swing.JTextField();
        submitBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        messageField = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Create Discussion");
        setMinimumSize(new java.awt.Dimension(700, 500));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(2, 50, 99));
        title.setText("Create New Discussion");
        getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 30));

        jPanel1.setBackground(new Color(217,217,217,40));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(2, 50, 99));
        jLabel3.setText("Message:");
        jLabel3.setMaximumSize(new java.awt.Dimension(135, 44));
        jLabel3.setMinimumSize(new java.awt.Dimension(135, 44));
        jLabel3.setPreferredSize(new java.awt.Dimension(135, 44));

        description.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        description.setForeground(new java.awt.Color(2, 50, 99));
        description.setText("Drop the subject and message in the text box below.");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(2, 50, 99));
        jLabel5.setText("Subject:");
        jLabel5.setMaximumSize(new java.awt.Dimension(135, 44));
        jLabel5.setMinimumSize(new java.awt.Dimension(135, 44));
        jLabel5.setPreferredSize(new java.awt.Dimension(135, 44));

        subjectField.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        subjectField.setForeground(new java.awt.Color(2, 50, 99));
        subjectField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        subjectField.setMaximumSize(new java.awt.Dimension(345, 40));
        subjectField.setMinimumSize(new java.awt.Dimension(345, 40));
        subjectField.setPreferredSize(new java.awt.Dimension(345, 40));

        submitBtn.setBackground(new java.awt.Color(27, 61, 96));
        submitBtn.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        submitBtn.setForeground(new java.awt.Color(255, 255, 255));
        submitBtn.setText("Submit");
        submitBtn.setPreferredSize(new java.awt.Dimension(60, 25));
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        messageField.setColumns(20);
        messageField.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        messageField.setForeground(new java.awt.Color(2, 50, 99));
        messageField.setRows(5);
        jScrollPane2.setViewportView(messageField);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(subjectField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2))))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subjectField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 660, 420));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(700, 500));
        jLabel1.setMinimumSize(new java.awt.Dimension(700, 500));
        jLabel1.setPreferredSize(new java.awt.Dimension(700, 500));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        if (resubject == null) {
            String[] discussionInput = new String[3];
            discussionInput[0] = assessmentID;
            discussionInput[1] = subjectField.getText();
            discussionInput[2] = messageField.getText();
            CommunicationController action = new CommunicationController();
            boolean result = action.createNewDiscussion(discussionInput);
            if (result) {
                JOptionPane.showMessageDialog(null, "Successfully created a discussion.");
                this.setVisible(false);
                if (studentParentPage != null) {
                    studentParentPage.setVisible(false);
                    StudentAssessmentDetailPage page = new StudentAssessmentDetailPage(assessmentID, assessmentType);
                    page.setVisible(true);
                    page.selectCommunicationPanel(1, null);
                } else {
                    lecturerIntakePage.refreshContent(); 
                    lecturerIntakePage.selectCommunicationPanel(1, null);
                }
            }
        } else {
            String[] messageInput = new String[2];
            System.out.println(channelID);
            messageInput[0] = channelID;
            messageInput[1] = messageField.getText();
            CommunicationController action = new CommunicationController();
            boolean result = action.createNewMessage(messageInput);
            if (result) {
                JOptionPane.showMessageDialog(null, "Successfully created a message.");
                this.setVisible(false);
                if (studentParentPage != null) {
                    studentParentPage.setVisible(false);
                    StudentAssessmentDetailPage page = new StudentAssessmentDetailPage(assessmentID, assessmentType);
                    page.setVisible(true);
                    page.selectCommunicationPanel(2, channelID);
                } else {
                    lecturerIntakePage.refreshContent();
                    lecturerIntakePage.selectCommunicationPanel(2, channelID);
                }
            }
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
            java.util.logging.Logger.getLogger(CreateNewMessagePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateNewMessagePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateNewMessagePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateNewMessagePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateNewMessagePage("A0001", "internship_report", null, null, null, null).setVisible(true);
            }
        });
    }

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon_with_background.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel description;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea messageField;
    private javax.swing.JTextField subjectField;
    private javax.swing.JButton submitBtn;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
