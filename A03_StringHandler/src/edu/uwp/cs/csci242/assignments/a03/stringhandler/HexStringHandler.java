package edu.uwp.cs.csci242.assignments.a03.stringhandler;
import java.util.ArrayList;

/**
 * This class implements a validator and string handler for processing hexadecimal strings.
 * It provides methods to validate hexadecimal format, process digit characters,
 * letter characters, and other characters, and calculate the decimal value of the hexadecimal string.
 * <p>
 * The class maintains a list of numerical values representing the hexadecimal decimal values,
 * and it calculates the numerical value based on the positional weights of the digits.
 * If the input string contains invalid characters, the validHex flag is set to false.
 * <p>
 * This implementation follows the Validator and StringHandler interfaces,
 * providing a modular and extensible approach for handling hexadecimal strings.
 *
 * @author Austin Moser
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 003
 * @edu.uwp.cs.242.assignment 3
 * @bugs none
 */
public class HexStringHandler implements Validator, StringHandler{
    /** Indicates whether the format is valid or not. */
    public boolean validHex = true;

    /** Represents the result of the hex digit decimal number. */
    public int number = 0;


    /** Used to store the decimal value of number in the hex digit. */
    private final ArrayList<Integer> numberList = new ArrayList<>();

    /** Represents invalid number for when the character is not a hex digit. */
    private final int INVALID_NUMBER = -1;

    /** Represents the total number of hex digits */
    private final int NUMBER_SYSTEM = 16;

    /** Represents the min number that hex 'A' start at*/
    private final int NUMBER_LETTER_MIN = 10;

    /** Represents the max number of the hex digit*/
    private final int NUMBER_LETTER_MAX = 16;


    /**
     * Calculates a numerical value based on the elements of numberList.
     * <p>
     * If the string is valid, it iterates through numberList and calculates the result
     * based on positional weights. If the string is invalid, returns INVALID_NUMBER.
     *
     * @return The calculated numerical value or INVALID_NUMBER if the string is invalid.
     */
    public int getNumber() {
        int result = 0;
        // Check if string is valid. If so then result will be calculated,
        // else result will equal INVALID_NUMBER.
        if(isValid()){
            // Iterates thought numberList and calculates the result.
            for(int i = 1; i <= numberList.size(); i++){
                result+= numberList.get(i-1) * ((int) Math.pow(NUMBER_SYSTEM, numberList.size() - i));
            }
        } else result = INVALID_NUMBER;

        return result;
    }


    /**
     * Processes a digit character.
     * <p>
     * If the character is a digit ('0' through '9'), converts it to a numerical value
     * and stores it in the numberList. Otherwise, throws an IllegalArgumentException.
     *
     * @param digit The digit character to be processed.
     * @throws IllegalArgumentException If when an argument passed to a method doesn't fit within the logic of the usage of the argument.
     */
    @Override
    public void processDigit(char digit) {
        try {
            // If digit is '0' through '9'.
            if (digit >= '0' && digit <= '9') {
                // digit converted to a number and is subtracted by '0'
                // Then stored to the numberList.
                numberList.add(number = digit - '0');
            }
        } catch (IllegalArgumentException e){
            // Checks when an argument passed to a method doesn't fit within the logic of the usage of the argument.
            throw new IllegalArgumentException(" Invalid Character: " + digit);
        }
    }


    /**
     * Processes a letter character.
     * <p>
     * If the character is a letter ('A' through 'Z' or 'a' through 'z'), converts it to uppercase,
     * calculates a numerical value based on its position of a decimal value using NUMBER_LETTER_MIN, and stores it in numberList.
     * If the calculated value is not within the valid range, sets validHex to false.
     *
     * @param letter The letter character to be processed.
     * @throws IllegalArgumentException If when an argument passed to a method doesn't fit within the logic of the usage of the argument.
     */
    @Override
    public void processLetter(char letter) {
        try {
            // Checks to see if letter is a letter.
            if ((letter >= 'A' && letter <= 'Z') || (letter >= 'a' && letter <= 'z')) {
                // Converts char to String.
                String letterString = letter + "";
                // Upper cases letter and convert it back to a char.
                letter = letterString.toUpperCase().charAt(0);

                // letter is converted to a number and is subtracted by 'A',
                // and then added with the value of NUMBER_LETTER_MIN.
                // letter is then stored to number.
                number = letter - 'A' + NUMBER_LETTER_MIN;

                // Checks if number is between NUMBER_LETTER_MIN and NUMBER_LETTER_MAX,
                // else validHex equals false.
                if (number >= NUMBER_LETTER_MIN && number <= NUMBER_LETTER_MAX) {
                    // number is then stored to the numberList.
                    numberList.add(number);
                } else validHex = false; // Sets valid hex to false.
            }
        } catch (IllegalArgumentException e){
            // Checks when an argument passed to a method doesn't fit within the logic of the usage of the argument.
            throw new IllegalArgumentException(" Invalid Character: " + letter);
        }
    }


    /**
     * Processes a character other than a digit or letter.
     * <p>
     * Sets the validHex flag to false, indicating that the character is not part of the valid hex representation.
     *
     * @param other The character to be processed.
     */
    @Override
    public void processOther(char other) {
        try {
            // If there is an other the case is automatically false.
            validHex = false; // Sets valid hex to false.
        } catch (IllegalArgumentException e) {
            // Checks when an argument passed to a method doesn't fit within the logic of the usage of the argument.
            throw new IllegalArgumentException(" Invalid Character: " + other);
        }
    }


    /**
     * Checks whether the current state is valid for a hexadecimal representation.
     *
     * @return true if the state is valid for a hexadecimal representation, false otherwise.
     */
    @Override
    public boolean isValid() {
        return validHex;
    }
}
