/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem.User;

import com.mycompany.projectmanagementsystem.GeneralFunction.FileHandler;
import com.mycompany.projectmanagementsystem.GeneralFunction.SessionManager;
import com.mycompany.projectmanagementsystem.LoginPage;
import com.mycompany.projectmanagementsystem.admin_lecturer_record;
import com.mycompany.projectmanagementsystem.admin_view_lec_details;
import com.mycompany.projectmanagementsystem.admin_view_projectmanager_details;
import com.mycompany.projectmanagementsystem.admin_view_studentrecord;
import com.mycompany.projectmanagementsystem.admin_student_management;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
                                                admin_student_management.printStudentTable();
                                                admin_student_management.readNumOfStudent();
                                                JOptionPane.showMessageDialog(null, "Student: " + userID + " has been added succefully!", "Successful Added", JOptionPane.INFORMATION_MESSAGE);
                                            }
                                            case "lecturer" -> {
                                                FileHandler.writeFile("user.txt", userInput[3] + ";" + userInput[0] + ";" + userInput[1] + ";"
                                                        + userInput[5] + ";" + userInput[2] + ";" + userInput[4] + ";" + userInput[6] + ";" + userInput[7]
                                                        + ";" + userInput[8] + ";" + initialPassword + ";" + userInput[9] + ";" + userInput[10]);
                                                JOptionPane.showMessageDialog(null, "Lecturer: " + userID + " has been added succefully!", "Successful Added", JOptionPane.INFORMATION_MESSAGE);
                                            }
                                            case "project manager" -> {
                                            }
                                            case "admin" -> {
                                            }
                                        }

                                    } else {
                                        JOptionPane.showMessageDialog(null, "Please Enter Your School Email Address (eg: xxx@MAIL.agh.edu.my)", "Error: Invalid Email Address", JOptionPane.ERROR_MESSAGE);
                                    }
                                } else {
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

    public boolean projectmanagerDelete(String userID) {
        System.out.println(userID);
        int confirm = JOptionPane.showConfirmDialog(null, "Remove " + userID + " as Project Manager?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            List<String> data = FileHandler.readFile("user.txt");
            ArrayList<String> updatedData = new ArrayList<>();

            for (String line : data) {
                if (line.startsWith(userID)) {
                    String[] record = line.split(";");
                    record[10] = "lecturer";
                    String updatedLine = String.join(";", record);
                    System.out.println(updatedLine);
                    updatedData.add(updatedLine);
                } else {
                    updatedData.add(line);
                }
            }
            JOptionPane.showMessageDialog(null, "Successfully Removed " + userID + " from project manager list.");
            FileHandler.modifyFileData("user.txt", updatedData);
            admin_lecturer_record.printLecturerTable();
            admin_lecturer_record.readNumOfLecturer();
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Action Cancelled!");
            return false;
        }
    }

    public void projectmanagerAdd(String userID) {

        int confirm = JOptionPane.showConfirmDialog(null, "Assign " + userID + " as Project Manager?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            List<String> assessmentData = FileHandler.readFile("assessment.txt");
            for (String assessmentLine : assessmentData) {
                String[] assessmentRecord = assessmentLine.split(";");
                if ((userID.equals(assessmentRecord[4]) || userID.equals(assessmentRecord[5])) && assessmentRecord[7].equals("incomplete")) {
                    JOptionPane.showMessageDialog(null, "Lecturer Has Incomplete Assessment On Hand.", "Error: Fail To Assign", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            List<String> data = FileHandler.readFile("user.txt");
            ArrayList<String> updatedData = new ArrayList<>();

            for (String lines : data) {
                if (lines.startsWith(userID)) {
                    String[] line = lines.split(";");
                    line[10] = "project manager";
                    String updatedLine = String.join(";", line);
                    updatedData.add(updatedLine);
                } else {
                    updatedData.add(lines);
                }
            }
            JOptionPane.showMessageDialog(null, "Successfully Assigned!");
            FileHandler.modifyFileData("user.txt", updatedData);
            admin_lecturer_record.printLecturerTable();
            admin_lecturer_record.readNumOfLecturer();

        } else {
            JOptionPane.showMessageDialog(null, "Action Cancelled!");
        }
    }

    public boolean userDelete(String userID) {
        List<String> data = FileHandler.readFile("user.txt");
        ArrayList<String> updatedData = new ArrayList<>();
        String role = null;
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + userID + "?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            for (String line : data) {
                if (!line.startsWith(userID)) {
                    updatedData.add(line);
                }
                String[] list = line.split(";");
                if (list[0].equals(userID)) {
                    role = list[10];
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Action Cancelled!");
            return false;
        }
        FileHandler.modifyFileData("user.txt", updatedData);
        if ("student".equals(role)) {
            admin_student_management.printStudentTable();
            admin_student_management.readNumOfStudent();
        } else {
            admin_lecturer_record.printLecturerTable();
            admin_lecturer_record.readNumOfLecturer();
            admin_lecturer_record.printSchoolWiseTable();
            admin_lecturer_record.readNumOfSchoolWise();
        }

        return true;
    }

    public void viewUser(String userID) {
        List<String> data = FileHandler.readFile("user.txt");
        String[] userDetails = null;
        String user = null;
        for (String line : data) {
            if (line.startsWith(userID)) {
                userDetails = line.split(";");
                user = userDetails[10];

                switch (user) {
                    case "student" -> {
                        admin_view_studentrecord studentDetails = new admin_view_studentrecord();
                        studentDetails.displayStudentDetails(userDetails);
                        studentDetails.show();
                    }
                    case "lecturer" -> {
                        admin_view_lec_details lecturerDetails = new admin_view_lec_details();
                        lecturerDetails.displayLecturerDetails(userDetails);
                        lecturerDetails.show();
                    }
                    case "project manager" -> {
                        admin_view_projectmanager_details lecturerDetails = new admin_view_projectmanager_details();
                        lecturerDetails.displayLecturerDetails(userDetails);
                        lecturerDetails.show();
                    }

                }
            }
        }

    }

    public static void modifyUser(String[] userInput) {
        if (UserValidator.validateUserInput(userInput)) {
            if (UserValidator.validateDateOfBirth(userInput[2])) {
                if (UserValidator.validateContact(userInput[5])) {
                    if (UserValidator.validateNRICPassportInput(userInput[6])) {
                        if (UserValidator.validateNationality(userInput[7])) {
                            if (UserValidator.validateEmail(userInput[8])) {
                                if (UserValidator.validatePassword(userInput[11])) {
                                    List<String> data = FileHandler.readFile("user.txt");
                                    ArrayList<String> array_list = new ArrayList<>();

                                    for (String line : data) {
                                        String[] list = line.split(";");
                                        if (userInput[3].equals(list[0])) {
                                            list[0] = userInput[3];  //id
                                            list[1] = userInput[0];  //name
                                            list[2] = userInput[1]; //gender
                                            list[3] = userInput[5]; //contact
                                            list[4] = userInput[2];  //dob
                                            list[5] = userInput[4]; //address
                                            list[6] = userInput[6]; //nric
                                            list[7] = userInput[7]; //nation
                                            list[8] = userInput[8]; //email
                                            list[9] = userInput[11]; //password
                                            list[10] = userInput[9]; //"student"
                                            list[11] = userInput[10]; //intake

                                            line = String.join(";", list);
                                            array_list.add(line);
                                        } else {
                                            array_list.add(line);
                                        }
                                    }
                                    FileHandler.modifyFileData("user.txt", array_list);
                                    switch (userInput[9]) {
                                        case "student" -> {
                                            JOptionPane.showMessageDialog(null, "Student: " + userInput[3] + " has been Updated succefully!", "Successful Updated", JOptionPane.INFORMATION_MESSAGE);
                                            admin_student_management.printStudentTable();
                                        }
                                        case "lecturer" -> {
                                            JOptionPane.showMessageDialog(null, "Lecturer: " + userInput[3] + " has been Updated succefully!", "Successful Updated", JOptionPane.INFORMATION_MESSAGE);
                                            admin_lecturer_record.printLecturerTable();
                                            admin_lecturer_record.readNumOfLecturer();
                                            admin_lecturer_record.printSchoolWiseTable();
                                        }
                                        case "project manager" -> {
                                            JOptionPane.showMessageDialog(null, "Project Manager: " + userInput[3] + " has been Updated succefully!", "Successful Updated", JOptionPane.INFORMATION_MESSAGE);
                                            admin_lecturer_record.printLecturerTable();
                                            admin_lecturer_record.readNumOfLecturer();
                                            admin_lecturer_record.printSchoolWiseTable();
                                        }

                                    }

                                } else {
                                    JOptionPane.showMessageDialog(null, "Invalid Password,The password should contain\n \"At least 8 characters\",\"at "
                                            + "least one uppercase letter, one lowercase letter, one digit and one special character[!@#$%^&*()]\"", "Message", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Please Enter Your School Email Address (eg: xxx@MAIL.agh.edu.my)", "Error: Invalid Email Address", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
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
