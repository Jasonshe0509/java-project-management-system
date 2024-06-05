/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projectmanagementsystem.Assessment;

/**
 *
 * @author user
 */
public interface LecReportTableActionEvent {
    
    public void reportGrading(int row, Object value);
    
    public void reportDone(int row, Object value);
}
