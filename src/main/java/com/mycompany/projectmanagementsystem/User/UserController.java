/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.User;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.projectmanagementsystem.User.UserValidator;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class UserController extends UserAuthentication {

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
    public void userLogin() {

    }

    @Override
    public void userLogout() {

    }

    public void userCreate() {

    }
}
