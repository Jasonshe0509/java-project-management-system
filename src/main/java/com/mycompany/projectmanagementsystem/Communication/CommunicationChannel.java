/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.Communication;

import java.time.LocalDateTime;

/**
 *
 * @author ASUS
 */
public class CommunicationChannel {
    private String channelID;
    private String userID;
    private String assessmentID;
    private String subject;
    private LocalDateTime createdDateTime;

    public CommunicationChannel(String channelID, String userID, String assessmentID, String subject, LocalDateTime createdDateTime) {
        this.channelID = channelID;
        this.userID = userID;
        this.assessmentID = assessmentID;
        this.subject = subject;
        this.createdDateTime = createdDateTime;
    }

    public String getChannelID() {
        return channelID;
    }

    public void setChannelID(String channelID) {
        this.channelID = channelID;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }
    
    
}
