/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.Intake;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class Intake {
    private String intakeCode;
    private String schoolWiseName;
    private String educationLevel;
    private String courseName;
    private String enrollYear;
    private int enrollMonth;
    private static Map<String, Intake> intakeMap = new HashMap<>();

    public Intake(String intakeCode, String schoolWiseName, String educationLevel, String courseName, String enrollYear, int enrollMonth) {
        this.intakeCode = intakeCode;
        this.schoolWiseName = schoolWiseName;
        this.educationLevel = educationLevel;
        this.courseName = courseName;
        this.enrollYear = enrollYear;
        this.enrollMonth = enrollMonth;
    }

    public String getIntakeCode() {
        return intakeCode;
    }

    public void setIntakeCode(String intakeCode) {
        this.intakeCode = intakeCode;
    }

    public String getSchoolWiseName() {
        return schoolWiseName;
    }

    public void setSchoolWiseName(String schoolWiseName) {
        this.schoolWiseName = schoolWiseName;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getEnrollYear() {
        return enrollYear;
    }

    public void setEnrollYear(String enrollYear) {
        this.enrollYear = enrollYear;
    }

    public int getEnrollMonth() {
        return enrollMonth;
    }

    public void setEnrollMonth(int enrollMonth) {
        this.enrollMonth = enrollMonth;
    }
  
    public static void loadIntakes(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] list = line.split(";");
                if (list.length >= 6) {
                    String intakeCode = list[0].trim();
                    String schoolWiseName = list[1].trim();
                    String educationLevel = list[2].trim();
                    String courseName = list[3].trim();
                    String enrollYear = list[4].trim();
                    int enrollMonth = Integer.parseInt(list[5].trim());
                    Intake intake = new Intake(intakeCode, schoolWiseName, educationLevel, courseName, enrollYear, enrollMonth);
                    intakeMap.put(intakeCode, intake);
                }
            }
        } catch (IOException ex) {
            System.err.println("Error reading file: " + ex.getMessage());
        }
    }

    public static Intake getIntakeByCode(String intakeCode) {
        return intakeMap.get(intakeCode);
    }
}

    

