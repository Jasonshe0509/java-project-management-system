/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projectmanagementsystem;

import com.mycompany.projectmanagementsystem.Assessment.AssessmentController;
import com.mycompany.projectmanagementsystem.Assessment.AssessmentTableActionEvent;
import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import com.mycompany.projectmanagementsystem.GeneralFunction.SessionManager;
import com.mycompany.projectmanagementsystem.User.User;
import com.mycompany.projectmanagementsystem.User.UserController;
import java.awt.Toolkit;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author shuhuilee
 */
public class PM_assessment_page extends javax.swing.JFrame {

    private final String assessmentType;
    private final SessionManager sessionManager = SessionManager.getInstance();
    User user = sessionManager.getCurrentUser();
    private TableRowSorter<DefaultTableModel> rowSorter;

    /**
     * Creates new form Internship
     *
     * @param assessmentType
     */
    public PM_assessment_page(String assessmentType) {
        this.assessmentType = assessmentType;
        initComponents();
        setIconImage();
        populateComboBox();
        readAssessmentFromFile();
        assessmentType();

        DefaultTableModel model = (DefaultTableModel) pm_assessment_table.getModel();
        rowSorter = new TableRowSorter<>(model);
        pm_assessment_table.setRowSorter(rowSorter);
        setupTable();
    }

    private void setupTable() {
        PM_assessment_ActionPanel action = new PM_assessment_ActionPanel();
        AssessmentTableActionEvent event = new AssessmentTableActionEvent() {
            @Override
            public void assessment_Delete(int row, Object value) {
                DefaultTableModel model = (DefaultTableModel) pm_assessment_table.getModel();
                String assessmentID = (String) model.getValueAt(row, 0); // Assuming assessmentID is in the first column

                int response = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you want to delete the assessment with ID " + assessmentID + "?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );
                if (response == JOptionPane.YES_OPTION) {
                    boolean canDelete = canDeleteAssessment(assessmentID);
                    if (canDelete) {
                        AssessmentController controller = new AssessmentController();
                        boolean result = controller.assessment_Delete(assessmentID);
                        if (result) {
                            JOptionPane.showMessageDialog(null, "Assessment successfully deleted");
                            backAssessmentPage(); // Refresh the table data
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Cannot delete assessment. There are submitted or marked student submissions related to it.");
                    }
                }
            }

            @Override
            public void assessment_Edit(int row, Object value) {
                DefaultTableModel model = (DefaultTableModel) pm_assessment_table.getModel();
                if (row >= 0 && row < model.getRowCount()) {
                    String assessmentID = (String) model.getValueAt(row, 0);
                    String intakeCode = (String) model.getValueAt(row, 2);
                    redirectEdit(assessmentID,intakeCode);
                }
            }

            @Override
            public void assessment_Report(int row, Object value) {
                DefaultTableModel model = (DefaultTableModel) pm_assessment_table.getModel();
                if (row >= 0 && row < model.getRowCount()) {
                    String assessmentID = (String) model.getValueAt(row, 0);
                    PM_report_status report = new PM_report_status(assessmentType, assessmentID);
                    report.setVisible(true);
                    PM_assessment_page.this.dispose();
                }
            }
        };
        pm_assessment_table.getColumnModel().getColumn(7).setCellRenderer(action.new rPanelActionRenderer());
        pm_assessment_table.getColumnModel().getColumn(7).setCellEditor(action.new TableActionCellEditor(event));

    }

    ;
            
            private boolean canDeleteAssessment(String assessmentID) {
        // Check if there are any student submissions related to this assessment
        List<String> studentSubmissions = FileHandler.readFile("student_assessment.txt");
        for (String line : studentSubmissions) {
            String[] parts = line.split(";");
            if (parts[0].equals(assessmentID)) {
                // Assuming status is stored at index 2
                String status = parts[2];
                if (status.equals("submitted") || status.equals("marked")) {
                    return false; // There are submitted or marked student submissions
                }
            }
        }
        return true; // No submitted or marked student submissions found
    }

    private void backAssessmentPage() {
        // Refresh the assessment page by creating a new instance of it
        PM_assessment_page assessmentPage = new PM_assessment_page(assessmentType);
        assessmentPage.setVisible(true);
        assessmentPage.dispose();
    }

    private void assessmentType() {
        if (assessmentType.equalsIgnoreCase("internship_report")) {
            pm_assessment.setText("Internship Report");
        } else if (assessmentType.equalsIgnoreCase("fyp")) {
            pm_assessment.setText("Final Year Project");
        } else if (assessmentType.equalsIgnoreCase("cp1")) {
            pm_assessment.setText("Capstone Project 1");
        } else if (assessmentType.equalsIgnoreCase("cp2")) {
            pm_assessment.setText("Capstone Project 2");
        } else if (assessmentType.equalsIgnoreCase("rmcp")) {
            pm_assessment.setText("Research Methodology for Capstone Project");
        } else if (assessmentType.equalsIgnoreCase("investigation")) {
            pm_assessment.setText("Investigation Report");
        } else {
            pm_assessment.setText("Unknown");
        }
    }

