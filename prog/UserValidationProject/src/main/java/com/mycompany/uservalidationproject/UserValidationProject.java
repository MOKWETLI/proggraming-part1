/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */
package com.mycompany.uservalidationproject;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

    





public class UserValidationProject {

    static String storedUsername;
    static String storedPassword;

    // Validate username format
    public static String validateUsername(String username) {
        if (username.contains("_") && username.length() <= 5) {
            return "Username successfully captured.";
        } else {
            return "Username is not correctly formatted. Please ensure that your username contains an underscore and is not more than five characters long.";
        }
    }

    // Register user
    public static String registerUser(String username, String password) {
        if (!checkUsername(username)) {
            return "Username is not correctly formatted. Please ensure that your username contains an underscore and is not more than five characters long.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password does not meet complexity requirements. Please ensure your password contains a capital letter, a number, a special character, and is at least eight characters long.";
        }

        // Store the username and password for login
        storedUsername = username;
        storedPassword = password;
        return "Username and password accepted. User has been successfully registered.";
    }

    // Login check
    public static boolean loginUser(String username, String password) {
        return username.equals(storedUsername) && password.equals(storedPassword);
    }

    // Return login status
    public static String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Login successful. Welcome!";
        } else {
            return "Login failed. Username or password incorrect.";
        }
    }

    // Boolean username checker
    public static boolean checkUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Validate password format
    public static String validatePassword(String password) {
        if (password.length() >= 8) {
            Pattern capitalLetter = Pattern.compile("[A-Z]");
            Pattern specialChar = Pattern.compile("[^a-zA-Z0-9]");
            if (capitalLetter.matcher(password).find() && specialChar.matcher(password).find()) {
                return "Password successfully captured.";
            } else {
                return "Password incorrectly formatted. Please ensure your password contains a capital letter, special character, and is eight characters long.";
            }
        } else {
            return "Password incorrectly formatted. Please ensure your password contains a capital letter, special character, and is eight characters long.";
        }
    }

    // Boolean password checker
    public static boolean checkPasswordComplexity(String password) {
        if (password.length() < 8) return false;

        Pattern capitalLetter = Pattern.compile("[A-Z]");
        Pattern specialChar = Pattern.compile("[^a-zA-Z0-9]");
        Pattern digit = Pattern.compile("[0-9]");

        return capitalLetter.matcher(password).find()
                && specialChar.matcher(password).find()
                && digit.matcher(password).find();
    }

    // Validate phone number format
    public static String validatePhoneNumber(String phoneNumber) {
        String regex = "^\\+\\d{1,4}\\d{1,10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);

        if (matcher.matches()) {
            return "Cell phone number captured successfully.";
        } else {
            return "Cell phone number incorrectly formatted or doesn't contain international code.";
        }
    }

    // Boolean phone number checker
    public static boolean checkPhoneNumber(String phoneNumber) {
        String regex = "^\\+\\d{1,4}\\d{1,10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to the User Validation System!");

        // Register user
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();

        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        System.out.print("Enter your phone number (with international code): ");
        String phoneNumber = scanner.nextLine();

        // Validation checks
        System.out.println(validateUsername(username));
        System.out.println(validatePassword(password));
        System.out.println(validatePhoneNumber(phoneNumber));

        System.out.println("\n--- Boolean Checks ---");
        System.out.println("Username valid? " + checkUsername(username));
        System.out.println("Password valid? " + checkPasswordComplexity(password));
        System.out.println("Phone valid? " + checkPhoneNumber(phoneNumber));

        // Registration
        System.out.println("\n--- Registration Process ---");
        System.out.println(registerUser(username, password));

        // Login process
        System.out.println("\n--- Login Process ---");
        System.out.print("Enter your username to login: ");
        String loginUsername = scanner.nextLine();

        System.out.print("Enter your password to login: ");
        String loginPassword = scanner.nextLine();

        // Show login status
        System.out.println(returnLoginStatus(loginUsername, loginPassword));

        scanner.close();
    }
}

