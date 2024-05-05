/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.User;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Admin extends User {
    
    public Admin(String userID, String name, String gender, String phoneNumber, Date dateOfBirth, String address, String identityNumber, String email, String password, Role role) {
        super(userID, name, gender, phoneNumber, dateOfBirth, address, identityNumber, email, password, role);
    }
    
}
