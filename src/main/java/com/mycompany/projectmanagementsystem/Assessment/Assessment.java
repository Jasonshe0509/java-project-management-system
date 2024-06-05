/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.Assessment;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Assessment {
    private String assessmentID;
    private String assessmentType;
    private String studentIntake;
    private Date assessmentDueDate;
    private String supervisorID;
    private String secondMarkerID;
    private String projectManagerID;
    private String assessmentStatus;

    public Assessment(String assessmentID, String assessmentType, String studentIntake, Date assessmentDueDate, String supervisorID, String secondMarkerID, String projectManagerID, String assessmentStatus) {
        this.assessmentID = assessmentID;
        this.assessmentType = assessmentType;
        this.studentIntake = studentIntake;
        this.assessmentDueDate = assessmentDueDate;
        this.supervisorID = supervisorID;
        this.secondMarkerID = secondMarkerID;
        this.projectManagerID = projectManagerID;
        this.assessmentStatus = assessmentStatus;
    }

    public String getAssessmentID() {
        return assessmentID;
    }

    public void setAssessmentID(String assessmentID) {
        this.assessmentID = assessmentID;
    }

    public String getAssessmentType() {
        return assessmentType;
    }

    public void setAssessmentType(String assessmentType) {
        this.assessmentType = assessmentType;
    }

    public String getStudentIntake() {
        return studentIntake;
    }

    public void setStudentIntake(String studentIntake) {
        this.studentIntake = studentIntake;
    }

    public Date getAssessmentDueDate() {
        return assessmentDueDate;
    }

    public void setAssessmentDueDate(Date assessmentDueDate) {
        this.assessmentDueDate = assessmentDueDate;
    }

    public String getSupervisorID() {
        return supervisorID;
    }

    public void setSupervisorID(String supervisorID) {
        this.supervisorID = supervisorID;
    }

    public String getSecondMarkerID() {
        return secondMarkerID;
    }

    public void setSecondMarkerID(String secondMarkerID) {
        this.secondMarkerID = secondMarkerID;
    }

    public String getProjectManagerID() {
        return projectManagerID;
    }

    public void setProjectManagerID(String projectManagerID) {
        this.projectManagerID = projectManagerID;
    }

    public String getAssessmentStatus() {
        return assessmentStatus;
    }

    public void setAssessmentStatus(String assessmentStatus) {
        this.assessmentStatus = assessmentStatus;
    }
    
    
}
