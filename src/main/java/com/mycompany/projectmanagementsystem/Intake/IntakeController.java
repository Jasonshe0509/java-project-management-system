/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.Intake;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class IntakeController {
    
    public static void addIntake(String[] userInput){
        boolean validateIntake = IntakeValidator.validateIntake(userInput);
        if (validateIntake == true){
                        
            String studyLevel = String.valueOf(userInput[0]);
            
            List <String> levelOfEducation = FileHandler.readFile("level_of_education.txt");       //to get the short form of the education level
            Object[] lines = levelOfEducation.toArray();
            String inputEducationLevel = null;
                for(int i = 0; i< lines.length; i++){
                    String line = lines[i].toString();
                    String[] results = line.split(";");
                    String educationLevel = results[1];
                    if(educationLevel.equals(studyLevel)){
                        inputEducationLevel = results[0];
                        
                    }
                    }
                
            String course = String.valueOf(userInput[2]);
            List <String> courseList = FileHandler.readFile("course.txt");
            Object[] lines2 = courseList.toArray();
            String courseCode = null;
            for(int i = 0; i < lines2.length; i++){
                String line2 = lines2[i].toString();
                String[] results2 = line2.split(";");
                String courseInList = results2[1];
                if(courseInList.equals(course)){
                    courseCode = results2[0];
                    System.out.print(results2[1]);
                    System.out.print(courseCode);
                    
                }
            }
                    
            int inputMonth = Integer.parseInt(userInput[3]) + 1;                           //to abstact the last two digit of year
            int year = Integer.parseInt(userInput[4]);
            String yearLastTwoDigits = Integer.toString(year);
            int inputYear = yearLastTwoDigits.length()-2;
            int inputYearTwoDigits = Integer.parseInt(yearLastTwoDigits.substring(inputYear));
            
            String inputMonthTwoDigits = String.format("%02d", inputMonth);                //to form date in MMYY
            
            String inputIntake = inputEducationLevel + inputYearTwoDigits + inputMonthTwoDigits + courseCode;    //to form the intake code
            System.out.print(inputIntake);
            
            boolean intakeExist = false;
            List <String> data = FileHandler.readFile("intake.txt");
            for(String line3 : data){
                String[] intakeRecord = line3.split(";");
                
                if(intakeRecord[0].equals(inputIntake)){
                    intakeExist = true;
                    JOptionPane.showMessageDialog(null, "Intake: "+inputIntake+ " Existed!", "Error: Intake Existed", JOptionPane.ERROR_MESSAGE);
                }
            }if(!intakeExist){
                FileHandler.writeFile("intake.txt", inputIntake+";"+userInput[1]+";"+userInput[0]+";"+userInput[2]+";"+userInput[4]+";"+inputMonthTwoDigits);
                JOptionPane.showMessageDialog(null, inputIntake+" has been added succefully!", "Successful Added", JOptionPane.INFORMATION_MESSAGE);
                }
            
            
            
        }else{
            JOptionPane.showMessageDialog(null, "Please Ensure All Field Is selected!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
