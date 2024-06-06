/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.EC;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import com.mycompany.projectmanagementsystem.GeneralFunction.IDGenerator;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class ECController {

    public boolean ecApply(String[] ecInput) {
        if (ECValidator.validateECInput(ecInput)) {
            if (ECValidator.validateECDocLink(ecInput[3])) {
                List<String> data = FileHandler.readFile("ec.txt");
                for (String line : data) {
                    String[] list = line.split(";");
                    if (list[1].equals(ecInput[0]) && list[2].equals(ecInput[1]) && !list[5].equals("reject")) {
                        JOptionPane.showMessageDialog(null, "There is a pending or approved ec request", "Message", JOptionPane.ERROR_MESSAGE);
                    }
                    return false;
                }
                String ecID = IDGenerator.genID("EC");
                String record = ecID + ";" + ecInput[0] + ";" + ecInput[1] + ";" + ecInput[2] + ";" + ecInput[3] + ";" + "pending" + ";" + "";
                FileHandler.writeFile("ec.txt", record);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Wrong url format", "Message", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "All input cannot be null", "Message", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean ecDelete(String ecID) {
        List<String> data = FileHandler.readFile("ec.txt");
        ArrayList<String> array_list = new ArrayList<>();
        for (String line : data) {
            String[] list = line.split(";");
            if (!list[0].equals(ecID)) {
                line = String.join(";", list);
                array_list.add(line);
            } else {
                if (list[5].equals("approve")) {
                    JOptionPane.showMessageDialog(null, "The ec cannot be remove once approved", "Message", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }
        FileHandler.modifyFileData("ec.txt", array_list);
        return true;
    }
    public boolean ecEdit(String ecID) {
        if (ecID != null && !ecID.isEmpty()) {
            System.out.println("Editing EC with ID: " + ecID);
            return true;
        } else {
            return false;
        }
    }
}
