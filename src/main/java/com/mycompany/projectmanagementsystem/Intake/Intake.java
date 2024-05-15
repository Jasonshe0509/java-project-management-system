/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.Intake;

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

    
}
