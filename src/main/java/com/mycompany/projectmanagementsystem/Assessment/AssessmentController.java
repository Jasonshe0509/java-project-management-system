/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.Assessment;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
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
public class AssessmentController implements StudentAssessmentController {

    private final SessionManager sessionManager = SessionManager.getInstance();
    User user = sessionManager.getCurrentUser();

    public String assessmentType(String assessmentType) {
        String assessmentName;
        if (assessmentType.equalsIgnoreCase("internship_report")) {
            assessmentName = "Internship Report";
        } else if (assessmentType.equalsIgnoreCase("fyp")) {
            assessmentName = "Final Year Project";
        } else if (assessmentType.equalsIgnoreCase("cp1")) {
            assessmentName = "Capstone Project 1";
        } else if (assessmentType.equalsIgnoreCase("cp2")) {
            assessmentName = "Capstone Project 2";
        } else if (assessmentType.equalsIgnoreCase("rmcp")) {
            assessmentName = "Research Methodology for Capstone Project";
        } else if (assessmentType.equalsIgnoreCase("investigation")) {
            assessmentName = "Investigation Report";
        } else {
            assessmentName = "Unknown";
        }
        return assessmentName;
    }

    @Override
    public boolean submitAssessment(String action, String[] assessmentInput) {
        if (AssessmentValidator.validateAssessmentInput(assessmentInput)) {
            if (AssessmentValidator.validateMoodleLink(assessmentInput[1])) {
                List<String> data = FileHandler.readFile("student_assessment.txt");
                ArrayList<String> array_list = new ArrayList<>();
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
                String formattedDateTime = now.format(formatter);
                for (String line : data) {
                    String[] list = line.split(";");
                    String userID = user.getUserID();
                    if (list[2].equals(assessmentInput[0]) && list[1].equals(userID)) {
                        if ("submit".equals(action) || "modify".equals(action)) {
                            list[4] = assessmentInput[1];
                            list[5] = formattedDateTime;
                            list[6] = "submitted";
                        } else if ("resubmit".equals(action)) {
                            list[4] = assessmentInput[1];
                            list[5] = formattedDateTime;
                            list[6] = "submitted";
                            list[10] = "1";
                        }
                        line = String.join(";", list);
                        array_list.add(line);
                    } else {
                        array_list.add(line);
                    }
                }
                FileHandler.modifyFileData("student_assessment.txt", array_list);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Wrong url format", "Message", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "All input cannot be null", "Message", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
