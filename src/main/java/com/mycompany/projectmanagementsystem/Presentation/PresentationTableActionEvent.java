/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projectmanagementsystem.Presentation;

/**
 *
 * @author user
 */
public interface PresentationTableActionEvent {
    
    public void presentationFeedback(int row, Object value);
    
    public void presentationDone(int row, Object value);
}
