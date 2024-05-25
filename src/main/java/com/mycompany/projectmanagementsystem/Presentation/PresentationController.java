/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.Presentation;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class PresentationController {    

    public boolean spvPresentationDone(String stdID, String newStatus) {
        List<String> data = FileHandler.readFile("presentation_confirmation.txt");
        ArrayList<String> updatedData = new ArrayList<>();

        for (String line : data) {
            String[] list = line.split(";");
            if (list[1].equals(stdID)) {
                // Validate if feedback has no value or not
                if (!list[4].isEmpty()) {
                    list[5] = newStatus;
                    line = String.join(";", list);
                } else {
                    JOptionPane.showMessageDialog(null, 
                            "Supervisee(" + stdID + ") cannot be marked as done because feedback has not been given.", "Message", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }

            updatedData.add(line);
        }
        FileHandler.modifyFileData("presentation_confirmation.txt", updatedData);
        return true;
    }
    public boolean secMarkPresentationDone(String stdID) {
        List<String> data = FileHandler.readFile("presentation_confirmation.txt");

        for (String line : data) {
            String[] list = line.split(";");
            if (list[1].equals(stdID)) {
                // Validate if feedback has no value or not
                if (list[4].isEmpty()) {
                    JOptionPane.showMessageDialog(null, 
                            "Supervisee(" + stdID + ") cannot be marked as done because feedback has not been given.", "Message", JOptionPane.ERROR_MESSAGE);
                    return false;
                } else {
                    int confirm = JOptionPane.showConfirmDialog(null, 
                            "Here's the feedback for student ("+stdID+"):\n"+list[4]+"\nSubmit?", 
                            "Confirmation", JOptionPane.YES_NO_OPTION);
                    if(confirm == JOptionPane.NO_OPTION){
                        return false;
                    }
                }
            }
        }
        return true;
    } 
}
