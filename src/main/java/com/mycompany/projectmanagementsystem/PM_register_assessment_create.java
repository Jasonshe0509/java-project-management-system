/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projectmanagementsystem;

import com.mycompany.projectmanagementsystem.Assessment.AssessmentController;
import com.mycompany.projectmanagementsystem.GeneralFunction.SessionManager;
import com.mycompany.projectmanagementsystem.User.User;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shuhuilee
 */
public class PM_register_assessment_create extends javax.swing.JFrame {

    private final SessionManager sessionManager = SessionManager.getInstance();
    private boolean saved = false;
    private final String assessmentType;
    private int currentId = 1;
    private JTable pm_assessment_table;
    PM_assessment_page parentpage;

    private static String getAssessmentType() {
        return "internship";
    }

    public PM_register_assessment_create(String assessmentType, PM_assessment_page parentpage) {
        initComponents();
        setIconImage();
        this.assessmentType = assessmentType;
        this.assessment_Type.setText(assessmentType);
        this.parentpage = parentpage;
        assessment_Type();
        assessment_Type.setEditable(false);
        loadIntakeCodes(getStudentIntakeCodes());
        pm_studentIntake.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String selectedIntake = (String) pm_studentIntake.getSelectedItem();
                if (selectedIntake != null && !selectedIntake.isEmpty()) {
                    String school = getSchoolByIntake(selectedIntake);
                    populateLecturers(school);
                }
            }
        });
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private String generateUniqueId() {
        String fileName = "assessment.txt";
        int maxId = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] list = line.split(";");
                if (list.length > 0 && list[0].startsWith("A")) {
                    int id = Integer.parseInt(list[0].substring(1));
                    if (id > maxId) {
                        maxId = id;
                    }
                }
            }
        } catch (IOException ex) {
            System.err.println("Error reading file: " + ex.getMessage());
        }

        return "A" + String.format("%04d", maxId + 1);
    }

    private void saveAssessmentToFile(String uniqueId, String[] list) {
        String fileName = "assessment.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            // Determine whether to include the second marker or a placeholder based on the assessment type
            String secondMarkerData = "";
            if (list[0].equalsIgnoreCase("internship_report") || list[0].equalsIgnoreCase("investigation")) {
                secondMarkerData = "-"; // Add a placeholder if no second marker is required
            } else {
                secondMarkerData = list[4]; // Use the provided second marker ID
            }

            String line = uniqueId + ";" + list[0] + ";" + list[1] + ";" + list[2] + ";" + list[3] + ";" + secondMarkerData + ";" + list[5] + ";" + list[6] + "\n";
            bw.write(line);
        } catch (IOException ex) {
            System.err.println("Error writing to file: " + ex.getMessage());
        }
    }

    private void readAssessmentFromFile() {
        String fileName = "assessment.txt";
        if (pm_assessment_table == null) {
            System.err.println("pm_assessment_table is null!");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) pm_assessment_table.getModel();
        if (model == null) {
            System.err.println("Table model is null!");
            return;
        }

        model.setRowCount(0); // Clear existing rows

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] list = line.split(";");
                if (list.length == 8) {
                    String[] reorderedData = {
                        list[0], // Assessment ID
                        list[1], // Assessment Type
                        list[2], // Student Intake
                        list[3], // Due Date
                        getUserNameFromId(list[4]), // Supervisor Name
                        getUserNameFromId(list[5]), // Second Marker Name
                        getUserNameFromId(list[6]), // Project Manager ID
                        list[7] // Assessment Status
                    };
                    model.addRow(reorderedData);
                }
            }
            System.out.println("Table data has been loaded from " + fileName);
        } catch (IOException ex) {
            System.err.println("Error reading file: " + ex.getMessage());
        }
    }

    private String getUserNameFromId(String userId) {
        String fileName = "user.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] list = line.split(";");
                if (list[0].trim().equals(userId)) {
                    return list[1].trim();
                }
            }
        } catch (IOException ex) {
            System.err.println("Error reading file: " + ex.getMessage());
        }
        return "Unknown";
    }

    public boolean isSaved() {
        return saved;
    }

    private void assessment_Type() {
        if (assessmentType.equalsIgnoreCase("internship_report") || assessmentType.equalsIgnoreCase("investigation")) {
            secondmarker_name.setVisible(false);
            second_maker_name.setVisible(false); // Ensure the label is also hidden
        } else {
            secondmarker_name.setVisible(true);
            second_maker_name.setVisible(true); // Ensure the label is also shown
        }

        if (assessmentType.equalsIgnoreCase("internship_report")) {
            assessment_Type.setText("internship_report");
        } else if (assessmentType.equalsIgnoreCase("fyp")) {
            assessment_Type.setText("fyp");
        } else if (assessmentType.equalsIgnoreCase("cp1")) {
            assessment_Type.setText("cp1");
        } else if (assessmentType.equalsIgnoreCase("cp2")) {
            assessment_Type.setText("cp2");
        } else if (assessmentType.equalsIgnoreCase("rmcp")) {
            assessment_Type.setText("rmcp");
        } else if (assessmentType.equalsIgnoreCase("investigation")) {
            assessment_Type.setText("investigation");
        } else {
            assessment_Type.setText("Unknown");
        }
    }

    private void populateLecturers(String school) {
        supervisor_name.removeAllItems();
        secondmarker_name.removeAllItems();
        String fileName = "user.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] list = line.split(";");
                if (list.length > 11 && list[10].equalsIgnoreCase("lecturer") && list[11].trim().equalsIgnoreCase(school)) {
                    String userIdAndName = list[0] + " - " + list[1]; // Concatenate user ID and name
                    supervisor_name.addItem(userIdAndName);
                    secondmarker_name.addItem(userIdAndName);
                }
            }
        } catch (IOException ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }
    }

    private Set<String> getStudentIntakeCodes() {
        Set<String> studentIntakeCodes = new HashSet<>();
        String fileName = "user.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] list = line.split(";");
                if (list.length > 10 && list[10].equalsIgnoreCase("student")) {
                    studentIntakeCodes.add(list[11].trim());
                }
            }
        } catch (IOException ex) {
            System.err.println("Error reading file: " + ex.getMessage());
        }
        System.out.println(studentIntakeCodes);
        return studentIntakeCodes;
    }

    private void loadIntakeCodes(Set<String> validIntakeCodes) {
        String fileName = "intake.txt";
        pm_studentIntake.addItem(""); // Add a blank item first
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String intakeCode = line.split(";")[0].trim();
                if (validIntakeCodes.contains(intakeCode)) {
                    pm_studentIntake.addItem(intakeCode);
                }
            }
        } catch (IOException ex) {
            System.err.println("Error reading file: " + ex.getMessage());
        }
    }

    private String getSchoolByIntake(String intakeCode) {
        String fileName = "intake.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] list = line.split(";");
                if (list[0].trim().equals(intakeCode)) {
                    return list[1].trim(); // School wise
                }
            }
        } catch (IOException ex) {
            System.err.println("Error reading file: " + ex.getMessage());
        }
        return null;
    }

    private boolean SupervisorSecondMarkerSameWithinIntake(String studentIntake, String supervisorId, String secondMarkerId) {
        String fileName = "assessment.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] list = line.split(";");
                if (list.length >= 3 && list[2].equalsIgnoreCase(studentIntake)) {
                    String supervisorInFile = list[4];
                    String secondMarkerInFile = list[5];
                    if (supervisorInFile.equals(supervisorId) && secondMarkerInFile.equals(secondMarkerId)) {
                        return true;
                    }
                }
            }
        } catch (IOException ex) {
            System.err.println("Error reading file: " + ex.getMessage());
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        supervisorName = new javax.swing.JLabel();
        assessment_type = new javax.swing.JLabel();
        student_intake = new javax.swing.JLabel();
        second_maker_name = new javax.swing.JLabel();
        duedate = new javax.swing.JLabel();
        assessment_Type = new javax.swing.JTextField();
        pm_studentIntake = new javax.swing.JComboBox<>();
        supervisor_name = new javax.swing.JComboBox<>();
        secondmarker_name = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        back_jButton1 = new javax.swing.JButton();
        create_jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(700, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        supervisorName.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        supervisorName.setText("Supervisor Name：");
        getContentPane().add(supervisorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, -1, -1));

        assessment_type.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        assessment_type.setText("Assessment Type ：");
        getContentPane().add(assessment_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        student_intake.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        student_intake.setText("Student Intake ：");
        getContentPane().add(student_intake, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, -1));

        second_maker_name.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        second_maker_name.setText("Second Marker Name ：");
        getContentPane().add(second_maker_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, -1, -1));

        duedate.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        duedate.setText("Duedate：");
        getContentPane().add(duedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 90, -1));

        assessment_Type.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        assessment_Type.setMaximumSize(new java.awt.Dimension(64, 28));
        getContentPane().add(assessment_Type, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 210, -1));

        pm_studentIntake.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        pm_studentIntake.setMaximumSize(new java.awt.Dimension(64, 28));
        pm_studentIntake.setMinimumSize(new java.awt.Dimension(64, 28));
        pm_studentIntake.setPreferredSize(new java.awt.Dimension(64, 28));
        getContentPane().add(pm_studentIntake, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 210, -1));

        supervisor_name.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        supervisor_name.setMaximumSize(new java.awt.Dimension(64, 28));
        supervisor_name.setMinimumSize(new java.awt.Dimension(64, 28));
        supervisor_name.setPreferredSize(new java.awt.Dimension(64, 28));
        getContentPane().add(supervisor_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 310, -1));

        secondmarker_name.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        secondmarker_name.setMaximumSize(new java.awt.Dimension(64, 28));
        secondmarker_name.setMinimumSize(new java.awt.Dimension(64, 28));
        secondmarker_name.setPreferredSize(new java.awt.Dimension(64, 28));
        getContentPane().add(secondmarker_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 310, -1));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 210, 30));

        back_jButton1.setBackground(new java.awt.Color(76, 127, 174));
        back_jButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        back_jButton1.setForeground(new java.awt.Color(255, 255, 255));
        back_jButton1.setText("Back");
        back_jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(back_jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, -1, -1));

        create_jButton2.setBackground(new java.awt.Color(76, 127, 174));
        create_jButton2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        create_jButton2.setForeground(new java.awt.Color(255, 255, 255));
        create_jButton2.setText("Create Assessment");
        create_jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(create_jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, -1, -1));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel2.setText("Register New Assessment ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(700, 500));
        jLabel1.setMinimumSize(new java.awt.Dimension(700, 500));
        jLabel1.setPreferredSize(new java.awt.Dimension(700, 500));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void back_jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_back_jButton1ActionPerformed

    private void create_jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_jButton2ActionPerformed
        // TODO add your handling code here:
        User user = sessionManager.getCurrentUser(); // Get the current user ID\
        String assessmentType = assessment_Type.getText();
        String studentIntake = (String) pm_studentIntake.getSelectedItem();
        Date dueDate = jDateChooser1.getDate();
        if (dueDate != null) {
            String dueDateString = new SimpleDateFormat("yyyy-MM-dd").format(dueDate);
            String supervisor = (String) supervisor_name.getSelectedItem();
            String supervisorId = supervisor.split(" - ")[0];  // Extract ID
            String userID = user != null ? user.getUserID() : "";
            String assessmentStatus = "incomplete";
            AssessmentController action = new AssessmentController();
            boolean result;

            if (assessmentType.equals("internship_report") || assessmentType.equals("investigation")) {
                String[] assessmentData1 = {
                    assessmentType,
                    studentIntake,
                    dueDateString,
                    supervisorId,
                    userID,
                    assessmentStatus
                };
                result = action.assessment_Create(assessmentData1);

            } else {
                String secondMarker = (String) secondmarker_name.getSelectedItem();
                String secondMarkerId = secondMarker.split(" - ")[0];
                String[] assessmentData2 = {
                    assessmentType,
                    studentIntake,
                    dueDateString,
                    supervisorId,
                    userID,
                    assessmentStatus,
                    secondMarkerId
                };
                result = action.assessment_Create(assessmentData2);
            }
            if (result) {
                JOptionPane.showMessageDialog(null, "Successfully create a new assessment: " + assessmentType + "for intake " + studentIntake);
                this.dispose();
                parentpage.setVisible(false);
                PM_assessment_page assessment = new PM_assessment_page(assessmentType);
                assessment.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "The due date cannot be null.", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_create_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(PM_register_assessment_create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PM_register_assessment_create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PM_register_assessment_create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PM_register_assessment_create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String assessmentType = getAssessmentType();
                new PM_register_assessment_create(assessmentType, null).setVisible(true);
            }
        });
    }

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon_with_background.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField assessment_Type;
    private javax.swing.JLabel assessment_type;
    private javax.swing.JButton back_jButton1;
    private javax.swing.JButton create_jButton2;
    private javax.swing.JLabel duedate;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> pm_studentIntake;
    private javax.swing.JLabel second_maker_name;
    private javax.swing.JComboBox<String> secondmarker_name;
    private javax.swing.JLabel student_intake;
    private javax.swing.JLabel supervisorName;
    private javax.swing.JComboBox<String> supervisor_name;
    // End of variables declaration//GEN-END:variables
}
