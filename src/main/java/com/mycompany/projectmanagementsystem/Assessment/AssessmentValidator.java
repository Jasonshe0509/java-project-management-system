/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.Assessment;

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
}