    private String[] getSupervisorAndSecondMarkerNames(String supervisorId, String secondMarkerId) {
        String[] names = new String[2];
        String fileName = "user.txt";
        List<String> data = FileHandler.readFile(fileName);
        for (String line : data) {
            String[] list = line.split(";");
            if (list.length >= 11) {
                String id = list[0].trim();
                if (id.equalsIgnoreCase(supervisorId)) {
                    names[0] = list[1].trim(); // Supervisor name
                } else if (id.equalsIgnoreCase(secondMarkerId)) {
                    names[1] = list[1].trim(); // Second Marker name
                }
            }
        }

        return names;
    }

    private void readAssessmentFromFile() {
        String fileName = "assessment.txt";
        DefaultTableModel model = (DefaultTableModel) pm_assessment_table.getModel();
        model.setRowCount(0); // Clear existing rows
        List<String> data = FileHandler.readFile(fileName);
        for (String line : data) {
            String[] list = line.split(";");
            if (list.length == 8 && list[1].equalsIgnoreCase(assessmentType) && list[6].equals(user.getUserID())) {
                String supervisorId = list[4].trim(); // Supervisor ID
                String secondMarkerId = list[5].trim(); // Second Marker ID
                String[] names = getSupervisorAndSecondMarkerNames(supervisorId, secondMarkerId);

                // Replace supervisor and second marker IDs with names
                list[4] = names[0]; // Supervisor Name
                // Check assessment type and set second marker accordingly
                if (list[1].equalsIgnoreCase("internship_report") || list[1].equalsIgnoreCase("investigation")) {
                    list[5] = "-"; // Set to "-" for internship and investigation
                } else {
                    list[5] = names[1]; // Second Marker Name for other types
                }

                String[] reorderedData = {
                    list[0], // Assessment ID
                    list[1], // Assessment Type
                    list[2], // Student Intake
                    list[4], // Supervisor Name
                    list[5], // Second Marker Name
                    list[7], // Assessment Status
                    list[3], // Due Date
                };
                model.addRow(reorderedData);
            }
        }
        System.out.println("Table data has been loaded from " + fileName);
    }

