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

    public static void userCreate(String[] userInput) {

        boolean userExisted = false;
        if (UserValidator.validateUserInput(userInput)) {
            if (UserValidator.validateUserID(userInput[3])) {
                List<String> userRecord = FileHandler.readFile("user.txt");
                for (String line : userRecord) {
                    String[] record = line.split(";");

                    if (record[0].equals(userInput[3])) {
                        userExisted = true;
                        JOptionPane.showMessageDialog(null, "UserID: " + userInput[3] + " already existed!", "Error: UserID Existed", JOptionPane.ERROR_MESSAGE);
                    }
                }
                if (!userExisted) {
                    if (UserValidator.validateDateOfBirth(userInput[2])) {
                        if (UserValidator.validateContact(userInput[5])) {
                            if (UserValidator.validateNRICPassportInput(userInput[6])) {
                                if (UserValidator.validateNationality(userInput[7])) {
                                    if (UserValidator.validateEmail(userInput[8])) {
                                        String userID = userInput[3];
                                        String digitInUserID = userID.substring(2);
                                        String initialPassword = "Tp" + digitInUserID + "@";      //create an initial password by default

                                        switch (userInput[9]) {
                                            case "student" -> {
                                                FileHandler.writeFile("user.txt", userInput[3] + ";" + userInput[0] + ";" + userInput[1] + ";"
                                                        + userInput[5] + ";" + userInput[2] + ";" + userInput[4] + ";" + userInput[6] + ";" + userInput[7]
                                                        + ";" + userInput[8] + ";" + initialPassword + ";" + userInput[9] + ";" + userInput[10]);
                                                JOptionPane.showMessageDialog(null, "Student: " + userID + " has been added succefully!", "Successful Added", JOptionPane.INFORMATION_MESSAGE);
                                            }
                                            case "lecturer" -> {
                                            }
                                            case "project manager" -> {
                                            }
                                            case "admin" -> {
                                            }
                                        }

                                    } else {
                                        JOptionPane.showMessageDialog(null, "Please Enter Your School Email Address (eg: xxx@MAIL.agh.edu.my)", "Error: Invalid Email Address", JOptionPane.ERROR_MESSAGE);
                                    }
                                }else {
                                    JOptionPane.showMessageDialog(null, "Please Enter Only Character For Nationality.", "Error: Invalid Nationality.", JOptionPane.ERROR_MESSAGE);
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Please Enter Only Integer For NRIC/ Passport Number.", "Error: Invalid NRIC/ Passport No.", JOptionPane.ERROR_MESSAGE);

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Contact Number Format: 01x-xxx xxxx/ 01x-xxx xxxxx", "Error: Invalid Contact Number", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "The minimum age that can be registerd should be 15", "Error: Invalid Birth Date", JOptionPane.ERROR_MESSAGE);

                    }

                }
            } else {
                JOptionPane.showMessageDialog(null, "User ID Format: TPxxxx", "Error: Invalid UserID", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Fill In All The Field!", "Error: Missing Value(s)", JOptionPane.ERROR_MESSAGE);
        }

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