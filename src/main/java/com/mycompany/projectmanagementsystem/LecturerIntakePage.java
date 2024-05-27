/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projectmanagementsystem;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import com.mycompany.projectmanagementsystem.GeneralFunction.SessionManager;
import com.mycompany.projectmanagementsystem.Presentation.PresentationController;
import com.mycompany.projectmanagementsystem.Presentation.PresentationTableActionEvent;
import com.mycompany.projectmanagementsystem.User.User;
import com.mycompany.projectmanagementsystem.User.UserController;
import com.mycompany.projectmanagementsystem.lect_PresentationPanelAction.PanelActionRenderer;
import com.mycompany.projectmanagementsystem.lect_ReportPanelAction.rPanelActionRenderer;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
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
    private JPanel stdContentPanel;
    private JPanel PeoplePanel;
    private JButton PeopleViewBtn;
    private JLabel StatusLabel;
    private JLabel StdIDLabel;
    private JLabel StdNameLabel;
    List<JPanel> people = new ArrayList<JPanel>();
    
    public LecturerIntakePage(String AssmntID, String intakeCode) {
        this.intakeCode = intakeCode;
        this.AssmntID = AssmntID;
        initComponents();
        setIconImage();
        showAssmnt();
        IntakeLabel.setText(intakeCode);
        showNoStd();    
        showAssmntDueDate();
        showTotalSubmission();
        showPeopleInfo();
        showPresentation();
        readPresentationFromFile();
        
        // Set preferred width for each column in presentation tab
        int[] columnWidths1 = {100, 170, 170, 200, 170}; 
        int numColumns1 = SchdPresentationTable.getColumnCount();
        for (int i = 0; i < numColumns1; i++) {
            TableColumn column = SchdPresentationTable.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths1[i]);
        }
        
        // Set preferred width for each column in report tab
        int[] columnWidths2 = {110, 160, 190, 150, 110, 170}; 
        int numColumns2 = jTable2.getColumnCount();
        for (int i = 0; i < numColumns2; i++) {
            TableColumn column = jTable2.getColumnModel().getColumn(i);
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
        
        for (int i = 0; i < jTable2.getColumnCount(); i++) {
            jTable2.getColumnModel().getColumn(i).setCellRenderer(new WhiteBackgroundRenderer());           
        }
        
        SchdPresentationTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));
        SchdPresentationTable.getTableHeader().setForeground(new Color(2, 50, 99));
        ((DefaultTableCellRenderer)SchdPresentationTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        
        lect_ReportPanelAction rpanel = new lect_ReportPanelAction();
        jTable2.getColumnModel().getColumn(5).setCellRenderer(rpanel.new rPanelActionRenderer());
        jTable2.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        jTable2.getTableHeader().setForeground(new Color(2, 50, 99));
        ((DefaultTableCellRenderer)jTable2.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
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
                LecturerPresentationFeedback pfeedback = new LecturerPresentationFeedback(AssmntID ,stdID, name, marker, presentSlot);
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
                            boolean result = action.spvPresentationDone(stdID, "completed");
                            if (result) {
                                model.removeRow(row);
                                JOptionPane.showMessageDialog(null, 
                                        "Presentation from supervisee (" + stdID + ") has been marked done with feedback.");
                            }
                            return; // No need to continue the loop once a match is found
                        } else if (user.getUserID().equals(list[5])) { // Second Marker
                            boolean result = action.secMarkPresentationDone(stdID);
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
        SchdPresentationTable.getColumnModel().getColumn(4).setCellRenderer(ppanel.new PanelActionRenderer());
        SchdPresentationTable.getColumnModel().getColumn(4).setCellEditor(ppanel.new TableActionCellEditor(event));

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
        jPanel2 = new javax.swing.JPanel();
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
        SchdPresentLabel = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        CmpltPresentLabel = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SchdPresentationTable = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        viewPresentRqtLabel = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel12 = new javax.swing.JPanel();
        commChannelPanel = new javax.swing.JPanel();
        SubjectLabel = new javax.swing.JLabel();
        CommOpenBtn = new javax.swing.JButton();
        CommDltBtn = new javax.swing.JButton();
        CommDateLabel = new javax.swing.JLabel();
        CommIconLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel13 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        syscoLogo = new javax.swing.JLabel();
        LecLogOutLabel = new javax.swing.JLabel();
        LecProfileLabel = new javax.swing.JLabel();
        NotiLabel = new javax.swing.JLabel();
        SumRptLabel = new javax.swing.JLabel();
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

        jPanel2.setBackground(new java.awt.Color(217, 217, 217));

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
        jLabel12.setText("Scheduled Presentation");

        SchdPresentLabel.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        SchdPresentLabel.setForeground(new java.awt.Color(2, 50, 99));
        SchdPresentLabel.setMaximumSize(new java.awt.Dimension(330, 26));
        SchdPresentLabel.setMinimumSize(new java.awt.Dimension(330, 26));
        SchdPresentLabel.setPreferredSize(new java.awt.Dimension(330, 26));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel12)
                .addGap(173, 173, 173)
                .addComponent(SchdPresentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(SchdPresentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.setMaximumSize(new java.awt.Dimension(836, 60));
        jPanel10.setMinimumSize(new java.awt.Dimension(836, 60));
        jPanel10.setPreferredSize(new java.awt.Dimension(836, 60));

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(2, 50, 99));
        jLabel13.setText("Completed Presentation");

        CmpltPresentLabel.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        CmpltPresentLabel.setForeground(new java.awt.Color(2, 50, 99));
        CmpltPresentLabel.setMaximumSize(new java.awt.Dimension(330, 26));
        CmpltPresentLabel.setMinimumSize(new java.awt.Dimension(330, 26));
        CmpltPresentLabel.setPreferredSize(new java.awt.Dimension(330, 26));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel13)
                .addGap(171, 171, 171)
                .addComponent(CmpltPresentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(CmpltPresentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Details", jPanel2);

        jPanel7.setBackground(new java.awt.Color(217, 217, 217));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        SchdPresentationTable.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        SchdPresentationTable.setForeground(new java.awt.Color(2, 50, 99));
        SchdPresentationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supervisee ID", "Name", "Marker", "Presentation Slot", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SchdPresentationTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SchdPresentationTable.setGridColor(new java.awt.Color(0, 0, 0));
        SchdPresentationTable.setRowHeight(30);
        SchdPresentationTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        SchdPresentationTable.setSelectionForeground(new java.awt.Color(2, 50, 99));
        SchdPresentationTable.setShowGrid(false);
        SchdPresentationTable.setShowHorizontalLines(true);
        SchdPresentationTable.getTableHeader().setResizingAllowed(false);
        SchdPresentationTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(SchdPresentationTable);

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

        jLabel20.setFont(new java.awt.Font("Bell MT", 1, 22)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(2, 50, 99));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Scheduled Presentation");

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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(viewPresentRqtLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewPresentRqtLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Presentation", jPanel7);

        jPanel11.setBackground(new java.awt.Color(217, 217, 217));

        jLabel22.setFont(new java.awt.Font("Bell MT", 1, 22)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(2, 50, 99));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Report Marking");

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jTable2.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jTable2.setForeground(new java.awt.Color(2, 50, 99));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Supervisee ID", "Name", "Submission Date", "EC Status", "Resubmission", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable2.setGridColor(new java.awt.Color(0, 0, 0));
        jTable2.setRowHeight(30);
        jTable2.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable2.setSelectionForeground(new java.awt.Color(2, 50, 99));
        jTable2.setShowGrid(false);
        jTable2.setShowHorizontalLines(true);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Report", jPanel11);

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        commChannelPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        commChannelPanel.setMaximumSize(new java.awt.Dimension(888, 68));
        commChannelPanel.setMinimumSize(new java.awt.Dimension(888, 68));
        commChannelPanel.setPreferredSize(new java.awt.Dimension(888, 68));

        SubjectLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        SubjectLabel.setForeground(new java.awt.Color(2, 50, 99));
        SubjectLabel.setText("Subject");

        CommOpenBtn.setBackground(new java.awt.Color(76, 127, 174));
        CommOpenBtn.setFont(new java.awt.Font("Bell MT", 1, 12)); // NOI18N
        CommOpenBtn.setForeground(new java.awt.Color(255, 255, 255));
        CommOpenBtn.setText("Open");
        CommOpenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CommOpenBtnActionPerformed(evt);
            }
        });

        CommDltBtn.setBackground(new java.awt.Color(76, 127, 174));
        CommDltBtn.setFont(new java.awt.Font("Bell MT", 1, 12)); // NOI18N
        CommDltBtn.setForeground(new java.awt.Color(255, 255, 255));
        CommDltBtn.setText("Delete");
        CommDltBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CommDltBtnActionPerformed(evt);
            }
        });

        CommDateLabel.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        CommDateLabel.setForeground(new java.awt.Color(2, 50, 99));
        CommDateLabel.setText("Date");

        CommIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chat1.png"))); // NOI18N
        CommIconLabel.setText("jLabel29");

        javax.swing.GroupLayout commChannelPanelLayout = new javax.swing.GroupLayout(commChannelPanel);
        commChannelPanel.setLayout(commChannelPanelLayout);
        commChannelPanelLayout.setHorizontalGroup(
            commChannelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commChannelPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(CommIconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(SubjectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 366, Short.MAX_VALUE)
                .addComponent(CommDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CommOpenBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CommDltBtn)
                .addGap(29, 29, 29))
        );
        commChannelPanelLayout.setVerticalGroup(
            commChannelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commChannelPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(commChannelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(commChannelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CommOpenBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CommDltBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(commChannelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CommIconLabel)
                        .addComponent(SubjectLabel)
                        .addComponent(CommDateLabel)))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(commChannelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(commChannelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(799, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel12);

        jTabbedPane1.addTab("Communication", jScrollPane3);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 922, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
        );

        jScrollPane4.setViewportView(jPanel13);

        jTabbedPane1.addTab("People", jScrollPane4);

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        jLabel1.setText("background");
        jLabel1.setPreferredSize(new java.awt.Dimension(1000, 700));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CommOpenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CommOpenBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CommOpenBtnActionPerformed

    private void CommDltBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CommDltBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CommDltBtnActionPerformed

    private void syscoLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_syscoLogoMouseClicked
        LecturerDashboardPage dashboard = new LecturerDashboardPage();
        dashboard.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_syscoLogoMouseClicked

    private void SumRptLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SumRptLabelMouseClicked
        this.setVisible(false);
        LecturerSummaryReport lectSumRpt = new LecturerSummaryReport();
        lectSumRpt.setVisible(true);
    }//GEN-LAST:event_SumRptLabelMouseClicked

    private void NotiLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NotiLabelMouseClicked
        this.setVisible(false);
        NotificationPage lectNoti = new NotificationPage();
        lectNoti.setVisible(true);
    }//GEN-LAST:event_NotiLabelMouseClicked

    private void LecProfileLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LecProfileLabelMouseClicked
        this.setVisible(false);
        LecturerProfile profile = new LecturerProfile();
        profile.setVisible(true);
    }//GEN-LAST:event_LecProfileLabelMouseClicked

    private void LecLogOutLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LecLogOutLabelMouseClicked
        int confirm = JOptionPane.showConfirmDialog(null, "Are you confirmed to log out?", 
                    "Confirmation", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            this.setVisible(false);
            UserController logout = new UserController();
            logout.userLogout();
        } else {}
    }//GEN-LAST:event_LecLogOutLabelMouseClicked

    private void viewPresentRqtLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewPresentRqtLabelMouseClicked
        redirectPresentRqt(AssmntID);
    }//GEN-LAST:event_viewPresentRqtLabelMouseClicked

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
                new LecturerIntakePage("intake", "assessmentID").setVisible(true);
            }
        });
    }
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon_with_background.png")));
    }
    
    private void showAssmnt(){
        List<String> AssmntData = FileHandler.readFile("assessment.txt");
        
        for (String line : AssmntData) {
            String[] AssmntList = line.split(";");
            if (user.getUserID().equals(AssmntList[4])) {
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
    
    private void showNoStd(){
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
    
    private void showAssmntDueDate(){
        List<String> AssmntData = FileHandler.readFile("assessment.txt");
        
        for (String line : AssmntData) {
            String[] AssmntList = line.split(";");
            AssmntDueLabel.setText(AssmntList[3]);
        }            
    }
    
    private void showTotalSubmission(){
        List<String> StdAssmntData = FileHandler.readFile("student_assessment.txt");
        int stdSubCount = 0;
        
        for (String line : StdAssmntData) {
                String[] StdAssmntList = line.split(";");
                if (AssmntID.equals(StdAssmntList[2]) && "submitted".equals(StdAssmntList[6])) {
                    stdSubCount++;
                }                      
            }
            TotalSubmsnLabel.setText(Integer.toString(stdSubCount));
        }     
    private void showPresentation(){
        List<String> presentationData = FileHandler.readFile("presentation_confirmation.txt");
        int schdPresentationCount = 0;
        int cmpltPresentationCount = 0;
        
        for (String line : presentationData) {
                String[] presentationList = line.split(";");
                if (AssmntID.equals(presentationList[2])) {
                    if ("scheduled".equals(presentationList[5])){
                       schdPresentationCount++; 
                    } else                   
                    if ("completed".equals(presentationList[5])) {
                        cmpltPresentationCount++;
                    }
}
            SchdPresentLabel.setText(Integer.toString(schdPresentationCount));
            CmpltPresentLabel.setText(Integer.toString(cmpltPresentationCount));
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
                                SchdPresentationTable.getColumnModel().getColumn(2).setHeaderValue("Second Marker");
                                SchdPresentationTable.getTableHeader().repaint();
                                String[] reorderedData = {
                                    studentID,       // Supervisee ID
                                    studentName,     // Supervisee Name
                                    SecMarkerName,   // Second Marker Name
                                    presentationSlot // Presentation Slot
                                };
                                model.addRow(reorderedData);
                                addedRows.add(rowIdentifier);
                            } else if (secMarker.equals(user.getUserID())) {
                                SchdPresentationTable.getColumnModel().getColumn(2).setHeaderValue("Supervisor");
                                SchdPresentationTable.getTableHeader().repaint();
                                String[] reorderedData = {
                                    studentID,       // Supervisee ID
                                    studentName,     // Supervisee Name
                                    spvName,         // Supervisor Name
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

    private void redirectPresentRqt(String id){
        LecturerPresentationRequest request = new LecturerPresentationRequest(id, intakeCode);
        request.setVisible(true);
        this.setVisible(false);
    }
    private void showCommChannel(){
        List<String> CommChannelData = FileHandler.readFile("communication_channel.txt");
        Collections.reverse(CommChannelData);
        boolean CommChannelFound = false;
        
        for (String line : CommChannelData) {
            String[] CommChannelList = line.split(";");
            if (user.getUserID().equals(CommChannelList[4])) {
                commChannelPanel = new JPanel();
                commChannelPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                commChannelPanel.setMaximumSize(new java.awt.Dimension(888, 68));
                commChannelPanel.setMinimumSize(new java.awt.Dimension(888, 68));
                commChannelPanel.setPreferredSize(new java.awt.Dimension(888, 68));
                
                SubjectLabel = new JLabel();
                SubjectLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
                SubjectLabel.setForeground(new java.awt.Color(2, 50, 99));
                SubjectLabel.setText("Subject");
                
                CommOpenBtn = new JButton();
                CommOpenBtn.setBackground(new java.awt.Color(76, 127, 174));
                CommOpenBtn.setFont(new java.awt.Font("Bell MT", 1, 12)); // NOI18N
                CommOpenBtn.setForeground(new java.awt.Color(255, 255, 255));
                CommOpenBtn.setText("Open");
                CommOpenBtn.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        CommOpenBtnActionPerformed(evt);
                    }
                });
                
                CommDltBtn = new JButton();
                CommDltBtn.setBackground(new java.awt.Color(76, 127, 174));
                CommDltBtn.setFont(new java.awt.Font("Bell MT", 1, 12)); // NOI18N
                CommDltBtn.setForeground(new java.awt.Color(255, 255, 255));
                CommDltBtn.setText("Delete");
                CommDltBtn.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        CommDltBtnActionPerformed(evt);
                    }
                });
                
                CommDateLabel = new JLabel();
                CommDateLabel.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
                CommDateLabel.setForeground(new java.awt.Color(2, 50, 99));
                CommDateLabel.setText("Date");
                
                CommIconLabel = new JLabel();
                CommIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chat1.png"))); // NOI18N
                CommIconLabel.setText("jLabel29");

                javax.swing.GroupLayout commChannelPanelLayout = new javax.swing.GroupLayout(commChannelPanel);
                commChannelPanel.setLayout(commChannelPanelLayout);
                commChannelPanelLayout.setHorizontalGroup(
                    commChannelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(commChannelPanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(CommIconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(SubjectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 366, Short.MAX_VALUE)
                        .addComponent(CommDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CommOpenBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CommDltBtn)
                        .addGap(29, 29, 29))
                );
                commChannelPanelLayout.setVerticalGroup(
                    commChannelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(commChannelPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(commChannelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(commChannelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CommOpenBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CommDltBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(commChannelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CommIconLabel)
                                .addComponent(SubjectLabel)
                                .addComponent(CommDateLabel)))
                        .addContainerGap(11, Short.MAX_VALUE))
                );        
            }
        
        }
    }
    
    private void showPeopleInfo(){
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
                    StatusLabel.setText(AssmntList[6]);
                    StatusLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
                    StatusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    switch (AssmntList[6]) {
                        case "pending" -> {
                            StatusLabel.setBackground(new java.awt.Color(255, 255, 0));                            
                        }
                        case "submitted" -> {
                            StatusLabel.setBackground(new java.awt.Color(102, 255, 102));                            
                        }
                        case "marked" -> {
                            StatusLabel.setBackground(new java.awt.Color(0, 204, 0));                            
                        }
                    } 
                    
                    StdIDLabel = new JLabel();
                    StdIDLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
                    StdIDLabel.setForeground(new java.awt.Color(2, 50, 99));
                    StdIDLabel.setText(AssmntList[1]);
                    
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
                    jPanel13.add(stdContentPanel);
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
        jScrollPane4.setViewportView(stdContentPanel);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AssmntDueLabel;
    private javax.swing.JLabel CmpltPresentLabel;
    private javax.swing.JLabel CommDateLabel;
    private javax.swing.JButton CommDltBtn;
    private javax.swing.JLabel CommIconLabel;
    private javax.swing.JButton CommOpenBtn;
    private javax.swing.JLabel IntakeLabel;
    private javax.swing.JLabel LecLogOutLabel;
    private javax.swing.JLabel LecProfileLabel;
    private javax.swing.JLabel NoStdLabel;
    private javax.swing.JLabel NotiLabel;
    private javax.swing.JLabel SchdPresentLabel;
    private javax.swing.JTable SchdPresentationTable;
    private javax.swing.JLabel SubjectLabel;
    private javax.swing.JLabel SumRptLabel;
    private javax.swing.JLabel TotalSubmsnLabel;
    private javax.swing.JPanel commChannelPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel syscoLogo;
    private javax.swing.JLabel viewPresentRqtLabel;
    // End of variables declaration//GEN-END:variables
}
