/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.EC;

import com.mycompany.projectmanagementsystem.Assessment.AssessmentController;
import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import com.mycompany.projectmanagementsystem.GeneralFunction.IDGenerator;
import com.mycompany.projectmanagementsystem.GeneralFunction.SessionManager;
import com.mycompany.projectmanagementsystem.Notification.NotificationController;
import com.mycompany.projectmanagementsystem.User.User;
import com.mycompany.projectmanagementsystem.admin_approval_ec_details;
import com.mycompany.projectmanagementsystem.admin_ec_details;
import com.mycompany.projectmanagementsystem.admin_ec_record;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class ECController {

    private final SessionManager sessionManager = SessionManager.getInstance();
    User user = sessionManager.getCurrentUser();

    public boolean ecApply(String[] ecInput) {
        String assessmentName = null;
        if (ECValidator.validateECInput(ecInput)) {
            if (ECValidator.validateECDocLink(ecInput[3])) {
                List<String> data = FileHandler.readFile("ec.txt");
                for (String line : data) {
                    String[] list = line.split(";");
                    if (list[1].equals(ecInput[0]) && list[2].equals(ecInput[1]) && !list[5].equals("rejected")) {
                        JOptionPane.showMessageDialog(null, "There is a pending or approved ec request", "Message", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                }
                String ecID = IDGenerator.genID("EC");
                String record = ecID + ";" + ecInput[0] + ";" + ecInput[1] + ";" + ecInput[2] + ";" + ecInput[3] + ";" + "pending" + ";" + "";
                FileHandler.writeFile("ec.txt", record);
                List<String> Assessmentdata = FileHandler.readFile("assessment.txt");
                for (String assessmentline : Assessmentdata) {
                    String[] assessmentlist = assessmentline.split(";");
                    if (assessmentlist[0].equals(ecInput[1])) {
                        AssessmentController action  = new AssessmentController();
                        assessmentName = action.assessmentType(assessmentlist[1]);
                    }
                }
                NotificationController.create(user.getUserID(), "New EC has been applied for assessment: " + assessmentName);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Wrong url format", "Message", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "All input cannot be null", "Message", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean ecDelete(String ecID) {
        List<String> data = FileHandler.readFile("ec.txt");
        ArrayList<String> array_list = new ArrayList<>();
        for (String line : data) {
            String[] list = line.split(";");
            if (!list[0].equals(ecID)) {
                line = String.join(";", list);
                array_list.add(line);
            } else {
                if (list[5].equals("approved")) {
                    JOptionPane.showMessageDialog(null, "The ec cannot be remove once approved", "Message", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }
        FileHandler.modifyFileData("ec.txt", array_list);
        return true;
    }

    public void adminViewPendingEC(String ECID) {
        List<String> data = FileHandler.readFile("ec.txt");
        String[] ecDetail = null;
        for (String lines : data) {
            if (lines.startsWith(ECID)) {
                ecDetail = lines.split(";");

            }
        }
        admin_approval_ec_details ecDetails = new admin_approval_ec_details();
        ecDetails.displayECDetails(ecDetail);
        ecDetails.show();
    }

    public void adminViewEC(String ECID) {
        List<String> data = FileHandler.readFile("ec.txt");
        String[] ecDetail = null;
        for (String lines : data) {
            if (lines.startsWith(ECID)) {
                ecDetail = lines.split(";");

            }
        }
        admin_ec_details ecDetails = new admin_ec_details();
        ecDetails.displayECDetails(ecDetail);
        ecDetails.show();
    }

    public void approveEC(String ECID) {
        List<String> data = FileHandler.readFile("ec.txt");
        ArrayList<String> updatedData = new ArrayList<>();
        int confirm = JOptionPane.showConfirmDialog(null, "Approve " + ECID + "?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            for (String line : data) {
                if (line.startsWith(ECID)) {
                    String[] updatedLine = line.split(";");
                    updatedLine[5] = "approved";
                    line = String.join(";", updatedLine);
                    updatedData.add(line);
                } else {
                    updatedData.add(line);
                }
            }
            JOptionPane.showMessageDialog(null, "EC: " + ECID + " has been approved!", "Successful Approved", JOptionPane.INFORMATION_MESSAGE);
            FileHandler.modifyFileData("ec.txt", updatedData);
            admin_ec_record.printPendingECTable();
            admin_ec_record.printApprovedECTable();
            admin_ec_record.printRejectedECTable();
            admin_ec_record.readNumOfPendingEC();

        } else {
            JOptionPane.showMessageDialog(null, "Action Cancelled!");
        }

    }

    public void rejectEC(String ECID) {
        List<String> data = FileHandler.readFile("ec.txt");
        ArrayList<String> updatedData = new ArrayList<>();
        int confirm = JOptionPane.showConfirmDialog(null, "Reject " + ECID + "?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            for (String line : data) {
                if (line.startsWith(ECID)) {
                    String[] updatedLine = line.split(";");
                    updatedLine[5] = "rejected";
                    line = String.join(";", updatedLine);
                    updatedData.add(line);
                } else {
                    updatedData.add(line);
                }
            }
            JOptionPane.showMessageDialog(null, "EC: " + ECID + " has been rejected!", "Successful Rejected", JOptionPane.INFORMATION_MESSAGE);
            FileHandler.modifyFileData("ec.txt", updatedData);
            admin_ec_record.printPendingECTable();
            admin_ec_record.printApprovedECTable();
            admin_ec_record.printRejectedECTable();
            admin_ec_record.readNumOfPendingEC();
        } else {
            JOptionPane.showMessageDialog(null, "Action Cancelled!");
        }

    }
}
