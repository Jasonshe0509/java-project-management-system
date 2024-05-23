/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.EC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ASUS
 */
public class ECValidator {

    private static final String URL_REGEX
            = "^(https?|ftp)://[a-zA-Z0-9\\-\\.]+\\.[a-zA-Z]{2,}(\\:[0-9]+)?(/\\S*)?$";

    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);

    public static boolean validateECInput(String[] ECInput) {
        for (String ECInput1 : ECInput) {
            if (ECInput1 == null || ECInput1.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateECDocLink(String ECDocLink) {
        Matcher matcher = URL_PATTERN.matcher(ECDocLink);
        return matcher.matches();
    }
}
