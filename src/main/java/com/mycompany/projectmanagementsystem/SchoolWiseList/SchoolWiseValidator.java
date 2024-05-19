/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.SchoolWiseList;

/**
 *
 * @author ASUS
 */
public class SchoolWiseValidator {
    
    public static boolean validateSchoolWise(String userInput) {
        if (userInput == null || userInput.isEmpty()) {                //input should not be empty or null
            return false;
        }
        String[] words = userInput.split("\\s+");
        if (!userInput.startsWith("school of") || words.length < 3){   //input should start with "School Of" and more than 3words
            return false;
        } else{
            return true;
        }
           
    }
        
    
}
