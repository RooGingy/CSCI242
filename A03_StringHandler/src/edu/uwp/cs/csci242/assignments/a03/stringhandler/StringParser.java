package edu.uwp.cs.csci242.assignments.a03.stringhandler;

import java.util.Scanner;

public class StringParser {
    private static StringHandler handler;


    public StringParser(StringHandler handler) {
        StringParser.handler = handler;
    }



    public StringHandler getHandler() {
        return handler;
    }
    public void setHandler(StringHandler handler) {
        StringParser.handler = handler;
    }



    public static void parse(String s){
        // Converts String to char array.
        char[] charArray = s.toCharArray();

        for(int i = 0; i < charArray.length; i++){
            if(charArray[i] >= '0' && charArray[i] <= '9')
                handler.processDigit(charArray[i]);
            else if ((charArray[i] >= 'A' && charArray[i] <= 'Z') ||
                     (charArray[i] >= 'a' && charArray[i] <= 'z'))
                handler.processLetter(charArray[i]);
            else
                handler.processOther(charArray[i]);
        }
    }
}
