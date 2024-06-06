/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projectmanagementsystem;

import com.mycompany.projectmanagementsystem.Assessment.AssessmentController;
import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import com.mycompany.projectmanagementsystem.GeneralFunction.SessionManager;
import com.mycompany.projectmanagementsystem.Assessment.LecReportTableActionEvent;
import com.mycompany.projectmanagementsystem.Communication.CommunicationController;
import com.mycompany.projectmanagementsystem.Presentation.PresentationController;
import com.mycompany.projectmanagementsystem.Presentation.PresentationTableActionEvent;
import com.mycompany.projectmanagementsystem.User.User;
import com.mycompany.projectmanagementsystem.User.UserController;
import com.mycompany.projectmanagementsystem.lect_PresentationPanelAction.PanelActionRenderer;
import com.mycompany.projectmanagementsystem.lect_PresentationPanelAction.TableActionCellEditor;
import com.mycompany.projectmanagementsystem.lect_ReportPanelAction.rPanelActionRenderer;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author user
 */
public class LecturerIntakePage extends javax.swing.JFrame {

    /**
     * Creates new form LecturerIntakePage
     */
    private final SessionManager sessionManager = SessionManager.getInstance();
    User user = sessionManager.getCurrentUser();
    private String intakeCode;
    private String AssmntID;
    private String AssmntType;
    private JPanel stdContentPanel;
    private JPanel PeoplePanel;
    private JButton PeopleViewBtn;
    private JLabel StatusLabel;
    private JLabel StdIDLabel;
    private JLabel StdNameLabel;
    List<JPanel> people = new ArrayList<JPanel>();

    private JPanel communicationPanel;
    private JLabel subject;
    private JButton openComBtn;
    private JButton deleteComButton;
    private JLabel channelDate;
    private JLabel communicationIcon;

    private JPanel communicationReplyPanel;
    private JLabel resubjectLabel;
    private JLabel replyMessage;
    private JLabel replyName;
    private JLabel replyDate;
    private JLabel deleteReply;
    
    private DefaultTableModel reportTableModel;

    public LecturerIntakePage(String AssmntID, String intakeCode, String AssmntType) {
        this.AssmntType = AssmntType;
        this.intakeCode = intakeCode;
        this.AssmntID = AssmntID;
        initComponents();
        setIconImage();
        checkAssmntStatus();
        showAssmnt(AssmntType);
        IntakeLabel.setText(intakeCode);
        showNoStd();
        showAssmntDueDate();
        showTotalSubmission();
        showPeopleInfo();
        showPresentation();
        showReportData();
        readPresentationFromFile();
        showCreateDiscussionBtn();
        readFromCommunicationChannel();
        showReport();
        int index1 = jTabbedPane1.indexOfComponent(lecreplyCommunicationScrollPanel);
        jTabbedPane1.removeTabAt(index1);
        reportTableModel = new DefaultTableModel();
        reportTableModel = (DefaultTableModel) reportTable.getModel();

        // Set preferred width for each column in presentation tab
        int[] columnWidths1 = {100, 170, 170, 200, 170};
        int numColumns1 = SchdPresentationTable.getColumnCount();
        for (int i = 0; i < numColumns1; i++) {
            TableColumn column = SchdPresentationTable.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths1[i]);
        }

