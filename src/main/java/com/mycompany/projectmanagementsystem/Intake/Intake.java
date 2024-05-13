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
    private String levelCode;
    private String courseCode;
    private String enrollYear;
    private String enrollMonth;

    public Intake(String intakeCode, String schoolWiseName, String levelCode, String courseCode, String enrollYear, String enrollMonth) {
        this.intakeCode = intakeCode;
        this.schoolWiseName = schoolWiseName;
        this.levelCode = levelCode;
        this.courseCode = courseCode;
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

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getEnrollYear() {
        return enrollYear;
    }

    public void setEnrollYear(String enrollYear) {
        this.enrollYear = enrollYear;
    }

    public String getEnrollMonth() {
        return enrollMonth;
    }

    public void setEnrollMonth(String enrollMonth) {
        this.enrollMonth = enrollMonth;
    }
    
    
}
