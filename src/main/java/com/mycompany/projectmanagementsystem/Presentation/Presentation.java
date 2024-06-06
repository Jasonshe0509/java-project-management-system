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
public class Presentation {
    private String presentationID;
    private String userID;
    private String assessmentID;
    private LocalDateTime presentationDateTime;
    private String presentationStatus;
    private String presentationFeedback;
    private String isSecMarkExist;

    public Presentation(String presentationID, String userID, String assessmentID, LocalDateTime presentationDateTime, String presentationStatus, String presentationFeedback, String isSecMarkExist) {
        this.presentationID = presentationID;
        this.userID = userID;
        this.assessmentID = assessmentID;
        this.presentationDateTime = presentationDateTime;
        this.presentationStatus = presentationStatus;
        this.presentationFeedback = presentationFeedback;
        this.isSecMarkExist = isSecMarkExist;
    }

    public String getIsSecMarkExist() {
        return isSecMarkExist;
    }

    public void setIsSecMarkExist(String isSecMarkExist) {
        this.isSecMarkExist = isSecMarkExist;
    }

    public String getPresentationID() {
        return presentationID;
    }

    public void setPresentationID(String presentationID) {
        this.presentationID = presentationID;
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

    public LocalDateTime getPresentationDateTime() {
        return presentationDateTime;
    }

    public void setPresentationDateTime(LocalDateTime presentationDateTime) {
        this.presentationDateTime = presentationDateTime;
    }

    public String getPresentationStatus() {
        return presentationStatus;
    }

    public void setPresentationStatus(String presentationStatus) {
        this.presentationStatus = presentationStatus;
    }

    public String getPresentationFeedback() {
        return presentationFeedback;
    }

    public void setPresentationFeedback(String presentationFeedback) {
        this.presentationFeedback = presentationFeedback;
    }
    
    
}
