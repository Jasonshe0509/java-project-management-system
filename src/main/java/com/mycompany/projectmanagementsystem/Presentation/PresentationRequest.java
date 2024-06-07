/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.Presentation;

import java.time.LocalDateTime;

/**
 *
 * @author ASUS
 */
public class PresentationRequest {
    private String presentationRequestID;
    private String userID;
    private String assessmentID;
    private LocalDateTime requestDateTime;
    private String supervisorApprovalStatus;
    private String secondMarkerApprovalStatus;
    private String presentationApprovalStatus;

    public PresentationRequest(String presentationRequestID, String userID, String assessmentID, 
            LocalDateTime requestDateTime, String supervisorApprovalStatus, String secondMarkerApprovalStatus, 
            String presentationApprovalStatus) {
        this.presentationRequestID = presentationRequestID;
        this.userID = userID;
        this.assessmentID = assessmentID;
        this.requestDateTime = requestDateTime;
        this.supervisorApprovalStatus = supervisorApprovalStatus;
        this.secondMarkerApprovalStatus = secondMarkerApprovalStatus;
        this.presentationApprovalStatus = presentationApprovalStatus;
    }

    public String getPresentationRequestID() {
        return presentationRequestID;
    }

    public void setPresentationRequestID(String presentationRequestID) {
        this.presentationRequestID = presentationRequestID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getAssessmentID() {
        return assessmentID;
    }

    public void setAssessmentID(String assessmentID) {
        this.assessmentID = assessmentID;
    }

    public LocalDateTime getRequestDateTime() {
        return requestDateTime;
    }

    public void setRequestDateTime(LocalDateTime requestDateTime) {
        this.requestDateTime = requestDateTime;
    }

    public String getSupervisorApprovalStatus() {
        return supervisorApprovalStatus;
    }

    public void setSupervisorApprovalStatus(String supervisorApprovalStatus) {
        this.supervisorApprovalStatus = supervisorApprovalStatus;
    }

    public String getSecondMarkerApprovalStatus() {
        return secondMarkerApprovalStatus;
    }

    public void setSecondMarkerApprovalStatus(String secondMarkerApprovalStatus) {
        this.secondMarkerApprovalStatus = secondMarkerApprovalStatus;
    }

    public String getPresentationApprovalStatus() {
        return presentationApprovalStatus;
    }

    public void setPresentationApprovalStatus(String presentationApprovalStatus) {
        this.presentationApprovalStatus = presentationApprovalStatus;
    }
    
    
}
