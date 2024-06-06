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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class FileHandler {

    public static List<String> readFile(String fileName) {
        List<String> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void writeFile(String fileName, String record) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
            bw.write(record);
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void modifyFileData(String fileName, ArrayList<String> lines) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            for (String modifiedLine : lines) {
                bw.write(modifiedLine);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void modifyFileData(String assessmenttxt, List<String> updatedAssessmentData) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
