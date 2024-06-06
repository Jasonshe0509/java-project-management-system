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

}
