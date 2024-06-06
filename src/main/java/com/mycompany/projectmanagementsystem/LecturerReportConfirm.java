/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projectmanagementsystem;

import com.mycompany.projectmanagementsystem.Assessment.AssessmentController;
import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import com.mycompany.projectmanagementsystem.GeneralFunction.SessionManager;
import com.mycompany.projectmanagementsystem.User.User;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class LecturerReportConfirm extends javax.swing.JFrame {

    /**
     * Creates new form LecturerReportConfirm
     */
    private final SessionManager sessionManager = SessionManager.getInstance();
    User user = sessionManager.getCurrentUser();
    private String AssmntID;
    private String stdID;
    private int mark1;
    private int mark2;
    private int mark3;
    private String feedback;
    private String AssmntType;
    private String intakeCode;
    private int total;
    private JFrame parent;
    private LecturerIntakePage intakePage;
    
    public LecturerReportConfirm(JFrame parent, LecturerIntakePage intakePage, String assmntid, String id, String name, int mark1, int mark2, int mark3, String feedback, String type, String code) {
        this.intakePage = intakePage;
        this.parent = parent;
        this.AssmntID = assmntid;
        this.stdID = id;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        this.feedback = feedback;
        this.AssmntType = type;
        this.intakeCode = code;
        initComponents();
        setIconImage();
        showGradeFeedback();
   
        stdIDLabel.setText(id);        
        stdNameLabel.setText(name);
        AssmntIDLabel.setText(assmntid);       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        stdIDLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        stdNameLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        AssmntIDLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        gradeLabel = new javax.swing.JLabel();
        feedbackLabel = new javax.swing.JLabel();
        noBtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        yesBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lecturer Report Confirmation");
        setMaximumSize(new java.awt.Dimension(500, 40));
        setMinimumSize(new java.awt.Dimension(500, 400));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Bell MT", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(2, 50, 99));
        jLabel7.setText("Confirmation Message");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 200, 30));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.setMaximumSize(new java.awt.Dimension(446, 26));
        jPanel2.setMinimumSize(new java.awt.Dimension(446, 26));

        stdIDLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        stdIDLabel.setToolTipText("");
        stdIDLabel.setMaximumSize(new java.awt.Dimension(150, 16));
        stdIDLabel.setMinimumSize(new java.awt.Dimension(150, 16));
        stdIDLabel.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setText("Supervisee ID");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(stdIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stdIDLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.setMaximumSize(new java.awt.Dimension(446, 26));
        jPanel3.setMinimumSize(new java.awt.Dimension(446, 26));

        stdNameLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        stdNameLabel.setToolTipText("");
        stdNameLabel.setMaximumSize(new java.awt.Dimension(150, 16));
        stdNameLabel.setMinimumSize(new java.awt.Dimension(150, 16));
        stdNameLabel.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel5.setText("Name");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(stdNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stdNameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel4.setMaximumSize(new java.awt.Dimension(446, 26));
        jPanel4.setMinimumSize(new java.awt.Dimension(446, 26));

        AssmntIDLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        AssmntIDLabel.setToolTipText("");
        AssmntIDLabel.setMaximumSize(new java.awt.Dimension(150, 16));
        AssmntIDLabel.setMinimumSize(new java.awt.Dimension(150, 16));
        AssmntIDLabel.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel8.setText("Assessment ID");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AssmntIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AssmntIDLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(2, 50, 99));
        jLabel9.setText("Grade:");
        jLabel9.setMaximumSize(new java.awt.Dimension(55, 16));
        jLabel9.setMinimumSize(new java.awt.Dimension(55, 16));
        jLabel9.setPreferredSize(new java.awt.Dimension(55, 16));

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(2, 50, 99));
        jLabel10.setText("Feedback:");
        jLabel10.setMaximumSize(new java.awt.Dimension(63, 16));
        jLabel10.setMinimumSize(new java.awt.Dimension(63, 16));
        jLabel10.setPreferredSize(new java.awt.Dimension(63, 16));

        gradeLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        gradeLabel.setMaximumSize(new java.awt.Dimension(240, 53));
        gradeLabel.setMinimumSize(new java.awt.Dimension(240, 53));
        gradeLabel.setPreferredSize(new java.awt.Dimension(240, 53));

        feedbackLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        feedbackLabel.setMaximumSize(new java.awt.Dimension(240, 47));
        feedbackLabel.setMinimumSize(new java.awt.Dimension(240, 47));
        feedbackLabel.setPreferredSize(new java.awt.Dimension(240, 47));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(feedbackLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gradeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gradeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(feedbackLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 460, 240));

        noBtn.setBackground(new java.awt.Color(76, 127, 174));
        noBtn.setFont(new java.awt.Font("Bell MT", 1, 12)); // NOI18N
        noBtn.setForeground(new java.awt.Color(255, 255, 255));
        noBtn.setText("No");
        noBtn.setPreferredSize(new java.awt.Dimension(60, 25));
        noBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noBtnActionPerformed(evt);
            }
        });
        getContentPane().add(noBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, -1, -1));

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(2, 50, 99));
        jLabel11.setText("Are you confirmed to submit the graded report?");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 300, 20));

        yesBtn.setBackground(new java.awt.Color(76, 127, 174));
        yesBtn.setFont(new java.awt.Font("Bell MT", 1, 12)); // NOI18N
        yesBtn.setForeground(new java.awt.Color(255, 255, 255));
        yesBtn.setText("Yes");
        yesBtn.setPreferredSize(new java.awt.Dimension(60, 25));
        yesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesBtnActionPerformed(evt);
            }
        });
        getContentPane().add(yesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(500, 400));
        jLabel1.setMinimumSize(new java.awt.Dimension(500, 400));
        jLabel1.setPreferredSize(new java.awt.Dimension(500, 400));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void noBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noBtnActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_noBtnActionPerformed

    private void yesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesBtnActionPerformed
        updateStudentReportGrade();
        this.dispose();
        if (parent != null) {
            parent.dispose();
        }
    }//GEN-LAST:event_yesBtnActionPerformed

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
            java.util.logging.Logger.getLogger(LecturerReportConfirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LecturerReportConfirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LecturerReportConfirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LecturerReportConfirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LecturerReportConfirm(null, null, "assmntID", "stdName", "stdID", 0, 0, 0, "feedback", "type", "code").setVisible(true);
            }
        });
    }
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon_with_background.png")));
    }
    
    private void showGradeFeedback(){
        total = mark1 + mark2 + mark3;
        gradeLabel.setText("<html>Content: " + mark1 + "\nFormat: " + mark2 + "\nPresentation: " + mark3 + "   Total:- " + total + "</html>");
        feedbackLabel.setText(feedback);
    }
    
    private void updateStudentReportGrade() {
        List<String> assessmentData = FileHandler.readFile("assessment.txt");
        List<String> studentAssessmentData = FileHandler.readFile("student_assessment.txt");
        ArrayList<String> updatedData = new ArrayList<>();
        boolean isSupervisor = false;
        boolean isSecondMarker = false;

        // Determine the user's role for the current assessment ID
        for (String line : assessmentData) {
            String[] parts = line.split(";");
            if (parts[0].equals(AssmntID)) {
                if (parts[4].equals(user.getUserID())) { // Supervisor
                    isSupervisor = true;
                } else if (parts[5].equals(user.getUserID())) { // Second Marker
                    isSecondMarker = true;
                }
                break;
            }
        }

        // Update the student assessment data based on the user's role
        for (String line : studentAssessmentData) {
            String[] parts = line.split(";");
            if (parts[1].equals(stdID) && parts[2].equals(AssmntID)) {
                parts[7] = feedbackLabel.getText(); // Update feedback

                if (isSupervisor) {
                    parts[9] = Integer.toString(total); // Supervisor's total
                } else if (isSecondMarker) {
                    parts[10] = Integer.toString(total); // Second marker's total
                }
                line = String.join(";", parts);
            }
            updatedData.add(line);
        }

        FileHandler.modifyFileData("student_assessment.txt", updatedData);
        
        // Execute the spvReportDone or secMarkReportDone method based on the user's role
        AssessmentController action = new AssessmentController();
        boolean found = false;

        for (String line : assessmentData) {
            String[] list = line.split(";");
            if (AssmntID.equals(list[0])) {
                if (user.getUserID().equals(list[4])) { // Supervisor
                    for (String assmntline : studentAssessmentData) {
                        String[] assmntlist = assmntline.split(";");
                        if (stdID.equals(assmntlist[1])) {
                            boolean result = action.spvReportDone(stdID, AssmntID, "marked", AssmntType);
                            if (result) {
                                // Dispose the current intake page
                                ((Window) SwingUtilities.getWindowAncestor(intakePage.getReportTable())).dispose();
                                // Display an updated intake page
                                LecturerIntakePage update = new LecturerIntakePage(AssmntID, intakeCode, AssmntType);
                                update.setVisible(true);
                            }
                            found = true;
                            break;
                        }
                    }
                    break;
                } else if (user.getUserID().equals(list[5])) { // Second Marker
                    for (String assmntline : studentAssessmentData) {
                        String[] assmntlist = assmntline.split(";");
                        if (stdID.equals(assmntlist[1])) {
                            boolean result = action.secMarkReportDone(stdID, AssmntID, "marked", AssmntType);
                            if (result) {
                                // Dispose the current intake page
                                ((Window) SwingUtilities.getWindowAncestor(intakePage.getReportTable())).dispose();
                                // Display an updated intake page
                                LecturerIntakePage update = new LecturerIntakePage(AssmntID, intakeCode, AssmntType);
                                update.setVisible(true);
                            }
                            found = true;
                            break;
                        }
                    }
                    break;
                }
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(null, "No matching record found for the given assessment ID and user ID", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AssmntIDLabel;
    private javax.swing.JLabel feedbackLabel;
    private javax.swing.JLabel gradeLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton noBtn;
    private javax.swing.JLabel stdIDLabel;
    private javax.swing.JLabel stdNameLabel;
    private javax.swing.JButton yesBtn;
    // End of variables declaration//GEN-END:variables
}
