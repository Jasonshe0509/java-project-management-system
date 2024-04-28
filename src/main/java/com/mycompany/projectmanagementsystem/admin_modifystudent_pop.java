package com.mycompany.projectmanagementsystem;

import java.awt.Toolkit;

public class admin_modifystudent_pop extends javax.swing.JFrame {


    public admin_modifystudent_pop() {
        initComponents();
        setIconImage();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        admin_modify_student_instruction = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        admin_stumanage_viewbutton = new javax.swing.JButton();
        admin_stumanage_modifybutton = new javax.swing.JButton();
        admin_modifystudent_pop = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Choose an action for this record.");
        setMinimumSize(new java.awt.Dimension(500, 300));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admin_modify_student_instruction.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        admin_modify_student_instruction.setForeground(new java.awt.Color(2, 50, 99));
        admin_modify_student_instruction.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_modify_student_instruction.setText("Please Choose An Action For This Record:");
        getContentPane().add(admin_modify_student_instruction, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 500, 70));

        jLabel1.setText("studentname, tpno");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, -1, -1));

        admin_stumanage_viewbutton.setBackground(new java.awt.Color(76, 127, 174));
        admin_stumanage_viewbutton.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        admin_stumanage_viewbutton.setForeground(new java.awt.Color(2, 50, 99));
        admin_stumanage_viewbutton.setText("VIEW");
        getContentPane().add(admin_stumanage_viewbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, -1, -1));

        admin_stumanage_modifybutton.setBackground(new java.awt.Color(76, 127, 174));
        admin_stumanage_modifybutton.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        admin_stumanage_modifybutton.setForeground(new java.awt.Color(2, 50, 99));
        admin_stumanage_modifybutton.setText("MODIFY");
        getContentPane().add(admin_stumanage_modifybutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, -1, -1));

        admin_modifystudent_pop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_background.png"))); // NOI18N
        admin_modifystudent_pop.setMaximumSize(new java.awt.Dimension(500, 300));
        admin_modifystudent_pop.setMinimumSize(new java.awt.Dimension(500, 300));
        admin_modifystudent_pop.setOpaque(true);
        admin_modifystudent_pop.setPreferredSize(new java.awt.Dimension(500, 300));
        getContentPane().add(admin_modifystudent_pop, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_modifystudent_pop().setVisible(true);
            }
        });
    }
        private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Sysco_icon_with_background.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel admin_modify_student_instruction;
    private javax.swing.JLabel admin_modifystudent_pop;
    private javax.swing.JButton admin_stumanage_modifybutton;
    private javax.swing.JButton admin_stumanage_viewbutton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
