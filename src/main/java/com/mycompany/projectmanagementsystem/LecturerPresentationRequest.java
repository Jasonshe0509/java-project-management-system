/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projectmanagementsystem;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import com.mycompany.projectmanagementsystem.GeneralFunction.SessionManager;
import com.mycompany.projectmanagementsystem.Presentation.PresentationController;
import com.mycompany.projectmanagementsystem.Presentation.PresentationRqtTableActionEvent;
import com.mycompany.projectmanagementsystem.User.User;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author user
 */
public class LecturerPresentationRequest extends javax.swing.JFrame {

    /**
     * Creates new form LecturerPresentationRequest
     */
    private final SessionManager sessionManager = SessionManager.getInstance();
    User user = sessionManager.getCurrentUser();
    private String AssmntID;
    private String intakeCode;
    private String AssmntType;
    
    public LecturerPresentationRequest(String id, String code, String type) {
        this.AssmntID = id;
        this.intakeCode = code;
        initComponents();
        setIconImage();
        showPresentRqt();
       
        // Custom cell renderer to set white background
        class WhiteBackgroundRenderer extends DefaultTableCellRenderer {
            
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
            // Set white background for unselected cells
            cellComponent.setBackground(Color.WHITE);

            // If the cell is selected, use the default selection background color
            if (isSelected) {
                cellComponent.setBackground(table.getSelectionBackground());
            }

            return cellComponent;
            }
        }

        for (int i = 0; i < PresentRqtTable.getColumnCount(); i++) {
            PresentRqtTable.getColumnModel().getColumn(i).setCellRenderer(new WhiteBackgroundRenderer());            
        }
        
