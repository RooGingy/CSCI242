package edu.uwp.cs.csci242.assignments.a03.stringhandler;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;


        //Part 1:
        System.out.println("Enter a hexadecimal number > ");
        input = scanner.nextLine();

        HexStringHandler hsh = new HexStringHandler();
        new StringParser(hsh);
        StringParser.parse(input);

        System.out.println(input + " = " + hsh.getNumber());



        // Part 2:
        System.out.println("\nA strong password has at least eight");
        System.out.println("characters and contains at least one digit");
        System.out.println("and one special characters.");
        System.out.println("Enter a password >");
        input = scanner.nextLine();

        PasswordSecurityHandler psh = new PasswordSecurityHandler();
        new StringParser(psh);
        StringParser.parse(input);

        System.out.println(input +"'s security is: " + psh.securityLevel());



        // Extra Credit 1.1:
        System.out.println("\nEnter a us phone number using this format (XXX) XXX-XXXX >");
        input = scanner.nextLine();

        UsTelephoneStringHandler1 utsh1 = new UsTelephoneStringHandler1();
        new StringParser(utsh1);
        StringParser.parse(input);

        System.out.println(input + " is " + utsh1.verifyPhoneNumber());



        // Extra Credit 1.2:
        System.out.println("\nEnter a us phone number using this format XXX-XXX-XXXX >");
        input = scanner.nextLine();

        UsTelephoneStringHandler2 utsh2 = new UsTelephoneStringHandler2();
        new StringParser(utsh2);
        StringParser.parse(input);

        System.out.println(input + " is " + utsh2.verifyPhoneNumber());



        // Extra Credit 2:
    }
}
// Test:
// (123) 123-1234  : T
// (123) 123-12345 : T
// (abc) 123-1234  : T
// (123) abc-12345 : T
// (123) 123-12    : T
// (1a3) 1b3-12    : T