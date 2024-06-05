/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.EC;

import java.net.URL;

/**
 *
 * @author ASUS
 */
public class EC {
    private String ecID;
    private String userID;
    private String assessmentID;
    private String ecReason;
    private URL ecDocumentURLLink;
    private String ecStatus;
    private String ecRejectReason;

    public EC(String ecID, String userID, String assessmentID, String ecReason, URL ecDocumentURLLink, String ecStatus, String ecRejectReason) {
        this.ecID = ecID;
        this.userID = userID;
        this.assessmentID = assessmentID;
        this.ecReason = ecReason;
        this.ecDocumentURLLink = ecDocumentURLLink;
        this.ecStatus = ecStatus;
        this.ecRejectReason = ecRejectReason;
    }

    public String getEcID() {
        return ecID;
    }

    public void setEcID(String ecID) {
        this.ecID = ecID;
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

    public String getEcReason() {
        return ecReason;
    }

    public void setEcReason(String ecReason) {
        this.ecReason = ecReason;
    }

    public URL getEcDocumentURLLink() {
        return ecDocumentURLLink;
    }

    public void setEcDocumentURLLink(URL ecDocumentURLLink) {
        this.ecDocumentURLLink = ecDocumentURLLink;
    }

    public String getEcStatus() {
        return ecStatus;
    }

    public void setEcStatus(String ecStatus) {
        this.ecStatus = ecStatus;
    }

    public String getEcRejectReason() {
        return ecRejectReason;
    }

    public void setEcRejectReason(String ecRejectReason) {
        this.ecRejectReason = ecRejectReason;
    }
    
}
