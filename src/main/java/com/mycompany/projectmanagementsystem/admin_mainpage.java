package com.mycompany.projectmanagementsystem;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class admin_mainpage extends javax.swing.JFrame {

    public admin_mainpage() {
        initComponents();
        setIconImage();
        showStudentPieChart();
        showECChart();
        showLecturerBarChart();
        printLatestECTable();
    }

    public void showLecturerBarChart() {
        DefaultPieDataset lecturerDataset = new DefaultPieDataset();

        List<String> schoolWise = FileHandler.readFile("school_wise.txt");
        for (String line : schoolWise) {
            int lecturerCount = 0;
            List<String> userList = FileHandler.readFile("user.txt");
            for (String userLines : userList) {
                String[] userLine = userLines.split(";");
                if (userLine.length > 10 && userLine[10].equals("lecturer")
                        || userLine[10].equals("project manager") && userLine[11].equals(line)) {
                    lecturerCount++;

                }
            }
            lecturerDataset.setValue(line, lecturerCount);
        
        }
        JFreeChart lecturerpieChart = ChartFactory.createPieChart("Lecturer Distribution by School Wise",
                lecturerDataset, true, true, false);

        PiePlot lecturerpieplot = (PiePlot) lecturerpieChart.getPlot();

        //pie section settings
//        lecturerpieplot.setSectionPaint("CERT", new Color(135, 206, 235)); // Light Blue
//        lecturerpieplot.setSectionPaint("FOUN", new Color(255, 165, 0)); // Orange
//        lecturerpieplot.setSectionPaint("DEG", new Color(0, 128, 0)); // Green
//        lecturerpieplot.setSectionPaint("DIP", new Color(128, 0, 128)); // Purple
//        lecturerpieplot.setSectionPaint("MAS", new Color(255, 255, 0)); // Yellow
//        lecturerpieplot.setSectionPaint("PHD", new Color(255, 0, 0)); // Red

        lecturerpieplot.setBackgroundPaint(new Color(192, 192, 192, 90));

        //label settings
        lecturerpieplot.setLabelFont(new Font("SansSerif", Font.BOLD, 12));
        lecturerpieplot.setLabelPaint(new Color(2, 50, 99));
        lecturerpieplot.setLabelOutlinePaint(new Color(2, 50, 99));
        lecturerpieplot.setLabelShadowPaint(null);

        //outline settings
        lecturerpieplot.setSectionOutlinesVisible(true);
        lecturerpieplot.setOutlinePaint(new Color(2, 50, 99));

        ChartPanel lecturerbarchartpanel = new ChartPanel(lecturerpieChart);
        graph4.removeAll();
        graph4.add(lecturerbarchartpanel, BorderLayout.CENTER);
        graph4.validate();
        

    }

    public void showStudentPieChart() {
        DefaultPieDataset studentCountDataset = new DefaultPieDataset();

        List<String> levelOfStudyData = FileHandler.readFile("level_of_education.txt");

        for (String line : levelOfStudyData) {
            String[] levelRecord = line.split(";");
            String levelOfEducation = levelRecord[0];
            List<String> studentData = FileHandler.readFile("user.txt");
            int studentCount = 0;
            for (String studentLine : studentData) {
                String[] record = studentLine.split(";");

                if (record.length > 10 && record[10].equals("student") && record[11].startsWith(levelOfEducation)) {
                    studentCount++;

                }

            }
            studentCountDataset.setValue(levelOfEducation, studentCount);
        }

        // Create pie chart
        JFreeChart pieChart = ChartFactory.createPieChart("Student Distribution by Education Level",
                studentCountDataset, true, true, false);

        PiePlot pieplot = (PiePlot) pieChart.getPlot();

        //pie section settings
        pieplot.setSectionPaint("CERT", new Color(135, 206, 235)); // Light Blue
        pieplot.setSectionPaint("FOUN", new Color(255, 165, 0)); // Orange
        pieplot.setSectionPaint("DEG", new Color(0, 128, 0)); // Green
        pieplot.setSectionPaint("DIP", new Color(128, 0, 128)); // Purple
        pieplot.setSectionPaint("MAS", new Color(255, 255, 0)); // Yellow
        pieplot.setSectionPaint("PHD", new Color(255, 0, 0)); // Red
//        pieplot.setSectionPaint("Lecturer", new Color(70, 130, 180));
//        pieplot.setSectionPaint("Project Manager", new Color(255, 165, 0));

        pieplot.setBackgroundPaint(new Color(192, 192, 192, 90));

        //label settings
        pieplot.setLabelFont(new Font("SansSerif", Font.BOLD, 12));
        pieplot.setLabelPaint(new Color(2, 50, 99));
        pieplot.setLabelOutlinePaint(new Color(2, 50, 99));
        pieplot.setLabelShadowPaint(null);

        //outline settings
        pieplot.setSectionOutlinesVisible(true);
        pieplot.setOutlinePaint(new Color(2, 50, 99));

        ChartPanel barchartpanel = new ChartPanel(pieChart);
        student_graph.removeAll();
        student_graph.add(barchartpanel, BorderLayout.CENTER);
        student_graph.validate();
    }

    public void showECChart() {
        DefaultCategoryDataset ecDataset = new DefaultCategoryDataset();
        List<String> ecData = FileHandler.readFile("ec.txt");
        int ecPendingCount = 0, ecRejectedCount = 0, ecApprovedCount = 0;
        for (String ecLine : ecData) {
            String[] ecRecord = ecLine.split(";");
            String ecStatus = ecRecord[5];
            switch (ecStatus) {
                case "approved" ->
                    ecApprovedCount++;
                case "rejected" ->
                    ecRejectedCount++;
                default ->
                    ecPendingCount++;
            }
        }
        ecDataset.addValue(ecApprovedCount, "Status", "Approved");
        ecDataset.addValue(ecRejectedCount, "Status", "Rejected");
        ecDataset.addValue(ecPendingCount, "Status", "Pending");

        JFreeChart ecBarChart = ChartFactory.createBarChart(
                "EC Status", "Status", "Count", ecDataset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot ecChart = ecBarChart.getCategoryPlot();

        ecChart.setBackgroundPaint(new Color(192, 192, 192, 90));

        ecChart.setOutlinePaint(new Color(2, 50, 99));

        BarRenderer barrenderer = (BarRenderer) ecChart.getRenderer();
        barrenderer.setSeriesPaint(0, new Color(2, 50, 99));

        ChartPanel ecChartPanel = new ChartPanel(ecBarChart);
        graph3.removeAll();
        graph3.add(ecChartPanel, BorderLayout.CENTER);
        graph3.validate();

    }
    
    public static void printLatestECTable(){
        DefaultTableModel model = (DefaultTableModel) ec_approved_list.getModel();
        List<String> ecData = FileHandler.readFile("ec.txt");
        int startLine = Math.max(0, ecData.size() - 5);
        for(int i = startLine; i < ecData.size(); i++) {
                String line = ecData.get(i);
                String[] ecLine = line.split(";");
                String[] latestEC = {ecLine[0], ecLine[1], ecLine[5]};
                model.addRow(latestEC);
            }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        admin_header = new javax.swing.JPanel();
        admin_logo = new javax.swing.JLabel();
        admin_lecturer = new javax.swing.JLabel();
        admin_student = new javax.swing.JLabel();
        admin_report = new javax.swing.JLabel();
        admin_logout = new javax.swing.JLabel();
        graph2 = new javax.swing.JPanel();
        graph4 = new javax.swing.JPanel();
        graph3 = new javax.swing.JPanel();
        student_graph = new javax.swing.JPanel();
        admin_greeting = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ec_approved_list = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        admin_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin: Main Page");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admin_header.setBackground(new Color(255, 255, 255, 90));
        admin_header.setToolTipText("");
        admin_header.setMaximumSize(new java.awt.Dimension(1000, 73));
        admin_header.setMinimumSize(new java.awt.Dimension(1000, 73));
        admin_header.setPreferredSize(new java.awt.Dimension(1000, 73));

        admin_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sysco_logo.png"))); // NOI18N
        admin_logo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        admin_logout.setBackground(new Color(255, 255, 255, 0));
        admin_logout.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        admin_logout.setForeground(new java.awt.Color(2, 50, 99));
        admin_logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_logout.setText("Log Out");
        admin_logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admin_logout.setMaximumSize(new java.awt.Dimension(96, 73));
        admin_logout.setMinimumSize(new java.awt.Dimension(96, 73));
        admin_logout.setPreferredSize(new java.awt.Dimension(96, 73));

        javax.swing.GroupLayout admin_headerLayout = new javax.swing.GroupLayout(admin_header);
        admin_header.setLayout(admin_headerLayout);
        admin_headerLayout.setHorizontalGroup(
            admin_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(admin_headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(admin_logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 396, Short.MAX_VALUE)
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
                .addGroup(admin_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admin_logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(admin_student, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(admin_lecturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(admin_report, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(admin_headerLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(admin_logo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(admin_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        graph2.setBackground(new Color(192, 192, 192));
        graph2.setLayout(new java.awt.BorderLayout());
        getContentPane().add(graph2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 280, 240));

        graph4.setBackground(new Color(192, 192, 192));
        graph4.setLayout(new java.awt.BorderLayout());
        getContentPane().add(graph4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 540, 290));

        graph3.setBackground(new Color(192, 192, 192, 90));
        graph3.setLayout(new java.awt.BorderLayout());
        getContentPane().add(graph3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 300, 240));

        student_graph.setBackground(new Color(192, 192, 192, 90));
        student_graph.setLayout(new java.awt.BorderLayout());
        getContentPane().add(student_graph, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 130, 310, 240));

        admin_greeting.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        admin_greeting.setForeground(new java.awt.Color(2, 50, 99));
        admin_greeting.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_greeting.setText("Good Day Admin!");
        admin_greeting.setMaximumSize(new java.awt.Dimension(230, 18));
        admin_greeting.setMinimumSize(new java.awt.Dimension(230, 18));
        admin_greeting.setPreferredSize(new java.awt.Dimension(230, 18));
        getContentPane().add(admin_greeting, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 170, 30));

        ec_approved_list.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        ec_approved_list.setForeground(new java.awt.Color(2, 50, 99));
        ec_approved_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EC ID", "Student ID", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ec_approved_list.setRowHeight(30);
        jScrollPane1.setViewportView(ec_approved_list);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 410, 170));

        jLabel1.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(2, 50, 99));
        jLabel1.setText("Recent EC Submission");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 360, 50));

        jButton1.setBackground(new java.awt.Color(2, 50, 99));
        jButton1.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("VIEW DETAILS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 610, 220, 30));

        admin_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        admin_background.setText("Good Day Admin!");
        admin_background.setMaximumSize(new java.awt.Dimension(1000, 700));
        admin_background.setMinimumSize(new java.awt.Dimension(1000, 700));
        admin_background.setPreferredSize(new java.awt.Dimension(1000, 700));
        getContentPane().add(admin_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void admin_studentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_studentMouseClicked
        // TODO add your handling code here:
        admin_student admin_stu = new admin_student();
        admin_stu.show();
        hide();
    }//GEN-LAST:event_admin_studentMouseClicked

    private void admin_lecturerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_lecturerMouseClicked
        dispose();
        admin_lecturer_record lecturerManagement = new admin_lecturer_record();
        lecturerManagement.show();
    }//GEN-LAST:event_admin_lecturerMouseClicked

    private void admin_reportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_reportMouseClicked
        dispose();
        admin_edit_assessment assessmentManagement = new admin_edit_assessment();
        assessmentManagement.show();
    }//GEN-LAST:event_admin_reportMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        admin_ec_record ecManagement = new admin_ec_record();
        ecManagement.show();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new admin_mainpage().setVisible(true);
        });
    }

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon_with_background.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel admin_background;
    private javax.swing.JLabel admin_greeting;
    private javax.swing.JPanel admin_header;
    private javax.swing.JLabel admin_lecturer;
    private javax.swing.JLabel admin_logo;
    private javax.swing.JLabel admin_logout;
    private javax.swing.JLabel admin_report;
    private javax.swing.JLabel admin_student;
    private static javax.swing.JTable ec_approved_list;
    private javax.swing.JPanel graph2;
    private javax.swing.JPanel graph3;
    private javax.swing.JPanel graph4;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel student_graph;
    // End of variables declaration//GEN-END:variables
}
