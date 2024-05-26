/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.Assessment;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class AssessmentController {
    public boolean assessment_Delete(String assessmentID) {
        List<String> data = FileHandler.readFile("assessment.txt");
        ArrayList<String> array_list = new ArrayList<>();
        for (String line : data) {
            String[] list = line.split(";");
            if (!list[0].equals(assessmentID)) {
                line = String.join(";", list);
                array_list.add(line);
            }
        }
        FileHandler.modifyFileData("assessment.txt", array_list);
        return true;
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

                    // Check if the new due date is at least 5 days later than the original due date
                    Calendar minDueDateCalendar = Calendar.getInstance();
                    minDueDateCalendar.setTime(originalDate);
                    minDueDateCalendar.add(Calendar.DAY_OF_MONTH, 5); // Add 5 days to the original due date
                    Date minDueDate = minDueDateCalendar.getTime();

                    if (newDate.before(minDueDate)) {
                        // New due date is not valid
                        return false;
                    }

                    // Update supervisor ID, second marker ID, and due date
                    list[4] = supervisorID; // Update supervisor ID
                    list[5] = secondMarkerID; // Update second marker ID
                    list[3] = dueDate; // Update due date

                    line = String.join(";", list);
                } catch (ParseException e) {
                    e.printStackTrace();
                    return false; // Return false if parsing fails
                }
            }
            array_list.add(line);
        }
        FileHandler.modifyFileData("assessment.txt", array_list);
        return true; // Return true if update is successful
    }

    public boolean assessment_Report(String assessmentID) {
        return false;
    }
}

