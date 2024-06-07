/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.projectmanagementsystem;

import com.mycompany.projectmanagementsystem.Assessment.ReportTableActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ASUS
 */
public class PM_delete_ActionPanel extends javax.swing.JPanel {

    /**
     * Creates new form StudentECActionPanel
     */
    private int row = 0;
    public PM_delete_ActionPanel() {
        initComponents();
    }

    public class rPanelActionRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            PM_delete_ActionPanel action = new PM_delete_ActionPanel();
            if (!isSelected && row % 2 == 0) {
                action.setBackground(Color.WHITE);
            } else {
                action.setBackground(com.getBackground());
            }
            return action;
        }
    }

    public class TableActionCellEditor extends DefaultCellEditor {
        private ReportTableActionEvent event;

        public TableActionCellEditor(ReportTableActionEvent event) {
            super(new JCheckBox());
            this.event = event;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            PM_delete_ActionPanel action = new PM_delete_ActionPanel();
            action.initEvent(event, row, value);
            action.setBackground(table.getSelectionBackground());
            return action;
        }
    }
    
    public void initEvent(ReportTableActionEvent event, int row, Object value) {
        delete_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.report_Delete(row, value);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        delete_button = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(150, 33));
        setMinimumSize(new java.awt.Dimension(150, 33));
        setPreferredSize(new java.awt.Dimension(150, 33));

        delete_button.setBackground(new java.awt.Color(0, 153, 153));
        delete_button.setFont(new java.awt.Font("Bell MT", 1, 12)); // NOI18N
        delete_button.setForeground(new java.awt.Color(255, 255, 255));
        delete_button.setText("Delete");
        delete_button.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        delete_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        delete_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(delete_button, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(delete_button)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delete_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delete_button;
    // End of variables declaration//GEN-END:variables
}