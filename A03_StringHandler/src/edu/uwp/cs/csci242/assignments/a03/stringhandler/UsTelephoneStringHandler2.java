package edu.uwp.cs.csci242.assignments.a03.stringhandler;

/**
 * Handles and validates US telephone numbers.
 * <p>
 * This class provides methods to process and validate US telephone numbers.
 * It maintains information such as the current position in processing the number,
 * the count of numbers encountered, and whether the format is valid or not.
 * <p>
 * The class implements the StringHandler and Validator interfaces.
 * It provides methods to process digits, letters, and other characters in the phone number string.
 * <p>
 * If the phone number format is valid, it returns "Valid"; otherwise, it returns "Invalid".
 *
 * @author Austin Moser
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 003
 * @edu.uwp.cs.242.assignment 3
 * @bugs none
 */
public class UsTelephoneStringHandler2 implements StringHandler, Validator{
    /** Indicates whether the format is valid or not. */
    public boolean validFormat;

    /** Represents the current position. */
    private int position;

    /** Tracks the count of numbers encountered. */
    private int numberCounter;

    /** Indicates whether a hyphen has been encountered. */
    private boolean hyphen;



    /** Represents a valid phone number status. */
    private final String VALID_PHONE_NUMBER = "Valid";

    /** Represents an invalid phone number status. */
    private final String INVALID_PHONE_NUMBER = "Invalid";

    /** Represents the maximum allowed length for a phone number string. */
    private final int MAX_STRING_LENGTH = 12;

    /** Represents the maximum allowed count of numbers in a phone number string. */
    private  final int MAX_NUMBER_COUNT = 10;


    /**
     * Initializes a new instance of UsTelephoneStringHandler1.
     * <p>
     * This constructor initializes the UsTelephoneStringHandler1 object with default values.
     * It sets the validFormat flag to true, the position to 0, the numberCounter to 0,
     * and sets hyphen flags to false.
     */
    public UsTelephoneStringHandler2(){
        validFormat = true;
        position = 0;
        numberCounter = 0;
        hyphen = false;
    }

    /**
     * Checks if the phone number has a valid format.
     *
     * @return True if the phone number has a valid format, otherwise false.
     */
    public boolean isValidFormat() {
        return validFormat;
    }


    /**
     * Sets whether the phone number has a valid format.
     *
     * @param validFormat True if the phone number has a valid format, otherwise false.
     */
    public void setValidFormat(boolean validFormat) {
        this.validFormat = validFormat;
    }


    /**
     * Gets the current position in processing the phone number.
     *
     * @return The current position.
     */
    public int getPosition() {
        return position;
    }

    /**
     * Sets the current position in processing the phone number.
     *
     * @param position The current position.
     */
    public void setPosition(int position) {
        this.position = position;
    }


    /**
     * Gets the number of digits encountered so far.
     *
     * @return The number of digits encountered.
     */
    public int getNumberCounter() {
        return numberCounter;
    }


    /**
     * Sets the number of digits encountered so far.
     *
     * @param numberCounter The number of digits encountered.
     */
    public void setNumberCounter(int numberCounter) {
        this.numberCounter = numberCounter;
    }


    /**
     * Checks if a hyphen '-' is encountered.
     *
     * @return True if a hyphen is encountered, otherwise false.
     */
    protected boolean hasHyphen() {
        return hyphen;
    }


    /**
     * Sets whether a hyphen '-' is encountered.
     *
     * @param hyphen True if a hyphen is encountered, otherwise false.
     */
    public void setHyphen(boolean hyphen) {
        this.hyphen = hyphen;
    }


    /**
     * Verifies if a phone number string is valid.
     * <p>
     * This method checks various conditions such as the number count,
     * position, and hyphens to determine the validity of the phone number.
     * <p>
     * If all conditions are met, VALID_PHONE_NUMBER will be returned.
     * Otherwise, INVALID_PHONE_NUMBER will be returned.
     *
     * @return return a string stating if phone number is valid or invalid.
     */
    public String verifyPhoneNumber() {
        // Check if string is valid. If so then VALID_PHONE_NUMBER will be returned,
        // else INVALID_PHONE_NUMBER will be returned.
        if (getNumberCounter() == MAX_NUMBER_COUNT
                && getPosition() <= MAX_STRING_LENGTH
                && hasHyphen()){
            return VALID_PHONE_NUMBER;
        } else return INVALID_PHONE_NUMBER;
    }


