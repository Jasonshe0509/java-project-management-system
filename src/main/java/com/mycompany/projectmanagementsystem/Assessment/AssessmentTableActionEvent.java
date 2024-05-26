/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projectmanagementsystem.Assessment;

/**
 *
 * @author shuhuilee
 */
public interface AssessmentTableActionEvent {
    public void assessment_Delete(int row, Object value);
    public void assessment_Edit(int row, Object value);
    public void assessment_Report(int row, Object value);
    
}
