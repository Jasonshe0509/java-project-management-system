/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.SchoolWiseList;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class SchoolWiseController {
    
    public static void addSchoolWise(String userInput){          //methods to add school wise, no return value
        boolean validateSchoolWise = SchoolWiseValidator.validateSchoolWise(userInput);
        if(validateSchoolWise == true){                          //to validate user input in the validator
            List<String> data = FileHandler.readFile("school_wise.txt");
            boolean existSchoolWise = false;
            for(String line: data){                              // check existance in .txt
                String normalizedLine = line.trim().toLowerCase();
                if(normalizedLine.equalsIgnoreCase(userInput)){  //ignore the casesensitive 
                    JOptionPane.showMessageDialog(null, "School Wise already exists! Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    existSchoolWise = true;                  
                }
            }if(!existSchoolWise){                               //if line not existed
                    String[] words = userInput.split("\\s");     //ensure every alphabet of words is uppercase
                    StringBuilder formatInput = new StringBuilder();
                    for(String word: words){        
                        formatInput.append(Character.toUpperCase(word.charAt(0)));
                        formatInput.append(word.substring(1).toLowerCase());
                        formatInput.append(" ");
                    }
                    FileHandler.writeFile("school_wise.txt", formatInput.toString()); 
                    FileHandler.readFile("school_wise.txt");
                    JOptionPane.showMessageDialog(null, formatInput+" has been added succefully!", "Successful", JOptionPane.INFORMATION_MESSAGE);
                }
        }else{
            JOptionPane.showMessageDialog(null, "Invalid Format! (School Wise Format: School Of Example)", "Error", JOptionPane.ERROR_MESSAGE);
        }
           }    
}