    /**
     * Processes a single digit of a phone number.
     * <p>
     * This method handles the processing of individual digits of a phone number.
     * It checks if the position is within the maximum string length and validates
     * whether the digit is within the acceptable range for specific positions.
     * <p>
     * If the position is within the acceptable range and the digit is between '0' and '9',
     * the method increments the number counter and sets the valid format accordingly.
     * Otherwise, it sets the valid format to false.
     *
     *
     * @param digit The digit character to be processed.
     * @throws IllegalArgumentException If when an argument passed to a method doesn't fit within the logic of the usage of the argument.
     */
    @Override
    public void processDigit(char digit) {
        try {
            // Checks if position is less than values of STRING_LENGTH,
            // else if position is greater than STRING_LENGTH then validFormat is false.
            if (getPosition() < MAX_STRING_LENGTH) {
                // If digit is '0' through '9' and digit position is equal to 0-2, 6-8, or 10-13.
                setValidFormat(digit >= '0' && digit <= '9'
                        && ((getPosition() >= 1 && getPosition() <= 3)
                        || (getPosition() >= 4 && getPosition() >= 6)
                        || (getPosition() >= 8 && getPosition() <= 11)));
                setNumberCounter(getNumberCounter() + 1); // Ups numberCounter by 1.
            } else setValidFormat(false);

            setPosition(getPosition() + 1); // Ups number of position by 1.

            // Notes:
            // 0123456789012 = MAX_STRING_LENGTH
            // 123-123-1234  = position

        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(" Invalid Character: " + digit);
        }
    }


    /**
     * Processes a single letter of a phone number.
     * <p>
     * This method handles the processing of individual letters of a phone number.
     * It checks if the provided character is a letter, in which case it sets the valid format to false.
     * <p>
     * The position is incremented regardless of the character being a letter or not.
     *
     * @param letter The letter to be processed.
     * @throws IllegalArgumentException If when an argument passed to a method doesn't fit within the logic of the usage of the argument.
     */
    @Override
    public void processLetter(char letter) {
        try {
            // Checks to see if letter is a letter. If so then validFormat will be false.
            if ((letter >= 'A' && letter <= 'Z') || (letter >= 'a' && letter <= 'z')) {
                setValidFormat(false);
            }

            setPosition(getPosition() + 1); // Ups number of position by 1.

        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(" Invalid Character: " + letter);
        }
    }


    /**
     * Processes characters other than digits and letters in a phone number.
     * <p>
     * This method handles the processing of characters other than digits and letters,
     * such as hyphens, in a phone number. It checks if the position is within the
     * maximum string length and validates whether the hyphen is at the correct position
     * according to the phone number format.
     * <p>
     * If the hyphen is at the correct position, the hyphen flag will be set to true.
     * Otherwise, the valid format flag will be set to false.
     *
     * @param other The character to be processed.
     * @throws IllegalArgumentException If when an argument passed to a method doesn't fit within the logic of the usage of the argument.
     */
    @Override
    public void processOther(char other) {
        try {
            // Checks if position is less than values of STRING_LENGTH,
            // else if position is greater than STRING_LENGTH then validFormat is false.
            if (getPosition() < MAX_STRING_LENGTH) {
                if (other == '-' && (getPosition() == 3 || getPosition() == 7))
                    // Ups number of hasHyphenCounter by 1.
                    setHyphen(true);
                else setValidFormat(false);
            } else setValidFormat(false);

            setPosition(getPosition() + 1); // Ups number of position by 1.

            // Notes:
            // 0123456789012 = MAX_STRING_LENGTH
            // 123-123-1234  = position

        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(" Invalid Character: " + other);
        }
    }


    /**
     * Checks if the phone number format is valid.
     * <p>
     * This method returns a boolean value indicating whether the phone number format
     * is valid based on the processing done by other methods in the class.
     *
     * @return if true the phone number format is valid, otherwise false.
     */
    @Override
    public boolean isValid() {
        return isValidFormat();
    }
}
