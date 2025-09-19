/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */

package com.mycompany.UserValidationProject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {

    // Checks if username contains underscore and is <= 5 chars
    public static boolean checkUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Checks if password has length >= 8, contains a capital letter, and special char
    public static boolean checkPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        Pattern capitalLetter = Pattern.compile("[A-Z]");
        Pattern specialChar = Pattern.compile("[^a-zA-Z0-9]");
        return capitalLetter.matcher(password).find() && specialChar.matcher(password).find();
    }

    // Checks if phone number matches regex (starts with + and international code)
    public static boolean checkPhoneNumber(String phoneNumber) {
        String regex = "^\\+\\d{1,4}\\d{1,10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
