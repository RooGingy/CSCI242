package edu.uwp.cs.csci242.assignments.a03.stringhandler;

import java.util.Scanner;

public class StringParser {
    private static StringHandler handler;



    public StringParser() {
    }

    public StringParser(StringHandler handler) {
        this.handler = handler;
    }



    public StringHandler getHandler() {
        return handler;
    }
    public void setHandler(StringHandler handler) {
        this.handler = handler;
    }



    public static void parse(String s){
        // Converts String to char array.
        char[] charArray = s.toUpperCase().toCharArray();
        for(int i = 0; i< charArray.length; i++){
            handler.processDigit(charArray[i]);
            handler.processLetter(charArray[i]);
            handler.processOther(charArray[i]);
            HexStringHandler hSH;
            hSH.getNumber();
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a hexadecimal number >");
        String input = scanner.next();

        parse(input);

        System.out.println("A strong password has at least eight");
        System.out.println("characters and contains at least one digit");
        System.out.println("and one special characters.");

        System.out.println("Enter a password >");
        input = scanner.next();

        System.out.println(input +"'s security is: ");
    }
}