    private void populateComboBox() {
        String fileName = "assessment.txt";
        Set<String> intakes = new HashSet<>();
        intakes.add("All"); // Add default "All" option

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] list = line.split(";");
                if (list.length == 8 && list[1].equalsIgnoreCase(assessmentType)) {
                    intakes.add(list[2].trim()); // Add intake to the set
                }
            }
        } catch (IOException ex) {
            System.err.println("Error reading file: " + ex.getMessage());
        }

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(intakes.toArray(new String[0]));
        jComboBox1.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pm_assessment = new javax.swing.JLabel();
        pm_assessment_search = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        pm_assessment_table = new javax.swing.JTable();
        pm_assessment_create_button1 = new javax.swing.JButton();
        pm_assessment_back_button2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        pm_logo_sysco = new javax.swing.JLabel();
        pm_ec_approvement = new javax.swing.JLabel();
        pm_notification = new javax.swing.JLabel();
        pm_profile = new javax.swing.JLabel();
        pm_logout = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Project Manager Internship ");
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pm_assessment.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        pm_assessment.setText("Report");
        getContentPane().add(pm_assessment, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 670, 30));

        pm_assessment_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pm_assessment_searchActionPerformed(evt);
            }
        });
        pm_assessment_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pm_assessment_searchKeyReleased(evt);
            }
        });
        getContentPane().add(pm_assessment_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 170, -1));

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 190, -1));

        pm_assessment_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Assessment ID", "Assessment Type", "Student Intake", "Supervisor Name", "Second Marker Name", "Assessment Status ", "Duedate", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pm_assessment_table.setRowHeight(40);
        jScrollPane1.setViewportView(pm_assessment_table);
        if (pm_assessment_table.getColumnModel().getColumnCount() > 0) {
            pm_assessment_table.getColumnModel().getColumn(7).setMinWidth(170);
            pm_assessment_table.getColumnModel().getColumn(7).setPreferredWidth(170);
            pm_assessment_table.getColumnModel().getColumn(7).setMaxWidth(170);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 970, 470));

        pm_assessment_create_button1.setBackground(new java.awt.Color(76, 127, 174));
        pm_assessment_create_button1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        pm_assessment_create_button1.setForeground(new java.awt.Color(255, 255, 255));
        pm_assessment_create_button1.setText("Create");
        pm_assessment_create_button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pm_assessment_create_button1ActionPerformed(evt);
            }
        });
        getContentPane().add(pm_assessment_create_button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 130, -1, -1));

        pm_assessment_back_button2.setBackground(new java.awt.Color(76, 127, 174));
        pm_assessment_back_button2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        pm_assessment_back_button2.setForeground(new java.awt.Color(255, 255, 255));
        pm_assessment_back_button2.setText("Back");
        pm_assessment_back_button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pm_assessment_back_button2ActionPerformed(evt);
            }
        });
        getContentPane().add(pm_assessment_back_button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 130, -1, -1));

        jPanel1.setBackground(new Color(255, 255, 255, 90));
        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 73));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 73));

        pm_logo_sysco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sysco_logo.png"))); // NOI18N

        pm_ec_approvement.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        pm_ec_approvement.setForeground(new java.awt.Color(2, 50, 99));
        pm_ec_approvement.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pm_ec_approvement.setText("EC Approvement");
        pm_ec_approvement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pm_ec_approvementMouseClicked(evt);
            }
        });

        pm_notification.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        pm_notification.setForeground(new java.awt.Color(2, 50, 99));
        pm_notification.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pm_notification.setText("Notification");
        pm_notification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pm_notificationMouseClicked(evt);
            }
        });

        pm_profile.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        pm_profile.setForeground(new java.awt.Color(2, 50, 99));
        pm_profile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pm_profile.setText("Profile");
        pm_profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pm_profileMouseClicked(evt);
            }
        });

        pm_logout.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        pm_logout.setForeground(new java.awt.Color(2, 50, 99));
        pm_logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pm_logout.setText("Log Out");
        pm_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pm_logoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pm_logo_sysco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 356, Short.MAX_VALUE)
                .addComponent(pm_ec_approvement)
                .addGap(18, 18, 18)
                .addComponent(pm_notification)
                .addGap(18, 18, 18)
                .addComponent(pm_profile)
                .addGap(26, 26, 26)
                .addComponent(pm_logout)
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pm_logout)
                            .addComponent(pm_profile)
                            .addComponent(pm_notification)
                            .addComponent(pm_ec_approvement)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(pm_logo_sysco)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pm_assessment_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pm_assessment_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pm_assessment_searchActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:

        String selectedIntake = jComboBox1.getSelectedItem().toString();
        DefaultTableModel model = (DefaultTableModel) pm_assessment_table.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        pm_assessment_table.setRowSorter(sorter);
        if ("All".equals(selectedIntake)) {
            sorter.setRowFilter(null); // Show all rows
        } else {
            RowFilter<DefaultTableModel, Object> intakeFilter = new RowFilter<DefaultTableModel, Object>() {
                public boolean include(RowFilter.Entry<? extends DefaultTableModel, ? extends Object> entry) {
                    return entry.getStringValue(2).equals(selectedIntake);
                }
            };
            sorter.setRowFilter(intakeFilter);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void pm_assessment_create_button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pm_assessment_create_button1ActionPerformed
        // TODO add your handling code here:
        // Create an instance of PM_internship_create
        PM_register_assessment_create assessment = new PM_register_assessment_create(assessmentType, this);
        assessment.setVisible(true);
    }//GEN-LAST:event_pm_assessment_create_button1ActionPerformed

    private void pm_assessment_back_button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pm_assessment_back_button2ActionPerformed
        // TODO add your handling code here:
        ProjectManagerPage pm = new ProjectManagerPage();
        pm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_pm_assessment_back_button2ActionPerformed

    private void pm_assessment_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pm_assessment_searchKeyReleased
        // TODO add your handling code here:
        String searchText = pm_assessment_search.getText();
        if (searchText.trim().length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
        }
    }//GEN-LAST:event_pm_assessment_searchKeyReleased

    private void pm_ec_approvementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pm_ec_approvementMouseClicked
        // TODO add your handling code here:
        PM_ec_approvement ecApprove = new PM_ec_approvement();
        ecApprove.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_pm_ec_approvementMouseClicked

    private void pm_notificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pm_notificationMouseClicked
        // TODO add your handling code here:
        NotificationPage noti = new NotificationPage();
        noti.setVisible(true);
    }//GEN-LAST:event_pm_notificationMouseClicked

    private void pm_profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pm_profileMouseClicked
        // TODO add your handling code here:
        PM_profile_page profile = new PM_profile_page();
        profile.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_pm_profileMouseClicked

    private void pm_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pm_logoutMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        UserController action = new UserController();
        action.userLogout();
    }//GEN-LAST:event_pm_logoutMouseClicked

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
            java.util.logging.Logger.getLogger(PM_assessment_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PM_assessment_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PM_assessment_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PM_assessment_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PM_assessment_page("Assessment").setVisible(true);
            }
        });
    }

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon_with_background.png")));
    }

    void redirectEdit(String assessmentID, String intakeCode) {
        PM_assessment_edit edit = new PM_assessment_edit(assessmentType, assessmentID, intakeCode, this);
        edit.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel pm_assessment;
    private javax.swing.JButton pm_assessment_back_button2;
    private javax.swing.JButton pm_assessment_create_button1;
    private javax.swing.JTextField pm_assessment_search;
    private javax.swing.JTable pm_assessment_table;
    private javax.swing.JLabel pm_ec_approvement;
    private javax.swing.JLabel pm_logo_sysco;
    private javax.swing.JLabel pm_logout;
    private javax.swing.JLabel pm_notification;
    private javax.swing.JLabel pm_profile;
    // End of variables declaration//GEN-END:variables
}
