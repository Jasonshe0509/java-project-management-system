package com.mycompany.projectmanagementsystem;

import java.awt.Toolkit;

public class admin_register_schoolwiselist extends javax.swing.JFrame {

    public admin_register_schoolwiselist() {
        initComponents();
        setIconImage();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        admin_register_schoolwise_title = new javax.swing.JLabel();
        school_wise_title = new javax.swing.JLabel();
        school_wise = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        back = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Register School Wise ");
        setMaximumSize(new java.awt.Dimension(500, 300));
        setMinimumSize(new java.awt.Dimension(500, 300));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admin_register_schoolwise_title.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        admin_register_schoolwise_title.setForeground(new java.awt.Color(2, 50, 99));
        admin_register_schoolwise_title.setText("Register New School Wise List");
        getContentPane().add(admin_register_schoolwise_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        school_wise_title.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        school_wise_title.setForeground(new java.awt.Color(2, 50, 99));
        school_wise_title.setText("New School Wise:");
        getContentPane().add(school_wise_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        school_wise.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        school_wise.setForeground(new java.awt.Color(2, 50, 99));
        school_wise.setToolTipText("e.g. APU2F2402CS");
        getContentPane().add(school_wise, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 150, -1));

        submit.setBackground(new java.awt.Color(76, 127, 174));
        submit.setFont(new java.awt.Font("Bell MT", 1, 19)); // NOI18N
        submit.setText("SUBMIT");
        getContentPane().add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, -1));

        back.setBackground(new java.awt.Color(76, 127, 174));
        back.setFont(new java.awt.Font("Bell MT", 1, 19)); // NOI18N
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        background.setMaximumSize(new java.awt.Dimension(500, 300));
        background.setMinimumSize(new java.awt.Dimension(500, 300));
        background.setOpaque(true);
        background.setPreferredSize(new java.awt.Dimension(500, 300));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_register_schoolwiselist().setVisible(true);
            }
        });
    }
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel admin_register_schoolwise_title;
    private javax.swing.JButton back;
    private javax.swing.JLabel background;
    private javax.swing.JTextField school_wise;
    private javax.swing.JLabel school_wise_title;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}