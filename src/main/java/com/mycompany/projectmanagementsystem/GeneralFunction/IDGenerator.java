/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.GeneralFunction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ASUS
 */
public class IDGenerator {

    public static String genID(String IDType) {
        String[] recList;
        String oldNo, newID, code = "";
        try (BufferedReader br = new BufferedReader(new FileReader("serial.txt"))) {
            recList = br.readLine().trim().split(";");
            switch (IDType.toUpperCase()) {
                //User ID
                case "TP" -> {
                    oldNo = recList[0];
                    code = "TP";
                    newID = joinID(oldNo, code);
                    recList[0] = newID;
                    break;
                }
                //Notification ID
                case "NT" -> {
                    oldNo = recList[1];
                    code = "NT";
                    newID = joinID(oldNo, code);
                    recList[1] = newID;
                    break;
                }
                // EC ID
                case "EC" -> {
                    oldNo = recList[2];
                    code = "EC";
                    newID = joinID(oldNo, code);
                    recList[2] = newID;
                    break;
                }
                // Assessment ID
                case "A" -> {
                    oldNo = recList[3];
                    code = "A";
                    newID = joinID(oldNo, code);
                    recList[3] = newID;
                    break;
                }
                // Student Assessment ID
                case "SA" -> {
                    oldNo = recList[4];
                    code = "SA";
                    newID = joinID(oldNo, code);
                    recList[4] = newID;
                    break;
                }
                // Communication Channel ID
                case "CC" -> {
                    oldNo = recList[5];
                    code = "CC";
                    newID = joinID(oldNo, code);
                    recList[5] = newID;
                    break;
                }
                // Communication Message ID
                case "CM" -> {
                    oldNo = recList[6];
                    code = "CM";
                    newID = joinID(oldNo, code);
                    recList[6] = newID;
                    break;
                }
                // Presentation Request ID
                case "PR" -> {
                    oldNo = recList[7];
                    code = "PR";
                    newID = joinID(oldNo, code);
                    recList[7] = newID;
                    break;
                }
                 // Presentation ID
                case "P" -> {
                    oldNo = recList[8];
                    code = "P";
                    newID = joinID(oldNo, code);
                    recList[8] = newID;
                    break;
                }
            }
            br.close();
            //Rewrite IDlist to ID.txt
            BufferedWriter bw = new BufferedWriter(new FileWriter("serial.txt"));
            bw.write(String.join(";", recList) + "\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String joinID(String oldNo, String code) {
        //define string, int
        String newStr;
        int newPart;

        newPart = Integer.parseInt(oldNo.substring(3)) + 1; //increment of integer starting from index 3
        newStr = String.valueOf(newPart);
        code += String.format("%04d", newPart); //formatting ID with 3 digits
        return code;
    }
}
