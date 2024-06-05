/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author ASUS
 */
public class UserTableAction extends JButton {

    private boolean mouseClick;

    public UserTableAction() {
        setContentAreaFilled(false); //to remove background
        setBorder(new EmptyBorder(3, 3, 3, 3));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseClick = true;
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                mouseClick = false;
            }
            
        });
    }

//    @Override
//    protected void paintComponent(Graphics graphics) {
//        Graphics2D actionBackground = (Graphics2D) graphics.create();
//        actionBackground.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        int width = getWidth();
//        int height = getHeight();
//        int size = Math.min(width, height);
//        int x = (width - size) / 2;
//        int y = (height - size) / 2;
//        if (mouseClick) {
//            actionBackground.setColor(Color.yellow);
//        } else {
//            actionBackground.setColor(Color.blue);
//        }
//        actionBackground.fill(new Ellipse2D.Double(x, y, size, size));
//        actionBackground.dispose();
//        super.paintComponent(graphics);
//    }

}
