package com.mycompany.projectmanagementsystem;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import com.mycompany.projectmanagementsystem.SchoolWiseList.SchoolWiseController;
import com.mycompany.projectmanagementsystem.User.AdminDeleteActionEvent;
import com.mycompany.projectmanagementsystem.User.UserController;
import com.mycompany.projectmanagementsystem.User.UserTableActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class admin_lecturer_record extends javax.swing.JFrame {

    static int numOfSchoolWise, numOfLecturer, numOfProjectManager;

    public admin_lecturer_record() {
        initComponents();
        setIconImage();
        readNumOfSchoolWise();
        readNumOfLecturer();
        printSchoolWiseTable();
        printLecturerTable();

        school_wise_table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 18));
        school_wise_table.getTableHeader().setOpaque(false);
        school_wise_table.getTableHeader().setBackground(new Color(2, 50, 99));
        school_wise_table.getTableHeader().setForeground(new Color(255, 255, 255));

        projectmanager_table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 18));
        projectmanager_table.getTableHeader().setOpaque(false);
        projectmanager_table.getTableHeader().setBackground(new Color(2, 50, 99));
        projectmanager_table.getTableHeader().setForeground(new Color(255, 255, 255));

        lecturer_table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 18));
        lecturer_table.getTableHeader().setOpaque(false);
        lecturer_table.getTableHeader().setBackground(new Color(2, 50, 99));
        lecturer_table.getTableHeader().setForeground(new Color(255, 255, 255));

        UserTableActionPanel actionPanel = new UserTableActionPanel();
        UserTableActionEvent event;
        event = new UserTableActionEvent() {
            @Override
            public void userView(int row, Object value) {

                DefaultTableModel model = (DefaultTableModel) lecturer_table.getModel();
                int columnIndex = 0;
                String userID = (String) model.getValueAt(row, columnIndex);
                UserController action = new UserController();
                action.viewUser(userID);

            }

            @Override
            public void userDelete(int row, Object value) {
                DefaultTableModel model = (DefaultTableModel) lecturer_table.getModel();
                int columnIndex = 0;
                String userID = (String) model.getValueAt(row, columnIndex);
                UserController action = new UserController();
                boolean result = action.userDelete(userID);
                if(result){
                    redirectBack(0);
                }
            }
        };

        UserTableActionPanel removePMPanel = new UserTableActionPanel();
        UserTableActionEvent deletePMEvent;
        deletePMEvent = new UserTableActionEvent() {

            @Override
            public void userView(int row, Object value) {

                DefaultTableModel model = (DefaultTableModel) projectmanager_table.getModel();
                int columnIndex = 0;
                String userID = (String) model.getValueAt(row, columnIndex);
                UserController action = new UserController();
                action.viewUser(userID);

            }

            @Override
            public void userDelete(int row, Object value) {
                DefaultTableModel model = (DefaultTableModel) projectmanager_table.getModel();
                int columnIndex = 0;
                String userID = (String) model.getValueAt(row, columnIndex);
                UserController action = new UserController();
                action.projectmanagerDelete(userID);
                redirectBack(1);
            }

        };

        AdminDeleteActionPanel removeSWPanel = new AdminDeleteActionPanel();
        AdminDeleteActionEvent deleteSWEvent;
        deleteSWEvent = new AdminDeleteActionEvent() {

            @Override
            public void adminDelete(int row, Object value) {
                DefaultTableModel model = (DefaultTableModel) school_wise_table.getModel();
                int columnIndex = 0;
                String schoolWise = (String) model.getValueAt(row, columnIndex);
                SchoolWiseController action = new SchoolWiseController();
                boolean result = action.deleteSchoolWise(schoolWise);
                if (result) {
                    redirectBack(2);
                }
            }

        };

        lecturer_table.getColumnModel().getColumn(5).setCellRenderer(actionPanel.new rPanelActionRenderer());
        lecturer_table.getColumnModel().getColumn(5).setCellEditor(actionPanel.new UserTableActionCellEditor(event));

        projectmanager_table.getColumnModel().getColumn(5).setCellRenderer(removePMPanel.new rPanelActionRenderer());
        projectmanager_table.getColumnModel().getColumn(5).setCellEditor(removePMPanel.new UserTableActionCellEditor(deletePMEvent));

        school_wise_table.getColumnModel().getColumn(2).setCellRenderer(removeSWPanel.new rPanelActionRenderer());
        school_wise_table.getColumnModel().getColumn(2).setCellEditor(removeSWPanel.new AdminDeleteActionCellEditor(deleteSWEvent));
    }

    public static void readNumOfSchoolWise() {
        List<String> data = FileHandler.readFile("school_wise.txt");
        int i = 0;
        for (String lines : data) {
            i++;
        }
        numOfSchoolWise = i;
        numSchoolWise.setText(String.valueOf(numOfSchoolWise));

    }

    public static void readNumOfLecturer() {
        List<String> data = FileHandler.readFile("user.txt");
        int countLecturer = 0;
        int countProjectManager = 0;
        for (String lines : data) {

            String[] userData = lines.split(";");

            String user = userData[10];
            if (user.equals("lecturer")) {
                countLecturer++;

            }
            if (user.equals("project manager")) {
                countProjectManager++;
            }
        }
        numOfLecturer = countLecturer;
        numOfProjectManager = countProjectManager;
        numlecturer.setText(String.valueOf(numOfLecturer));
        numprojectmanager.setText(String.valueOf(numOfProjectManager));
    }

    public static void printSchoolWiseTable() {
        DefaultTableModel model = (DefaultTableModel) school_wise_table.getModel();
        model.setNumRows(0);
        List<String> data = FileHandler.readFile("school_wise.txt");

        for (String line : data) {

            int numOfLecturer = 0;
            List<String> lecturerList = FileHandler.readFile("user.txt");

            for (String line2 : lecturerList) {
                String[] lecturerRecord = line2.split(";");
                if (lecturerRecord.length > 11 && lecturerRecord[11].equals(line)) {
                    numOfLecturer++;
                }
            }

            String[] schoolWiseRow = {line, String.valueOf(numOfLecturer)};
            model.addRow(schoolWiseRow);
        }

    }

    public static void printLecturerTable() {
        DefaultTableModel model = (DefaultTableModel) lecturer_table.getModel();
        model.setNumRows(0);
        DefaultTableModel model1 = (DefaultTableModel) projectmanager_table.getModel();
        model1.setNumRows(0);
        List<String> data = FileHandler.readFile("user.txt");

        for (String line : data) {

            String[] userData = line.split(";");
            String user = userData[10];
            if (user.equals("lecturer")) {
                String[] lecturerRow = {userData[0], userData[1], userData[11], userData[8], userData[3]};
                model.addRow(lecturerRow);

            }
            if (user.equals("project manager")) {
                String[] projectManagerRow = {userData[0], userData[1], userData[11], userData[8], userData[3]};
                model1.addRow(projectManagerRow);

            }
        }
    }
    
    public void redirectBack(int index) {
        this.setVisible(false);
        admin_lecturer_record page = new admin_lecturer_record();
        page.setVisible(true);
        lecturer_record.setSelectedIndex(index);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        admin_header = new javax.swing.JPanel();
        admin_lecturer = new javax.swing.JLabel();
        admin_student = new javax.swing.JLabel();
        admin_report = new javax.swing.JLabel();
        admin_profile = new javax.swing.JLabel();
        admin_logout = new javax.swing.JLabel();
        admin_logo = new javax.swing.JLabel();
        numprojectmanager = new javax.swing.JLabel();
        numlecturer = new javax.swing.JLabel();
        numSchoolWise = new javax.swing.JLabel();
        totallec_border = new javax.swing.JLabel();
        totallec_background = new javax.swing.JLabel();
        totalschool_background = new javax.swing.JLabel();
        totalschool_border = new javax.swing.JLabel();
        lecturer_record = new javax.swing.JTabbedPane();
        javax.swing.JScrollPane lectuter_record = new javax.swing.JScrollPane();
        lecturer_table = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        projectmanager_table = new javax.swing.JTable();
        javax.swing.JScrollPane schoolwise_record = new javax.swing.JScrollPane();
        school_wise_table = new javax.swing.JTable();
        totalpm_background = new javax.swing.JLabel();
        totalpm_border = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lecturer Record");
        setMaximumSize(new java.awt.Dimension(1000, 700));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(2, 50, 99));
        jLabel1.setText("Lecturer Record");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 80, 180, 30));

        jLabel3.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(2, 50, 99));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back.png"))); // NOI18N
        jLabel3.setText("BACK");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, -1));

        admin_header.setBackground(new Color(255, 255, 255, 90));
        admin_header.setToolTipText("");
        admin_header.setMaximumSize(new java.awt.Dimension(1000, 73));
        admin_header.setMinimumSize(new java.awt.Dimension(1000, 73));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 253, Short.MAX_VALUE)
                .addComponent(admin_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(admin_report, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(admin_lecturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(admin_student, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(admin_logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        admin_headerLayout.setVerticalGroup(
            admin_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(admin_headerLayout.createSequentialGroup()
                .addGroup(admin_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(admin_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(admin_logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(admin_student, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(admin_lecturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(admin_report, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(admin_profile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(admin_headerLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(admin_logo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(admin_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, -1));

        numprojectmanager.setFont(new java.awt.Font("Bell MT", 1, 48)); // NOI18N
        numprojectmanager.setForeground(new java.awt.Color(2, 50, 99));
        numprojectmanager.setText("jLabel2");
        getContentPane().add(numprojectmanager, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 130, 80, 50));

        numlecturer.setFont(new java.awt.Font("Bell MT", 1, 48)); // NOI18N
        numlecturer.setForeground(new java.awt.Color(2, 50, 99));
        numlecturer.setText("jLabel2");
        getContentPane().add(numlecturer, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 80, 40));

        numSchoolWise.setFont(new java.awt.Font("Bell MT", 1, 48)); // NOI18N
        numSchoolWise.setForeground(new java.awt.Color(2, 50, 99));
        numSchoolWise.setText("jLabel2");
        getContentPane().add(numSchoolWise, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 80, 40));

        totallec_border.setBackground(new Color(2, 50, 99, 0));
        totallec_border.setBorder(new LineBorder(new Color(192, 192, 192, 90), 15, true));
        totallec_border.setMaximumSize(new java.awt.Dimension(440, 125));
        totallec_border.setMinimumSize(new java.awt.Dimension(440, 125));
        totallec_border.setPreferredSize(new java.awt.Dimension(440, 125));
        getContentPane().add(totallec_border, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 300, 90));

        totallec_background.setBackground(new Color(192, 192, 192, 90));
        totallec_background.setFont(new java.awt.Font("Bell MT", 1, 20)); // NOI18N
        totallec_background.setForeground(new java.awt.Color(2, 50, 99));
        totallec_background.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        totallec_background.setText("Total Lecturer");
        totallec_background.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        totallec_background.setMaximumSize(new java.awt.Dimension(418, 123));
        totallec_background.setMinimumSize(new java.awt.Dimension(418, 123));
        totallec_background.setOpaque(true);
        totallec_background.setPreferredSize(new java.awt.Dimension(418, 123));
        getContentPane().add(totallec_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 280, 70));

        totalschool_background.setBackground(new Color(192, 192, 192, 90));
        totalschool_background.setFont(new java.awt.Font("Bell MT", 1, 20)); // NOI18N
        totalschool_background.setForeground(new java.awt.Color(2, 50, 99));
        totalschool_background.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        totalschool_background.setText("Total School Wise");
        totalschool_background.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        totalschool_background.setMaximumSize(new java.awt.Dimension(418, 123));
        totalschool_background.setMinimumSize(new java.awt.Dimension(418, 123));
        totalschool_background.setOpaque(true);
        totalschool_background.setPreferredSize(new java.awt.Dimension(418, 123));
        getContentPane().add(totalschool_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 280, 70));

        totalschool_border.setBackground(new Color(2, 50, 99, 0));
        totalschool_border.setBorder(new LineBorder(new Color(192, 192, 192, 90), 15, true));
        totalschool_border.setMaximumSize(new java.awt.Dimension(440, 125));
        totalschool_border.setMinimumSize(new java.awt.Dimension(440, 125));
        totalschool_border.setPreferredSize(new java.awt.Dimension(440, 125));
        getContentPane().add(totalschool_border, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 300, 90));

        lecturer_record.setOpaque(true);

        lecturer_table.setAutoCreateRowSorter(true);
        lecturer_table.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lecturer_table.setForeground(new java.awt.Color(2, 50, 99));
        lecturer_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "Name", "School Wise", "Email", "Contact Number", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        lecturer_table.setRowHeight(30);
        lectuter_record.setViewportView(lecturer_table);

        lecturer_record.addTab("Lecturer", lectuter_record);

        projectmanager_table.setAutoCreateRowSorter(true);
        projectmanager_table.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        projectmanager_table.setForeground(new java.awt.Color(2, 50, 99));
        projectmanager_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "Name", "School Wise", "Email", "Contact Number", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        projectmanager_table.setRowHeight(30);
        jScrollPane1.setViewportView(projectmanager_table);

        lecturer_record.addTab("Project Manager", jScrollPane1);

        school_wise_table.setAutoCreateRowSorter(true);
        school_wise_table.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        school_wise_table.setForeground(new java.awt.Color(2, 50, 99));
        school_wise_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "School Wise", "Number Of Lecturer", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        school_wise_table.setRowHeight(30);
        schoolwise_record.setViewportView(school_wise_table);

        lecturer_record.addTab("School Wise List", schoolwise_record);

        getContentPane().add(lecturer_record, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 920, 370));
        lecturer_record.getAccessibleContext().setAccessibleName("");
        lecturer_record.getAccessibleContext().setAccessibleDescription("");

        totalpm_background.setBackground(new Color(192, 192, 192, 90));
        totalpm_background.setFont(new java.awt.Font("Bell MT", 1, 20)); // NOI18N
        totalpm_background.setForeground(new java.awt.Color(2, 50, 99));
        totalpm_background.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        totalpm_background.setText("<html><div style= 'text-align: center; width: 100px;'>Total Project Manager</div></html>");
        totalpm_background.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        totalpm_background.setMaximumSize(new java.awt.Dimension(418, 123));
        totalpm_background.setMinimumSize(new java.awt.Dimension(418, 123));
        totalpm_background.setOpaque(true);
        totalpm_background.setPreferredSize(new java.awt.Dimension(418, 123));
        getContentPane().add(totalpm_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, 280, 70));

        totalpm_border.setBackground(new Color(2, 50, 99, 0));
        totalpm_border.setBorder(new LineBorder(new Color(192, 192, 192, 90), 15, true));
        totalpm_border.setMaximumSize(new java.awt.Dimension(440, 125));
        totalpm_border.setMinimumSize(new java.awt.Dimension(440, 125));
        totalpm_border.setPreferredSize(new java.awt.Dimension(440, 125));
        getContentPane().add(totalpm_border, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 110, 300, 90));

        jLabel2.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(2, 50, 99));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        jLabel2.setText("Type To Search");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 220, -1, 30));

        search.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
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
        getContentPane().add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 250, 170, 40));

        background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void admin_studentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_studentMouseClicked
        dispose();
        admin_student adminStudent = new admin_student();
        adminStudent.show();

    }//GEN-LAST:event_admin_studentMouseClicked

    private void admin_logoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_logoMouseClicked
        dispose();
        admin_mainpage adminMainpage = new admin_mainpage();
        adminMainpage.show();

    }//GEN-LAST:event_admin_logoMouseClicked

    private void admin_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_logoutMouseClicked
        dispose();
        GeneralPage generalPage = new GeneralPage();
        generalPage.show();
    }//GEN-LAST:event_admin_logoutMouseClicked

    private void admin_lecturerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_lecturerMouseClicked
        dispose();
        admin_lecturer adminLecturer = new admin_lecturer();
        adminLecturer.show();
    }//GEN-LAST:event_admin_lecturerMouseClicked

    private void admin_reportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_reportMouseClicked
        dispose();
        admin_assessment_management assessmentManagement = new admin_assessment_management();
        assessmentManagement.show();
    }//GEN-LAST:event_admin_reportMouseClicked

    private void admin_profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_profileMouseClicked
        dispose();
        admin_ec_record ecRecord = new admin_ec_record();
        ecRecord.show();
    }//GEN-LAST:event_admin_profileMouseClicked

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        String searchText = search.getText();

        DefaultTableModel lecturer = (DefaultTableModel) lecturer_table.getModel();
        TableRowSorter<DefaultTableModel> searchLecturer = new TableRowSorter<>(lecturer);
        lecturer_table.setRowSorter(searchLecturer);
        searchLecturer.setRowFilter(RowFilter.regexFilter(searchText));
        searchLecturer.setRowFilter(RowFilter.regexFilter("(?i)" + Pattern.quote(searchText)));

        DefaultTableModel project_manager = (DefaultTableModel) projectmanager_table.getModel();
        TableRowSorter<DefaultTableModel> searchProjectManager = new TableRowSorter<>(project_manager);
        projectmanager_table.setRowSorter(searchProjectManager);
        searchProjectManager.setRowFilter(RowFilter.regexFilter(searchText));
        searchProjectManager.setRowFilter(RowFilter.regexFilter("(?i)" + Pattern.quote(searchText)));

        DefaultTableModel school_wise = (DefaultTableModel) school_wise_table.getModel();
        TableRowSorter<DefaultTableModel> searchSchoolwise = new TableRowSorter<>(school_wise);
        school_wise_table.setRowSorter(searchSchoolwise);
        searchSchoolwise.setRowFilter(RowFilter.regexFilter("(?i)" + Pattern.quote(searchText)));
    }//GEN-LAST:event_searchKeyReleased

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        dispose();
        admin_lecturer adminLecturer = new admin_lecturer();
        adminLecturer.show();
    }//GEN-LAST:event_jLabel3MouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_lecturer_record().setVisible(true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTabbedPane lecturer_record;
    private static javax.swing.JTable lecturer_table;
    private static javax.swing.JLabel numSchoolWise;
    private static javax.swing.JLabel numlecturer;
    private static javax.swing.JLabel numprojectmanager;
    private static javax.swing.JTable projectmanager_table;
    private static javax.swing.JTable school_wise_table;
    private javax.swing.JTextField search;
    private javax.swing.JLabel totallec_background;
    private javax.swing.JLabel totallec_border;
    private javax.swing.JLabel totalpm_background;
    private javax.swing.JLabel totalpm_border;
    private javax.swing.JLabel totalschool_background;
    private javax.swing.JLabel totalschool_border;
    // End of variables declaration//GEN-END:variables
}
