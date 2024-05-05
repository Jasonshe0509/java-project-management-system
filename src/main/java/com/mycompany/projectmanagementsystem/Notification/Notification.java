/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.Notification;

import java.time.LocalDateTime;

/**
 *
 * @author ASUS
 */
public class Notification {
    private String notificationID;
    private String userID;
    private String message;
    private LocalDateTime dateSent;

    public Notification(String notificationID, String userID, String message, LocalDateTime dateSent) {
        this.notificationID = notificationID;
        this.userID = userID;
        this.message = message;
        this.dateSent = dateSent;
    }

    public String getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(String notificationID) {
        this.notificationID = notificationID;
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

    public LocalDateTime getDateSent() {
        return dateSent;
    }

    public void setDateSent(LocalDateTime dateSent) {
        this.dateSent = dateSent;
    }
    
    
}
