/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projectmanagementsystem;

import com.mycompany.projectmanagementsystem.Assessment.AssessmentController;
import com.mycompany.projectmanagementsystem.Assessment.ReportTableActionEvent;
import com.mycompany.projectmanagementsystem.GeneralFunction.SessionManager;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shuhuilee
 */
public class PM_report_status extends javax.swing.JFrame {

    private final SessionManager sessionManager = SessionManager.getInstance();
    private final String assessmentType;
    private final String assessmentID;

    /**
     * Creates new form ProjectManagerPage
     */
    public PM_report_status(String assessmentType, String assessmentID) {
        initComponents();
        setIconImage();
        this.assessmentType = assessmentType;
        this.assessmentID = assessmentID;
        report_delete();
        loadReportStatus();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void report_delete() {
        PM_delete_ActionPanel panel = new PM_delete_ActionPanel();
        ReportTableActionEvent event = (int row, Object value) -> {
            DefaultTableModel model = (DefaultTableModel) pm_report_table.getModel();
            String userID = (String) model.getValueAt(row, 0); // Assuming userID is in the first column
            int response = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to delete the report with ID " + userID + "?",
                    "Confirm Delete",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );
            if (response == JOptionPane.YES_OPTION) {
                AssessmentController controller = new AssessmentController();
                boolean result = controller.report_Delete(userID, assessmentID);
                if (result) {
                    JOptionPane.showMessageDialog(null, "Successfully deleted the report.");
                    loadReportStatus();  // Refresh the table data
                }
            }
        };
        // Adjusting the column index to place the delete button in the action column
        pm_report_table.getColumnModel().getColumn(9).setCellRenderer(panel.new rPanelActionRenderer());
        pm_report_table.getColumnModel().getColumn(9).setCellEditor(panel.new TableActionCellEditor(event));
    }

    private void loadReportStatus() {
        String fileName = "student_assessment.txt";
        DefaultTableModel model = (DefaultTableModel) pm_report_table.getModel();
        model.setRowCount(0); // Clear existing rows

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] list = line.split(";");
                if (list[2].equals(assessmentID)) {
                    String userID = list[1]; // Assuming UserID is in the second column
                    String studentName = getUserInfoFromUserID(userID, "name");
                    String intake = getUserInfoFromUserID(userID, "intake");
                    model.addRow(new Object[]{
                        userID,
                        studentName,
                        intake,
                        list[3], // Due Date
                        list[5], // Submission Date
                        list[6], // Submission Status
                        list[8], // Grade
                        list[9], // Supervisor Mark
                        list[10], // Second Marker Mark
                        ""
                    });
                }

            }
        } catch (IOException ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }
    }

    private String getUserInfoFromUserID(String userID, String infoType) {
        String fileName = "user.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userInfo = line.split(";");
                if (userInfo[0].equals(userID)) {
                    switch (infoType) {
                        case "name":
                            return userInfo[1];
                        case "intake":
                            return userInfo[11];
                        default:
                            return "Unknown";
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }
        return "Unknown";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        back_buttom = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pm_report_table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 700));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel8.setText("Report Status");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        back_buttom.setBackground(new java.awt.Color(76, 127, 174));
        back_buttom.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        back_buttom.setForeground(new java.awt.Color(255, 255, 255));
        back_buttom.setText("Back");
        back_buttom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttomActionPerformed(evt);
            }
        });
        getContentPane().add(back_buttom, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 650, 80, 30));

        pm_report_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Student ID", "Student Name", "Intake", "Duedate", "Submission Date/Time", "Submission Status ", "Grade", "SupervisorMark", "SecondMarkerMark", "Action"
            }
        ));
        pm_report_table.setRowHeight(30);
        jScrollPane1.setViewportView(pm_report_table);
        if (pm_report_table.getColumnModel().getColumnCount() > 0) {
            pm_report_table.getColumnModel().getColumn(4).setMinWidth(150);
            pm_report_table.getColumnModel().getColumn(4).setPreferredWidth(150);
            pm_report_table.getColumnModel().getColumn(4).setMaxWidth(150);
            pm_report_table.getColumnModel().getColumn(5).setMinWidth(100);
            pm_report_table.getColumnModel().getColumn(5).setPreferredWidth(100);
            pm_report_table.getColumnModel().getColumn(5).setMaxWidth(100);
            pm_report_table.getColumnModel().getColumn(9).setMinWidth(150);
            pm_report_table.getColumnModel().getColumn(9).setPreferredWidth(150);
            pm_report_table.getColumnModel().getColumn(9).setMaxWidth(150);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 960, 550));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void back_buttomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttomActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_back_buttomActionPerformed

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
            java.util.logging.Logger.getLogger(PM_report_status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PM_report_status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PM_report_status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PM_report_status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String assessmentType = "type";
                String assessmentID = "ID";
                new PM_report_status(assessmentType, assessmentID).setVisible(true);
            }
        });
    }

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon_with_background.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_buttom;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable pm_report_table;
    // End of variables declaration//GEN-END:variables
}
