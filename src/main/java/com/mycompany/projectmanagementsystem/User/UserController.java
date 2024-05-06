/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.User;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class UserController extends UserAuthenticationController {

    @Override
    public boolean userForgetPassword(String[] userInput) {
        int ind = -1;
        if (UserValidator.validateUserInput(userInput)) {
            List<String> data = FileHandler.readFile("user.txt");
            ArrayList<String> array_list = new ArrayList<>();
            for (String line : data) {
                String[] list = line.split(";");
                if (userInput[0].equals(list[7])) {
                    if (UserValidator.validatePassword(userInput[1])) {
                        list[8] = userInput[1];
                        line = String.join(";", list);
                        ind = 1;
                        array_list.add(line);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Password,The password should contain\n \"At least 8 characters\",\"at "
                                + "least one uppercase letter, one lowercase letter, one digit and one special character[!@#$%^&*()]\"", "Message", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                } else {
                    array_list.add(line);
                }
            }
            if (ind == -1) {
                JOptionPane.showMessageDialog(null, "Wrong email", "Message", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            FileHandler.modifyFileData("user.txt", array_list);
            return true;
        }
        JOptionPane.showMessageDialog(null, "Email and password cannot be null", "Message", JOptionPane.ERROR_MESSAGE);
        return false;

    }

    @Override
    public String userLogin(String[] userInput) {
        String role = null;
        int ind = -1;
        if (UserValidator.validateUserInput(userInput)) {
            List<String> data = FileHandler.readFile("user.txt");
            ArrayList<String> array_list = new ArrayList<>();
            for (String line : data) {
                String[] list = line.split(";");
                if (userInput[0].equals(list[7]) && userInput[1].equals(list[8])) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = null;
                    try {
                        date = dateFormat.parse(list[4]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    switch (list[9]) {
                        case "student" -> {
                            Student student = new Student(list[0], list[1], list[2], list[3], date, list[5], list[6], list[7], list[8], list[9], list[10]);
                        }
                        case "lecturer" -> {
                            Lecturer lecturer = new Lecturer(list[0], list[1], list[2], list[3], date, list[5], list[6], list[7], list[8], list[9], list[10]);
                        }
                        case "project manager" -> {
                            ProjectManager manager = new ProjectManager(list[0], list[1], list[2], list[3], date, list[5], list[6], list[7], list[8], list[9], list[10]);
                        }
                        case "admin" -> {
                            Admin admin = new Admin(list[0], list[1], list[2], list[3], date, list[5], list[6], list[7], list[8], list[9]);
                        }
                    }
                    role = list[9];
                    ind = 1;
                    break;
                }
            }
            if (ind != 1) {
                JOptionPane.showMessageDialog(null, "Wrong credential", "Message", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Email and password cannot be null", "Message", JOptionPane.ERROR_MESSAGE);
        }
        return role;

    }

    @Override
    public void userLogout() {

    }

    public void userCreate() {

    }
}
