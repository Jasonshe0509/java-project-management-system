/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.Course;

/**
 *
 * @author ASUS
 */
public class CourseValidator {
    
    public static boolean validateCourse(String[] userInput){
        for (String userInput1 : userInput) {
            if (userInput1 == null || userInput1.equals("")) {
                return false;
            } 
        }
        return true;
    }
    
}
