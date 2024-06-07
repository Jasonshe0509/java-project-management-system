/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.Presentation;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import com.mycompany.projectmanagementsystem.GeneralFunction.IDGenerator;
import com.mycompany.projectmanagementsystem.LecturerPresentationReject;
import com.mycompany.projectmanagementsystem.GeneralFunction.SessionManager;
import com.mycompany.projectmanagementsystem.Notification.NotificationController;
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

    public boolean spvPresentationDone(String stdID, String assmntid, String newStatus, String type) {
        List<String> data = FileHandler.readFile("presentation_confirmation.txt");
        ArrayList<String> updatedData = new ArrayList<>();

        for (String line : data) {
            String[] list = line.split(";");
            if (list[1].equals(stdID) && list[2].equals(assmntid)) {
                if ("internship_report".equals(type) || "investigation".equals(type)) {
                    if (!list[4].isEmpty()) {
                        list[5] = newStatus;
                        line = String.join(";", list);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Supervisee(" + stdID + ") cannot be marked as done because feedback has not been given.", "Message", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                } else {
                    // Validate if feedback has no value or not
                    if (!list[4].isEmpty() && "true".equals(list[6])) {
                        list[5] = newStatus;
                        line = String.join(";", list);
                    } else if (!list[4].isEmpty() && !"true".equals(list[6])){
                        JOptionPane.showMessageDialog(null,
                                "Supervisee(" + stdID + ") cannot be marked as done because feedback has not been given by second marker.", "Message", JOptionPane.ERROR_MESSAGE);
                        return false;
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Supervisee(" + stdID + ") cannot be marked as done because feedback has not been given.", "Message", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                }   
            }

            updatedData.add(line);
        }
        FileHandler.modifyFileData("presentation_confirmation.txt", updatedData);
        return true;
    }

    public boolean secMarkPresentationDone(String stdID, String assmntid, String secMarkFeedbackStatus) {
        List<String> data = FileHandler.readFile("presentation_confirmation.txt");
        ArrayList<String> updatedData = new ArrayList<>();

        for (String line : data) {
            String[] list = line.split(";");
            if (list[1].equals(stdID) && list[2].equals(assmntid)) {
                // Validate if feedback has no value or not
                if (list[4].isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Supervisee(" + stdID + ") cannot be marked as done because feedback has not been given.", "Message", JOptionPane.ERROR_MESSAGE);
                    return false;
                } else {
                    int confirm = JOptionPane.showConfirmDialog(null,
                            "Here's the feedback for student (" + stdID + "):\n" + list[4] + "\nSubmit?",
                            "Confirmation", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        list[6] = secMarkFeedbackStatus;
                        line = String.join(";", list);
                    } else {
                        return false;
                    }
                }
            }
            updatedData.add(line);
        }
        FileHandler.modifyFileData("presentation_confirmation.txt", updatedData);
        return true;
    }

    public boolean presentationRqtApprove(String userRole, String rqtID, String newStatus) {
        List<String> data = FileHandler.readFile("presentation_request.txt");
        ArrayList<String> updatedData = new ArrayList<>();
        boolean found = false;

        for (String line : data) {
            String[] list = line.split(";");
            if (list[0].equals(rqtID)) {
                String stdID = list[1];
                found = true;
                switch (userRole) {
                    case "supervisor" -> {
                        if ("pending".equals(list[4])) {
                            if ("approved".equals(list[5]) || list[5].isEmpty()) { //isEmpty indicates second marker not existed
                                list[6] = newStatus;
                                NotificationController.create(stdID, "Your presentation request has been approved. "
                                        + "Please view your scheduled presentation date & time");
                            }
                            list[4] = newStatus;
                            line = String.join(";", list);
                        }
                    }
                    case "second marker" -> {
                        if ("pending".equals(list[5])) {
                            if ("approved".equals(list[4])) {
                                list[6] = newStatus;
                                NotificationController.create(stdID, "Your presentation request has been approved. "
                                        + "Please view your scheduled presentation date & time");
                            }
                            list[5] = newStatus;
                            line = String.join(";", list);
                        }
                    }
                }
            }
            updatedData.add(line);
        }

        if (!found) {
            JOptionPane.showMessageDialog(null,
                    "Request (" + rqtID + ") cannot be approved because acceptance is not pending.", "Message", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        FileHandler.modifyFileData("presentation_request.txt", updatedData);
        return true;
    }

    public boolean writeAccptPresentation(String[] schdPInput) {
        if (schdPInput != null && schdPInput.length == 3) {
            String schdPID = IDGenerator.genID("P");
            String record = schdPID + ";" + schdPInput[0] + ";" + schdPInput[1] + ";" + schdPInput[2] + ";" + "" + ";" + "scheduled" + ";" + "false";

            FileHandler.writeFile("presentation_confirmation.txt", record);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "All input cannot be null", "Message", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    public boolean presentationRqtReject(String userRole, String rqtID, String stdID, String assmntID, String newStatus) {
        List<String> data = FileHandler.readFile("presentation_request.txt");
        ArrayList<String> updatedData = new ArrayList<>();
        boolean statusChanged = false; // Track if the status has been changed

        // Count the number of requests for the same student ID and assessment ID
        int requestCount = 0;
        for (String line : data) {
            String[] list = line.split(";");
            if (list[1].equals(stdID) && list[2].equals(assmntID)) {
                requestCount++;
            }
        }

        // If the request count exceeds 2, show a message and return false
        if (requestCount > 2) {
            JOptionPane.showMessageDialog(null,
                    "Request from supervisee(" + stdID + ") cannot be rejected more than twice. Please approve the request.", "Message", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        for (String line : data) {
            String[] list = line.split(";");
            if (list[0].equals(rqtID)) {
                switch (userRole) {
                    case "supervisor" -> {
                        if ("pending".equals(list[4])) {
                            LecturerPresentationReject reject = new LecturerPresentationReject(userRole, stdID);
                            reject.setVisible(true);

                            if (reject.isNotificationCreated()) {
                                // Update the status to rejected for supervisor
                                list[4] = newStatus;
                                list[6] = newStatus;
                                statusChanged = true;
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Request (" + rqtID + ") cannot be rejected because available slot is not provided.", "Message", JOptionPane.ERROR_MESSAGE);
                                return false;
                            }
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Request (" + rqtID + ") cannot be rejected because acceptance is not pending.", "Message", JOptionPane.ERROR_MESSAGE);
                            return false;
                        }
                    }
                    case "second marker" -> {
                        if ("pending".equals(list[5])) {
                            LecturerPresentationReject reject = new LecturerPresentationReject(userRole, rqtID);
                            reject.setVisible(true); // This will block until the dialog is closed

                            if (reject.isNotificationCreated()) {
                                // Update the status to rejected for second marker
                                list[5] = newStatus;
                                list[6] = newStatus;
                                statusChanged = true;
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Request (" + rqtID + ") cannot be rejected because available slot is not provided.", "Message", JOptionPane.ERROR_MESSAGE);
                                return false;
                            }
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Request (" + rqtID + ") cannot be rejected because acceptance is not pending.", "Message", JOptionPane.ERROR_MESSAGE);
                            return false;
                        }
                    }
                    default -> {
                        JOptionPane.showMessageDialog(null,
                                "Invalid user role: " + userRole, "Message", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                }
                line = String.join(";", list); // Update the line after changing status
            }
            updatedData.add(line); // Add line to updated data
        }

        if (statusChanged) {
            FileHandler.modifyFileData("presentation_request.txt", updatedData);
            return true;
        } else {
            JOptionPane.showMessageDialog(null,
                    "Request (" + rqtID + ") cannot be rejected because it was not found.", "Message", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean studentRequestPresentation(String[] presentationInput) {
        String record;
        if (PresentationValidator.validatePresentationInput(presentationInput)) {
            if (PresentationValidator.validatePresentationDateTime(presentationInput[1])) {
                String requestID = IDGenerator.genID("PR");
                if (presentationInput[2].equals("internship_report") || presentationInput[2].equals("investigation")) {
                    record = requestID + ";" + user.getUserID() + ";" + presentationInput[0] + ";" + presentationInput[1] + ";" + "pending" + ";" + "" + ";" + "pending";

                } else {
                    record = requestID + ";" + user.getUserID() + ";" + presentationInput[0] + ";" + presentationInput[1] + ";" + "pending" + ";" + "pending" + ";" + "pending";
                }

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
            }else{
                if(list[6].equals("rejected") || list[6].equals("approved")){
                    JOptionPane.showMessageDialog(null, "The rejected and approved request cannot be removed", "Message", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }
        FileHandler.modifyFileData("presentation_request.txt", array_list);
        return true;
    }

    public boolean updateStudentPresentationIndex(String stdID, String assmntid, String feedback) {
        List<String> data = FileHandler.readFile("presentation_confirmation.txt");
        ArrayList<String> updatedData = new ArrayList<>();
        boolean isUpdated = false;

        for (String line : data) {
            String[] list = line.split(";");
            if (list[1].equals(stdID) && list[2].equals(assmntid)) {
                list[4] = feedback; // Update the feedback at index 5
                line = String.join(";", list);
                isUpdated = true;
            }
            updatedData.add(line);
        }

        if (isUpdated) {
            FileHandler.modifyFileData("presentation_confirmation.txt", updatedData);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Student ID not found.", "Message", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
