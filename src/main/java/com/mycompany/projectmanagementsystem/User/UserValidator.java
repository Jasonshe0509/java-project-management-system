/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.User;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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

    public static boolean validateUserID(String userID) {
        String pattern = "^TP\\d{4}$";
        return Pattern.matches(pattern, userID);
    }

    public static boolean validatePassword(String password) {
        // the password pattern is "At least 8 characters,atleast one uppercase letter, one lowercase letter, one digit and one special character[!@#$%^&*()]"
        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*()#])[A-Za-z\\d@$!%*()#]{8,}$";
        return Pattern.matches(pattern, password);
    }

    public static boolean validateEmail(String email) {
        String pattern = "^[A-Za-z0-9._%+-]+@mail.agh.edu.my$";
        return Pattern.matches(pattern, email);
    }

    public static boolean validateContact(String contact) {
        // the contact number pattern is start with 01, after 3number must have a -, and after - will only have 7 to 8 number
        String pattern = "^01[0-46-9]-[0-9]{7,8}$";
        return Pattern.matches(pattern, contact);
    }

    public static boolean validateNRICPassportInput(String userInput) {
        String pattern = "^(-)?[0-9]+(-[0-9]+)*$";
        return Pattern.matches(pattern, userInput);
    }

    public static boolean validateDateOfBirth(String birthDate) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            LocalDate birthDateParsed = LocalDate.parse(birthDate, formatter);

            LocalDate currentDate = LocalDate.now();
            if (birthDateParsed.isAfter(currentDate)) {
                return false;
            }
            int age = Period.between(birthDateParsed, currentDate).getYears();
            return age >= 15;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    
    public static boolean validateNationality(String nationality) {
        String pattern = "^[A-Z][A-Z]*(?:[\\s-][A-Z][A-Z]*)*$";
        return Pattern.matches(pattern, nationality);
    }
}
