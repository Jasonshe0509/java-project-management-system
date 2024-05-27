/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.SchoolWiseList;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class SchoolWiseController {

    public static void addSchoolWise(String userInput) {          //methods to add school wise, no return value
        boolean validateSchoolWise = SchoolWiseValidator.validateSchoolWise(userInput);
        if (validateSchoolWise == true) {                          //to validate user input in the validator
            List<String> data = FileHandler.readFile("school_wise.txt");
            boolean existSchoolWise = false;
            for (String line : data) {                              // check existance in .txt
                String normalizedLine = line.trim().toLowerCase();
                if (normalizedLine.equalsIgnoreCase(userInput)) {  //ignore the casesensitive 
                    JOptionPane.showMessageDialog(null, "School Wise already exists! Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    existSchoolWise = true;
                }
            }
            if (!existSchoolWise) {                               //if line not existed
                String[] words = userInput.split("\\s");     //ensure every alphabet of words is uppercase
                StringBuilder formatInput = new StringBuilder();
                for (String word : words) {
                    formatInput.append(Character.toUpperCase(word.charAt(0)));
                    formatInput.append(word.substring(1).toLowerCase());
                    formatInput.append(" ");
                }
                FileHandler.writeFile("school_wise.txt", formatInput.toString());
                FileHandler.readFile("school_wise.txt");
                JOptionPane.showMessageDialog(null, formatInput + " has been added succefully!", "Successful", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Format! (School Wise Format: School Of Example)", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Boolean deleteSchoolWise(String schoolWise) {
        List<String> data = FileHandler.readFile("school_wise.txt");
        ArrayList<String> updatedData = new ArrayList<>();
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + schoolWise + "?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            for (String schoolWiseLine : data) {
                if (schoolWiseLine.equals(schoolWise)) {
                    List<String> userData = FileHandler.readFile("user.txt");
                    for (String line : userData) {
                        String[] userRecord = line.split(";");
                        if (userRecord.length > 11 && userRecord[11].equals(schoolWise)) {
                            JOptionPane.showMessageDialog(null, "There are Lecturer registered under " + schoolWise + " .\nSo, it can't be deleted!", "Error: Failed To Delete", JOptionPane.ERROR_MESSAGE);
                            return false;
                        }
                    }
                } else {
                    updatedData.add(schoolWiseLine);
                }

            }
            JOptionPane.showMessageDialog(null, "Successfully Removed " + schoolWise + " from project manager list.");
            FileHandler.modifyFileData("school_wise.txt", updatedData);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Action Cancelled!");
            return false;
        }
    }
}
