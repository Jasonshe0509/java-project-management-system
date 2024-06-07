package com.mycompany.projectmanagementsystem;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;

public class admin_student extends javax.swing.JFrame {

    public admin_student() {
        initComponents();
        setIconImage();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        admin_header = new javax.swing.JPanel();
        admin_lecturer = new javax.swing.JLabel();
        admin_student = new javax.swing.JLabel();
        admin_report = new javax.swing.JLabel();
        admin_profile = new javax.swing.JLabel();
        admin_logout = new javax.swing.JLabel();
        admin_logo = new javax.swing.JLabel();
        admin_intakei = new javax.swing.JLabel();
        admin_reg_intake = new javax.swing.JLabel();
        intake_background = new javax.swing.JLabel();
        admin_studenti = new javax.swing.JLabel();
        admin_reg_student = new javax.swing.JLabel();
        regstu_background = new javax.swing.JLabel();
        admin_eci = new javax.swing.JLabel();
        admin_ec_management = new javax.swing.JLabel();
        ecmanage_background = new javax.swing.JLabel();
        admin_stu_managementi = new javax.swing.JLabel();
        admin_stu_management = new javax.swing.JLabel();
        stumanage_background = new javax.swing.JLabel();
        admin_studenti1 = new javax.swing.JLabel();
        admin_reg_student1 = new javax.swing.JLabel();
        regstu_background1 = new javax.swing.JLabel();
        admin_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin: Student Management");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admin_header.setBackground(new Color(255, 255, 255, 90));
        admin_header.setToolTipText("");
        admin_header.setMaximumSize(new java.awt.Dimension(1000, 700));
        admin_header.setMinimumSize(new java.awt.Dimension(1000, 73));
        admin_header.setPreferredSize(new java.awt.Dimension(1000, 73));

        admin_lecturer.setBackground(new Color(255, 255, 255, 0));
        admin_lecturer.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        admin_lecturer.setForeground(new java.awt.Color(2, 50, 99));
        admin_lecturer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_lecturer.setText("Lecturer");
        admin_lecturer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admin_lecturer.setMaximumSize(new java.awt.Dimension(96, 73));
        admin_lecturer.setMinimumSize(new java.awt.Dimension(96, 73));
        admin_lecturer.setPreferredSize(new java.awt.Dimension(96, 73));
        admin_lecturer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_lecturerMouseClicked(evt);
            }
        });

        admin_student.setBackground(new Color(255, 255, 255, 0));
        admin_student.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        admin_student.setForeground(new java.awt.Color(2, 50, 99));
        admin_student.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_student.setText("Student");
        admin_student.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admin_student.setMaximumSize(new java.awt.Dimension(96, 73));
        admin_student.setMinimumSize(new java.awt.Dimension(96, 73));
        admin_student.setPreferredSize(new java.awt.Dimension(96, 73));
        admin_student.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_studentMouseClicked(evt);
            }
        });

        admin_report.setBackground(new Color(255, 255, 255, 0));
        admin_report.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        admin_report.setForeground(new java.awt.Color(2, 50, 99));
        admin_report.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_report.setText("EC Management");
        admin_report.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admin_report.setMaximumSize(new java.awt.Dimension(96, 73));
        admin_report.setMinimumSize(new java.awt.Dimension(96, 73));
        admin_report.setPreferredSize(new java.awt.Dimension(96, 73));
        admin_report.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_reportMouseClicked(evt);
            }
        });

        admin_profile.setBackground(new Color(255, 255, 255, 0));
        admin_profile.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        admin_profile.setForeground(new java.awt.Color(2, 50, 99));
        admin_profile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_profile.setText("Assessment");
        admin_profile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admin_profile.setMaximumSize(new java.awt.Dimension(96, 73));
        admin_profile.setMinimumSize(new java.awt.Dimension(96, 73));
        admin_profile.setPreferredSize(new java.awt.Dimension(96, 73));
        admin_profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_profileMouseClicked(evt);
            }
        });

        admin_logout.setBackground(new Color(255, 255, 255, 0));
        admin_logout.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        admin_logout.setForeground(new java.awt.Color(2, 50, 99));
        admin_logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_logout.setText("Log Out");
        admin_logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admin_logout.setMaximumSize(new java.awt.Dimension(96, 73));
        admin_logout.setMinimumSize(new java.awt.Dimension(96, 73));
        admin_logout.setPreferredSize(new java.awt.Dimension(96, 73));
        admin_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_logoutMouseClicked(evt);
            }
        });

        admin_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sysco_logo.png"))); // NOI18N
        admin_logo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admin_logo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_logoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout admin_headerLayout = new javax.swing.GroupLayout(admin_header);
        admin_header.setLayout(admin_headerLayout);
        admin_headerLayout.setHorizontalGroup(
            admin_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(admin_headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(admin_logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
                .addComponent(admin_report, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(admin_profile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(admin_lecturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(admin_student, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(admin_logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        admin_headerLayout.setVerticalGroup(
            admin_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(admin_headerLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(admin_logo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(admin_headerLayout.createSequentialGroup()
                .addGroup(admin_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(admin_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(admin_profile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(admin_report, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(admin_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(admin_logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(admin_student, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(admin_lecturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        getContentPane().add(admin_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        admin_intakei.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intake_icon.png"))); // NOI18N
        admin_intakei.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_intakeiMouseClicked(evt);
            }
        });
        getContentPane().add(admin_intakei, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 80, 70));

        admin_reg_intake.setBackground(new Color(76, 127, 174, 0));
        admin_reg_intake.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        admin_reg_intake.setForeground(new java.awt.Color(2, 50, 99));
        admin_reg_intake.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_reg_intake.setText("<html><div style = \"text-align: center; width: 70px;\">Register New Intake</div></html>");
        admin_reg_intake.setBorder(new LineBorder(new Color(192, 192, 192, 90), 15, true));
        admin_reg_intake.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admin_reg_intake.setMaximumSize(new java.awt.Dimension(380, 240));
        admin_reg_intake.setMinimumSize(new java.awt.Dimension(380, 240));
        admin_reg_intake.setOpaque(true);
        admin_reg_intake.setPreferredSize(new java.awt.Dimension(380, 240));
        admin_reg_intake.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_reg_intakeMouseClicked(evt);
            }
        });
        getContentPane().add(admin_reg_intake, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 260, 260));

        intake_background.setBackground(new Color(192, 192, 192, 90));
        intake_background.setOpaque(true);
        intake_background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                intake_backgroundMouseClicked(evt);
            }
        });
        getContentPane().add(intake_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 240, 240));
        intake_background.getAccessibleContext().setAccessibleName("intake_background");

        admin_studenti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_icon.png"))); // NOI18N
        admin_studenti.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_studentiMouseClicked(evt);
            }
        });
        getContentPane().add(admin_studenti, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 70, 80));

        admin_reg_student.setBackground(new Color(192, 192, 192, 90));
        admin_reg_student.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        admin_reg_student.setForeground(new java.awt.Color(2, 50, 99));
        admin_reg_student.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_reg_student.setText("<html><div style = \"text-align: center; width: 70px;\">Register New Student</div></html>");
        admin_reg_student.setBorder(new LineBorder(new Color(192, 192, 192, 90), 15, true));
        admin_reg_student.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admin_reg_student.setMaximumSize(new java.awt.Dimension(380, 240));
        admin_reg_student.setMinimumSize(new java.awt.Dimension(380, 240));
        admin_reg_student.setOpaque(true);
        admin_reg_student.setPreferredSize(new java.awt.Dimension(380, 240));
        admin_reg_student.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_reg_studentMouseClicked(evt);
            }
        });
        getContentPane().add(admin_reg_student, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 260, 260));

        regstu_background.setBackground(new Color(192, 192, 192, 90));
        regstu_background.setOpaque(true);
        regstu_background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regstu_backgroundMouseClicked(evt);
            }
        });
        getContentPane().add(regstu_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 240, 240));

        admin_eci.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EC_icon.png"))); // NOI18N
        admin_eci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_eciMouseClicked(evt);
            }
        });
        getContentPane().add(admin_eci, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, -1, -1));

        admin_ec_management.setBackground(new Color(192, 192, 192, 90));
        admin_ec_management.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        admin_ec_management.setForeground(new java.awt.Color(2, 50, 99));
        admin_ec_management.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_ec_management.setText("EC Management");
        admin_ec_management.setBorder(new LineBorder(new Color(192, 192, 192, 90), 15, true));
        admin_ec_management.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admin_ec_management.setMaximumSize(new java.awt.Dimension(380, 240));
        admin_ec_management.setMinimumSize(new java.awt.Dimension(380, 240));
        admin_ec_management.setOpaque(true);
        admin_ec_management.setPreferredSize(new java.awt.Dimension(380, 240));
        admin_ec_management.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_ec_managementMouseClicked(evt);
            }
        });
        getContentPane().add(admin_ec_management, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, -1, -1));

        ecmanage_background.setBackground(new Color(192, 192, 192, 90));
        ecmanage_background.setOpaque(true);
        ecmanage_background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ecmanage_backgroundMouseClicked(evt);
            }
        });
        getContentPane().add(ecmanage_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 360, 220));
        ecmanage_background.getAccessibleContext().setAccessibleName("ecmanage_background");

        admin_stu_managementi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Setting_icon.png"))); // NOI18N
        admin_stu_managementi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_stu_managementiMouseClicked(evt);
            }
        });
        getContentPane().add(admin_stu_managementi, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 420, -1, -1));
        admin_stu_managementi.getAccessibleContext().setAccessibleDescription("");

        admin_stu_management.setBackground(new Color(192, 192, 192, 90));
        admin_stu_management.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        admin_stu_management.setForeground(new java.awt.Color(2, 50, 99));
        admin_stu_management.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_stu_management.setText("View Intake/ Student");
        admin_stu_management.setBorder(new LineBorder(new Color(192, 192, 192, 90), 15, true));
        admin_stu_management.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admin_stu_management.setMaximumSize(new java.awt.Dimension(380, 240));
        admin_stu_management.setMinimumSize(new java.awt.Dimension(380, 240));
        admin_stu_management.setOpaque(true);
        admin_stu_management.setPreferredSize(new java.awt.Dimension(380, 240));
        admin_stu_management.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_stu_managementMouseClicked(evt);
            }
        });
        getContentPane().add(admin_stu_management, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 410, -1, -1));

        stumanage_background.setBackground(new Color(192, 192, 192, 90));
        stumanage_background.setOpaque(true);
        stumanage_background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stumanage_backgroundMouseClicked(evt);
            }
        });
        getContentPane().add(stumanage_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 420, 360, 220));

        admin_studenti1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_course_icon.png"))); // NOI18N
        admin_studenti1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_studenti1MouseClicked(evt);
            }
        });
        getContentPane().add(admin_studenti1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, 70, 70));

        admin_reg_student1.setBackground(new Color(192, 192, 192, 90));
        admin_reg_student1.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        admin_reg_student1.setForeground(new java.awt.Color(2, 50, 99));
        admin_reg_student1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_reg_student1.setText("<html><div style = \"text-align: center; width: 70px;\">Register New Course</div></html>");
        admin_reg_student1.setBorder(new LineBorder(new Color(192, 192, 192, 90), 15, true));
        admin_reg_student1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admin_reg_student1.setMaximumSize(new java.awt.Dimension(380, 240));
        admin_reg_student1.setMinimumSize(new java.awt.Dimension(380, 240));
        admin_reg_student1.setOpaque(true);
        admin_reg_student1.setPreferredSize(new java.awt.Dimension(380, 240));
        admin_reg_student1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_reg_student1MouseClicked(evt);
            }
        });
        getContentPane().add(admin_reg_student1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, 260, 260));

        regstu_background1.setBackground(new Color(192, 192, 192, 90));
        regstu_background1.setOpaque(true);
        regstu_background1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regstu_background1MouseClicked(evt);
            }
        });
        getContentPane().add(regstu_background1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 120, 240, 240));

        admin_background.setBackground(new java.awt.Color(76, 127, 174));
        admin_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        admin_background.setText("Good Day Admin!");
        admin_background.setMaximumSize(new java.awt.Dimension(1000, 700));
        admin_background.setMinimumSize(new java.awt.Dimension(1000, 700));
        admin_background.setOpaque(true);
        admin_background.setPreferredSize(new java.awt.Dimension(1000, 700));
        getContentPane().add(admin_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void admin_reg_intakeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_reg_intakeMouseClicked
        admin_register_intake adminIntake = new admin_register_intake();
        adminIntake.show();

    }//GEN-LAST:event_admin_reg_intakeMouseClicked

    private void admin_reg_studentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_reg_studentMouseClicked
        admin_register_student adminRegisterStudent = new admin_register_student();
        adminRegisterStudent.show();

    }//GEN-LAST:event_admin_reg_studentMouseClicked

    private void admin_ec_managementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_ec_managementMouseClicked
        dispose();
        admin_ec_record adminEC = new admin_ec_record();
        adminEC.show();
    }//GEN-LAST:event_admin_ec_managementMouseClicked

    private void admin_stu_managementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_stu_managementMouseClicked
        dispose();
        admin_student_management adminStudentManagement = new admin_student_management();
        adminStudentManagement.show();
    }//GEN-LAST:event_admin_stu_managementMouseClicked

    private void admin_logoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_logoMouseClicked
        dispose();
        admin_mainpage adminMainpage = new admin_mainpage();
        adminMainpage.show();
    }//GEN-LAST:event_admin_logoMouseClicked

    private void admin_reg_student1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_reg_student1MouseClicked
        admin_register_course adminRegisterCourse = new admin_register_course();
        adminRegisterCourse.show();
    }//GEN-LAST:event_admin_reg_student1MouseClicked

    private void intake_backgroundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_intake_backgroundMouseClicked
        admin_register_intake adminIntake = new admin_register_intake();
        adminIntake.show();
    }//GEN-LAST:event_intake_backgroundMouseClicked

    private void admin_intakeiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_intakeiMouseClicked
        admin_register_intake adminIntake = new admin_register_intake();
        adminIntake.show();
    }//GEN-LAST:event_admin_intakeiMouseClicked

    private void admin_studentiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_studentiMouseClicked
        admin_register_student adminRegisterStudent = new admin_register_student();
        adminRegisterStudent.show();
    }//GEN-LAST:event_admin_studentiMouseClicked

    private void regstu_backgroundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regstu_backgroundMouseClicked
        admin_register_student adminRegisterStudent = new admin_register_student();
        adminRegisterStudent.show();
    }//GEN-LAST:event_regstu_backgroundMouseClicked

    private void admin_studenti1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_studenti1MouseClicked
        admin_register_course adminRegisterCourse = new admin_register_course();
        adminRegisterCourse.show();
    }//GEN-LAST:event_admin_studenti1MouseClicked

    private void regstu_background1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regstu_background1MouseClicked
        admin_register_course adminRegisterCourse = new admin_register_course();
        adminRegisterCourse.show();
    }//GEN-LAST:event_regstu_background1MouseClicked

    private void admin_eciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_eciMouseClicked
        dispose();
        admin_ec_record adminEC = new admin_ec_record();
        adminEC.show();
    }//GEN-LAST:event_admin_eciMouseClicked

    private void ecmanage_backgroundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ecmanage_backgroundMouseClicked
        dispose();
        admin_ec_record adminEC = new admin_ec_record();
        adminEC.show();
    }//GEN-LAST:event_ecmanage_backgroundMouseClicked

    private void admin_stu_managementiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_stu_managementiMouseClicked
        dispose();
        admin_student_management adminStudentManagement = new admin_student_management();
        adminStudentManagement.show();
    }//GEN-LAST:event_admin_stu_managementiMouseClicked

    private void stumanage_backgroundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stumanage_backgroundMouseClicked
        dispose();
        admin_student_management adminStudentManagement = new admin_student_management();
        adminStudentManagement.show();
    }//GEN-LAST:event_stumanage_backgroundMouseClicked

    private void admin_lecturerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_lecturerMouseClicked
        dispose();
        admin_lecturer adminLecturer = new admin_lecturer();
        adminLecturer.show();
    }//GEN-LAST:event_admin_lecturerMouseClicked

    private void admin_studentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_studentMouseClicked
        dispose();
        admin_student adminStudent = new admin_student();
        adminStudent.show();
    }//GEN-LAST:event_admin_studentMouseClicked

    private void admin_profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_profileMouseClicked
        dispose();
        admin_assessment_management assessmentManagement = new admin_assessment_management();
        assessmentManagement.show();
    }//GEN-LAST:event_admin_profileMouseClicked

    private void admin_reportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_reportMouseClicked
        dispose();
        admin_ec_record adminEC = new admin_ec_record();
        adminEC.show();
    }//GEN-LAST:event_admin_reportMouseClicked

    private void admin_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_logoutMouseClicked
        dispose();
        GeneralPage generalPage = new GeneralPage();
        generalPage.show();
    }//GEN-LAST:event_admin_logoutMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new admin_student().setVisible(true);
        });
    }

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon_with_background.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel admin_background;
    private javax.swing.JLabel admin_ec_management;
    private javax.swing.JLabel admin_eci;
    private javax.swing.JPanel admin_header;
    private javax.swing.JLabel admin_intakei;
    private javax.swing.JLabel admin_lecturer;
    private javax.swing.JLabel admin_logo;
    private javax.swing.JLabel admin_logout;
    private javax.swing.JLabel admin_profile;
    private javax.swing.JLabel admin_reg_intake;
    private javax.swing.JLabel admin_reg_student;
    private javax.swing.JLabel admin_reg_student1;
    private javax.swing.JLabel admin_report;
    private javax.swing.JLabel admin_stu_management;
    private javax.swing.JLabel admin_stu_managementi;
    private javax.swing.JLabel admin_student;
    private javax.swing.JLabel admin_studenti;
    private javax.swing.JLabel admin_studenti1;
    private javax.swing.JLabel ecmanage_background;
    private javax.swing.JLabel intake_background;
    private javax.swing.JLabel regstu_background;
    private javax.swing.JLabel regstu_background1;
    private javax.swing.JLabel stumanage_background;
    // End of variables declaration//GEN-END:variables
}
