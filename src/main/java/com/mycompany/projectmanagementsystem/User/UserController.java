/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.User;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import com.mycompany.projectmanagementsystem.GeneralFunction.SessionManager;
import com.mycompany.projectmanagementsystem.LoginPage;
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

    private final SessionManager sessionManager = SessionManager.getInstance();
    User loggedUser = sessionManager.getCurrentUser();

    @Override
    public boolean userForgetPassword(String[] userInput) {
        int ind = -1;
        if (UserValidator.validateUserInput(userInput)) {
            List<String> data = FileHandler.readFile("user.txt");
            ArrayList<String> array_list = new ArrayList<>();
            for (String line : data) {
                String[] list = line.split(";");
                if (userInput[0].equals(list[8])) {
                    if (UserValidator.validatePassword(userInput[1])) {
                        list[9] = userInput[1];
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
    public User userLogin(String[] userInput) {
        User user = null;
        int ind = -1;
        if (UserValidator.validateUserInput(userInput)) {
            List<String> data = FileHandler.readFile("user.txt");
            ArrayList<String> array_list = new ArrayList<>();
            for (String line : data) {
                String[] list = line.split(";");
                if (userInput[0].equals(list[8]) && userInput[1].equals(list[9])) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = null;
                    try {
                        date = dateFormat.parse(list[4]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    switch (list[10]) {
                        case "student" -> {
                            user = new Student(list[0], list[1], list[2], list[3], date, list[5], list[6], list[7], list[8], list[9], list[10], list[11]);
                        }
                        case "lecturer" -> {
                            user = new Lecturer(list[0], list[1], list[2], list[3], date, list[5], list[6], list[7], list[8], list[9], list[10], list[11]);
                        }
                        case "project manager" -> {
                            user = new ProjectManager(list[0], list[1], list[2], list[3], date, list[5], list[6], list[7], list[8], list[9], list[10], list[11]);
                        }
                        case "admin" -> {
                            user = new Admin(list[0], list[1], list[2], list[3], date, list[5], list[6], list[7], list[8], list[9], list[10]);
                        }
                    }
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
        return user;

    }

    @Override
    public void userLogout() {
        SessionManager.getInstance().clearSession();
        LoginPage login = new LoginPage();
        login.setVisible(true);
    }

    public void userCreate() {

    }

    public boolean userProfileUpdate(String[] userInput) {
        if (UserValidator.validateUserInput(userInput)) {
            if (UserValidator.validateEmail(userInput[2])) {
                if (UserValidator.validateContact(userInput[3])) {
                    if (UserValidator.validatePassword(userInput[4])) {
                        List<String> data = FileHandler.readFile("user.txt");
                        ArrayList<String> array_list = new ArrayList<>();
                        for (String line : data) {
                            String[] list = line.split(";");
                            if (userInput[0].equals(list[0])) {
                                list[3] = userInput[3];
                                list[5] = userInput[1];
                                list[8] = userInput[2];
                                list[9] = userInput[4];
                                loggedUser.setAddress(userInput[1]);
                                loggedUser.setEmail(userInput[2]);
                                loggedUser.setPhoneNumber(userInput[3]);
                                loggedUser.setPassword(userInput[4]);
                                line = String.join(";", list);
                                array_list.add(line);
                            } else {
                                array_list.add(line);
                            }
                        }
                        FileHandler.modifyFileData("user.txt", array_list);
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Password,The password should contain\n \"At least 8 characters\",\"at "
                                + "least one uppercase letter, one lowercase letter, one digit and one special character[!@#$%^&*()]\"", "Message", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong contact number format. The contact number must have -", "Message", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Wrong email format. The email must be having mail.agh.edu.my", "Message", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(null, "All the input field cannot be null", "Message", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