        JTableHeader header = PresentRqtTable.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(), 40)); // Adjust the height as needed
        PresentRqtTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
        PresentRqtTable.getTableHeader().setForeground(new Color(2, 50, 99));
        ((DefaultTableCellRenderer)PresentRqtTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);   
        //end of table properties code
        
        lect_PresentationRqtActionPanel panel = new lect_PresentationRqtActionPanel();
        PresentationRqtTableActionEvent event = new PresentationRqtTableActionEvent() {
            @Override
            public void presentationRqtApprove(int row, Object value) {
                List<String> data = FileHandler.readFile("assessment.txt");

                DefaultTableModel model = (DefaultTableModel) PresentRqtTable.getModel();
                String stdID = (String) model.getValueAt(row, 0);
                String acceptance = (String) model.getValueAt(row, 2);
                String presentSlot = (String) model.getValueAt(row, 3);
                PresentationController action = new PresentationController();

                for (String line : data) {
                    String[] list = line.split(";");
                    if (AssmntID.equals(list[0])) {
                        if (user.getUserID().equals(list[4])) { // Supervisor
                            boolean result = action.presentationRqtApprove("supervisor", stdID, "accepted");
                            if (result) {
                                model.removeRow(row);
                                String[] schdPInput = new String[3];
                                schdPInput[0] = stdID;
                                schdPInput[1] = AssmntID;
                                schdPInput[2] = presentSlot;
                                boolean confirm = action.writeAccptPresentation(schdPInput);
                                if (confirm){
                                    JOptionPane.showMessageDialog(null, 
                                        "Presentation request from supervisee (" + stdID + ") has been accepted.");
                                } 
                            } else {
                                JOptionPane.showMessageDialog(null, 
                                        "You have accepted the presentation request from supervisee (" + stdID 
                                                + ").\nSecond marker acceptance is still pending.");
                            }
                            return; // No need to continue the loop once a match is found
                        } else if (user.getUserID().equals(list[5])) { // Second Marker
                            boolean result = action.presentationRqtApprove("second marker", stdID, "accepted");
                            if (result) {
                                model.removeRow(row);
                                String[] schdPInput = new String[3];
                                schdPInput[0] = stdID;
                                schdPInput[1] = AssmntID;
                                schdPInput[2] = presentSlot;
                                boolean confirm = action.writeAccptPresentation(schdPInput);
                                if (confirm){
                                    JOptionPane.showMessageDialog(null, 
                                        "Presentation request from supervisee (" + stdID + ") has been accepted.");
                                } 
                            } else {
                                JOptionPane.showMessageDialog(null, 
                                        "You have accepted the presentation request from supervisee (" + stdID 
                                                + ").\nSupervisor acceptance is still pending.");
                            }
                            return; // No need to continue the loop once a match is found
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "No matching record found for the given assessment ID and user ID", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
            
            @Override
            public void presentationRqtReject(int row, Object value) {
                List<String> data = FileHandler.readFile("assessment.txt");

                DefaultTableModel model = (DefaultTableModel) PresentRqtTable.getModel();
                String stdID = (String) model.getValueAt(row, 0);
                String acceptance = (String) model.getValueAt(row, 2);
                PresentationController action = new PresentationController();

                for (String line : data) {
                    String[] list = line.split(";");
                    if (AssmntID.equals(list[0])) {
                        if (user.getUserID().equals(list[4])) { // Supervisor
                            boolean result = action.presentationRqtReject("supervisor", stdID, "rejected");
                            if (result) {
                                model.removeRow(row);
                                JOptionPane.showMessageDialog(null, 
                                        "Presentation from supervisee (" + stdID + ") has been rejected with provided available slot.");
                            }
                            return; // No need to continue the loop once a match is found
                        } else if (user.getUserID().equals(list[5])) { // Second Marker
                            boolean result = action.presentationRqtReject("second marker", stdID, "rejected");
                            if (result) {
                                model.removeRow(row);
                                JOptionPane.showMessageDialog(null, 
                                        "Presentation from supervisee (" + stdID + ") has been rejected with provided available slot.");
                            }
                            return; // No need to continue the loop once a match is found
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "No matching record found for the given assessment ID and user ID", "Message", JOptionPane.INFORMATION_MESSAGE);
            }

        };
        PresentRqtTable.getColumnModel().getColumn(4).setCellRenderer(panel.new PanelActionRenderer());
        PresentRqtTable.getColumnModel().getColumn(4).setCellEditor(panel.new TableActionCellEditor(event));

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
        jScrollPane1 = new javax.swing.JScrollPane();
        PresentRqtTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lecturer Presentation Request");
        setMaximumSize(new java.awt.Dimension(700, 500));
        setMinimumSize(new java.awt.Dimension(700, 500));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Bell MT", 1, 28)); // NOI18N
        jLabel7.setText("Intake");
        jLabel7.setMaximumSize(new java.awt.Dimension(275, 47));
        jLabel7.setMinimumSize(new java.awt.Dimension(275, 47));
        jLabel7.setPreferredSize(new java.awt.Dimension(275, 47));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 275, 40));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        PresentRqtTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PresentRqtTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supervisee ID", "Name", "Acceptance", "Requested Slot", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PresentRqtTable.setGridColor(new java.awt.Color(0, 0, 0));
        PresentRqtTable.setRowHeight(30);
        PresentRqtTable.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(PresentRqtTable);
        if (PresentRqtTable.getColumnModel().getColumnCount() > 0) {
            PresentRqtTable.getColumnModel().getColumn(0).setMinWidth(90);
            PresentRqtTable.getColumnModel().getColumn(0).setPreferredWidth(90);
            PresentRqtTable.getColumnModel().getColumn(0).setMaxWidth(90);
            PresentRqtTable.getColumnModel().getColumn(1).setMinWidth(120);
            PresentRqtTable.getColumnModel().getColumn(1).setPreferredWidth(120);
            PresentRqtTable.getColumnModel().getColumn(1).setMaxWidth(120);
            PresentRqtTable.getColumnModel().getColumn(2).setMinWidth(170);
            PresentRqtTable.getColumnModel().getColumn(2).setPreferredWidth(170);
            PresentRqtTable.getColumnModel().getColumn(2).setMaxWidth(170);
            PresentRqtTable.getColumnModel().getColumn(3).setMinWidth(130);
            PresentRqtTable.getColumnModel().getColumn(3).setPreferredWidth(130);
            PresentRqtTable.getColumnModel().getColumn(3).setMaxWidth(130);
        }

        jLabel2.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(2, 50, 99));
        jLabel2.setText("Presentation Request");

        backBtn.setBackground(new java.awt.Color(76, 127, 174));
        backBtn.setFont(new java.awt.Font("Bell MT", 1, 12)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("Back");
        backBtn.setPreferredSize(new java.awt.Dimension(60, 25));
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 640, 410));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(700, 500));
        jLabel1.setMinimumSize(new java.awt.Dimension(700, 500));
        jLabel1.setPreferredSize(new java.awt.Dimension(700, 500));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.setVisible(false);
        LecturerIntakePage intake = new LecturerIntakePage(AssmntID, intakeCode, AssmntType);
        intake.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

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
            java.util.logging.Logger.getLogger(LecturerPresentationRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LecturerPresentationRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LecturerPresentationRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LecturerPresentationRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LecturerPresentationRequest("id", "intakeCode", "type").setVisible(true);
            }
        });
    }
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon_with_background.png")));
    }

    private void showPresentRqt() {
        String fileNamex = "presentation_request.txt";
        String fileNamey = "assessment.txt";
        String fileNamez = "user.txt";

        DefaultTableModel model = (DefaultTableModel) PresentRqtTable.getModel();
        model.setRowCount(0); // Clear existing rows

        List<String> datax = FileHandler.readFile(fileNamex);
        List<String> datay = FileHandler.readFile(fileNamey);
        List<String> dataz = FileHandler.readFile(fileNamez);
        
        // Map to store studentID to studentName
        Map<String, String> studentNames = new HashMap<>();
        for (String linez : dataz) {
            String[] listz = linez.split(";");
            String studentID = listz[0];
            String studentName = listz[1];
            studentNames.put(studentID, studentName);
        }
        
        // Set to track added rows to avoid duplication
        Set<String> addedRows = new HashSet<>();
        
        for (String linex : datax) {
        String[] listx = linex.split(";");
        String studentID = listx[1];
        String assessmentID = listx[2];
        String rqtPresentationSlot = listx[3];
        String spvStatus = listx[4];
        String secMarkerstatus = listx[5];

        if (studentID != null) {
            String studentName = studentNames.get(studentID);
            if (studentName != null) {
                for (String liney : datay) {
                    String[] listy = liney.split(";");
                    String currentAssessmentID = listy[0];
                    if (currentAssessmentID.equals(assessmentID) && currentAssessmentID.equals(AssmntID)) {
                        String spv = listy[4];
                        String secMarker = listy[5];

                        String rowIdentifier = studentID + "-" + assessmentID;
                        if (!addedRows.contains(rowIdentifier)) {
                            if (spv.equals(user.getUserID()) && "pending".equals(listx[6]) && "pending".equals(listx[4])) {
                                PresentRqtTable.getColumnModel().getColumn(2).setHeaderValue("Second Marker Acceptance");
                                PresentRqtTable.getTableHeader().repaint();
                                String[] reorderedData = {
                                    studentID,       // Supervisee ID
                                    studentName,     // Supervisee Name
                                    secMarkerstatus,   // Second Marker Name
                                    rqtPresentationSlot // Requested Presentation Slot
                                };
                                model.addRow(reorderedData);
                                addedRows.add(rowIdentifier);
                            } else if (secMarker.equals(user.getUserID()) && "pending".equals(listx[6]) && "pending".equals(listx[5])) {
                                PresentRqtTable.getColumnModel().getColumn(2).setHeaderValue("Supervisor Acceptance");
                                PresentRqtTable.getTableHeader().repaint();
                                String[] reorderedData = {
                                    studentID,       // Supervisee ID
                                    studentName,     // Supervisee Name
                                    spvStatus,         // Supervisor Name
                                    rqtPresentationSlot // Presentation Slot
                                };
                                model.addRow(reorderedData);
                                addedRows.add(rowIdentifier);
                            }
                        }
                }

                    }
                }
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable PresentRqtTable;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
