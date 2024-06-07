/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.Assessment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ASUS
 */
public class AssessmentValidator {

    private static final String URL_REGEX
            = "^(https?|ftp)://[a-zA-Z0-9\\-\\.]+\\.[a-zA-Z]{2,}(\\:[0-9]+)?(/\\S*)?$";

    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);

    public static boolean validateAssessmentInput(String[] AssessmentInput) {
        for (String AssessmentInput1 : AssessmentInput) {
            if (AssessmentInput1 == null || AssessmentInput1.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateMoodleLink(String ECDocLink) {
        Matcher matcher = URL_PATTERN.matcher(ECDocLink);
        return matcher.matches();
    }

    public static boolean validateAssessmentDueDate(String DueDate) {
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yy-MM-dd");
        Date inputDate;
        try {
            inputDate = dateTimeFormat.parse(DueDate);
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
