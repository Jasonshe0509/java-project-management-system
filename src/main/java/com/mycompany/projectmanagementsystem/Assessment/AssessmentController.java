/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.Assessment;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.mycompany.projectmanagementsystem.GeneralFunction.SessionManager;
import com.mycompany.projectmanagementsystem.User.User;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    
    public boolean spvReportDone(String stdID, String newStatus) {
        List<String> data = FileHandler.readFile("student_assessment.txt");
        ArrayList<String> updatedData = new ArrayList<>();
        boolean updateStatus = false; // Flag to determine if the status can be updated
        int spvMark;
        int secMarkerMark;
        int resubmissionCount;

        for (String line : data) {
            String[] list = line.split(";");
            if (list[1].equals(stdID)) {
                if (!list[9].isEmpty() && !list[10].isEmpty()) { // Validate if both marks are given
                    // Take the higher mark to assign grade
                    spvMark = Integer.parseInt(list[9]);
                    secMarkerMark = Integer.parseInt(list[10]);
                    resubmissionCount = Integer.parseInt(list[11]);
                    int higherMark = Math.max(spvMark, secMarkerMark);
                    String grade = assignGrade(stdID, higherMark, resubmissionCount);
                    list[8] = grade;
                    // Mark status as 'marked'
                    list[6] = newStatus;
                    line = String.join(";", list);
                    updateStatus = true;
                } else if (!list[9].isEmpty() && list[10].isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Successfully marked as done. Pending supervisor's grading.");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Supervisee (" + stdID + ") cannot be marked as done because both markers have not submitted their marks.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }
            updatedData.add(line);
        }

        if (updateStatus) {
            FileHandler.modifyFileData("student_assessment.txt", updatedData);
            return true;
        } else {
            return false;
        }
    }

    public boolean secMarkReportDone(String stdID, String newStatus) {
        List<String> data = FileHandler.readFile("student_assessment.txt");
        ArrayList<String> updatedData = new ArrayList<>();
        boolean updateStatus = false; // Flag to determine if the status can be updated
        int spvMark;
        int secMarkerMark;
        int resubmissionCount;

        for (String line : data) {
            String[] list = line.split(";");
            
            if (list[1].equals(stdID)) {
                if (!list[9].isEmpty() && !list[10].isEmpty()) { // Validate if both marks are given
                    // Take the higher mark to assign grade
                    spvMark = Integer.parseInt(list[9]);
                    secMarkerMark = Integer.parseInt(list[10]);
                    resubmissionCount = Integer.parseInt(list[11]);
                    int higherMark = Math.max(spvMark, secMarkerMark);
                    String grade = assignGrade(stdID, higherMark, resubmissionCount);
                    list[8] = grade;
                    // Mark status as 'marked'
                    list[6] = newStatus;
                    line = String.join(";", list);
                    updateStatus = true;
                } else if (!list[10].isEmpty() && list[9].isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Successfully marked as done. Pending supervisor's grading.");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Supervisee (" + stdID + ") cannot be marked as done because both markers have not submitted their marks.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }
            updatedData.add(line);
        }

        if (updateStatus) {
            FileHandler.modifyFileData("student_assessment.txt", updatedData);
            return true;
        } else {
            return false;
        }
    }

    private String assignGrade(String stdID, int mark, int count) {
        if (count >= 2) {
            if (mark >= 50) return "Pass with Small Changes";
            return null;
        } else {
            if (mark >= 50) return "Pass";
            return "Fail";
        }
    }
    
    
    public List<String> getStudentsByIntake(String studentIntake) {
        List<String> students = new ArrayList<>();
        String fileName = "user.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] list = line.split(";");
                if (list.length >= 12 && list[11].equalsIgnoreCase(studentIntake) && list[10].equalsIgnoreCase("student")) {
                    students.add(list[0]);
                }
            }
        } catch (IOException ex) {
            System.err.println("Error reading file: " + ex.getMessage());
        }
        return students;
    }

    public void saveStudentAssessment(String[] studentAssessmentData) {
        String fileName = "student_assessment.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write(String.join(";", studentAssessmentData));
            bw.newLine();
        } catch (IOException ex) {
            System.err.println("Error writing to file: " + ex.getMessage());
        }
    }

    public boolean assessment_Delete(String assessmentID) {
         boolean success = true;
    
         // Read and update assessment.txt
         List<String> data = FileHandler.readFile("assessment.txt");
         ArrayList<String> updatedAssessmentData = new ArrayList<>();
         for (String line : data) {
             String[] list = line.split(";");
             if (!list[0].equals(assessmentID)) {
                 updatedAssessmentData.add(line);
             }
         }
         FileHandler.modifyFileData("assessment.txt", updatedAssessmentData);
         // Read and update student_assessment.txt
         List<String> studentAssessmentData = FileHandler.readFile("student_assessment.txt");
         ArrayList<String> updatedStudentAssessmentData = new ArrayList<>();
         for (String line : studentAssessmentData) {
             String[] parts = line.split(";");
             if (!parts[0].equals(assessmentID)) {
                 updatedStudentAssessmentData.add(line);
             }
         }
         FileHandler.modifyFileData("student_assessment.txt", updatedStudentAssessmentData);
            return success;
        }
    

    public boolean assessment_Edit(String assessmentID, String supervisorID, String secondMarkerID, String dueDate) {
        List<String> data = FileHandler.readFile("assessment.txt");
        ArrayList<String> array_list = new ArrayList<>();
        for (String line : data) {
            String[] list = line.split(";");
            if (list[0].equals(assessmentID)) {
                String originalDueDate = list[3]; // Get original due date
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date originalDate = dateFormat.parse(originalDueDate);
                    Date newDate = dateFormat.parse(dueDate);

                    // Check if the new due date is at least 2 days later than the current date
                    Calendar minDueDateCalendar = Calendar.getInstance();
                    minDueDateCalendar.add(Calendar.DAY_OF_MONTH, 2); // Add 2 days to the current date
                    Date minDueDate = minDueDateCalendar.getTime();

                    if (newDate.before(minDueDate)) {
                        return false;
                    }

                    // Update supervisor ID, second marker ID, and due date
                    list[4] = supervisorID; 
                    list[5] = secondMarkerID; 
                    list[3] = dueDate; 

                    line = String.join(";", list);
                } catch (ParseException e) {
                    e.printStackTrace();
                    return false; 
                }
            }
            array_list.add(line);
        }
        FileHandler.modifyFileData("assessment.txt", array_list);
        return true; 
    }

    public boolean assessment_Report(String assessmentID) {
        List<String> data = FileHandler.readFile("student_assessment.txt");
        for (String line : data) {
            String[] list = line.split(";");
            if (list[0].equals(assessmentID)) {
                return true; // Assessment report exists
            }
        }
        return false; // Assessment report does not exist
    }
    
    public boolean report_Delete(String assessmentID) {
        List<String> data = FileHandler.readFile("student_assessment.txt");
        ArrayList<String> array_list = new ArrayList<>();
        for (String line : data) {
            String[] list = line.split(";");
            if (!list[0].equals(assessmentID)) {
                line = String.join(";", list);
                array_list.add(line);
            }
        }
        FileHandler.modifyFileData("student_assessment.txt", array_list);
        return true;
    }
}

