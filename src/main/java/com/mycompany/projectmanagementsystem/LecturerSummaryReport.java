/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projectmanagementsystem;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import com.mycompany.projectmanagementsystem.GeneralFunction.SessionManager;
import com.mycompany.projectmanagementsystem.JTableDataSource;
import com.mycompany.projectmanagementsystem.User.User;
import com.mycompany.projectmanagementsystem.User.UserController;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class LecturerSummaryReport extends javax.swing.JFrame {

    /**
     * Creates new form LecturerSummaryReport
     */
    
    private final SessionManager sessionManager = SessionManager.getInstance();
    User user = sessionManager.getCurrentUser();
    private String intakeCode;
    private String AssmntID;
    
    public LecturerSummaryReport(String AssmntID, String intakeCode) {
        this.AssmntID = AssmntID;
        this.intakeCode = intakeCode;
        initComponents();
        setIconImage();
        showRptData();
        
        Color fontColor = new Color(2, 50, 99);
        sumRptTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14)); // Adjust size as needed
        sumRptTable.getTableHeader().setForeground(fontColor);
        
        for (int i = 0; i < sumRptTable.getColumnCount(); i++) {
        sumRptTable.getColumnModel().getColumn(i).setHeaderRenderer(new WrappedHeaderRenderer(sumRptTable));
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        sumRptTable.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
}
    }
    
    public class WrappedHeaderRenderer implements TableCellRenderer {
    DefaultTableCellRenderer renderer;

    public WrappedHeaderRenderer(JTable table) {
        renderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER); // Center-align the text horizontally
        
        // Set the preferred height for the table header
        JTableHeader header = table.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(), 65)); // Adjust the height as needed
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel headerLabel = (JLabel) renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        headerLabel.setText("<html><div style='text-align: center; vertical-align: middle;'>" + value.toString() + "</div></html>"); // Enable text wrapping and vertical centering
        
        return headerLabel;
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sumRptTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        logoutLabel = new javax.swing.JLabel();
        lecProfileLabel = new javax.swing.JLabel();
        notiLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        backBtn = new javax.swing.JLabel();
        generateBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lecturer Summary Report");
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Bell MT", 1, 30)); // NOI18N
        jLabel7.setText("Assessment Summary Report");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 400, 30));

        sumRptTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Assessment ID", "Assessment Type", "Total Student", "Number of EC", "Total Submission", "Completed Assessment", "Passing Percentage"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sumRptTable.setRowHeight(35);
        sumRptTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(sumRptTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 950, 550));

        jPanel1.setBackground(new Color(255, 255, 255, 90));
        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 73));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 73));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sysco_logo.png"))); // NOI18N
        jLabel2.setText("logo");
        jLabel2.setMaximumSize(new java.awt.Dimension(184, 42));
        jLabel2.setMinimumSize(new java.awt.Dimension(184, 42));
        jLabel2.setPreferredSize(new java.awt.Dimension(184, 42));

        logoutLabel.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        logoutLabel.setForeground(new java.awt.Color(2, 50, 99));
        logoutLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoutLabel.setText("Log Out");
        logoutLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutLabelMouseClicked(evt);
            }
        });

        lecProfileLabel.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        lecProfileLabel.setForeground(new java.awt.Color(2, 50, 99));
        lecProfileLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lecProfileLabel.setText("Profile");
        lecProfileLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lecProfileLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lecProfileLabelMouseClicked(evt);
            }
        });

        notiLabel.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        notiLabel.setForeground(new java.awt.Color(2, 50, 99));
        notiLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        notiLabel.setText("Notification");
        notiLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        notiLabel.setMaximumSize(new java.awt.Dimension(37, 21));
        notiLabel.setMinimumSize(new java.awt.Dimension(37, 21));
        notiLabel.setPreferredSize(new java.awt.Dimension(37, 21));
        notiLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notiLabelMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(2, 50, 99));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Summary Report");
        jLabel6.setMaximumSize(new java.awt.Dimension(37, 21));
        jLabel6.setMinimumSize(new java.awt.Dimension(37, 21));
        jLabel6.setPreferredSize(new java.awt.Dimension(37, 21));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 317, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(notiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lecProfileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lecProfileLabel)
                    .addComponent(logoutLabel)
                    .addComponent(notiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, -1));

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back.png"))); // NOI18N
        backBtn.setText("jLabel8");
        backBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBtnMouseClicked(evt);
            }
        });
        getContentPane().add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 50, 40));

        generateBtn.setBackground(new java.awt.Color(76, 127, 174));
        generateBtn.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        generateBtn.setForeground(new java.awt.Color(255, 255, 255));
        generateBtn.setText("Generate");
        generateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        generateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                generateBtnMouseClicked(evt);
            }
        });
        getContentPane().add(generateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 90, 110, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(1000, 700));
        jLabel1.setMinimumSize(new java.awt.Dimension(1000, 700));
        jLabel1.setPreferredSize(new java.awt.Dimension(1000, 700));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseClicked
        this.setVisible(false);
        LecturerDashboardPage dashboard = new LecturerDashboardPage();
        dashboard.setVisible(true);
    }//GEN-LAST:event_backBtnMouseClicked

    private void notiLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notiLabelMouseClicked
        NotificationPage lectNoti = new NotificationPage();
        lectNoti.setVisible(true);
    }//GEN-LAST:event_notiLabelMouseClicked

    private void lecProfileLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lecProfileLabelMouseClicked
        this.setVisible(false);
        LecturerProfile profile = new LecturerProfile(AssmntID, intakeCode);
        profile.setVisible(true);
    }//GEN-LAST:event_lecProfileLabelMouseClicked

    private void logoutLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutLabelMouseClicked
        int confirm = JOptionPane.showConfirmDialog(null, "Are you confirmed to log out?", 
                    "Confirmation", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            this.setVisible(false);
            UserController logout = new UserController();
            logout.userLogout();
        } else {}
    }//GEN-LAST:event_logoutLabelMouseClicked

    private void generateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generateBtnMouseClicked
        generateReport(sumRptTable, "LecSumReport.jasper");
    }//GEN-LAST:event_generateBtnMouseClicked

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
            java.util.logging.Logger.getLogger(LecturerSummaryReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LecturerSummaryReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LecturerSummaryReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LecturerSummaryReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LecturerSummaryReport("id", "intakeCode").setVisible(true);
            }
        });
    }
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon_with_background.png")));
    }
    
    private void showRptData() {
        String fileNamex = "student_assessment.txt";
        String fileNamey = "assessment.txt";
        String fileNamez = "user.txt";
        String fileNamea = "ec.txt";
        String fileNameb = "presentation_confirmation.txt";
        int stdCount = 0;
        int ecCount = 0;
        int stdSubCount = 0;
        int stdCmpltCount = 0;
        int stdPassCount = 0;
        
        DefaultTableModel model = (DefaultTableModel) sumRptTable.getModel();
        model.setRowCount(0); // Clear existing rows

        List<String> datax = FileHandler.readFile(fileNamex);
        List<String> datay = FileHandler.readFile(fileNamey);
        List<String> dataz = FileHandler.readFile(fileNamez);
        List<String> dataa = FileHandler.readFile(fileNamea);
        List<String> datab = FileHandler.readFile(fileNameb);
               
        // Map to store assessment ID to assessment type
        Map<String, String> AssessmentTypes = new HashMap<>();
        for (String liney : datay) {
            String[] listy = liney.split(";");
            String assmntID = listy[0];
            String assmntType = listy[1];
            AssessmentTypes.put(assmntID, assmntType);
        }
        
        //Total Student
        for (String line : dataz) {
            String[] UserList = line.split(";");
            if ("student".equals(UserList[10]) && intakeCode.equals(UserList[11])) {
                stdCount++;
            }
        }
        
        //Total EC
        for (String line : dataa) {
            String[] ecList = line.split(";");
            if (AssmntID.equals(ecList[2])) {
                ecCount++;
            }
        }
        
        //Total Submission
        for (String line : datax) {
                String[] StdAssmntList = line.split(";");
                if (AssmntID.equals(StdAssmntList[2]) && "submitted".equals(StdAssmntList[6])) {
                    stdSubCount++;
                }                      
            }
        
        // Completed Assessment (marked & presented)
        for (String line : datax) {
            String[] StdAssmntList = line.split(";");
            if (AssmntID.equals(StdAssmntList[2]) && "marked".equals(StdAssmntList[6])) {
                for (String linea : datab) {
                    String[] StdPresentList = linea.split(";");
                    if (AssmntID.equals(StdPresentList[2]) && "completed".equals(StdPresentList[5])) {
                        stdCmpltCount++;
                    }
                }
            }
        }
        
        // Passing Percentage
        for (String line : datax) {
            String[] StdAssmntList = line.split(";");
            if (AssmntID.equals(StdAssmntList[2]) && 
               ("Pass".equals(StdAssmntList[8]) || "Pass with Small Changes".equals(StdAssmntList[8]))) {
                stdPassCount++;
            }                      
        }
        int passPercent = stdPassCount / stdCount * 100;
        String finalpercent = Integer.toString(passPercent) + "%";
        
        // Set to track added rows to avoid duplication
        Set<String> addedRows = new HashSet<>();
        
        for (String linex : datax) {
        String[] listx = linex.split(";");
        String assessmentID = listx[2];

        for (String liney : datay) {
            String[] listy = liney.split(";");
            String currentAssessmentID = listy[0];
            if (currentAssessmentID.equals(assessmentID) && currentAssessmentID.equals(AssmntID)) {
                String spv = listy[4];
                String secMarker = listy[5];
                String AssmntType = AssessmentTypes.get(AssmntID);

                String rowIdentifier = assessmentID + "-" + user.getUserID();
                if (!addedRows.contains(rowIdentifier)) {
                    if (spv.equals(user.getUserID())) {
                        String[] reorderedData = {
                            AssmntID,       // Supervisee ID
                            AssmntType,     // Supervisee Name
                            Integer.toString(stdCount),         // Supervisor Name
                            Integer.toString(ecCount), // Presentation Slot
                            Integer.toString(stdSubCount),
                            Integer.toString(stdCmpltCount),
                            finalpercent, 
                        };
                        model.addRow(reorderedData);
                        addedRows.add(rowIdentifier);
                    } else if (secMarker.equals(user.getUserID())) {
                        sumRptTable.getColumnModel().getColumn(2).setHeaderValue("Supervisor");
                        sumRptTable.getTableHeader().repaint();
                        String[] reorderedData = {
                            AssmntID,       // Supervisee ID
                            AssmntType,     // Supervisee Name
                            Integer.toString(stdCount),         // Supervisor Name
                            Integer.toString(ecCount), // Presentation Slot
                            Integer.toString(stdSubCount),
                            Integer.toString(stdCmpltCount),
                            finalpercent,                            
                        };
                        model.addRow(reorderedData);
                        addedRows.add(rowIdentifier);
                    }
                }
                }

                    }
                }
            }
    
        public void generateReport(JTable table, String reportPath) {
        try {
            // Load the compiled Jasper report
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(reportPath));

            // Create a data source from the JTable
            JTableDataSource dataSource = new JTableDataSource(table);

            // Fill the report with data
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), dataSource);

            // View the report
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backBtn;
    private javax.swing.JButton generateBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lecProfileLabel;
    private javax.swing.JLabel logoutLabel;
    private javax.swing.JLabel notiLabel;
    private javax.swing.JTable sumRptTable;
    // End of variables declaration//GEN-END:variables
}
