/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.GeneralFunction;

/**
 *
 * @author ASUS
 */
public class GeneralValidator {
    public static boolean validateInput(String[] Input) {
        for (String Input1 : Input) {
            if (Input1 == null || Input1.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
