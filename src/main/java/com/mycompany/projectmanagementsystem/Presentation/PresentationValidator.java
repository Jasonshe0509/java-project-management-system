/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.Presentation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class PresentationValidator {

    public static boolean validatePresentationInput(String[] presentationInput) {
        for (String presentationInput1 : presentationInput) {
            if (presentationInput1 == null || presentationInput1.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static boolean validatePresentationDateTime(String dateTime) {
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yy-MM-dd-HH-mm");
        Date inputDate;
        try {
            inputDate = dateTimeFormat.parse(dateTime);
        } catch (ParseException e) {
            return false;
        }
        // Get the current date and time
        Calendar currentDate = Calendar.getInstance();

        // Add two days to the current date
        currentDate.add(Calendar.DAY_OF_YEAR, 2);

        // Get the date after adding two days
        Date currentDatePlusTwo = currentDate.getTime();

        // Compare the input date with the current date plus two days
        return inputDate.after(currentDatePlusTwo);
    }
}
