package edu.uwp.cs.csci242.assignments.a03.stringhandler;

/**
 * This class provides functionality for parsing strings and processing their characters using a StringHandler object.
 * It allows setting and getting the StringHandler object for parsing, and provides a method to parse a string.
 * <p>
 * The parse method takes a string as input, converts it to a character array, and iterates through each character.
 * For each character, it calls the appropriate method in the StringHandler object to process the character,
 * categorizing them as digits, letters, or other characters based on their ASCII values.
 *
 * @author Austin Moser
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 003
 * @edu.uwp.cs.242.assignment 3
 * @bugs none
 */
public class StringParser {
    /** Represents the StringHandler object used for parsing. */
    private static StringHandler handler;


    /**
     * Constructs a new StringParser object with the specified StringHandler.
     *
     * @param handler The StringHandler object to be set for parsing.
     */
    public StringParser(StringHandler handler) {
        StringParser.handler = handler;
    }


    /**
     * Gets the StringHandler object currently set for parsing.
     *
     * @return The StringHandler object currently set for parsing.
     */
    public StringHandler getHandler() {
        return handler;
    }

    /**
     * Sets the StringHandler object for parsing.
     *
     * @param handler The StringHandler object to be set for parsing.
     */
    public void setHandler(StringHandler handler) {
        StringParser.handler = handler;
    }


    /**
     * Parses a string and processes its characters.
     * <p>
     * This method takes a string as input, converts it to a character array, and iterates through each character.
     * For each character, it calls the appropriate method in the StringHandler object to process the character.
     * Characters are categorized as digits, letters, or other characters based on their ASCII values.
     *
     * @param s The string to be parsed.
     */
    public static void parse(String s){
        // Converts String to char array.
        char[] charArray = s.toCharArray();

        // Loops thought the character to check if its a letter, digit, or other
        for(int i = 0; i < charArray.length; i++) {
            if (charArray[i]  >= '0' && charArray[i] <= '9')
                handler.processDigit(charArray[i]);
            else if((charArray[i] >= 'A' && charArray[i]  <= 'Z') || (charArray[i]  >= 'a' && charArray[i]  <= 'z'))
                handler.processLetter(charArray[i]);
            else
                handler.processOther(charArray[i]);
        }
    }
}
