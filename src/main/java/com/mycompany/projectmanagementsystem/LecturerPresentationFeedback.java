/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projectmanagementsystem;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import com.mycompany.projectmanagementsystem.GeneralFunction.SessionManager;
import com.mycompany.projectmanagementsystem.Presentation.PresentationController;
import com.mycompany.projectmanagementsystem.User.User;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class LecturerPresentationFeedback extends javax.swing.JFrame {

    /**
     * Creates new form LecturerPresentationFeedback
     */
    private final SessionManager sessionManager = SessionManager.getInstance();
    User user = sessionManager.getCurrentUser();
    private String stdID;
    
    public LecturerPresentationFeedback(String AssmntID, String stdID, String name, String marker, String presentSlot, String type) {
        this.stdID = stdID;
        initComponents();
        setIconImage();
        stdIDLabel.setText(stdID);
        stdNameLabel.setText(name);
        if ("internship_report".equals(type) || "investigation".equals(type)) {
            secMarkerLabel.setText("_");
        } else {
            secMarkerLabel.setText(marker);
        }      
        slotLabel.setText(presentSlot);
        showFeedback(AssmntID);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        stdIDLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        stdNameLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        secMarkerLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        slotLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        feedbackField = new javax.swing.JTextArea();
        saveFeedbackBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lecturer Presentation Feedback");
        setMinimumSize(new java.awt.Dimension(700, 500));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Bell MT", 1, 20)); // NOI18N
        jLabel7.setText("Feedback");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setMaximumSize(new java.awt.Dimension(4, 46));
        jPanel2.setMinimumSize(new java.awt.Dimension(4, 46));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(2, 50, 99));
        jLabel2.setText("Supervisee ID");
        jLabel2.setMaximumSize(new java.awt.Dimension(170, 30));
        jLabel2.setMinimumSize(new java.awt.Dimension(170, 30));
        jLabel2.setPreferredSize(new java.awt.Dimension(170, 30));

        stdIDLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        stdIDLabel.setForeground(new java.awt.Color(2, 50, 99));
        stdIDLabel.setMaximumSize(new java.awt.Dimension(300, 30));
        stdIDLabel.setMinimumSize(new java.awt.Dimension(300, 30));
        stdIDLabel.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(stdIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(stdIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setMaximumSize(new java.awt.Dimension(4, 46));
        jPanel3.setMinimumSize(new java.awt.Dimension(4, 46));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(2, 50, 99));
        jLabel4.setText("Name");
        jLabel4.setMaximumSize(new java.awt.Dimension(170, 30));
        jLabel4.setMinimumSize(new java.awt.Dimension(170, 30));
        jLabel4.setPreferredSize(new java.awt.Dimension(170, 30));

        stdNameLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        stdNameLabel.setForeground(new java.awt.Color(2, 50, 99));
        stdNameLabel.setMaximumSize(new java.awt.Dimension(300, 30));
        stdNameLabel.setMinimumSize(new java.awt.Dimension(300, 30));
        stdNameLabel.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(stdNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(stdNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setMaximumSize(new java.awt.Dimension(4, 46));
        jPanel4.setMinimumSize(new java.awt.Dimension(4, 46));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(2, 50, 99));
        jLabel6.setText("Second Marker");
        jLabel6.setMaximumSize(new java.awt.Dimension(170, 30));
        jLabel6.setMinimumSize(new java.awt.Dimension(170, 30));
        jLabel6.setPreferredSize(new java.awt.Dimension(170, 30));

        secMarkerLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        secMarkerLabel.setForeground(new java.awt.Color(2, 50, 99));
        secMarkerLabel.setMaximumSize(new java.awt.Dimension(300, 30));
        secMarkerLabel.setMinimumSize(new java.awt.Dimension(300, 30));
        secMarkerLabel.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(secMarkerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(secMarkerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setMaximumSize(new java.awt.Dimension(4, 46));
        jPanel5.setMinimumSize(new java.awt.Dimension(4, 46));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(2, 50, 99));
        jLabel9.setText("Presentation Slot");
        jLabel9.setMaximumSize(new java.awt.Dimension(170, 30));
        jLabel9.setMinimumSize(new java.awt.Dimension(170, 30));
        jLabel9.setPreferredSize(new java.awt.Dimension(170, 30));

        slotLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        slotLabel.setForeground(new java.awt.Color(2, 50, 99));
        slotLabel.setMaximumSize(new java.awt.Dimension(300, 30));
        slotLabel.setMinimumSize(new java.awt.Dimension(300, 30));
        slotLabel.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(slotLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(slotLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(2, 50, 99));
        jLabel11.setText("Feedback");
        jLabel11.setMaximumSize(new java.awt.Dimension(170, 30));
        jLabel11.setMinimumSize(new java.awt.Dimension(170, 30));
        jLabel11.setPreferredSize(new java.awt.Dimension(170, 30));

        feedbackField.setColumns(20);
        feedbackField.setRows(5);
        feedbackField.setMaximumSize(new java.awt.Dimension(510, 100));
        feedbackField.setMinimumSize(new java.awt.Dimension(510, 100));
        feedbackField.setPreferredSize(new java.awt.Dimension(510, 100));
        jScrollPane1.setViewportView(feedbackField);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 670, 420));

        saveFeedbackBtn.setBackground(new java.awt.Color(76, 127, 174));
        saveFeedbackBtn.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        saveFeedbackBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveFeedbackBtn.setText("Save");
        saveFeedbackBtn.setPreferredSize(new java.awt.Dimension(60, 25));
        saveFeedbackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFeedbackBtnActionPerformed(evt);
            }
        });
        getContentPane().add(saveFeedbackBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, 80, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(700, 500));
        jLabel1.setMinimumSize(new java.awt.Dimension(700, 500));
        jLabel1.setPreferredSize(new java.awt.Dimension(700, 500));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveFeedbackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFeedbackBtnActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to submit this feedback?", "Confirmation", JOptionPane.YES_NO_OPTION);

        String feedback = feedbackField.getText().trim();
        if (confirm == JOptionPane.YES_OPTION && !feedback.isEmpty()) {
            PresentationController action = new PresentationController();
            boolean feedbackGiven = action.updateStudentPresentationIndex(stdID, feedback);

            if (feedbackGiven) {
                JOptionPane.showMessageDialog(null, "Successfully submitted your feedback.");
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to submit feedback.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (feedback.isEmpty()){
            JOptionPane.showMessageDialog(null, "Feedback field cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveFeedbackBtnActionPerformed

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
            java.util.logging.Logger.getLogger(LecturerPresentationFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LecturerPresentationFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LecturerPresentationFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LecturerPresentationFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LecturerPresentationFeedback("AssmntID", "stdID", "name", "marker", "presentSlot", "type").setVisible(true);
            }
        });
    }
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon_with_background.png")));
    }
    
    private void showFeedback(String assessmentID) {
        List<String> datax = FileHandler.readFile("assessment.txt");
        List<String> datay = FileHandler.readFile("presentation_confirmation.txt");
        boolean isSupervisor = false;
        boolean isSecondMarker = false;

        for (String linex : datax) {
            String[] listx = linex.split(";");
            if (listx[0].equals(assessmentID)) { // Check the current assessment ID
                if (listx[4].equals(user.getUserID())) { // supervisor
                    isSupervisor = true;
                } else if (listx[5].equals(user.getUserID())) { // second marker
                    isSecondMarker = true;
                }
                break;
            }
        }

        if (isSupervisor) {
            for (String liney : datay) {
                String[] listy = liney.split(";");
                if (listy[1].equals(stdID)) {
                    feedbackField.setText(listy[4]);
                    feedbackField.setEditable(true); // Supervisors can always edit
                }
            }
        } else if (isSecondMarker) {
            boolean feedbackExists = false;
            for (String liney : datay) {
                String[] listy = liney.split(";");
                if (listy[1].equals(stdID)) {
                    if (listy.length > 5 && listy[4] != null && !listy[4].isEmpty()) {
                        feedbackField.setText(listy[4]);
                        feedbackField.setEditable(true); // Editable if feedback exists
                        feedbackExists = true;
                    }
                }
            }
            if (!feedbackExists) {
                feedbackField.setText("No feedback given by supervisor.");
                feedbackField.setEditable(false); // Not editable if no feedback
            }
            saveFeedbackBtn.setEnabled(feedbackExists);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea feedbackField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveFeedbackBtn;
    private javax.swing.JLabel secMarkerLabel;
    private javax.swing.JLabel slotLabel;
    private javax.swing.JLabel stdIDLabel;
    private javax.swing.JLabel stdNameLabel;
    // End of variables declaration//GEN-END:variables
}
