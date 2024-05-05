/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.User;

import java.util.regex.Pattern;

/**
 *
 * @author ASUS
 */
public class UserValidator {

    public static boolean validateUserInput(String[] userInput) {
        for (String userInput1 : userInput) {
            if (userInput1 == null || userInput1.isEmpty()) {
                return false;
            } 
        }
        return true;
    }

    public static boolean validatePassword(String password) {
        // the password pattern is "At least 8 characters,atleast one uppercase letter, one lowercase letter, one digit and one special character[!@#$%^&*()]"
        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*()#])[A-Za-z\\d@$!%*()#]{8,}$";
        return Pattern.matches(pattern, password);
    }
}
