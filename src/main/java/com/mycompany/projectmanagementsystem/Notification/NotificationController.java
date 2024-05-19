/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.Notification;

import com.mycompany.projectmanagementsystem.GeneralFunction.IDGenerator;
import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author ASUS
 */
public class NotificationController {

    public static void create(String userID, String message) {
        String notiID = IDGenerator.genID("NT");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
        String formattedDateTime = now.format(formatter);
        String rec = notiID +";"+userID +";"+message+ ";" + formattedDateTime;
        FileHandler.writeFile("notification.txt", rec);
    }
}