        // Set preferred width for each column in report tab
        int[] columnWidths2 = {110, 160, 190, 150, 110, 170};
        int numColumns2 = reportTable.getColumnCount();
        for (int i = 0; i < numColumns2; i++) {
            TableColumn column = reportTable.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths2[i]);
        }

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

        for (int i = 0; i < SchdPresentationTable.getColumnCount(); i++) {
            SchdPresentationTable.getColumnModel().getColumn(i).setCellRenderer(new WhiteBackgroundRenderer());
        }

        for (int i = 0; i < reportTable.getColumnCount(); i++) {
            reportTable.getColumnModel().getColumn(i).setCellRenderer(new WhiteBackgroundRenderer());
        }

        SchdPresentationTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));
        SchdPresentationTable.getTableHeader().setForeground(new Color(2, 50, 99));
        ((DefaultTableCellRenderer) SchdPresentationTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        reportTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        reportTable.getTableHeader().setForeground(new Color(2, 50, 99));
        ((DefaultTableCellRenderer) reportTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        //end of table properties codes

        lect_PresentationPanelAction ppanel = new lect_PresentationPanelAction();
        PresentationTableActionEvent event = new PresentationTableActionEvent() {
            @Override
            public void presentationFeedback(int row, Object value) {
                DefaultTableModel model = (DefaultTableModel) SchdPresentationTable.getModel();
                String stdID = (String) model.getValueAt(row, 0);
                String name = (String) model.getValueAt(row, 1);
                String marker = (String) model.getValueAt(row, 2);
                String presentSlot = (String) model.getValueAt(row, 3);
                LecturerPresentationFeedback pfeedback = new LecturerPresentationFeedback(AssmntID, stdID, name, marker, presentSlot, AssmntType);
                pfeedback.setVisible(true);
            }

            @Override
            public void presentationDone(int row, Object value) {
                List<String> data = FileHandler.readFile("assessment.txt");

                DefaultTableModel model = (DefaultTableModel) SchdPresentationTable.getModel();
                int columnIndex = 0;
                String stdID = (String) model.getValueAt(row, columnIndex);
                PresentationController action = new PresentationController();

                for (String line : data) {
                    String[] list = line.split(";");
                    if (AssmntID.equals(list[0])) {
                        if (user.getUserID().equals(list[4])) { // Supervisor
                            boolean result = action.spvPresentationDone(stdID, AssmntID, "completed", AssmntType);
                            if (result) {
                                model.removeRow(row);
                                JOptionPane.showMessageDialog(null,
                                        "Presentation from supervisee (" + stdID + ") has been marked done with feedback.");
                                // Dispose the current intake page
                                ((Window) SwingUtilities.getWindowAncestor(reportTable)).dispose();
                                // Display an updated intake page
                                LecturerIntakePage update = new LecturerIntakePage(AssmntID, intakeCode, AssmntType);
                                update.setVisible(true);
                            }
                            return; // No need to continue the loop once a match is found
                        } else if (user.getUserID().equals(list[5])) { // Second Marker
                            boolean result = action.secMarkPresentationDone(stdID, AssmntID, "true");
                            if (result) {
                                model.removeRow(row);
                                JOptionPane.showMessageDialog(null,
                                        "Presentation from supervisee (" + stdID + ") has been marked done.");
                            }
                            return; // No need to continue the loop once a match is found
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "No matching record found for the given assessment ID and user ID", "Message", JOptionPane.INFORMATION_MESSAGE);
            }

        };
        if ("internship_report".equals(AssmntType) || "investigation".equals(AssmntType)) {
            SchdPresentationTable.getColumnModel().getColumn(3).setCellRenderer(ppanel.new PanelActionRenderer());
            SchdPresentationTable.getColumnModel().getColumn(3).setCellEditor(ppanel.new TableActionCellEditor(event));
        } else {
            SchdPresentationTable.getColumnModel().getColumn(4).setCellRenderer(ppanel.new PanelActionRenderer());
            SchdPresentationTable.getColumnModel().getColumn(4).setCellEditor(ppanel.new TableActionCellEditor(event));
        }

        lect_ReportPanelAction rpanel = new lect_ReportPanelAction();
        LecReportTableActionEvent rptevent = new LecReportTableActionEvent() {
            @Override
            public void reportGrading(int row, Object value) {
                List<String> data = FileHandler.readFile("student_assessment.txt");

                DefaultTableModel model = (DefaultTableModel) reportTable.getModel();
                String stdID = (String) model.getValueAt(row, 0);
                String name = (String) model.getValueAt(row, 1);
                String subLink = null;
//                AssessmentController action = new AssessmentController();
//                boolean found = false;

                for (String line : data) {
                    String[] list = line.split(";");
                    if (list[1].equals(stdID)) {
                        subLink = list[4];
                        break;
                    }
                }

                if (subLink != null) {
                    gradeReport(stdID, name, subLink);
                } else {
                    JOptionPane.showMessageDialog(null, "Submission link not found for student ID: " + stdID);
                } 
            } 
        };
        reportTable.getColumnModel().getColumn(5).setCellRenderer(rpanel.new rPanelActionRenderer());
        reportTable.getColumnModel().getColumn(5).setCellEditor(rpanel.new TableActionCellEditor(rptevent));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        intakeDetails = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        IntakeLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        NoStdLabel = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        AssmntDueLabel = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        TotalSubmsnLabel = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        CmpltPresentLabel = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        MarkedRptLabel = new javax.swing.JLabel();
        schdPresentationList = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SchdPresentationTable = new javax.swing.JTable();
        viewPresentRqtLabel = new javax.swing.JLabel();
        submittedReportList = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        reportTable = new javax.swing.JTable();
        viewMarkedRptLabel = new javax.swing.JLabel();
        lecCommunicationScrollPanel = new javax.swing.JScrollPane();
        jPanel12 = new javax.swing.JPanel();
        lecreplyCommunicationScrollPanel = new javax.swing.JScrollPane();
        jPanel13 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        createdMessage = new javax.swing.JLabel();
        createdDate = new javax.swing.JLabel();
        createdName = new javax.swing.JLabel();
        reply = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        backIcon = new javax.swing.JLabel();
        selectedSubject = new javax.swing.JLabel();
        stdPeopleList = new javax.swing.JScrollPane();
        peoplePanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        syscoLogo = new javax.swing.JLabel();
        LecLogOutLabel = new javax.swing.JLabel();
        LecProfileLabel = new javax.swing.JLabel();
        NotiLabel = new javax.swing.JLabel();
        SumRptLabel = new javax.swing.JLabel();
        createDiscussionBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lecturer Assessment Details");
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(217, 217, 217));
        jTabbedPane1.setForeground(new java.awt.Color(2, 50, 99));
        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jTabbedPane1.setMaximumSize(new java.awt.Dimension(920, 500));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(920, 500));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(920, 500));

        intakeDetails.setBackground(new java.awt.Color(217, 217, 217));

        jPanel3.setBackground(new java.awt.Color(217, 217, 217));
        jPanel3.setMaximumSize(new java.awt.Dimension(840, 400));
        jPanel3.setMinimumSize(new java.awt.Dimension(840, 400));

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setMaximumSize(new java.awt.Dimension(836, 60));
        jPanel4.setMinimumSize(new java.awt.Dimension(836, 60));
        jPanel4.setPreferredSize(new java.awt.Dimension(836, 60));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(2, 50, 99));
        jLabel8.setText("Intake");

        IntakeLabel.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        IntakeLabel.setForeground(new java.awt.Color(2, 50, 99));
        IntakeLabel.setMaximumSize(new java.awt.Dimension(330, 26));
        IntakeLabel.setMinimumSize(new java.awt.Dimension(330, 26));
        IntakeLabel.setPreferredSize(new java.awt.Dimension(330, 26));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(IntakeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(IntakeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setMaximumSize(new java.awt.Dimension(836, 60));
        jPanel5.setMinimumSize(new java.awt.Dimension(836, 60));
        jPanel5.setPreferredSize(new java.awt.Dimension(836, 60));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(2, 50, 99));
        jLabel9.setText("Number of Students");

        NoStdLabel.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        NoStdLabel.setForeground(new java.awt.Color(2, 50, 99));
        NoStdLabel.setMaximumSize(new java.awt.Dimension(330, 26));
        NoStdLabel.setMinimumSize(new java.awt.Dimension(330, 26));
        NoStdLabel.setPreferredSize(new java.awt.Dimension(330, 26));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel9)
                .addGap(209, 209, 209)
                .addComponent(NoStdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(NoStdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setMaximumSize(new java.awt.Dimension(836, 60));
        jPanel6.setMinimumSize(new java.awt.Dimension(836, 60));
        jPanel6.setPreferredSize(new java.awt.Dimension(836, 60));

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(2, 50, 99));
        jLabel10.setText("Assessment Due Date");

        AssmntDueLabel.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        AssmntDueLabel.setForeground(new java.awt.Color(2, 50, 99));
        AssmntDueLabel.setMaximumSize(new java.awt.Dimension(330, 26));
        AssmntDueLabel.setMinimumSize(new java.awt.Dimension(330, 26));
        AssmntDueLabel.setPreferredSize(new java.awt.Dimension(330, 26));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel10)
                .addGap(191, 191, 191)
                .addComponent(AssmntDueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(AssmntDueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.setMaximumSize(new java.awt.Dimension(836, 60));
        jPanel8.setMinimumSize(new java.awt.Dimension(836, 60));
        jPanel8.setPreferredSize(new java.awt.Dimension(836, 60));

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(2, 50, 99));
        jLabel11.setText("Total Submission");

        TotalSubmsnLabel.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        TotalSubmsnLabel.setForeground(new java.awt.Color(2, 50, 99));
        TotalSubmsnLabel.setMaximumSize(new java.awt.Dimension(330, 26));
        TotalSubmsnLabel.setMinimumSize(new java.awt.Dimension(330, 26));
        TotalSubmsnLabel.setPreferredSize(new java.awt.Dimension(330, 26));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel11)
                .addGap(234, 234, 234)
                .addComponent(TotalSubmsnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(TotalSubmsnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel9.setMaximumSize(new java.awt.Dimension(836, 60));
        jPanel9.setMinimumSize(new java.awt.Dimension(836, 60));
        jPanel9.setPreferredSize(new java.awt.Dimension(836, 60));

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(2, 50, 99));
        jLabel12.setText("Completed Presentation");

        CmpltPresentLabel.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        CmpltPresentLabel.setForeground(new java.awt.Color(2, 50, 99));
        CmpltPresentLabel.setMaximumSize(new java.awt.Dimension(330, 26));
        CmpltPresentLabel.setMinimumSize(new java.awt.Dimension(330, 26));
        CmpltPresentLabel.setPreferredSize(new java.awt.Dimension(330, 26));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel12)
                .addGap(173, 173, 173)
                .addComponent(CmpltPresentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(CmpltPresentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.setMaximumSize(new java.awt.Dimension(836, 60));
        jPanel10.setMinimumSize(new java.awt.Dimension(836, 60));
        jPanel10.setPreferredSize(new java.awt.Dimension(836, 60));

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(2, 50, 99));
        jLabel13.setText("Marked Report");

        MarkedRptLabel.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        MarkedRptLabel.setForeground(new java.awt.Color(2, 50, 99));
        MarkedRptLabel.setMaximumSize(new java.awt.Dimension(330, 26));
        MarkedRptLabel.setMinimumSize(new java.awt.Dimension(330, 26));
        MarkedRptLabel.setPreferredSize(new java.awt.Dimension(330, 26));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MarkedRptLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MarkedRptLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout intakeDetailsLayout = new javax.swing.GroupLayout(intakeDetails);
        intakeDetails.setLayout(intakeDetailsLayout);
        intakeDetailsLayout.setHorizontalGroup(
            intakeDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(intakeDetailsLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        intakeDetailsLayout.setVerticalGroup(
            intakeDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(intakeDetailsLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Details", intakeDetails);

        schdPresentationList.setBackground(new java.awt.Color(217, 217, 217));

        jLabel20.setFont(new java.awt.Font("Bell MT", 1, 22)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(2, 50, 99));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Scheduled Presentation");

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        SchdPresentationTable.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        SchdPresentationTable.setForeground(new java.awt.Color(2, 50, 99));
        SchdPresentationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request ID", "Name", "Marker", "Presentation Slot", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SchdPresentationTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SchdPresentationTable.setRowHeight(30);
        SchdPresentationTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        SchdPresentationTable.setSelectionForeground(new java.awt.Color(2, 50, 99));
        SchdPresentationTable.setShowGrid(false);
        SchdPresentationTable.getTableHeader().setResizingAllowed(false);
        SchdPresentationTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(SchdPresentationTable);
        if (SchdPresentationTable.getColumnModel().getColumnCount() > 0) {
            SchdPresentationTable.getColumnModel().getColumn(4).setMinWidth(170);
            SchdPresentationTable.getColumnModel().getColumn(4).setPreferredWidth(170);
            SchdPresentationTable.getColumnModel().getColumn(4).setMaxWidth(170);
        }

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );

        viewPresentRqtLabel.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        viewPresentRqtLabel.setForeground(new java.awt.Color(2, 50, 99));
        viewPresentRqtLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewPresentRqtLabel.setText("View Presentation List >");
        viewPresentRqtLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewPresentRqtLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewPresentRqtLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout schdPresentationListLayout = new javax.swing.GroupLayout(schdPresentationList);
        schdPresentationList.setLayout(schdPresentationListLayout);
        schdPresentationListLayout.setHorizontalGroup(
            schdPresentationListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(viewPresentRqtLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        schdPresentationListLayout.setVerticalGroup(
            schdPresentationListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(schdPresentationListLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewPresentRqtLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Presentation", schdPresentationList);

        submittedReportList.setBackground(new java.awt.Color(217, 217, 217));

        jLabel22.setFont(new java.awt.Font("Bell MT", 1, 22)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(2, 50, 99));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Report Marking");

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        reportTable.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        reportTable.setForeground(new java.awt.Color(2, 50, 99));
        reportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supervisee ID", "Name", "Submission Datetime", "EC Status", "Resubmission", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        reportTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        reportTable.setRowHeight(30);
        reportTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        reportTable.setSelectionForeground(new java.awt.Color(2, 50, 99));
        reportTable.setShowGrid(false);
        reportTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(reportTable);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
        );

        viewMarkedRptLabel.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        viewMarkedRptLabel.setForeground(new java.awt.Color(2, 50, 99));
        viewMarkedRptLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewMarkedRptLabel.setText("View Marked Report List >");
        viewMarkedRptLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewMarkedRptLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewMarkedRptLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout submittedReportListLayout = new javax.swing.GroupLayout(submittedReportList);
        submittedReportList.setLayout(submittedReportListLayout);
        submittedReportListLayout.setHorizontalGroup(
            submittedReportListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(viewMarkedRptLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        submittedReportListLayout.setVerticalGroup(
            submittedReportListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(submittedReportListLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewMarkedRptLabel)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Report", submittedReportList);

        lecCommunicationScrollPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1008, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 873, Short.MAX_VALUE)
        );

        lecCommunicationScrollPanel.setViewportView(jPanel12);

        jTabbedPane1.addTab("Communication", lecCommunicationScrollPanel);

        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel17.setMaximumSize(new java.awt.Dimension(820, 140));
        jPanel17.setMinimumSize(new java.awt.Dimension(820, 140));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/profile_icon.png"))); // NOI18N

        createdMessage.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        createdMessage.setForeground(new java.awt.Color(2, 50, 99));
        createdMessage.setText("Message");

        createdDate.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        createdDate.setForeground(new java.awt.Color(2, 50, 99));
        createdDate.setText("Date");

        createdName.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        createdName.setForeground(new java.awt.Color(2, 50, 99));
        createdName.setText("Name");

        reply.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        reply.setForeground(new java.awt.Color(2, 50, 99));
        reply.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reply.setText("Reply");
        reply.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(createdName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(89, 89, 89)
                        .addComponent(createdDate, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(createdMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(107, Short.MAX_VALUE))))
            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                    .addContainerGap(745, Short.MAX_VALUE)
                    .addComponent(reply, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createdDate)
                            .addComponent(createdName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createdMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel17Layout.createSequentialGroup()
                    .addGap(95, 95, 95)
                    .addComponent(reply, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(16, 16, 16)))
        );

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chat1.png"))); // NOI18N
        jLabel31.setText("jLabel29");

        backIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back.png"))); // NOI18N
        backIcon.setText("jLabel4");
        backIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backIcon.setMaximumSize(new java.awt.Dimension(50, 40));
        backIcon.setMinimumSize(new java.awt.Dimension(50, 40));
        backIcon.setPreferredSize(new java.awt.Dimension(50, 40));
        backIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backIconMouseClicked(evt);
            }
        });

        selectedSubject.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        selectedSubject.setForeground(new java.awt.Color(2, 50, 99));
        selectedSubject.setText("Subject");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(backIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(selectedSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(backIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectedSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(175, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(821, Short.MAX_VALUE))
        );

        lecreplyCommunicationScrollPanel.setViewportView(jPanel13);

        jTabbedPane1.addTab("Communication", lecreplyCommunicationScrollPanel);

        javax.swing.GroupLayout peoplePanelLayout = new javax.swing.GroupLayout(peoplePanel);
        peoplePanel.setLayout(peoplePanelLayout);
        peoplePanelLayout.setHorizontalGroup(
            peoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 922, Short.MAX_VALUE)
        );
        peoplePanelLayout.setVerticalGroup(
            peoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
        );

        stdPeopleList.setViewportView(peoplePanel);

        jTabbedPane1.addTab("People", stdPeopleList);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 920, 500));
        jTabbedPane1.getAccessibleContext().setAccessibleName("Peope");

        jLabel7.setFont(new java.awt.Font("Bell MT", 1, 28)); // NOI18N
        jLabel7.setText("Intake");
        jLabel7.setMaximumSize(new java.awt.Dimension(400, 47));
        jLabel7.setMinimumSize(new java.awt.Dimension(400, 47));
        jLabel7.setPreferredSize(new java.awt.Dimension(400, 47));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 400, 47));

        jPanel1.setBackground(new Color(255, 255, 255, 90));
        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 73));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 73));

        syscoLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sysco_logo.png"))); // NOI18N
        syscoLogo.setText("logo");
        syscoLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        syscoLogo.setMaximumSize(new java.awt.Dimension(184, 42));
        syscoLogo.setMinimumSize(new java.awt.Dimension(184, 42));
        syscoLogo.setPreferredSize(new java.awt.Dimension(184, 42));
        syscoLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                syscoLogoMouseClicked(evt);
            }
        });

        LecLogOutLabel.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        LecLogOutLabel.setForeground(new java.awt.Color(2, 50, 99));
        LecLogOutLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LecLogOutLabel.setText("Log Out");
        LecLogOutLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LecLogOutLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LecLogOutLabelMouseClicked(evt);
            }
        });

        LecProfileLabel.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        LecProfileLabel.setForeground(new java.awt.Color(2, 50, 99));
        LecProfileLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LecProfileLabel.setText("Profile");
        LecProfileLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LecProfileLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LecProfileLabelMouseClicked(evt);
            }
        });

        NotiLabel.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        NotiLabel.setForeground(new java.awt.Color(2, 50, 99));
        NotiLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NotiLabel.setText("Notification");
        NotiLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NotiLabel.setMaximumSize(new java.awt.Dimension(37, 21));
        NotiLabel.setMinimumSize(new java.awt.Dimension(37, 21));
        NotiLabel.setPreferredSize(new java.awt.Dimension(37, 21));
        NotiLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NotiLabelMouseClicked(evt);
            }
        });

        SumRptLabel.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        SumRptLabel.setForeground(new java.awt.Color(2, 50, 99));
        SumRptLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SumRptLabel.setText("Summary Report");
        SumRptLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SumRptLabel.setMaximumSize(new java.awt.Dimension(37, 21));
        SumRptLabel.setMinimumSize(new java.awt.Dimension(37, 21));
        SumRptLabel.setPreferredSize(new java.awt.Dimension(37, 21));
        SumRptLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SumRptLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(syscoLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 317, Short.MAX_VALUE)
                .addComponent(SumRptLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NotiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LecProfileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LecLogOutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(syscoLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LecProfileLabel)
                    .addComponent(LecLogOutLabel)
                    .addComponent(NotiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SumRptLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, -1));

        createDiscussionBtn.setBackground(new java.awt.Color(76, 127, 174));
        createDiscussionBtn.setFont(new java.awt.Font("Bell MT", 1, 12)); // NOI18N
        createDiscussionBtn.setForeground(new java.awt.Color(255, 255, 255));
        createDiscussionBtn.setText("Create Discussion");
        createDiscussionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createDiscussionBtnActionPerformed(evt);
            }
        });
        getContentPane().add(createDiscussionBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 90, 130, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        jLabel1.setText("background");
        jLabel1.setPreferredSize(new java.awt.Dimension(1000, 700));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void syscoLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_syscoLogoMouseClicked
        LecturerDashboardPage dashboard = new LecturerDashboardPage();
        dashboard.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_syscoLogoMouseClicked

    private void SumRptLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SumRptLabelMouseClicked
        this.setVisible(false);
        LecturerSummaryReport lectSumRpt = new LecturerSummaryReport(AssmntID, intakeCode);
        lectSumRpt.setVisible(true);
    }//GEN-LAST:event_SumRptLabelMouseClicked

    private void NotiLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NotiLabelMouseClicked
        NotificationPage lectNoti = new NotificationPage();
        lectNoti.setVisible(true);
    }//GEN-LAST:event_NotiLabelMouseClicked

    private void LecProfileLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LecProfileLabelMouseClicked
        this.setVisible(false);
        LecturerProfile profile = new LecturerProfile(AssmntID, intakeCode);
        profile.setVisible(true);
    }//GEN-LAST:event_LecProfileLabelMouseClicked

    private void LecLogOutLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LecLogOutLabelMouseClicked
        int confirm = JOptionPane.showConfirmDialog(null, "Are you confirmed to log out?",
                "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            UserController logout = new UserController();
            logout.userLogout();
        } else {
        }
    }//GEN-LAST:event_LecLogOutLabelMouseClicked

    private void viewPresentRqtLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewPresentRqtLabelMouseClicked
        redirectPresentRqt(AssmntID);
    }//GEN-LAST:event_viewPresentRqtLabelMouseClicked

    private void createDiscussionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createDiscussionBtnActionPerformed
        CreateNewMessagePage messagePage = new CreateNewMessagePage(AssmntID, AssmntType, null, null, null, this);
        messagePage.setVisible(true);
    }//GEN-LAST:event_createDiscussionBtnActionPerformed

    private void backIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backIconMouseClicked
        Component[] components = jPanel13.getComponents();
        for (Component component : components) {
            if (component instanceof JPanel) {
                jPanel13.remove(component);
            }
        }
        jPanel13.add(jPanel18);
        jPanel13.add(jPanel17);
        jPanel13.revalidate();
        jPanel13.repaint();

        int index = jTabbedPane1.indexOfComponent(lecreplyCommunicationScrollPanel);
        jTabbedPane1.removeTabAt(index);
        jTabbedPane1.insertTab("Communication", null, lecCommunicationScrollPanel, null, index);
        jTabbedPane1.setSelectedComponent(lecCommunicationScrollPanel);
    }//GEN-LAST:event_backIconMouseClicked

    private void viewMarkedRptLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewMarkedRptLabelMouseClicked
        redirectMarkedReport(AssmntID, this);
    }//GEN-LAST:event_viewMarkedRptLabelMouseClicked

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
            java.util.logging.Logger.getLogger(LecturerIntakePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LecturerIntakePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LecturerIntakePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LecturerIntakePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LecturerIntakePage("intake", "assessmentID", "assmntType").setVisible(true);
            }
        });
    }

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon_with_background.png")));
    }
    
    private void gradeReport(String stdID, String name, String subLink){
        LecturerReportGrading markReport = new LecturerReportGrading(this, AssmntID, stdID, name, subLink, AssmntType, intakeCode);
        markReport.setVisible(true);
    }
    
    public DefaultTableModel getReportTableModel() {
        return reportTableModel;
    }
    
    public JTable getReportTable() {
        return reportTable;
    }
    
    private void checkAssmntStatus() {
        List<String> userData = FileHandler.readFile("user.txt");
        List<String> reportData = FileHandler.readFile("student_assessment.txt");
        List<String> assessmentData = FileHandler.readFile("assessment.txt");
        ArrayList<String> updatedData = new ArrayList<>();
        int markedRptCount = 0;
        int stdCount = 0;

        for (String line : userData) {
            String[] userList = line.split(";");
            if ("student".equals(userList[10]) && intakeCode.equals(userList[11])) {
                stdCount++;
            }
        }

        for (String line : reportData) {
            String[] reportList = line.split(";");
            if (AssmntID.equals(reportList[2])) {
                if ("marked".equals(reportList[6])) {
                    markedRptCount++;
                }
            }
        }

        for (String line : assessmentData) {
            String[] list = line.split(";");
            if (AssmntID.equals(list[0])) {
                if (stdCount == markedRptCount) {
                    list[7] = "completed";
                }
                line = String.join(";", list);
            }
            updatedData.add(line);
        }

        FileHandler.modifyFileData("assessment.txt", updatedData);
    }

    private void showAssmnt(String assmntType) {
        List<String> AssmntData = FileHandler.readFile("assessment.txt");

        for (String line : AssmntData) {
            String[] AssmntList = line.split(";");
            if (assmntType.equals(AssmntList[1])) {
                switch (AssmntList[1]) {
                    case "internship_report" -> {
                        jLabel7.setText("Intake (Internship Report)");
                    }
                    case "fyp" -> {
                        jLabel7.setText("Intake (Final Year Project)");
                    }
                    case "investigation" -> {
                        jLabel7.setText("Intake (Investigation Report)");
                    }
                    case "cp1" -> {
                        jLabel7.setText("Intake (Capstone Project 1)");
                    }
                    case "cp2" -> {
                        jLabel7.setText("Intake (Capstone Project 2)");
                    }
                    case "rmcp" -> {
                        jLabel7.setText("Intake (Research Methodology for Capstone Project)");
                    }
                }
            }
        }
    }

    private void showNoStd() {
        List<String> UserData = FileHandler.readFile("user.txt");
        int stdCount = 0;

        for (String line : UserData) {
            String[] UserList = line.split(";");
            if ("student".equals(UserList[10]) && intakeCode.equals(UserList[11])) {
                stdCount++;
            }
        }
        NoStdLabel.setText(Integer.toString(stdCount));
    }

    private void showAssmntDueDate() {
        List<String> AssmntData = FileHandler.readFile("assessment.txt");

        for (String line : AssmntData) {
            String[] AssmntList = line.split(";");
            AssmntDueLabel.setText(AssmntList[3]);
        }
    }

    private void showTotalSubmission() {
        List<String> StdAssmntData = FileHandler.readFile("student_assessment.txt");
        int stdSubCount = 0;

        for (String line : StdAssmntData) {
            String[] StdAssmntList = line.split(";");
            if (AssmntID.equals(StdAssmntList[2])) {
                if ("submitted".equals(StdAssmntList[6]) || "partially marked".equals(StdAssmntList[6]) || "marked".equals(StdAssmntList[6])) {
                    stdSubCount++;
                }
            }
        }
        TotalSubmsnLabel.setText(Integer.toString(stdSubCount));
    }

    private void showPresentation() {
        List<String> presentationData = FileHandler.readFile("presentation_confirmation.txt");
        int cmpltPresentationCount = 0;

        for (String line : presentationData) {
            String[] presentationList = line.split(";");
            if (AssmntID.equals(presentationList[2])) {
                if ("completed".equals(presentationList[5])) {
                    cmpltPresentationCount++;
                }
            }
            CmpltPresentLabel.setText(Integer.toString(cmpltPresentationCount));
        }
    }

    private void showReportData() {
        List<String> reportData = FileHandler.readFile("student_assessment.txt");
        int markedRptCount = 0;

        for (String line : reportData) {
            String[] reportList = line.split(";");
            if (AssmntID.equals(reportList[2])) {
                if ("marked".equals(reportList[6])) {
                    markedRptCount++;
                }
            }
            MarkedRptLabel.setText(Integer.toString(markedRptCount));
        }
    }

    private void readPresentationFromFile() {
        String fileNamex = "presentation_confirmation.txt";
        String fileNamey = "assessment.txt";
        String fileNamez = "user.txt";

        DefaultTableModel model = (DefaultTableModel) SchdPresentationTable.getModel();
        model.setRowCount(0); // Clear existing rows

        List<String> datax = FileHandler.readFile(fileNamex);
        List<String> datay = FileHandler.readFile(fileNamey);
        List<String> dataz = FileHandler.readFile(fileNamez);

        // Map to store studentID to studentName
        Map<String, String> MarkerNames = new HashMap<>();
        for (String linez : dataz) {
            String[] listz = linez.split(";");
            String MarkerID = listz[0];
            String MarkerName = listz[1];
            MarkerNames.put(MarkerID, MarkerName);
        }

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
            String presentationSlot = listx[3];
            String status = listx[5];

            if (studentID != null) {
                String studentName = studentNames.get(studentID);
                if (studentName != null) {
                    for (String liney : datay) {
                        String[] listy = liney.split(";");
                        String currentAssessmentID = listy[0];
                        if (currentAssessmentID.equals(assessmentID) && currentAssessmentID.equals(AssmntID)) {
                            String spv = listy[4];
                            String secMarker = listy[5];
                            String spvName = MarkerNames.get(spv);
                            String SecMarkerName = MarkerNames.get(secMarker);

                            String rowIdentifier = studentID + "-" + assessmentID;
                            if (!addedRows.contains(rowIdentifier) && "scheduled".equals(status)) {
                                if (spv.equals(user.getUserID())) {
                                    if ("internship_report".equals(AssmntType) || "investigation".equals(AssmntType)) {
                                        SchdPresentationTable.removeColumn(SchdPresentationTable.getColumnModel().getColumn(2));
                                        SchdPresentationTable.getTableHeader().repaint();
                                        String[] reorderedData = {
                                            studentID, // Supervisee ID
                                            studentName, // Supervisee Name
                                            "null",
                                            presentationSlot // Presentation Slot
                                        };
                                        model.addRow(reorderedData);
                                    } else {
                                        SchdPresentationTable.getColumnModel().getColumn(2).setHeaderValue("Second Marker");
                                        SchdPresentationTable.getTableHeader().repaint();
                                        String[] reorderedData = {
                                            studentID, // Supervisee ID
                                            studentName, // Supervisee Name
                                            SecMarkerName, // Second Marker Name
                                            presentationSlot // Presentation Slot
                                        };
                                        model.addRow(reorderedData);
                                    }
                                    addedRows.add(rowIdentifier);
                                } else if (secMarker.equals(user.getUserID()) && "false".equals(listx[6])) {
                                    SchdPresentationTable.getColumnModel().getColumn(2).setHeaderValue("Supervisor");
                                    SchdPresentationTable.getTableHeader().repaint();
                                    String[] reorderedData = {
                                        studentID, // Supervisee ID
                                        studentName, // Supervisee Name
                                        spvName, // Supervisor Name
                                        presentationSlot // Presentation Slot
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

    private void redirectPresentRqt(String id) {
        LecturerPresentationRequest request = new LecturerPresentationRequest(id, intakeCode, AssmntType, this);
        request.setVisible(true);
    }

    void selectPresentationPanel() {
        jTabbedPane1.setSelectedIndex(1);
    }

    private void showReport() {
        String fileNamex = "student_assessment.txt";
        String fileNamey = "assessment.txt";
        String fileNamez = "user.txt";
        String fileNamea = "ec.txt";

        DefaultTableModel model = (DefaultTableModel) reportTable.getModel();
        model.setRowCount(0); // Clear existing rows

        List<String> datax = FileHandler.readFile(fileNamex);
        List<String> datay = FileHandler.readFile(fileNamey);
        List<String> dataz = FileHandler.readFile(fileNamez);
        List<String> dataa = FileHandler.readFile(fileNamea);

        // Map to store studentID to studentName
        Map<String, String> studentNames = new HashMap<>();
        for (String linez : dataz) {
            String[] listz = linez.split(";");
            String studentID = listz[0];
            String studentName = listz[1];
            studentNames.put(studentID, studentName);
        }

        // Map to store studentID to EC status
        Map<String, String> ecStatus = new HashMap<>();
        for (String linea : dataa) {
            String[] lista = linea.split(";");
            String studentID = lista[0];
            boolean hasEC = Boolean.parseBoolean(lista[1]);
            String ecStatusString = hasEC ? "Approved" : "None";
            ecStatus.put(studentID, ecStatusString);
        }

        // Set to track added rows to avoid duplication
        Set<String> addedRows = new HashSet<>();

        for (String linex : datax) {
            String[] listx = linex.split(";");
            String studentID = listx[1];
            String assessmentID = listx[2];
            String submissionDate = listx[5];
            String resubmissionCount = listx[11];

            if (studentID != null) {
                String studentName = studentNames.get(studentID);
                String ecStatusString = ecStatus.getOrDefault(studentID, "None");
                if (studentName != null) {
                    for (String liney : datay) {
                        String[] listy = liney.split(";");
                        String currentAssessmentID = listy[0];
                        if (currentAssessmentID.equals(assessmentID) && currentAssessmentID.equals(AssmntID)) {
                            String spv = listy[4];
                            String secMarker = listy[5];

                            // Validate and adjust resubmissionCount
                            int resubCount;
                            try {
                                resubCount = Integer.parseInt(resubmissionCount);
                            } catch (NumberFormatException e) {
                                resubCount = 0; // Default to 0 if parsing fails
                            }

                            if (resubCount < 2) {
                                resubCount = 0;
                            } else {
                                resubCount -= 1;
                            }
                            String finalResubmissionCount = String.valueOf(resubCount);

                            String rowIdentifier = studentID + "-" + assessmentID;
                            if (!addedRows.contains(rowIdentifier)) {
                                if (spv.equals(user.getUserID()) && !listx[4].isEmpty() && listx[9].isEmpty()) { // supervisor
                                    // Check if listx[6] is 'marked'
                                    if (!"marked".equals(listx[6])) {
                                    String[] reorderedData = {
                                        studentID, // Supervisee ID
                                        studentName, // Supervisee Name
                                        submissionDate, // Submission Date
                                        ecStatusString, // EC Status                                        
                                        finalResubmissionCount // Resubmission Count
                                    };
                                    model.addRow(reorderedData);
                                    addedRows.add(rowIdentifier);
                                    }
                                } else if (secMarker.equals(user.getUserID()) && !listx[4].isEmpty() && listx[10].isEmpty()) { // second marker
                                    // Check if listx[6] is 'marked'
                                    if (!"marked".equals(listx[6])) {
                                        String[] reorderedData = {
                                            studentID, // second marker ID
                                            studentName, // second marker Name
                                            submissionDate, // Submission Date
                                            ecStatusString, // EC Status                                        
                                            finalResubmissionCount // Resubmission Count
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
    }

    private void redirectMarkedReport(String id, LecturerIntakePage intakePage) {
        LecturerMarkedReport marked = new LecturerMarkedReport(id, intakeCode, AssmntType, intakePage);
        marked.setVisible(true);
    }

    public void selectCommunicationPanel(int selection, String channelID) {
        // Check if the reply panel is currently displayed
        int replyPanelIndex = jTabbedPane1.indexOfComponent(lecreplyCommunicationScrollPanel);

        if (selection == 1) {
            if (replyPanelIndex != -1) {
                jTabbedPane1.removeTabAt(replyPanelIndex);
                jTabbedPane1.insertTab("Communication", null, lecCommunicationScrollPanel, null, replyPanelIndex);
                jTabbedPane1.setSelectedComponent(lecCommunicationScrollPanel);
            }
            jTabbedPane1.setSelectedIndex(3);
        } else {
            // Otherwise, proceed with the existing logic to display the reply panel
            int index = jTabbedPane1.indexOfComponent(lecCommunicationScrollPanel);
            jTabbedPane1.removeTabAt(index);
            jTabbedPane1.insertTab("Communication", null, lecreplyCommunicationScrollPanel, null, index);
            jTabbedPane1.setSelectedComponent(lecreplyCommunicationScrollPanel);
            readFromCommunicationMessage(channelID);
        }
    }

    private void showCreateDiscussionBtn() {
        createDiscussionBtn.setVisible(false);

        // Add ChangeListener to the JTabbedPane
        jTabbedPane1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // Check if the selected tab is the communicationScrollPanel
                int selectedIndex = jTabbedPane1.getSelectedIndex();
                if (selectedIndex == 3) {
                    createDiscussionBtn.setVisible(true);
                } else {
                    createDiscussionBtn.setVisible(false);
                }
            }
        });
    }

    private void readFromCommunicationChannel() {
        List<String> data = FileHandler.readFile("communication_channel.txt");

        // Clear the existing components from jPanel12 before adding new ones
        jPanel12.removeAll();
        jPanel12.setLayout(new BoxLayout(jPanel12, BoxLayout.Y_AXIS)); // Use a layout manager that supports dynamic content

        for (String line : data) {
            String[] list = line.split(";");
            if (list[2].equals(AssmntID)) {
                // Initialize components for each entry
                communicationPanel = new JPanel(new GridBagLayout());
                subject = new JLabel();
                openComBtn = new JButton();
                deleteComButton = new JButton();
                channelDate = new JLabel();
                communicationIcon = new JLabel();

                // Add border to communicationPanel
                communicationPanel.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                communicationPanel.setMaximumSize(new java.awt.Dimension(888, 68));
                communicationPanel.setMinimumSize(new java.awt.Dimension(888, 68));

                subject.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
                subject.setForeground(new java.awt.Color(2, 50, 99));
                subject.setText("<html>" + list[3] + "</html>");

                openComBtn.setBackground(new java.awt.Color(76, 127, 174));
                openComBtn.setFont(new java.awt.Font("Bell MT", 1, 12)); // NOI18N
                openComBtn.setForeground(new java.awt.Color(255, 255, 255));
                openComBtn.setText("Open");
                openComBtn.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        int index = jTabbedPane1.indexOfComponent(lecCommunicationScrollPanel);
                        jTabbedPane1.removeTabAt(index);
                        jTabbedPane1.insertTab("Communication", null, lecreplyCommunicationScrollPanel, null, index);
                        jTabbedPane1.setSelectedComponent(lecreplyCommunicationScrollPanel);
                        readFromCommunicationMessage(list[0]);
                    }
                });

                deleteComButton.setBackground(new java.awt.Color(76, 127, 174));
                deleteComButton.setFont(new java.awt.Font("Bell MT", 1, 12)); // NOI18N
                deleteComButton.setForeground(new java.awt.Color(255, 255, 255));
                deleteComButton.setText("Delete");
                deleteComButton.setVisible(list[1].equals(user.getUserID()));
                deleteComButton.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        int response = JOptionPane.showConfirmDialog(
                                null,
                                "Are you sure you want to delete this discussion channel",
                                "Confirm Delete",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.WARNING_MESSAGE
                        );
                        if (response == JOptionPane.YES_OPTION) {
                            CommunicationController delete = new CommunicationController();
                            boolean result = delete.deleteDiscussionChannel(list[0]);
                            if (result) {
                                JOptionPane.showMessageDialog(null, "Successfully delete the discussion channel");
                                redirectIntakePage(AssmntID, intakeCode, AssmntType, 2, null);
                            }
                        }
                    }
                });
                channelDate.setFont(
                        new java.awt.Font("Bell MT", 0, 18)); // NOI18N
                channelDate.setForeground(
                        new java.awt.Color(2, 50, 99));
                channelDate.setText(list[4]);

                communicationIcon.setIcon(
                        new javax.swing.ImageIcon(getClass().getResource("/chat1.png"))); // NOI18N

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(10, 10, 10, 10);

                // Add components to the panel with layout constraints
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.anchor = GridBagConstraints.WEST;

                communicationPanel.add(communicationIcon, gbc);

                gbc.gridx = 1;
                gbc.weightx = 1.0; // Allows the subject label to fill available space
                gbc.anchor = GridBagConstraints.WEST;

                communicationPanel.add(subject, gbc);

                gbc.gridx = 2;
                gbc.weightx = 0.0;
                gbc.anchor = GridBagConstraints.CENTER;

                communicationPanel.add(channelDate, gbc);

                gbc.gridx = 3;

                communicationPanel.add(openComBtn, gbc);

                gbc.gridx = 4;

                communicationPanel.add(deleteComButton, gbc);

                // Add each communicationPanel to jPanel12 with a vertical gap
                jPanel12.add(communicationPanel);

                jPanel12.add(Box.createVerticalStrut(10)); // Add vertical gap between each panel
            }
            lecCommunicationScrollPanel.setViewportView(jPanel12);
        }

        // Revalidate and repaint the container to reflect the changes
        jPanel12.revalidate();
        jPanel12.repaint();
    }

    private void readFromCommunicationMessage(String channelID) {
        List<String> data = FileHandler.readFile("communication_channel.txt");
        List<String> messageData = FileHandler.readFile("communication_message.txt");
        List<String> userData = FileHandler.readFile("user.txt");
        String channelSubject = null;
        LecturerIntakePage page = this;
        for (String line : data) {
            String[] list = line.split(";");
            if (list[0].equals(channelID)) {
                channelSubject = list[3];
                selectedSubject.setText("<html>" + list[3] + "</html>");
                createdDate.setText("<html>" + list[4] + "</html>");
                for (String FirstmessageLine : messageData) {
                    String[] FirstmessageList = FirstmessageLine.split(";");
                    if (FirstmessageList[1].equals(channelID)) {
                        createdMessage.setText("<html>" + FirstmessageList[3] + "</html>");
                        break;
                    }
                }
                for (String userLine : userData) {
                    String[] userList = userLine.split(";");
                    if (userList[0].equals(list[1])) {
                        createdName.setText(userList[1]);
                    }
                }
                reply.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        CreateNewMessagePage messagePage = new CreateNewMessagePage(AssmntID, AssmntType, list[3], list[0], null, page);
                        messagePage.setVisible(true);
                    }
                });

            }
        }

        // Ensure jPanel13 uses GridBagLayout
        jPanel13.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Remove all components from jPanel13 first, if necessary
        jPanel13.removeAll();

        // Add jPanel8 first (fixed at the top)
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0;
        jPanel13.add(jPanel18, gbc);

        // Add jPanel17 right below jPanel7
        gbc.gridy++;
        jPanel13.add(jPanel17, gbc);

        boolean firstMatchFound = false;
        int replyPanelY = gbc.gridy + 1; // Start placing reply panels below jPanel17

        for (String messageLine : messageData) {
            String[] messageList = messageLine.split(";");
            if (messageList[1].equals(channelID)) {
                if (firstMatchFound) {
                    communicationReplyPanel = new JPanel();
                    resubjectLabel = new JLabel();
                    replyMessage = new JLabel();
                    replyName = new JLabel();
                    replyDate = new JLabel();
                    deleteReply = new JLabel();

                    communicationReplyPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                    communicationReplyPanel.setPreferredSize(new java.awt.Dimension(766, 95));

                    resubjectLabel.setFont(new java.awt.Font("Bell MT", 0, 14)); // NOI18N
                    resubjectLabel.setForeground(new java.awt.Color(2, 50, 99));
                    resubjectLabel.setText("<html>" + "Re: " + channelSubject + "</html>");

                    replyMessage.setFont(new java.awt.Font("Bell MT", 0, 14)); // NOI18N
                    replyMessage.setForeground(new java.awt.Color(2, 50, 99));
                    replyMessage.setText("<html>" + messageList[3] + "</html>");
                    replyMessage.setPreferredSize(new java.awt.Dimension(563, 57));

                    for (String userLine : userData) {
                        String[] userList = userLine.split(";");
                        if (userList[0].equals(messageList[2])) {
                            replyName.setFont(new java.awt.Font("Bell MT", 0, 14)); // NOI18N
                            replyName.setForeground(new java.awt.Color(2, 50, 99));
                            replyName.setText("From: " + userList[1]);
                        }
                    }

                    replyDate.setFont(new java.awt.Font("Bell MT", 0, 14)); // NOI18N
                    replyDate.setForeground(new java.awt.Color(2, 50, 99));
                    replyDate.setText(messageList[4]);

                    deleteReply.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
                    deleteReply.setForeground(new java.awt.Color(2, 50, 99));
                    deleteReply.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    deleteReply.setText("Delete");
                    deleteReply.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                    deleteReply.setVisible(messageList[2].equals(user.getUserID()));
                    deleteReply.addMouseListener(new java.awt.event.MouseAdapter() {
                        @Override
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            int response = JOptionPane.showConfirmDialog(
                                    null,
                                    "Are you sure you want to delete this message",
                                    "Confirm Delete",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.WARNING_MESSAGE
                            );
                            if (response == JOptionPane.YES_OPTION) {
                                CommunicationController delete = new CommunicationController();
                                boolean result = delete.deleteMessage(messageList[0]);
                                if (result) {
                                    JOptionPane.showMessageDialog(null, "Successfully delete the message");
                                    redirectIntakePage(AssmntID, intakeCode, AssmntType, 3, messageList[1]);
                                }
                            }
                        }
                    });

                    // Set layout for communicationReplyPanel
                    GroupLayout communicationReplyPanelLayout = new GroupLayout(communicationReplyPanel);
                    communicationReplyPanel.setLayout(communicationReplyPanelLayout);
                    communicationReplyPanelLayout.setHorizontalGroup(
                            communicationReplyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(communicationReplyPanelLayout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(communicationReplyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                    .addGroup(communicationReplyPanelLayout.createSequentialGroup()
                                                            .addComponent(resubjectLabel)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(replyDate, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(communicationReplyPanelLayout.createSequentialGroup()
                                                            .addGroup(communicationReplyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                    .addComponent(replyMessage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(replyName, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE))
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(deleteReply, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
                                            .addContainerGap())
                    );
                    communicationReplyPanelLayout.setVerticalGroup(
                            communicationReplyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(communicationReplyPanelLayout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(communicationReplyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(resubjectLabel)
                                                    .addComponent(replyDate))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(replyName)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(communicationReplyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                    .addComponent(deleteReply, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(replyMessage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );

                    // Add communicationReplyPanel to jPanel13
                    gbc.gridy = replyPanelY++;
                    jPanel13.add(communicationReplyPanel, gbc);
                } else {
                    firstMatchFound = true;
                }
            }
        }

        // Finalize layout by adding vertical space and stretching the last component
        gbc.gridy = replyPanelY;
        gbc.weighty = 1.0;
        jPanel13.add(Box.createVerticalGlue(), gbc);

        // Revalidate and repaint jPanel13 to refresh the UI
        jPanel13.revalidate();
        jPanel13.repaint();

        // Update the scroll pane with the new content
        lecreplyCommunicationScrollPanel.setViewportView(jPanel13);

    }

    public void refreshContent() {
        //refreshing data
        revalidate();
        repaint();
    }

    private void redirectIntakePage(String assessmentID, String intakecode, String assessmentType, int number, String ID) {
        LecturerIntakePage intake = new LecturerIntakePage(assessmentID, intakecode, assessmentType);
        intake.setVisible(true);
        intake.selectCommunicationPanel(number, ID);
        this.setVisible(false);
    }

    private void showPeopleInfo() {
        List<String> StdData = FileHandler.readFile("user.txt");
        List<String> AssmntData = FileHandler.readFile("student_assessment.txt");
        boolean StudentFound = false;

        // Create a panel to hold all assessment panels
        stdContentPanel = new JPanel();
        stdContentPanel.setLayout(new BoxLayout(stdContentPanel, BoxLayout.Y_AXIS));
        stdContentPanel.add(Box.createVerticalStrut(5));
        stdContentPanel.setBackground(Color.WHITE);

        for (String line : StdData) {
            for (String lines : AssmntData) {
                String[] StdList = line.split(";");
                String[] AssmntList = lines.split(";");
                if (AssmntList[1].equals(StdList[0]) && AssmntID.equals(AssmntList[2])) {
                    PeoplePanel = new JPanel();
                    PeoplePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                    PeoplePanel.setMaximumSize(new java.awt.Dimension(884, 41));
                    PeoplePanel.setMinimumSize(new java.awt.Dimension(884, 41));
                    PeoplePanel.setPreferredSize(new java.awt.Dimension(884, 41));

                    StatusLabel = new JLabel();
                    StatusLabel.setOpaque(true);
                    StatusLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
                    StatusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    switch (AssmntList[6]) {
                        case "pending" -> {
                            StatusLabel.setText("in progress");
                            StatusLabel.setBackground(new java.awt.Color(255, 255, 0));
                        }
                        case "submitted" -> {
                            StatusLabel.setText("in progress");
                            StatusLabel.setBackground(new java.awt.Color(255, 255, 0));
                        }
                        case "partially marked" -> {
                            StatusLabel.setText("in progress");
                            StatusLabel.setBackground(new java.awt.Color(255, 255, 0));
                        }
                        case "marked" -> {
                            StatusLabel.setText("completed");
                            StatusLabel.setBackground(new java.awt.Color(102, 255, 102));
                        }
                    }

                    StdIDLabel = new JLabel();
                    StdIDLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
                    StdIDLabel.setForeground(new java.awt.Color(2, 50, 99));
                    String stdID = AssmntList[1];
                    StdIDLabel.setText(stdID);

                    StdNameLabel = new JLabel();
                    StdNameLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
                    StdNameLabel.setForeground(new java.awt.Color(2, 50, 99));
                    StdNameLabel.setText(StdList[1]);

                    PeopleViewBtn = new JButton();
                    PeopleViewBtn.setBackground(new java.awt.Color(76, 127, 174));
                    PeopleViewBtn.setFont(new java.awt.Font("Bell MT", 1, 14)); // NOI18N
                    PeopleViewBtn.setForeground(new java.awt.Color(255, 255, 255));
                    PeopleViewBtn.setText("View");
                    PeopleViewBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            LecturerPeopleProfile profile = new LecturerPeopleProfile(stdID);
                            profile.setVisible(true);
                        }
                    });

                    javax.swing.GroupLayout PeoplePanelLayout = new javax.swing.GroupLayout(PeoplePanel);
                    PeoplePanel.setLayout(PeoplePanelLayout);
                    PeoplePanelLayout.setHorizontalGroup(
                            PeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PeoplePanelLayout.createSequentialGroup()
                                            .addGap(38, 38, 38)
                                            .addComponent(StdIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(72, 72, 72)
                                            .addComponent(StdNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 309, Short.MAX_VALUE)
                                            .addComponent(StatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(PeopleViewBtn)
                                            .addGap(22, 22, 22))
                    );
                    PeoplePanelLayout.setVerticalGroup(
                            PeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PeoplePanelLayout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(PeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(StdIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(StdNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(StatusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(PeopleViewBtn))
                                            .addContainerGap())
                    );

                    stdContentPanel.add(PeoplePanel);
                    stdContentPanel.add(Box.createVerticalStrut(5));
                    peoplePanel.add(stdContentPanel);
                    people.add(PeoplePanel);
                    StudentFound = true;

                }
            }
        }
        if (!StudentFound) {
            JLabel noStdtLabel = new JLabel("No Student Assigned");
            noStdtLabel.setFont(new java.awt.Font("SansSerif", 1, 16));
            noStdtLabel.setForeground(new java.awt.Color(2, 50, 99));

            // Center the label horizontally and vertically
            noStdtLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            noStdtLabel.setAlignmentY(Component.CENTER_ALIGNMENT);

            stdContentPanel.add(noStdtLabel);
        }

        // Set the viewport view to the PeoplePanel
        stdPeopleList.setViewportView(stdContentPanel);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AssmntDueLabel;
    private javax.swing.JLabel CmpltPresentLabel;
    private javax.swing.JLabel IntakeLabel;
    private javax.swing.JLabel LecLogOutLabel;
    private javax.swing.JLabel LecProfileLabel;
    private javax.swing.JLabel MarkedRptLabel;
    private javax.swing.JLabel NoStdLabel;
    private javax.swing.JLabel NotiLabel;
    private javax.swing.JTable SchdPresentationTable;
    private javax.swing.JLabel SumRptLabel;
    private javax.swing.JLabel TotalSubmsnLabel;
    private javax.swing.JLabel backIcon;
    private javax.swing.JButton createDiscussionBtn;
    private javax.swing.JLabel createdDate;
    private javax.swing.JLabel createdMessage;
    private javax.swing.JLabel createdName;
    private javax.swing.JPanel intakeDetails;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JScrollPane lecCommunicationScrollPanel;
    private javax.swing.JScrollPane lecreplyCommunicationScrollPanel;
    private javax.swing.JPanel peoplePanel;
    private javax.swing.JLabel reply;
    private javax.swing.JTable reportTable;
    private javax.swing.JPanel schdPresentationList;
    private javax.swing.JLabel selectedSubject;
    private javax.swing.JScrollPane stdPeopleList;
    private javax.swing.JPanel submittedReportList;
    private javax.swing.JLabel syscoLogo;
    private javax.swing.JLabel viewMarkedRptLabel;
    private javax.swing.JLabel viewPresentRqtLabel;
    // End of variables declaration//GEN-END:variables
}
