/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projectmanagementsystem.User;

/**
 *
 * @author ASUS
 */
public interface UserTableActionEvent {
    
    public void userView(int row, Object value);
    
    public void userDelete(int row, Object value);
}
