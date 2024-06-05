/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projectmanagementsystem;

import com.mycompany.projectmanagementsystem.Assessment.AssessmentController;
import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import com.mycompany.projectmanagementsystem.GeneralFunction.SessionManager;
import com.mycompany.projectmanagementsystem.User.Student;
import com.mycompany.projectmanagementsystem.User.User;
import com.mycompany.projectmanagementsystem.User.UserController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class StudentDashboardPage extends javax.swing.JFrame {

    /**
     * Creates new form StudentDashboardPage
     */
    private final SessionManager sessionManager = SessionManager.getInstance();
    User user = sessionManager.getCurrentUser();
    private JPanel AssessmentPanel;
    private JButton AssessmentViewBtn;
    private JPanel AssessmentBackgroundPanel;
    private JLabel bg;
    private JLabel AssessmentNameLabel;
    private JLabel supervisorLabel;
    private JLabel secondMarkerLabel;
    private JPanel contentPanel;
    private JLabel dueDateLabel;
    private JPanel dueDatePanel;
    private JLabel fileIcon;
    private JLabel dueDateAssessment;
    private JLabel dateLabel;
    private JLabel upcomingEventLabel;
    private JPanel upcomingEventPanel;
    List<JPanel> assessments = new ArrayList<JPanel>();
    List<JPanel> dueDates = new ArrayList<JPanel>();
    List<JPanel> upcomingEvents = new ArrayList<JPanel>();

    public StudentDashboardPage() {
        initComponents();
        setIconImage();
        if (user != null) {
            jLabel8.setText("Welcome: Lecturer " + "(" + user.getName() + " " + user.getUserID() + ")");
        }
        showAssessmentInfo();
        showDueDateInfo();
        showUpcomingTaskInfo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dueDate = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        upcomingEvent = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        studentHeader = new javax.swing.JPanel();
        studentLogo = new javax.swing.JLabel();
        studentEcSubmission = new javax.swing.JLabel();
        studentNotification = new javax.swing.JLabel();
        studentProfile = new javax.swing.JLabel();
        studentLogout = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Dashboard");
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dueDate.setBackground(new Color(217,217,217,40));
        dueDate.setMaximumSize(new java.awt.Dimension(207, 203));
        dueDate.setMinimumSize(new java.awt.Dimension(207, 203));
        dueDate.setPreferredSize(new java.awt.Dimension(207, 203));
        dueDate.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(2, 50, 99));
        jLabel3.setText("Due Date");
        jLabel3.setMaximumSize(new java.awt.Dimension(80, 18));
        jLabel3.setMinimumSize(new java.awt.Dimension(80, 18));
        jLabel3.setPreferredSize(new java.awt.Dimension(80, 18));
        dueDate.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        getContentPane().add(dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 120, -1, -1));

        jLabel8.setFont(new java.awt.Font("Bell MT", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(2, 50, 99));
        jLabel8.setText("Welcome: ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 420, 30));

        upcomingEvent.setBackground(new Color(217,217,217,40));
        upcomingEvent.setMaximumSize(new java.awt.Dimension(207, 332));
        upcomingEvent.setMinimumSize(new java.awt.Dimension(207, 332));
        upcomingEvent.setPreferredSize(new java.awt.Dimension(207, 332));
        upcomingEvent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(2, 50, 99));
        jLabel1.setText("Upcoming Event");
        jLabel1.setMaximumSize(new java.awt.Dimension(80, 18));
        jLabel1.setMinimumSize(new java.awt.Dimension(80, 18));
        jLabel1.setPreferredSize(new java.awt.Dimension(80, 18));
        upcomingEvent.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, -1));

        getContentPane().add(upcomingEvent, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 352, 210, -1));

        studentHeader.setBackground(new Color(255, 255, 255, 90));
        studentHeader.setToolTipText("");
        studentHeader.setMaximumSize(new java.awt.Dimension(1000, 73));
        studentHeader.setMinimumSize(new java.awt.Dimension(1000, 73));
        studentHeader.setPreferredSize(new java.awt.Dimension(1000, 73));

        studentLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sysco_logo.png"))); // NOI18N
        studentLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentLogoMouseClicked(evt);
            }
        });

        studentEcSubmission.setBackground(new Color(255, 255, 255, 0));
        studentEcSubmission.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        studentEcSubmission.setForeground(new java.awt.Color(2, 50, 99));
        studentEcSubmission.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentEcSubmission.setText("EC Submission");
        studentEcSubmission.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentEcSubmission.setMaximumSize(new java.awt.Dimension(96, 73));
        studentEcSubmission.setMinimumSize(new java.awt.Dimension(96, 73));
        studentEcSubmission.setPreferredSize(new java.awt.Dimension(96, 73));
        studentEcSubmission.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentEcSubmissionMouseClicked(evt);
            }
        });

        studentNotification.setBackground(new Color(255, 255, 255, 0));
        studentNotification.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        studentNotification.setForeground(new java.awt.Color(2, 50, 99));
        studentNotification.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentNotification.setText("Notification");
        studentNotification.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentNotification.setMaximumSize(new java.awt.Dimension(96, 73));
        studentNotification.setMinimumSize(new java.awt.Dimension(96, 73));
        studentNotification.setPreferredSize(new java.awt.Dimension(96, 73));
        studentNotification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentNotificationMouseClicked(evt);
            }
        });

        studentProfile.setBackground(new Color(255, 255, 255, 0));
        studentProfile.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        studentProfile.setForeground(new java.awt.Color(2, 50, 99));
        studentProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentProfile.setText("Profile");
        studentProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentProfile.setMaximumSize(new java.awt.Dimension(96, 73));
        studentProfile.setMinimumSize(new java.awt.Dimension(96, 73));
        studentProfile.setPreferredSize(new java.awt.Dimension(96, 73));
        studentProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentProfileMouseClicked(evt);
            }
        });

        studentLogout.setBackground(new Color(255, 255, 255, 0));
        studentLogout.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        studentLogout.setForeground(new java.awt.Color(2, 50, 99));
        studentLogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentLogout.setText("Log Out");
        studentLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentLogout.setMaximumSize(new java.awt.Dimension(96, 73));
        studentLogout.setMinimumSize(new java.awt.Dimension(96, 73));
        studentLogout.setPreferredSize(new java.awt.Dimension(96, 73));
        studentLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentLogoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout studentHeaderLayout = new javax.swing.GroupLayout(studentHeader);
        studentHeader.setLayout(studentHeaderLayout);
        studentHeaderLayout.setHorizontalGroup(
            studentHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(studentLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 352, Short.MAX_VALUE)
                .addComponent(studentEcSubmission, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(studentNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        studentHeaderLayout.setVerticalGroup(
            studentHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentHeaderLayout.createSequentialGroup()
                .addGroup(studentHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentNotification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentEcSubmission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(studentHeaderLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(studentLogo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(studentHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jScrollPane1.setMaximumSize(new java.awt.Dimension(737, 564));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(737, 564));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(737, 564));

        jPanel2.setMaximumSize(new java.awt.Dimension(300, 250));
        jPanel2.setMinimumSize(new java.awt.Dimension(300, 250));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 735, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, -1, 580));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void studentLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentLogoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_studentLogoMouseClicked

    private void studentLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentLogoutMouseClicked
        this.setVisible(false);
        UserController action = new UserController();
        action.userLogout();
    }//GEN-LAST:event_studentLogoutMouseClicked

    private void studentProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentProfileMouseClicked
        StudentProfilePage profile = new StudentProfilePage();
        profile.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_studentProfileMouseClicked

    private void studentNotificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentNotificationMouseClicked
        NotificationPage notification = new NotificationPage();
        notification.setVisible(true);
    }//GEN-LAST:event_studentNotificationMouseClicked

    private void studentEcSubmissionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentEcSubmissionMouseClicked
        StudentEcSubmissionPage ecPage = new StudentEcSubmissionPage();
        ecPage.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_studentEcSubmissionMouseClicked

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
            java.util.logging.Logger.getLogger(StudentDashboardPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentDashboardPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentDashboardPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentDashboardPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new StudentDashboardPage().setVisible(true);
        });
    }

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon_with_background.png")));
    }

    public List<String> setAssessmentData() {
        List<String> data = FileHandler.readFile("student_assessment.txt");
        List<String> assessment = new ArrayList<>();

        for (String line : data) {
            String[] list = line.split(";");
            if (list.length > 3 && list[1].equals(user.getUserID())) {
                String assessmentID = list[2];
                String assmtDueDate = list[3];
                assessment.add(assessmentID + ";" + assmtDueDate);
            }
        }
        return assessment;
    }

    private void showAssessmentInfo() {
        List<String> AssmntData = FileHandler.readFile("assessment.txt");
        List<String> assmntID = setAssessmentData();
        List<String> userData = FileHandler.readFile("user.txt");
        String supervisorName = null;
        String secondMarkerName = null;
        Collections.reverse(AssmntData);

        // Create a panel to hold all assessment panels
        contentPanel = new JPanel();
        contentPanel.setLayout(null); // Set null layout for absolute positioning

        // Constants for layout
        int panelWidth = 300;
        int panelHeight = 255;
        int xGap = 40;
        int yGap = 10;
        int panelsPerRow = 2;

        int x = xGap;
        int y = yGap;
        int count = 0;
        if (assmntID.isEmpty()) {
            JLabel noAssmntLabel = new JLabel("No Assessment Assigned");
            noAssmntLabel.setFont(new java.awt.Font("SansSerif", 1, 16));
            noAssmntLabel.setForeground(new java.awt.Color(2, 50, 99));
            //set label to center
            int labelWidth = noAssmntLabel.getPreferredSize().width;
            int labelHeight = noAssmntLabel.getPreferredSize().height;
            int a = (contentPanel.getWidth() - labelWidth) / 2;
            int b = (contentPanel.getHeight() - labelHeight) / 2;

            noAssmntLabel.setBounds(a, b, labelWidth, labelHeight);
            contentPanel.add(noAssmntLabel);
        } else {
            for (String line : AssmntData) {
                for (String id : assmntID) {
                    String[] AssmntList = line.split(";");
                    String[] IDList = id.split(";");
                    if (IDList[0].equals(AssmntList[0])) {
                        for (String userLine : userData) {
                            String[] userList = userLine.split(";");
                            if (userList[0].equals(AssmntList[4])) {
                                supervisorName = userList[1];
                            }
                            if (userList[0].equals(AssmntList[5])) {
                                secondMarkerName = userList[1];
                            }
                        }
                        AssessmentPanel = new JPanel();
                        AssessmentPanel.setBackground(Color.WHITE);
                        AssessmentPanel.setPreferredSize(new java.awt.Dimension(panelWidth, panelHeight));
                        AssessmentPanel.setBounds(x, y, panelWidth, panelHeight);
                        AssessmentPanel.setLayout(null);

                        AssessmentBackgroundPanel = new JPanel();
                        bg = new JLabel();
                        AssessmentNameLabel = new javax.swing.JLabel();

                        switch (AssmntList[1]) {
                            case "internship_report" -> {
                                bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/internship.png")));

                                AssessmentNameLabel.setText("Internship Report");
                            }
                            case "fyp" -> {
                                bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_year_project.png")));

                                AssessmentNameLabel.setText("Final Year Project");
                            }
                            case "investigation" -> {
                                bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/investigation_report.png")));

                                AssessmentNameLabel.setText("Investigation Report");
                            }
                            case "cp1" -> {
                                bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capstone_project.png")));

                                AssessmentNameLabel.setText("Capstone Project 1");
                            }
                            case "cp2" -> {
                                bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capstone_project.png")));

                                AssessmentNameLabel.setText("Capstone Project 2");
                            }
                            case "rmcp" -> {
                                bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/research_methodology.png")));

                                AssessmentNameLabel.setText("<html>" + "Research Methodology for Capstone Project" + "</html>");
                            }
                        }

                        AssessmentBackgroundPanel.setBounds(0, 0, panelWidth, 150);
                        bg.setBounds(0, 0, panelWidth, 150);
                        AssessmentBackgroundPanel.add(bg);
                        AssessmentBackgroundPanel.setLayout(null);

                        AssessmentNameLabel.setFont(new java.awt.Font("Bell MT", 1, 18));
                        AssessmentNameLabel.setForeground(new java.awt.Color(2, 50, 99));
                        AssessmentNameLabel.setBounds(10, 160, 250, 35);

                        supervisorLabel = new javax.swing.JLabel();
                        supervisorLabel.setFont(new java.awt.Font("Bell MT", 1, 14));
                        supervisorLabel.setForeground(new java.awt.Color(2, 50, 99));
                        supervisorLabel.setBounds(10, 190, 200, 20);
                        supervisorLabel.setText("Supervisor:" + supervisorName);

                        secondMarkerLabel = new javax.swing.JLabel();
                        secondMarkerLabel.setFont(new java.awt.Font("Bell MT", 1, 14));
                        secondMarkerLabel.setForeground(new java.awt.Color(2, 50, 99));
                        secondMarkerLabel.setBounds(10, 210, 200, 20);
                        secondMarkerLabel.setText("Second Marker:" + secondMarkerName);

                        AssessmentViewBtn = new javax.swing.JButton();
                        AssessmentViewBtn.setBackground(new java.awt.Color(76, 127, 174));
                        AssessmentViewBtn.setFont(new java.awt.Font("Bell MT", 1, 12));
                        AssessmentViewBtn.setForeground(new java.awt.Color(255, 255, 255));
                        AssessmentViewBtn.setText("View");
                        AssessmentViewBtn.setBounds(230, 220, 60, 25);
                        AssessmentViewBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                        AssessmentViewBtn.addActionListener(new java.awt.event.ActionListener() {
                            @Override
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                redirectAssessmentPage(AssmntList[0],AssmntList[1]);
                            }
                        });

                        AssessmentPanel.add(AssessmentBackgroundPanel);
                        AssessmentPanel.add(AssessmentNameLabel);
                        AssessmentPanel.add(supervisorLabel);
                        AssessmentPanel.add(secondMarkerLabel);
                        AssessmentPanel.add(AssessmentViewBtn);

                        contentPanel.add(AssessmentPanel);
                        jPanel2.add(contentPanel);
                        assessments.add(AssessmentPanel);

                        count++;
                        if (count % panelsPerRow == 0) {
                            x = xGap;
                            y += panelHeight + yGap;
                        } else {
                            x += panelWidth + xGap;
                        }
                    }
                }

            }
        }

        // Set preferred size for the content panel based on the number of items
        int numRows = (count + panelsPerRow - 1) / panelsPerRow; // Calculate number of rows needed
        int contentHeight = numRows * (panelHeight + yGap) + yGap; // Calculate content panel height
        contentPanel.setPreferredSize(new java.awt.Dimension(
                panelsPerRow * (panelWidth + xGap) + xGap,
                contentHeight
        ));
        // Add content panel to the scroll pane
        jScrollPane1.setViewportView(contentPanel);
    }

    public void showDueDateInfo() {
        dueDateLabel = new JLabel();
        dueDateLabel.setFont(new java.awt.Font("Bell MT", Font.BOLD, 18));
        dueDateLabel.setForeground(new java.awt.Color(2, 50, 99));
        dueDateLabel.setText("Due Date");
        dueDateLabel.setMaximumSize(new Dimension(80, 18));
        dueDateLabel.setMinimumSize(new Dimension(80, 18));
        dueDateLabel.setPreferredSize(new Dimension(80, 18));
        dueDate.add(dueDateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        List<String> AssmntData = FileHandler.readFile("assessment.txt");
        List<String> assmnt = setAssessmentData();
        AssessmentController action = new AssessmentController();
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (!assmnt.isEmpty()) {
            int yOffset = 30; // Initial offset for the y-position
            for (String line : AssmntData) {
                for (String assmtLine : assmnt) {
                    String[] AssmntList = line.split(";");
                    String[] studentAssmnt = assmtLine.split(";");
                    if (studentAssmnt[0].equals(AssmntList[0])) {
                        LocalDate dueDateValue = LocalDate.parse(studentAssmnt[1], formatter);
                        long daysBetween = ChronoUnit.DAYS.between(today, dueDateValue);
                        if (daysBetween >= 0 && daysBetween <= 7) {
                            // Initialize dueDatePanel here
                            dueDatePanel = new JPanel();
                            dueDatePanel.setMaximumSize(new Dimension(190, 50));
                            dueDatePanel.setMinimumSize(new Dimension(190, 50));
                            dueDatePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                            fileIcon = new JLabel(); // Initialize fileIcon
                            fileIcon.setIcon(new ImageIcon(getClass().getResource("/File_dock.png")));
                            fileIcon.setMaximumSize(new Dimension(30, 30));
                            fileIcon.setMinimumSize(new Dimension(30, 30));
                            fileIcon.setPreferredSize(new Dimension(30, 30));
                            dueDatePanel.add(fileIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 37, -1));

                            dueDateAssessment = new JLabel(); // Initialize dueDateAssessment
                            dueDateAssessment.setFont(new java.awt.Font("SansSerif", Font.BOLD, 12));
                            dueDateAssessment.setForeground(new java.awt.Color(2, 50, 99));
                            dueDateAssessment.setText(action.assessmentType(AssmntList[1]));
                            dueDatePanel.add(dueDateAssessment, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 130, -1));

                            dateLabel = new JLabel(); // Initialize dateLabel
                            dateLabel.setFont(new java.awt.Font("SansSerif", Font.PLAIN, 12));
                            dateLabel.setText(studentAssmnt[1]);
                            dueDatePanel.add(dateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 80, -1));

                            dueDate.add(dueDatePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, yOffset, 190, 50));
                            upcomingEvents.add(dueDatePanel);
                            yOffset += 60; // Increment yOffset for the next panel
                        }
                    }
                }
            }

            dueDate.revalidate();
            dueDate.repaint();
        }
    }

    private void showUpcomingTaskInfo() {
        upcomingEventLabel = new JLabel();
        upcomingEventLabel.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        upcomingEventLabel.setForeground(new java.awt.Color(2, 50, 99));
        upcomingEventLabel.setText("Upcoming Event");
        upcomingEventLabel.setMaximumSize(new java.awt.Dimension(80, 18));
        upcomingEventLabel.setMinimumSize(new java.awt.Dimension(80, 18));
        upcomingEventLabel.setPreferredSize(new java.awt.Dimension(80, 18));
        upcomingEvent.add(upcomingEventLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, -1));

        List<String> AssmntData = FileHandler.readFile("assessment.txt");
        List<String> assmnt = setAssessmentData();
         AssessmentController action = new AssessmentController();
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (!assmnt.isEmpty()) {
            int yOffset = 30; // Initial offset for the y-position
            for (String line : AssmntData) {
                for (String assmtLine : assmnt) {
                    String[] AssmntList = line.split(";");
                    String[] studentAssmnt = assmtLine.split(";");
                    if (studentAssmnt[0].equals(AssmntList[0])) {
                        LocalDate dueDateValue = LocalDate.parse(studentAssmnt[1], formatter);
                        long daysBetween = ChronoUnit.DAYS.between(today, dueDateValue);
                        if (daysBetween >= 0) {
                            upcomingEventPanel = new JPanel();
                            upcomingEventPanel.setMaximumSize(new Dimension(190, 50));
                            upcomingEventPanel.setMinimumSize(new Dimension(190, 50));
                            upcomingEventPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                            fileIcon = new JLabel(); // Initialize fileIcon
                            fileIcon.setIcon(new ImageIcon(getClass().getResource("/File_dock.png")));
                            fileIcon.setMaximumSize(new Dimension(30, 30));
                            fileIcon.setMinimumSize(new Dimension(30, 30));
                            fileIcon.setPreferredSize(new Dimension(30, 30));
                            upcomingEventPanel.add(fileIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 37, -1));

                            dueDateAssessment = new JLabel(); // Initialize dueDateAssessment
                            dueDateAssessment.setFont(new java.awt.Font("SansSerif", Font.BOLD, 12));
                            dueDateAssessment.setForeground(new java.awt.Color(2, 50, 99));
                            dueDateAssessment.setText(action.assessmentType(AssmntList[1]));
                            upcomingEventPanel.add(dueDateAssessment, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 130, -1));

                            dateLabel = new JLabel(); // Initialize dateLabel
                            dateLabel.setFont(new java.awt.Font("SansSerif", Font.PLAIN, 12));
                            dateLabel.setText(studentAssmnt[1]);
                            upcomingEventPanel.add(dateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 80, -1));

                            upcomingEvent.add(upcomingEventPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, yOffset, 190, 50));
                            dueDates.add(upcomingEventPanel);
                            yOffset += 60; // Increment yOffset for the next panel
                        }
                    }
                }
            }
        }
    }

    private void redirectAssessmentPage(String assessmentID,String assessmentType) {
        StudentAssessmentDetailPage details = new StudentAssessmentDetailPage(assessmentID,assessmentType);
        details.setVisible(true);
        this.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JPanel dueDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel studentEcSubmission;
    private javax.swing.JPanel studentHeader;
    private javax.swing.JLabel studentLogo;
    private javax.swing.JLabel studentLogout;
    private javax.swing.JLabel studentNotification;
    private javax.swing.JLabel studentProfile;
    private javax.swing.JPanel upcomingEvent;
    // End of variables declaration//GEN-END:variables
}
