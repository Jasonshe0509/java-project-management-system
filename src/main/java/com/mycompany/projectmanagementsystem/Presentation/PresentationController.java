/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.Presentation;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import com.mycompany.projectmanagementsystem.GeneralFunction.IDGenerator;
import com.mycompany.projectmanagementsystem.GeneralFunction.SessionManager;
import com.mycompany.projectmanagementsystem.User.User;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class PresentationController {

    private final SessionManager sessionManager = SessionManager.getInstance();
    User user = sessionManager.getCurrentUser();

    public boolean spvPresentationDone(String stdID, String newStatus) {
        List<String> data = FileHandler.readFile("presentation_confirmation.txt");
        ArrayList<String> updatedData = new ArrayList<>();

        for (String line : data) {
            String[] list = line.split(";");
            if (list[1].equals(stdID)) {
                // Validate if feedback has no value or not
                if (!list[4].isEmpty()) {
                    list[5] = newStatus;
                    line = String.join(";", list);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Supervisee(" + stdID + ") cannot be marked as done because feedback has not been given.", "Message", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }

            updatedData.add(line);
        }
        FileHandler.modifyFileData("presentation_confirmation.txt", updatedData);
        return true;
    }

    public boolean secMarkPresentationDone(String stdID) {
        List<String> data = FileHandler.readFile("presentation_confirmation.txt");

        for (String line : data) {
            String[] list = line.split(";");
            if (list[1].equals(stdID)) {
                // Validate if feedback has no value or not
                if (list[4].isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Supervisee(" + stdID + ") cannot be marked as done because feedback has not been given.", "Message", JOptionPane.ERROR_MESSAGE);
                    return false;
                } else {
                    int confirm = JOptionPane.showConfirmDialog(null,
                            "Here's the feedback for student (" + stdID + "):\n" + list[4] + "\nSubmit?",
                            "Confirmation", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.NO_OPTION) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean studentRequestPresentation(String[] presentationInput) {
        if (PresentationValidator.validatePresentationInput(presentationInput)) {
            if (PresentationValidator.validatePresentationDateTime(presentationInput[1])) {
                String requestID = IDGenerator.genID("PR");
                String record = requestID + ";" + user.getUserID() + ";" + presentationInput[0] + ";" + presentationInput[1] + ";" + "pending" + ";" + "pending" + ";" + "pending";
                FileHandler.writeFile("presentation_request.txt", record);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "The presentation date must be two day after the current date", "Message", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "All input cannot be null", "Message", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean studentDeleteRequestPresentation(String requestID) {
        List<String> data = FileHandler.readFile("presentation_request.txt");
        ArrayList<String> array_list = new ArrayList<>();
        for (String line : data) {
            String[] list = line.split(";");
            if (!list[0].equals(requestID)) {
                line = String.join(";", list);
                array_list.add(line);
            }
        }
        FileHandler.modifyFileData("presentation_request.txt", array_list);
        return true;
    }
}
