/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.User;

/**
 *
 * @author ASUS
 */
public abstract class UserAuthentication {
    public abstract boolean userForgetPassword(String[] userInput);
    public abstract String userLogin(String[] userInput);
    public abstract void userLogout();
}
