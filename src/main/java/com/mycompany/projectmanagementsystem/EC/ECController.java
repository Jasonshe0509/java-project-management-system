/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.EC;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import com.mycompany.projectmanagementsystem.GeneralFunction.IDGenerator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class ECController {

    public boolean ecApply(String[] ecInput) {
        if(ECValidator.validateECInput(ecInput)){
            if(ECValidator.validateECDocLink(ecInput[3])){
                List<String> data = FileHandler.readFile("ec.txt");
                for (String line : data) {
                    String[] list = line.split(";");
                    if(list[1].equals(ecInput[0]) && list[2].equals(ecInput[1]) && !list[5].equals("reject")){
                        JOptionPane.showMessageDialog(null, "There is a pending ec request", "Message", JOptionPane.ERROR_MESSAGE);
                    }
                    return false;
                }
                String ecID = IDGenerator.genID("EC");
                String record = ecID + ";" + ecInput[0] + ";" + ecInput[1] + ";" + ecInput[2] + ";" + ecInput[3] + ";" + "pending" + ";" + "";
                FileHandler.writeFile("ec.txt", record);
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Wrong url format", "Message", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }
}
