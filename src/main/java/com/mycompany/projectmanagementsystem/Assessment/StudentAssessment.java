/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.Assessment;

import java.net.URL;
import java.time.LocalDateTime;

/**
 *
 * @author ASUS
 */
public class StudentAssessment {
    private String studentAssessmentID;
    private String studentID;
    private String assessmentID;
    private String studentAssessmentDueDate;
    private URL submissionLink;
    private LocalDateTime submissionDateTime;
    private String submissionStatus;
    private String feedback;
    private String grade;

    public StudentAssessment(String studentAssessmentID, String studentID, String assessmentID, String studentAssessmentDueDate, URL submissionLink, LocalDateTime submissionDateTime, String submissionStatus, String feedback, String grade) {
        this.studentAssessmentID = studentAssessmentID;
        this.studentID = studentID;
        this.assessmentID = assessmentID;
        this.studentAssessmentDueDate = studentAssessmentDueDate;
        this.submissionLink = submissionLink;
        this.submissionDateTime = submissionDateTime;
        this.submissionStatus = submissionStatus;
        this.feedback = feedback;
        this.grade = grade;
    }

    public String getStudentAssessmentID() {
        return studentAssessmentID;
    }

    public void setStudentAssessmentID(String studentAssessmentID) {
        this.studentAssessmentID = studentAssessmentID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getAssessmentID() {
        return assessmentID;
    }

    public void setAssessmentID(String assessmentID) {
        this.assessmentID = assessmentID;
    }

    public String getStudentAssessmentDueDate() {
        return studentAssessmentDueDate;
    }

    public void setStudentAssessmentDueDate(String studentAssessmentDueDate) {
        this.studentAssessmentDueDate = studentAssessmentDueDate;
    }

    public URL getSubmissionLink() {
        return submissionLink;
    }

    public void setSubmissionLink(URL submissionLink) {
        this.submissionLink = submissionLink;
    }

    public LocalDateTime getSubmissionDateTime() {
        return submissionDateTime;
    }

    public void setSubmissionDateTime(LocalDateTime submissionDateTime) {
        this.submissionDateTime = submissionDateTime;
    }

    public String getSubmissionStatus() {
        return submissionStatus;
    }

    public void setSubmissionStatus(String submissionStatus) {
        this.submissionStatus = submissionStatus;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    
}
