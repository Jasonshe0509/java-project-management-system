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
public class CommunicationMessage {
    private String messageID;
    private String channelID;
    private String userID;
    private String message;
    private LocalDateTime createdDateTime;

    public CommunicationMessage(String messageID, String channelID, String userID, String message, LocalDateTime createdDateTime) {
        this.messageID = messageID;
        this.channelID = channelID;
        this.userID = userID;
        this.message = message;
        this.createdDateTime = createdDateTime;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }
    
    
}
