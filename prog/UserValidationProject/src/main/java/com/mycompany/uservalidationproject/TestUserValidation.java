/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uservalidationproject;

/**
 *
 * @author RC_Student_lab
 */
 



public class TestUserValidation {

    public static void main(String[] args) {

        // --- USERNAME TESTS ---
        System.out.println("== Username Validation Tests ==");
        System.out.println("Valid: " + UserValidationProject.validateUsername("abc_d")); // valid
        System.out.println("Invalid: " + UserValidationProject.validateUsername("abcd")); // missing underscore
        System.out.println("Too long: " + UserValidationProject.validateUsername("ab_cd123")); // too long

        System.out.println();

        // --- PASSWORD TESTS ---
        System.out.println("== Password Validation Tests ==");
        System.out.println("Valid: " + UserValidationProject.validatePassword("Pass@123")); // valid
        System.out.println("No special char: " + UserValidationProject.validatePassword("Pass1234")); // invalid
        System.out.println("Too short: " + UserValidationProject.validatePassword("P@1")); // invalid

        System.out.println();

        // --- PHONE NUMBER TESTS ---
        System.out.println("== Phone Number Validation Tests ==");
        System.out.println("Valid: " + UserValidationProject.validatePhoneNumber("+27831234567")); // valid
        System.out.println("Invalid (no +): " + UserValidationProject.validatePhoneNumber("27831234567")); // invalid
        System.out.println("Too long: " + UserValidationProject.validatePhoneNumber("+123456789012345")); // invalid

        System.out.println();

        // --- BOOLEAN CHECKS ---
        System.out.println("== Boolean Checks ==");
        System.out.println("Username valid? " + UserValidationProject.checkUsername("abc_d"));
        System.out.println("Password valid? " + UserValidationProject.checkPasswordComplexity("Pass@123"));
        System.out.println("Phone valid? " + UserValidationProject.checkPhoneNumber("+27831234567"));

        System.out.println();

        // --- REGISTRATION TEST ---
        System.out.println("== Registration Test ==");
        String registrationResult = UserValidationProject.registerUser("abc_d", "Pass@123");
        System.out.println(registrationResult);

        System.out.println();

        // --- LOGIN TESTS ---
        System.out.println("== Login Test ==");
        System.out.println("Login with correct credentials: " +
                UserValidationProject.returnLoginStatus("abc_d", "Pass@123")); // should succeed
        System.out.println("Login with wrong password: " +
                UserValidationProject.returnLoginStatus("abc_d", "wrongpass")); // should fail
        System.out.println("Login with wrong username: " +
                UserValidationProject.returnLoginStatus("wrong_user", "Pass@123")); // should fail
    }
}
