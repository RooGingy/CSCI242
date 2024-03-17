package edu.uwp.cs.csci242.assignments.a03.stringhandler;
import java.util.Scanner;

/**
 * Contains the main method to execute the StringParser and various StringHandlers.
 * <p>
 * This class prompts the user for input and utilizes different StringHandlers through StringParser to process the input.
 * It demonstrates the functionality of handling hexadecimal values, passwords, and US phone numbers.
 *
 * @author Austin Moser
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 003
 * @edu.uwp.cs.242.assignment 3
 * @bugs none
 */
public class Main {
    /**
     * This method demonstrates the usage of StringParser class to handle different types of strings,
     * such as hexadecimal numbers, passwords, and US phone numbers, with various handlers.
     * <p>
     * The method prompts the user to input different types of strings and utilizes the StringParser
     * class to parse them. It then prints the results obtained from different handlers.
     * <p>
     * The method showcases the functionality of parsing hexadecimal numbers, evaluating password
     * security, and formatting US phone numbers using different handlers.
     */
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
    }
}