/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.GeneralFunction;

import com.mycompany.projectmanagementsystem.User.User;

/**
 *
 * @author ASUS
 */
public class SessionManager {
    private static SessionManager instance;
    private User currentUser;
    
    private SessionManager(){}
    
    public static SessionManager getInstance(){
        if (instance == null){
            instance = new SessionManager();
        }
        return instance;
    }
    public void setCurrentUser(User user) {
        currentUser = user;
    }

    public User getCurrentUser() {
        return currentUser;
    }
    
    public void clearSession() {
        currentUser = null;
    }
}
