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
import com.mycompany.projectmanagementsystem.Notification.NotificationController;
import com.mycompany.projectmanagementsystem.User.User;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.mycompany.projectmanagementsystem.admin_assessment_management;
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
                            list[9] = "";
                            list[10] = "";
                            list[11] = "1";
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

    public boolean spvReportDone(String stdID, String assmntID, String newStatus, String type) {
        List<String> data = FileHandler.readFile("student_assessment.txt");
        ArrayList<String> updatedData = new ArrayList<>();
        boolean updateStatus = false; // Flag to determine if the status can be updated
        int spvMark;
        int secMarkerMark;
        int resubmissionCount;

        for (String line : data) {
            String[] list = line.split(";");
            if (list[1].equals(stdID) && list[2].equals(assmntID)) { // Validate if both stdID and assmntID match
                if ("internship_report".equals(type) || "investigation".equals(type)) {
                    if (!list[9].isEmpty() && !list[7].isEmpty()) { // Validate feedback and mark
                        spvMark = Integer.parseInt(list[9]);
                        resubmissionCount = Integer.parseInt(list[11]);
                        String grade = assignGrade(type, spvMark, resubmissionCount);
                        list[8] = grade;
                        // Mark status as 'marked'
                        list[6] = newStatus;
                        line = String.join(";", list);
                        updateStatus = true;
                        JOptionPane.showMessageDialog(null,
                                "The final mark (" + spvMark + ") has been submitted, grade \"" + grade + "\" is recorded.");
                        if ("Pass with Changes".equals(grade)) {
                            NotificationController.create(stdID, "The submitted report for assessment (" + list[2]
                                    + ") has been graded \"Pass with Changes\". Please note that you may resubmit your report for regrading.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Supervisee (" + stdID + ") cannot be marked as done because marks have not been given.", "Message", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    if (!list[9].isEmpty() && !list[10].isEmpty()) { // Validate if both marks are given
                        // Take the higher mark to assign grade
                        spvMark = Integer.parseInt(list[9]);
                        secMarkerMark = Integer.parseInt(list[10]);
                        resubmissionCount = Integer.parseInt(list[11]);
                        int avgMark = (spvMark + secMarkerMark) / 2;
                        String grade = assignGrade(type, avgMark, resubmissionCount);
                        list[8] = grade;
                        // Mark status as 'marked'
                        list[6] = newStatus;
                        line = String.join(";", list);
                        updateStatus = true;
                        JOptionPane.showMessageDialog(null,
                                "The final mark (" + avgMark + ") has been submitted, grade \"" + grade + "\" is recorded.");
                        if ("Pass with Changes".equals(grade)) {
                            NotificationController.create(stdID, "The submitted report for assessment (" + list[2]
                                    + ") has been graded \"Pass with Changes\". Please note that you may resubmit your report for regrading.");
                        }
                    } else if (!list[9].isEmpty() && list[10].isEmpty()) {
                        list[6] = "partially marked";
                        line = String.join(";", list);
                        JOptionPane.showMessageDialog(null,
                                "Report successfully marked.");
                        updateStatus = true;
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Supervisee (" + stdID + ") cannot be marked as done because marks have not been given.", "Message", JOptionPane.ERROR_MESSAGE);
                    }
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

    public boolean secMarkReportDone(String stdID, String assmntID, String newStatus, String type) {
        List<String> data = FileHandler.readFile("student_assessment.txt");
        ArrayList<String> updatedData = new ArrayList<>();
        boolean updateStatus = false; // Flag to determine if the status can be updated
        int spvMark;
        int secMarkerMark;
        int resubmissionCount;

        for (String line : data) {
            String[] list = line.split(";");

            if (list[1].equals(stdID) && list[2].equals(assmntID)) { // Validate if both stdID and assmntID match
                if (!list[9].isEmpty() && !list[10].isEmpty()) { // Validate if both marks are given
                    // Take the higher mark to assign grade
                    spvMark = Integer.parseInt(list[9]);
                    secMarkerMark = Integer.parseInt(list[10]);
                    resubmissionCount = Integer.parseInt(list[11]);
                    int avgMark = (spvMark + secMarkerMark) / 2;
                    String grade = assignGrade(type, avgMark, resubmissionCount);
                    list[8] = grade;
                    // Mark status as 'marked'
                    list[6] = newStatus;
                    line = String.join(";", list);
                    updateStatus = true;
                    JOptionPane.showMessageDialog(null,
                            "The final mark (" + avgMark + ") has been submitted, grade \"" + grade + "\" is recorded.");
                    if ("Pass with Changes".equals(grade)) {
                        NotificationController.create(stdID, "The submitted report for assessment (" + list[2]
                                + ") has been graded \"Pass with Changes\". Please note that you may resubmit your report for regrading.");
                    }
                } else if (!list[10].isEmpty() && list[9].isEmpty()) {
                    list[6] = "partially marked";
                    line = String.join(";", list);
                    JOptionPane.showMessageDialog(null,
                            "Report successfully marked.");
                    updateStatus = true;
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Supervisee (" + stdID + ") cannot be marked as done because marks have not been given.", "Message", JOptionPane.ERROR_MESSAGE);
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

    private String assignGrade(String type, int mark, int count) {
        List<String> data = FileHandler.readFile("assessment_type.txt");
        for (String line : data) {
            String[] list = line.split(";");
            int pass = Integer.parseInt(list[4]);
            String passChangesRange = list[5];

            if (list[0].equals(type)) {
                if (count >= 2) {
                    if (mark >= pass) {
                        return "pass";
                    } else {
                        return "fail";
                    }
                } else {
                    if (isWithinRange(mark, passChangesRange)) {
                        return "pass_with_changes"; //allow student to resubmit
                    } else if ("0".equals(passChangesRange) && mark >= pass) {
                        return "pass";
                    } else if (mark >= pass) {
                        return "pass";
                    } else {
                        return "fail";
                    }
                }
            }
        }
        return "Fail";
    }

    private boolean isWithinRange(int mark, String range) {
        if (range.contains("-")) {
            String[] bounds = range.split("-");
            int lowerBound = Integer.parseInt(bounds[0]);
            int upperBound = Integer.parseInt(bounds[1]);
            return mark >= lowerBound && mark <= upperBound;
        } else {
            // If range is a single number, treat it as an exact match
            int exactValue = Integer.parseInt(range);
            return mark == exactValue;
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

    public void adminEditMark(String[] marklist) {

        if (AssessmentValidator.validateAssessmentInput(marklist)) {
            int totalMark = Integer.parseInt(marklist[1]) + Integer.parseInt(marklist[2]) + Integer.parseInt(marklist[3]);
            if (totalMark <= 100) {

                if ((Integer.parseInt(marklist[6]) < Integer.parseInt(marklist[4]))) {
                    List<String> data = FileHandler.readFile("assessment_type.txt");
                    ArrayList<String> updatedData = new ArrayList();
                    for (String line : data) {
                        if (line.startsWith(marklist[7].toLowerCase())) {
                            String[] record = line.split(";");
                            record[0] = marklist[7].toLowerCase();
                            record[1] = marklist[1];
                            record[2] = marklist[2];
                            record[3] = marklist[3];
                            record[4] = marklist[4];
                            record[5] = marklist[5];
                            record[6] = marklist[6];

                            line = String.join(";", record);
                            updatedData.add(line);

                        } else {
                            updatedData.add(line);
                        }
                    }
                    FileHandler.modifyFileData("assessment_type.txt", updatedData);
                    admin_assessment_management.printAssessmentTable();

                    JOptionPane.showMessageDialog(null, "Marks For " + marklist[0] + " has been Updated succefully!", "Successful Updated", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, "The Fail Mark Cannot Greater Than Pass Mark.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "The Total Mark Of Content, Format, and Presentation Cannot Exceed 100!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Please Ensure All The Fields Are Filled!", "Invalid Changes: Incomplete Input!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean editDueDate(String[] assessmentInput) {
        if (AssessmentValidator.validateAssessmentInput(assessmentInput)) {
            if (AssessmentValidator.validateAssessmentDueDate(assessmentInput[2])) {
                List<String> data = FileHandler.readFile("student_assessment.txt");
                ArrayList<String> array_list = new ArrayList<>();
                for (String line : data) {
                    String[] list = line.split(";");
                    if (list[1].equals(assessmentInput[0]) && list[2].equals(assessmentInput[1])) {
                        list[3] = assessmentInput[2];
                        line = String.join(";", list);
                        array_list.add(line);
                    } else {
                        array_list.add(line);
                    }
                }
                FileHandler.modifyFileData("student_assessment.txt", array_list);
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "The due date much be two days more than current date", "Message", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "All input cannot be null", "Message", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
