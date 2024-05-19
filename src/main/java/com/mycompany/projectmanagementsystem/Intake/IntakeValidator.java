/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.Intake;

/**
 *
 * @author ASUS
 */
public class IntakeValidator {
    
    public static boolean validateIntake(String[] userInput){
       for (String userInput1 : userInput) {
            if (userInput1 == null || userInput1.startsWith("")) {
                return false;
            } 
        }
        return true;
    }
    
}
