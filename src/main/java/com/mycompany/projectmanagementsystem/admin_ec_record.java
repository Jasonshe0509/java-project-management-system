package com.mycompany.projectmanagementsystem;

import com.mycompany.projectmanagementsystem.EC.AdminECTableActionEvent;
import com.mycompany.projectmanagementsystem.EC.ECController;
import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import com.mycompany.projectmanagementsystem.GeneralFunction.URLRenderer;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class admin_ec_record extends javax.swing.JFrame {

    static int numOfPendingEC;

    public admin_ec_record() {
        initComponents();
        setIconImage();
        printPendingECTable();
        printApprovedECTable();
        printRejectedECTable();
        readNumOfPendingEC();
        
        //header of the table
        ec_pending_list.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        ec_pending_list.getTableHeader().setOpaque(false);
        ec_pending_list.getTableHeader().setBackground(new Color(2, 50, 99));
        ec_pending_list.getTableHeader().setForeground(new Color(255, 255, 255));
        
        ec_approved_list.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        ec_approved_list.getTableHeader().setOpaque(false);
        ec_approved_list.getTableHeader().setBackground(new Color(2, 50, 99));
        ec_approved_list.getTableHeader().setForeground(new Color(255, 255, 255));
        
        ec_rejected_list.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        ec_rejected_list.getTableHeader().setOpaque(false);
        ec_rejected_list.getTableHeader().setBackground(new Color(2, 50, 99));
        ec_rejected_list.getTableHeader().setForeground(new Color(255, 255, 255));

        ec_pending_list.getColumnModel().getColumn(4).setCellRenderer(new URLRenderer());
        ec_approved_list.getColumnModel().getColumn(4).setCellRenderer(new URLRenderer());
        ec_rejected_list.getColumnModel().getColumn(4).setCellRenderer(new URLRenderer());

        // Add mouse listener to handle URL clicks
        ec_pending_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = ec_pending_list.rowAtPoint(e.getPoint());
                int col = ec_pending_list.columnAtPoint(e.getPoint());

                if (col == 4) { // Column index for URL
                    String url = (String) ec_pending_list.getValueAt(row, col);
                    if (Desktop.isDesktopSupported()) {
                        try {
                            Desktop.getDesktop().browse(new URI(url));
                        } catch (IOException | URISyntaxException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });
        ec_approved_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = ec_approved_list.rowAtPoint(e.getPoint());
                int col = ec_approved_list.columnAtPoint(e.getPoint());

                if (col == 4) { // Column index for URL
                    String url = (String) ec_approved_list.getValueAt(row, col);
                    if (Desktop.isDesktopSupported()) {
                        try {
                            Desktop.getDesktop().browse(new URI(url));
                        } catch (IOException | URISyntaxException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });

        ec_rejected_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = ec_rejected_list.rowAtPoint(e.getPoint());
                int col = ec_rejected_list.columnAtPoint(e.getPoint());

                if (col == 4) { // Column index for URL
                    String url = (String) ec_rejected_list.getValueAt(row, col);
                    if (Desktop.isDesktopSupported()) {
                        try {
                            Desktop.getDesktop().browse(new URI(url));
                        } catch (IOException | URISyntaxException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });

        AdminECTableActionPanel pendingECPanel = new AdminECTableActionPanel();
        AdminECTableActionEvent pendingECEvent;
        pendingECEvent = new AdminECTableActionEvent() {

            public void adminViewEC(int row, Object value) {
                DefaultTableModel model = (DefaultTableModel) ec_pending_list.getModel();
                int columnIndex = 0;
                String ECID = (String) model.getValueAt(row, columnIndex);
                ECController action = new ECController();
                action.adminViewPendingEC(ECID);

            }
        };

        ec_pending_list.getColumnModel().getColumn(5).setCellRenderer(pendingECPanel.new rPanelActionRenderer());
        ec_pending_list.getColumnModel().getColumn(5).setCellEditor(pendingECPanel.new AdminECTableActionCellEditor(pendingECEvent));

        AdminECTableActionPanel approvedECPanel = new AdminECTableActionPanel();
        AdminECTableActionEvent approvedECEvent;
        approvedECEvent = new AdminECTableActionEvent() {

            public void adminViewEC(int row, Object value) {
                DefaultTableModel model = (DefaultTableModel) ec_approved_list.getModel();
                int columnIndex = 0;
                String ECID = (String) model.getValueAt(row, columnIndex);
                ECController action = new ECController();
                action.adminViewEC(ECID);

            }
        };

        ec_approved_list.getColumnModel().getColumn(5).setCellRenderer(approvedECPanel.new rPanelActionRenderer());
        ec_approved_list.getColumnModel().getColumn(5).setCellEditor(approvedECPanel.new AdminECTableActionCellEditor(approvedECEvent));

        AdminECTableActionPanel rejectedECPanel = new AdminECTableActionPanel();
        AdminECTableActionEvent rejectedECEvent;
        rejectedECEvent = new AdminECTableActionEvent() {

            public void adminViewEC(int row, Object value) {
                DefaultTableModel model = (DefaultTableModel) ec_rejected_list.getModel();
                int columnIndex = 0;
                String ECID = (String) model.getValueAt(row, columnIndex);
                ECController action = new ECController();
                action.adminViewEC(ECID);

            }
        };

        ec_rejected_list.getColumnModel().getColumn(5).setCellRenderer(rejectedECPanel.new rPanelActionRenderer());
        ec_rejected_list.getColumnModel().getColumn(5).setCellEditor(rejectedECPanel.new AdminECTableActionCellEditor(rejectedECEvent));
    }

    public static void readNumOfPendingEC() {
        List<String> data = FileHandler.readFile("ec.txt");
        int countEC = 0;
        for (String line : data) {
            String[] ecLine = line.split(";");
            if (ecLine[5].equals("pending")) {
                countEC++;
            }
        }
        numOfPendingEC = countEC;
        label_num_pending_ec.setText(String.valueOf(numOfPendingEC));

    }

    public static void printPendingECTable() {
        DefaultTableModel model = (DefaultTableModel) ec_pending_list.getModel();
        model.setRowCount(0);
        List<String> data = FileHandler.readFile("ec.txt");
        for (String line : data) {
            String[] ecLine = line.split(";");

            if (ecLine[5].equals("pending")) {
                String[] pendingEC = {ecLine[0], ecLine[1], ecLine[2], ecLine[3], ecLine[4]};
                model.addRow(pendingEC);
            }
        }

    }

    public static void printApprovedECTable() {
        DefaultTableModel model = (DefaultTableModel) ec_approved_list.getModel();
        model.setRowCount(0);
        List<String> data = FileHandler.readFile("ec.txt");
        for (String line : data) {
            String[] ecLine = line.split(";");

            if (ecLine[5].equals("approved")) {
                String[] approvedEC = {ecLine[0], ecLine[1], ecLine[2], ecLine[3], ecLine[4]};
                model.addRow(approvedEC);
            }
        }

    }

    public static void printRejectedECTable() {
        DefaultTableModel model = (DefaultTableModel) ec_rejected_list.getModel();
        model.setRowCount(0);
        List<String> data = FileHandler.readFile("ec.txt");
        for (String line : data) {
            String[] ecLine = line.split(";");

            if (ecLine[5].equals("rejected")) {
                String[] rejectedEC = {ecLine[0], ecLine[1], ecLine[2], ecLine[3], ecLine[4]};
                model.addRow(rejectedEC);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ec_record_title = new javax.swing.JLabel();
        admin_header = new javax.swing.JPanel();
        admin_lecturer = new javax.swing.JLabel();
        admin_student = new javax.swing.JLabel();
        admin_report = new javax.swing.JLabel();
        admin_profile = new javax.swing.JLabel();
        admin_logout = new javax.swing.JLabel();
        admin_logo = new javax.swing.JLabel();
        label_num_pending_ec = new javax.swing.JLabel();
        ecnum_border = new javax.swing.JLabel();
        ecnum_background = new javax.swing.JLabel();
        ec_record = new javax.swing.JTabbedPane();
        javax.swing.JScrollPane ec_approved_record = new javax.swing.JScrollPane();
        ec_pending_list = new javax.swing.JTable();
        ec_rejeceted_record = new javax.swing.JScrollPane();
        ec_approved_list = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        ec_rejected_list = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EC Record");
        setMaximumSize(new java.awt.Dimension(1000, 700));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ec_record_title.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        ec_record_title.setForeground(new java.awt.Color(2, 50, 99));
        ec_record_title.setText("EC Record");
        getContentPane().add(ec_record_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 180, 30));

        admin_header.setBackground(new Color(255, 255, 255, 90));
        admin_header.setToolTipText("");
        admin_header.setMaximumSize(new java.awt.Dimension(1000, 73));
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
        admin_report.setText("Assessment");
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
        admin_profile.setText("EC Management");
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
                .addComponent(admin_logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
                .addComponent(admin_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(admin_report, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(admin_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(admin_logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(admin_student, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(admin_lecturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(admin_report, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(admin_profile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(admin_headerLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(admin_logo))
        );

        getContentPane().add(admin_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        label_num_pending_ec.setFont(new java.awt.Font("Bell MT", 1, 100)); // NOI18N
        label_num_pending_ec.setForeground(new java.awt.Color(2, 50, 99));
        label_num_pending_ec.setText("jLabel1");
        getContentPane().add(label_num_pending_ec, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 120, 120));

        ecnum_border.setBackground(new Color(2, 50, 99, 0));
        ecnum_border.setBorder(new LineBorder(new Color(192, 192, 192, 90), 15, true));
        ecnum_border.setMaximumSize(new java.awt.Dimension(440, 125));
        ecnum_border.setMinimumSize(new java.awt.Dimension(440, 125));
        ecnum_border.setPreferredSize(new java.awt.Dimension(440, 125));
        getContentPane().add(ecnum_border, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 400, 160));

        ecnum_background.setBackground(new Color(192, 192, 192, 90));
        ecnum_background.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        ecnum_background.setForeground(new java.awt.Color(2, 50, 99));
        ecnum_background.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ecnum_background.setText("Total Pending EC");
        ecnum_background.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ecnum_background.setMaximumSize(new java.awt.Dimension(418, 123));
        ecnum_background.setMinimumSize(new java.awt.Dimension(418, 123));
        ecnum_background.setOpaque(true);
        ecnum_background.setPreferredSize(new java.awt.Dimension(418, 123));
        getContentPane().add(ecnum_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 380, 140));

        ec_record.setOpaque(true);

        ec_pending_list.setAutoCreateRowSorter(true);
        ec_pending_list.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ec_pending_list.setForeground(new java.awt.Color(2, 50, 99));
        ec_pending_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "EC ID", "Student ID", "Assessment ID", "Applied Reason", "EC Document Link", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ec_pending_list.setRowHeight(30);
        ec_pending_list.setSelectionBackground(new Color(2, 50, 99, 90));
        ec_approved_record.setViewportView(ec_pending_list);

        ec_record.addTab("Pending", ec_approved_record);

        ec_approved_list.setForeground(new java.awt.Color(2, 50, 99));
        ec_approved_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "EC ID", "Student ID", "Assessment ID", "Applied Reason", "EC Document Link", "Action"
            }
        ));
        ec_approved_list.setRowHeight(30);
        ec_rejeceted_record.setViewportView(ec_approved_list);

        ec_record.addTab("Approved", ec_rejeceted_record);

        ec_rejected_list.setForeground(new java.awt.Color(2, 50, 99));
        ec_rejected_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "EC ID", "Student ID", "Assessment ID", "Applied Reason", "EC Document Link", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ec_rejected_list.setRowHeight(30);
        jScrollPane1.setViewportView(ec_rejected_list);

        ec_record.addTab("Rejected", jScrollPane1);

        getContentPane().add(ec_record, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 920, 300));
        ec_record.getAccessibleContext().setAccessibleName("");
        ec_record.getAccessibleContext().setAccessibleDescription("");

        jLabel1.setFont(new java.awt.Font("Bell MT", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        jLabel1.setText("Type To Search");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 210, 130, -1));

        search.setForeground(new java.awt.Color(2, 50, 99));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        getContentPane().add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 240, 180, 50));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void admin_studentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_studentMouseClicked
        dispose();
        admin_student admin_stu = new admin_student();
        admin_stu.show();
    }//GEN-LAST:event_admin_studentMouseClicked

    private void admin_profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_profileMouseClicked
        dispose();
        admin_ec_record ecRecord = new admin_ec_record();
        ecRecord.show();
    }//GEN-LAST:event_admin_profileMouseClicked

    private void admin_reportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_reportMouseClicked
        dispose();
        admin_assessment_management assessmentManagement = new admin_assessment_management();
        assessmentManagement.show();
    }//GEN-LAST:event_admin_reportMouseClicked

    private void admin_lecturerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_lecturerMouseClicked
        dispose();
        admin_lecturer_record lecturerRecord = new admin_lecturer_record();
        lecturerRecord.show();
    }//GEN-LAST:event_admin_lecturerMouseClicked

    private void admin_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_logoutMouseClicked
        dispose();
        GeneralPage generalPage = new GeneralPage();
        generalPage.show();
    }//GEN-LAST:event_admin_logoutMouseClicked

    private void admin_logoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_logoMouseClicked
        dispose();
        admin_mainpage adminMainpage = new admin_mainpage();
        adminMainpage.show();
    }//GEN-LAST:event_admin_logoMouseClicked

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
       String searchText = search.getText();
        
        DefaultTableModel ecPending = (DefaultTableModel) ec_pending_list.getModel();
       TableRowSorter<DefaultTableModel> searchECPending = new TableRowSorter<>(ecPending);
       ec_pending_list.setRowSorter(searchECPending);
       searchECPending.setRowFilter(RowFilter.regexFilter(searchText));
       
       DefaultTableModel ecApproved = (DefaultTableModel) ec_approved_list.getModel();
       TableRowSorter<DefaultTableModel> searchECApproved = new TableRowSorter<>(ecApproved);
       ec_approved_list.setRowSorter(searchECApproved);
       searchECApproved.setRowFilter(RowFilter.regexFilter(searchText));
       
       DefaultTableModel ecRejected = (DefaultTableModel) ec_rejected_list.getModel();
       TableRowSorter<DefaultTableModel> searchECRejected = new TableRowSorter<>(ecRejected);
       ec_rejected_list.setRowSorter(searchECRejected);
       searchECRejected.setRowFilter(RowFilter.regexFilter(searchText));
    }//GEN-LAST:event_searchKeyReleased

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_ec_record().setVisible(true);
            }
        });
    }

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon_with_background.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel admin_header;
    private javax.swing.JLabel admin_lecturer;
    private javax.swing.JLabel admin_logo;
    private javax.swing.JLabel admin_logout;
    private javax.swing.JLabel admin_profile;
    private javax.swing.JLabel admin_report;
    private javax.swing.JLabel admin_student;
    private javax.swing.JLabel background;
    private static javax.swing.JTable ec_approved_list;
    private static javax.swing.JTable ec_pending_list;
    private static javax.swing.JTabbedPane ec_record;
    private javax.swing.JLabel ec_record_title;
    private javax.swing.JScrollPane ec_rejeceted_record;
    private static javax.swing.JTable ec_rejected_list;
    private javax.swing.JLabel ecnum_background;
    private javax.swing.JLabel ecnum_border;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JLabel label_num_pending_ec;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
