/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.Course;

import java.util.Arrays;

/**
 *
 * @author ASUS
 */
public class CourseValidator {
    
    public static boolean validateCourse(String[] userInput){
        
            System.out.println(Arrays.toString(userInput));
            System.out.println(userInput[0]);
            System.out.println(userInput[1]);
            if (userInput.length < 2) {
            return false;
        }
        // Check if the first or second elements are null or empty
        
        return !(userInput[0] == null || userInput[0].equals("") ||
                userInput[1] == null || userInput[1].equals(""));
    }
    
}
