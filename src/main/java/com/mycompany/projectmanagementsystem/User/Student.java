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
public class Student extends User {
    private String intakeCode;

    public Student(String userID, String name, String gender, String phoneNumber, Date dateOfBirth, String address, String identityNumber, String email, String password, Role role, String intakeCode) {
        super(userID, name, gender, phoneNumber, dateOfBirth, address, identityNumber, email, password, role);
        this.intakeCode = intakeCode;
    }

    public String getIntakeCode() {
        return intakeCode;
    }

    public void setIntakeCode(String intakeCode) {
        this.intakeCode = intakeCode;
    }
    
}
