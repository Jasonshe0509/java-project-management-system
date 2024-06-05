/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.projectmanagementsystem;

import com.mycompany.projectmanagementsystem.Presentation.PresentationTableActionEvent;
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
 * @author user
 */
public class lect_PresentationPanelAction extends javax.swing.JPanel {

    
    private int row = 0;
    public lect_PresentationPanelAction() {
        initComponents();
    }

    public class PanelActionRenderer extends DefaultTableCellRenderer {
        
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            lect_PresentationPanelAction action = new lect_PresentationPanelAction();
            if (isSelected == false && row % 2 == 0) {
                action.setBackground(Color.WHITE);
            } else {
                action.setBackground(com.getBackground());
            }
            return action;

        }
    }
        
    public class TableActionCellEditor extends DefaultCellEditor {
        private PresentationTableActionEvent event;
        public TableActionCellEditor(PresentationTableActionEvent event) {
            super(new JCheckBox());
            this.event = event;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            lect_PresentationPanelAction action = new lect_PresentationPanelAction();
            action.initEvent(event, row, value);
            action.setBackground(table.getSelectionBackground());
            if (isSelected == true){
                System.out.println(row);
            }
            return action;
        }
    }
        public void initEvent(PresentationTableActionEvent event, int row , Object value) {
            feedbackBtn.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    event.presentationFeedback(row, value);
                }
            });
            doneBtn.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    event.presentationDone(row, value);
                }
        });
    }
 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        feedbackBtn = new javax.swing.JButton();
        doneBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(170, 31));
        setMinimumSize(new java.awt.Dimension(170, 31));
        setPreferredSize(new java.awt.Dimension(170, 31));

        feedbackBtn.setBackground(new java.awt.Color(76, 127, 174));
        feedbackBtn.setFont(new java.awt.Font("Bell MT", 1, 12)); // NOI18N
        feedbackBtn.setForeground(new java.awt.Color(255, 255, 255));
        feedbackBtn.setText("Feedback");
        feedbackBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        feedbackBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        feedbackBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        feedbackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feedbackBtnActionPerformed(evt);
            }
        });

        doneBtn.setBackground(new java.awt.Color(51, 199, 146));
        doneBtn.setFont(new java.awt.Font("Bell MT", 1, 12)); // NOI18N
        doneBtn.setForeground(new java.awt.Color(255, 255, 255));
        doneBtn.setText("Done");
        doneBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        doneBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        doneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(feedbackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(doneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(feedbackBtn)
                    .addComponent(doneBtn))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void doneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneBtnActionPerformed

    }//GEN-LAST:event_doneBtnActionPerformed

    private void feedbackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feedbackBtnActionPerformed

    }//GEN-LAST:event_feedbackBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton doneBtn;
    private javax.swing.JButton feedbackBtn;
    // End of variables declaration//GEN-END:variables
}
