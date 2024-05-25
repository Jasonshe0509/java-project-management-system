/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.projectmanagementsystem;

import com.mycompany.projectmanagementsystem.User.UserTableActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ASUS
 */
public class UserTableActionPanel extends javax.swing.JPanel {

    /**
     * Creates new form UserTableActionPanel
     */
    private int row = 0;

    public UserTableActionPanel() {
        initComponents();
    }

    public class rPanelActionRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            UserTableActionPanel action = new UserTableActionPanel();
            if (isSelected == false && row % 2 == 0) {
                action.setBackground(Color.WHITE);
            } else {
                action.setBackground(com.getBackground());
            }
            return action;

        }
    }

    public class UserTableActionCellEditor extends DefaultCellEditor {

        private UserTableActionEvent event;

        public UserTableActionCellEditor(UserTableActionEvent event) {
            super(new JCheckBox());
            this.event = event;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            UserTableActionPanel action = new UserTableActionPanel();
            action.initEvent(event, row, value);
            action.setBackground(table.getSelectionBackground());

            return action;
        }
    }

//    public class UserTableAction extends JButton {
//
//        private boolean mouseClick;
//
//        public UserTableAction() {
//            setContentAreaFilled(false); //to remove background
//            setBorder(new EmptyBorder(3, 3, 3, 3));
//            addMouseListener(new MouseAdapter() {
//                @Override
//                public void mousePressed(MouseEvent e) {
//                    mouseClick = true;
//                }
//
//                @Override
//                public void mouseReleased(MouseEvent e) {
//                    mouseClick = false;
//                }
//
//            });
//        }
//}

        public void initEvent(UserTableActionEvent event, int row, Object value) {

            view_button.addMouseListener(new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e) {
                    event.userView(row, value);
                }
            });

            delete_button.addMouseListener(new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e) {
                    event.userDelete(row, value);
                }
            });
        }

        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        view_button = new javax.swing.JLabel();
        delete_button = new javax.swing.JLabel();

        view_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_icon.png"))); // NOI18N
        view_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        delete_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete_icon.png"))); // NOI18N
        delete_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(view_button)
                .addGap(39, 39, 39)
                .addComponent(delete_button)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(delete_button)
                    .addComponent(view_button))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel delete_button;
    private javax.swing.JLabel view_button;
    // End of variables declaration//GEN-END:variables
}

