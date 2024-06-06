/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.Course;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import com.mycompany.projectmanagementsystem.admin_student_management;
import com.mycompany.projectmanagementsystem.admin_view_course;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class CourseController {

    public void viewCourse(String courseCode) {
        List<String> data = FileHandler.readFile("course.txt");
        String[] courseDetails = null;
        for (String line : data) {
            if (line.startsWith(courseCode)) {
                courseDetails = line.split(";");

            }

            admin_view_course courseRecord = new admin_view_course();
            courseRecord.displayCourseDetails(courseDetails);
            System.out.println(courseDetails[2]);
            courseRecord.show();
        }
    }

    public boolean courseDelete(String courseCode) {
        List<String> data = FileHandler.readFile("course.txt");
        ArrayList<String> updatedData = new ArrayList<>();

        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + courseCode + "?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            List<String> studentData = FileHandler.readFile("user.txt");
            for (String studentLine : studentData) {
                String[] studentInfo = studentLine.split(";");
                if (studentInfo.length > 11 && "student".equals(studentInfo[10])) {
                    String intakeCode = studentInfo[11];
                    if (intakeCode.endsWith(courseCode)) {
                        JOptionPane.showMessageDialog(null, "Course cannot be deleted as there are students enrolled under this course!");
                        return false;
                    } else {
                        for (String line : data) {
                            if (!line.startsWith(courseCode)) {
                                updatedData.add(line);
                            }
                        }
                    }
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Action Cancelled!");
            return false;
        }
        FileHandler.modifyFileData("course.txt", updatedData);
        admin_student_management.printCourseTable();
        return true;
    }

    public static void modifyCourse(String[] userInput) {

        List<String> data = FileHandler.readFile("course.txt");
        ArrayList<String> array_list = new ArrayList<>();
        for (String lines : data) {
            String[] line = lines.split(";");
            if (userInput[0].equals(line[0])) {
                line[0] = userInput[0]; //code
                line[1] = userInput[1]; //coursename
                line[2] = userInput[2]; //schoolwise

                lines = String.join(";", line);
                array_list.add(lines);
            } else {
                array_list.add(lines);
            }
        }
        FileHandler.modifyFileData("course.txt", array_list);
        JOptionPane.showMessageDialog(null, "Course: " + userInput[0] + " has been Updated succefully!", "Successful Updated", JOptionPane.INFORMATION_MESSAGE);
        admin_student_management.printCourseTable();
    }

    public static void addCourse(String[] userInput) {
        boolean validateCourse = CourseValidator.validateCourse(userInput);
        if (validateCourse == true) {

            String courseName = String.valueOf(userInput[1]);                  //abstract short form of course name
            String[] words = courseName.split(" ");
            StringBuilder courseNameShortForm = new StringBuilder();
            for (int i = 0; i < words.length; i++) {
                String results = words[i];
                courseNameShortForm.append(results.charAt(0));
            }
            String courseCode = null;
            String courseSpecialism = String.valueOf(userInput[2]);
            
            if (courseSpecialism == null || courseSpecialism.equals("")) {
                courseCode = courseNameShortForm.toString().toUpperCase();          //form the course code
            } else {
                String[] words2 = courseSpecialism.split(" ");
                StringBuilder courseSpecialismShortForm = new StringBuilder();
                for (int i = 0; i < words2.length; i++) {
                    String results2 = words2[i];
                    courseSpecialismShortForm.append(results2.charAt(0));
                }
                courseCode = (courseNameShortForm + "(" + courseSpecialismShortForm + ")").toUpperCase();          //form the course code

            }

            //String courseCode = (courseNameShortForm + "(" + courseSpecialismShortForm + ")").toUpperCase();          //form the course code
            List<String> courseList = FileHandler.readFile("course.txt");
            Object[] lines = courseList.toArray();
            boolean courseExist = false;
            for (int i = 0; i < lines.length; i++) {
                String line = lines[i].toString();
                String[] results = line.split(";");
                String courseInList = results[0];
                if (courseInList.equalsIgnoreCase(courseCode)) {
                    courseExist = true;
                    JOptionPane.showMessageDialog(null, "Course: " + courseCode + " Existed!", "Error: Duplicate Course", JOptionPane.ERROR_MESSAGE);

                }
            }
            if (!courseExist) {
                String[] words3 = userInput[1].split("\\s");     //ensure every alphabet of words is uppercase
                StringBuilder formatCourseName = new StringBuilder();
                for (String word3 : words3) {
                    formatCourseName.append(Character.toUpperCase(word3.charAt(0)));
                    formatCourseName.append(word3.substring(1).toLowerCase());
                    formatCourseName.append(" ");
                }
                
                StringBuilder formatCourseSpecialism = new StringBuilder();
                String newCourseData;
                System.out.println("this is error" + userInput[2]);
                if(userInput[2] != null && !(userInput[2]).equals("")){
                    String[] words4 = userInput[2].split("\\s");
                //formatCourseSpecialism = new StringBuilder();
                for (String word4 : words4) {
                    formatCourseSpecialism.append(Character.toUpperCase(word4.charAt(0)));
                    formatCourseSpecialism.append(word4.substring(1).toLowerCase());
                    formatCourseSpecialism.append(" ");
                }
                newCourseData = courseCode.trim() + ";" + formatCourseName.toString().trim() + "(" + formatCourseSpecialism.toString().trim() + ");" + userInput[0];
                } else{
                    newCourseData = courseCode.trim() + ";" + formatCourseName.toString().trim() + ";" +userInput[0];
                }
                
                FileHandler.writeFile("course.txt", newCourseData);
                JOptionPane.showMessageDialog(null, courseCode + " has been added succefully!", "Successful Added", JOptionPane.INFORMATION_MESSAGE);

            }

        } else {
            JOptionPane.showMessageDialog(null, "Please Ensure All Field Is Filled!", "Error: Incomplete Field.", JOptionPane.ERROR_MESSAGE);
        }
    }

}
