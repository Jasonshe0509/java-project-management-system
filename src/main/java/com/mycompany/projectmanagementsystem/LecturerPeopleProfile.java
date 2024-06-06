/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projectmanagementsystem;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import com.mycompany.projectmanagementsystem.GeneralFunction.SessionManager;
import com.mycompany.projectmanagementsystem.User.User;
import java.awt.Component;
import java.awt.Toolkit;
import java.util.List;

/**
 *
 * @author user
 */
public class LecturerPeopleProfile extends javax.swing.JFrame {

    /**
     * Creates new form LecturerPeopleProfile
     */
    private final SessionManager sessionManager = SessionManager.getInstance();
    User user = sessionManager.getCurrentUser();
    private String stdID;
    
    public LecturerPeopleProfile(String id) {
        this.stdID = id;
        initComponents();
        setIconImage();
        showStdDetails();
        showAssmntDetails();
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
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        icpassLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        nationLabel = new javax.swing.JLabel();
        dobLabel = new javax.swing.JLabel();
        hpLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        overallStatus = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        dueDateLabel = new javax.swing.JLabel();
        submissionStatus = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        presentStatus = new javax.swing.JLabel();
        spvPresentStatus = new javax.swing.JLabel();
        secMarkPresentStatus = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        presentFeedbackField = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        assmntStatus = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lecturer People Profile");
        setMaximumSize(new java.awt.Dimension(900, 500));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Bell MT", 1, 32)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(2, 50, 99));
        jLabel7.setText("Intake");
        jLabel7.setMaximumSize(new java.awt.Dimension(275, 47));
        jLabel7.setMinimumSize(new java.awt.Dimension(275, 47));
        jLabel7.setPreferredSize(new java.awt.Dimension(275, 47));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 320, 47));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(880, 370));
        jPanel2.setMinimumSize(new java.awt.Dimension(880, 370));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/profile1_icon.png"))); // NOI18N

        genderLabel.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        genderLabel.setForeground(new java.awt.Color(2, 50, 99));
        genderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        genderLabel.setText("Gender");

        icpassLabel.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        icpassLabel.setForeground(new java.awt.Color(2, 50, 99));
        icpassLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icpassLabel.setText("IC/Passport");

        idLabel.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        idLabel.setForeground(new java.awt.Color(2, 50, 99));
        idLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idLabel.setText("ID");

        nameLabel.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(2, 50, 99));
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("Name");

        emailLabel.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(2, 50, 99));
        emailLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emailLabel.setText("Email");

        nationLabel.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        nationLabel.setForeground(new java.awt.Color(2, 50, 99));
        nationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nationLabel.setText("Nationality");

        dobLabel.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        dobLabel.setForeground(new java.awt.Color(2, 50, 99));
        dobLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dobLabel.setText("DOB");

        hpLabel.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        hpLabel.setForeground(new java.awt.Color(2, 50, 99));
        hpLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hpLabel.setText("Phone no.");

        addressLabel.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        addressLabel.setForeground(new java.awt.Color(2, 50, 99));
        addressLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addressLabel.setText("Address");

        overallStatus.setBackground(new java.awt.Color(255, 255, 255));
        overallStatus.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        overallStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        overallStatus.setText("Status");
        overallStatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        overallStatus.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(overallStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(genderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(idLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nationLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(icpassLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emailLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hpLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dobLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(overallStatus)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(idLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icpassLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(genderLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nationLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hpLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dobLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addressLabel)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(2, 50, 99));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Project Due Date");
        jLabel13.setMaximumSize(new java.awt.Dimension(220, 21));
        jLabel13.setMinimumSize(new java.awt.Dimension(220, 21));
        jLabel13.setPreferredSize(new java.awt.Dimension(220, 21));

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(2, 50, 99));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Submission Status");
        jLabel14.setMaximumSize(new java.awt.Dimension(220, 21));
        jLabel14.setMinimumSize(new java.awt.Dimension(220, 21));
        jLabel14.setPreferredSize(new java.awt.Dimension(220, 21));

        dueDateLabel.setFont(new java.awt.Font("SansSerif", 2, 24)); // NOI18N
        dueDateLabel.setForeground(new java.awt.Color(2, 50, 99));
        dueDateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dueDateLabel.setText("Date");
        dueDateLabel.setMaximumSize(new java.awt.Dimension(180, 55));
        dueDateLabel.setMinimumSize(new java.awt.Dimension(180, 55));
        dueDateLabel.setPreferredSize(new java.awt.Dimension(180, 55));

        submissionStatus.setBackground(new java.awt.Color(255, 255, 255));
        submissionStatus.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        submissionStatus.setForeground(new java.awt.Color(2, 50, 99));
        submissionStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        submissionStatus.setText("Status");
        submissionStatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        submissionStatus.setOpaque(true);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(2, 50, 99));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Supervisor Status");
        jLabel16.setMaximumSize(new java.awt.Dimension(220, 21));
        jLabel16.setMinimumSize(new java.awt.Dimension(220, 21));
        jLabel16.setPreferredSize(new java.awt.Dimension(220, 21));

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(2, 50, 99));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Presentation Status");
        jLabel17.setMaximumSize(new java.awt.Dimension(220, 21));
        jLabel17.setMinimumSize(new java.awt.Dimension(220, 21));
        jLabel17.setPreferredSize(new java.awt.Dimension(220, 21));

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(2, 50, 99));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Second Marker Status");
        jLabel18.setMaximumSize(new java.awt.Dimension(220, 21));
        jLabel18.setMinimumSize(new java.awt.Dimension(220, 21));
        jLabel18.setPreferredSize(new java.awt.Dimension(220, 21));

        presentStatus.setBackground(new java.awt.Color(255, 255, 255));
        presentStatus.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        presentStatus.setForeground(new java.awt.Color(2, 50, 99));
        presentStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        presentStatus.setText("Status");
        presentStatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        presentStatus.setOpaque(true);

        spvPresentStatus.setBackground(new java.awt.Color(255, 255, 255));
        spvPresentStatus.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        spvPresentStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        spvPresentStatus.setText("Status");
        spvPresentStatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        spvPresentStatus.setOpaque(true);

        secMarkPresentStatus.setBackground(new java.awt.Color(255, 255, 255));
        secMarkPresentStatus.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        secMarkPresentStatus.setForeground(new java.awt.Color(2, 50, 99));
        secMarkPresentStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        secMarkPresentStatus.setText("Status");
        secMarkPresentStatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        secMarkPresentStatus.setOpaque(true);

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(2, 50, 99));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Feedback");
        jLabel20.setMaximumSize(new java.awt.Dimension(220, 21));
        jLabel20.setMinimumSize(new java.awt.Dimension(220, 21));
        jLabel20.setPreferredSize(new java.awt.Dimension(220, 21));

        jScrollPane1.setHorizontalScrollBar(null);

        presentFeedbackField.setColumns(20);
        presentFeedbackField.setRows(5);
        jScrollPane1.setViewportView(presentFeedbackField);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(secMarkPresentStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(presentStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spvPresentStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spvPresentStatus)
                            .addComponent(presentStatus)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(secMarkPresentStatus)
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(2, 50, 99));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Assessment Status");
        jLabel19.setMaximumSize(new java.awt.Dimension(220, 21));
        jLabel19.setMinimumSize(new java.awt.Dimension(220, 21));
        jLabel19.setPreferredSize(new java.awt.Dimension(220, 21));

        assmntStatus.setBackground(new java.awt.Color(255, 255, 255));
        assmntStatus.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        assmntStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        assmntStatus.setText("Status");
        assmntStatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        assmntStatus.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(dueDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(125, 125, 125)
                                .addComponent(submissionStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(assmntStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dueDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(submissionStatus))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(assmntStatus)
                        .addGap(0, 40, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 151, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 880, 420));

        backBtn.setBackground(new java.awt.Color(76, 127, 174));
        backBtn.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("Back");
        backBtn.setPreferredSize(new java.awt.Dimension(60, 25));
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        getContentPane().add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, 70, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(900, 500));
        jLabel1.setMinimumSize(new java.awt.Dimension(900, 500));
        jLabel1.setPreferredSize(new java.awt.Dimension(900, 500));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.dispose();
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
            java.util.logging.Logger.getLogger(LecturerPeopleProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LecturerPeopleProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LecturerPeopleProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LecturerPeopleProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LecturerPeopleProfile("id").setVisible(true);
            }
        });
    }
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon_with_background.png")));
    }
    
    private void showStdDetails(){
        List<String> data = FileHandler.readFile("user.txt");
        
        for (String line : data){
            String[] list = line.split(";");
            if (list[0].equals(stdID)){
                idLabel.setText(stdID);
                nameLabel.setText(list[1]);
                icpassLabel.setText(list[6]);
                genderLabel.setText(list[2]);
                nationLabel.setText(list[7]);
                emailLabel.setText(list[8]);
                hpLabel.setText(list[3]);
                dobLabel.setText(list[4]);
                addressLabel.setText(list[5]);
            }
        }
    }
    
    private void setStatusColor(Component component, String status) {
        switch (status) {
            case "pending" -> component.setBackground(new java.awt.Color(255, 255, 0));
            case "scheduled" -> component.setBackground(new java.awt.Color(255, 255, 0));
            case "rejected" -> component.setBackground(new java.awt.Color(255, 51, 51)); 
            case "completed" -> component.setBackground(new java.awt.Color(0, 204, 0));
            case "approved" -> component.setBackground(new java.awt.Color(0, 204, 0));
            case "submitted" -> component.setBackground(new java.awt.Color(51, 153, 255));
            default -> {
            }
        }
        // Handle other cases or provide a default color
            }

    private void showAssmntDetails() {
        List<String> assmntData = FileHandler.readFile("student_assessment.txt");
        List<String> presentData = FileHandler.readFile("presentation_request.txt");
        List<String> presentDoneData = FileHandler.readFile("presentation_confirmation.txt");

        for (String line : assmntData) {
            String[] list = line.split(";");
            if (list[1].equals(stdID)) {
                dueDateLabel.setText(list[3]);
                submissionStatus.setText(list[6]);

                boolean markedCompleted = false;
                for (String linea : presentDoneData) {
                    String[] lista = linea.split(";");
                    if ("marked".equals(list[6]) && "completed".equals(lista[5])) {
                        overallStatus.setText("completed");
                        assmntStatus.setText("completed");
                        setStatusColor(overallStatus, "completed");
                        setStatusColor(assmntStatus, "completed");
                        setStatusColor(submissionStatus, "completed");                      
                        markedCompleted = true;
                        break; // Exit loop early if condition is met
                    }
                }

                if (!markedCompleted) {
                    switch (list[6]) {
                        case "pending" -> {
                            assmntStatus.setText("pending");
                            overallStatus.setText("in progress");
                            setStatusColor(assmntStatus, "pending");
                            setStatusColor(overallStatus, "pending");
                            setStatusColor(submissionStatus, "pending");
                        }
                        case "submitted" -> {
                            assmntStatus.setText("pending");
                            overallStatus.setText("in progress");
                            setStatusColor(assmntStatus, "pending");
                            setStatusColor(overallStatus, "pending");
                            setStatusColor(submissionStatus, "submitted");
                        }
                        case "marked" -> {
                            assmntStatus.setText("pending");
                            overallStatus.setText("in progress");
                            setStatusColor(assmntStatus, "pending");
                            setStatusColor(overallStatus, "pending");
                            setStatusColor(submissionStatus, "completed");
                        }
                    }
                }
            }
        }

        for (String line : presentData) {
            String[] list = line.split(";");
            if (list[1].equals(stdID)) {
                spvPresentStatus.setText(list[4]);
                secMarkPresentStatus.setText(list[5]);
                presentStatus.setText(list[6]);

                boolean statusSet = false;
                for (String linea : presentDoneData) {
                    String[] lista = linea.split(";");
                    if ("approved".equals(list[6]) && "completed".equals(lista[5])) {
                        presentStatus.setText(lista[5]);
                        presentFeedbackField.setText(lista[4]);                          
                        setStatusColor(presentStatus, lista[5]);
                        statusSet = true;
                        break;
                    }
                }

                if (!statusSet) {
                    setStatusColor(presentStatus, list[6]);
                }
                setStatusColor(spvPresentStatus, list[4]);
                setStatusColor(secMarkPresentStatus, list[5]);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel assmntStatus;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel dobLabel;
    private javax.swing.JLabel dueDateLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel hpLabel;
    private javax.swing.JLabel icpassLabel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nationLabel;
    private javax.swing.JLabel overallStatus;
    private javax.swing.JTextArea presentFeedbackField;
    private javax.swing.JLabel presentStatus;
    private javax.swing.JLabel secMarkPresentStatus;
    private javax.swing.JLabel spvPresentStatus;
    private javax.swing.JLabel submissionStatus;
    // End of variables declaration//GEN-END:variables
}
