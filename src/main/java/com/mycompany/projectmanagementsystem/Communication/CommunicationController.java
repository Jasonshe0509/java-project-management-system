/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.Communication;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import com.mycompany.projectmanagementsystem.GeneralFunction.GeneralValidator;
import com.mycompany.projectmanagementsystem.GeneralFunction.IDGenerator;
import com.mycompany.projectmanagementsystem.GeneralFunction.SessionManager;
import com.mycompany.projectmanagementsystem.User.User;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class CommunicationController {

    private final SessionManager sessionManager = SessionManager.getInstance();
    User user = sessionManager.getCurrentUser();

    public boolean createNewDiscussion(String[] discussionInput) {
        if (GeneralValidator.validateInput(discussionInput)) {
            String channelID = IDGenerator.genID("CC");
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
            String formattedDateTime = now.format(formatter);
            String record = channelID + ";" + user.getUserID() + ";" + discussionInput[0] + ";" + discussionInput[1] + ";" + formattedDateTime;
            FileHandler.writeFile("communication_channel.txt", record);
            String messageID = IDGenerator.genID("CM");
            String messageRecord = messageID + ";" + channelID + ";" + user.getUserID() + ";" + discussionInput[2] + ";" + formattedDateTime;
            FileHandler.writeFile("communication_message.txt", messageRecord);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "All input cannot be null", "Message", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean deleteDiscussionChannel(String channelID) {
        List<String> data = FileHandler.readFile("communication_channel.txt");
        ArrayList<String> array_list = new ArrayList<>();
        for (String line : data) {
            String[] list = line.split(";");
            if (!list[0].equals(channelID)) {
                line = String.join(";", list);
                array_list.add(line);
            }
        }
        FileHandler.modifyFileData("communication_channel.txt", array_list);
        List<String> messageData = FileHandler.readFile("communication_message.txt");
        ArrayList<String> message_array_list = new ArrayList<>();
        for (String messageLine : messageData) {
            String[] messageList = messageLine.split(";");
            if (!messageList[1].equals(channelID)) {
                messageLine = String.join(";", messageList);
                message_array_list.add(messageLine);
            }
        }
        FileHandler.modifyFileData("communication_message.txt", message_array_list);
        return true;
    }

    public boolean createNewMessage(String[] messageInput) {
        if (GeneralValidator.validateInput(messageInput)) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
            String formattedDateTime = now.format(formatter);
            String messageID = IDGenerator.genID("CM");
            String messageRecord = messageID + ";" + messageInput[0] + ";" + user.getUserID() + ";" + messageInput[1] + ";" + formattedDateTime;
            FileHandler.writeFile("communication_message.txt", messageRecord);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "All input cannot be null", "Message", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean deleteMessage(String messageID) {
        List<String> data = FileHandler.readFile("communication_message.txt");
        ArrayList<String> array_list = new ArrayList<>();
        for (String line : data) {
            String[] list = line.split(";");
            if (!list[0].equals(messageID)) {
                line = String.join(";", list);
                array_list.add(line);
            }
        }
        FileHandler.modifyFileData("communication_message.txt", array_list);
        return true;
    }
}
