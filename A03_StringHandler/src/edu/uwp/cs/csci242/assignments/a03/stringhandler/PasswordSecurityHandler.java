package edu.uwp.cs.csci242.assignments.a03.stringhandler;

/**
 * This class implements a string handler for evaluating the security level of passwords.
 * It provides methods to check the length of the password, whether it contains digits,
 * and whether it contains characters other than letters and digits.
 * <p>
 * The security level of a password is categorized into three levels: Weak, Medium, or Strong,
 * based on criteria such as length, presence of digits, and other characters.
 * <p>
 * Passwords are considered Strong if they meet specific criteria including length, presence of digits,
 * and other characters. They are Medium if they meet either the length and digit or length and other character criteria,
 * and Weak if they don't meet any of the above.
 * <p>
 * This implementation provides methods to process digit, letter, and other characters
 * as part of password validation, and calculates the security level based on the evaluation of these characters.
 *
 * @author Austin Moser
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 003
 * @edu.uwp.cs.242.assignment 3
 * @bugs none
 */
public class PasswordSecurityHandler implements StringHandler {
    /** Represents the length of the password. */
    private int length;

    /** Represents whether the password contains at least one digit. */
    private boolean digit;

    /** Represents whether the password contains at least one otherCharacter. */
    private boolean otherCharacter;



    /** Represents the security level "weak" for passwords not meeting specific criteria. */
    private final String SECURITY_LEVEL_WEAK = "weak";

    /** Represents the security level "medium" for passwords not meeting specific criteria. */
    private final String SECURITY_LEVEL_MEDIUM = "medium";

    /** Represents the security level "strong" for passwords not meeting specific criteria. */
    private final String SECURITY_LEVEL_STRONG = "strong";

    /** Represents the minimum length required for a password. */
    private final int PASSWORD_LENGTH = 8;


    /**
     * Constructs a new PasswordSecurityHandler object.
     * <p>
     * This constructor initializes the PasswordSecurityHandler with default values.
     * It sets the length, digit, and otherCharacter variables to their initial states.
     */
    public PasswordSecurityHandler(){
        length = 0;
        digit = false;
        otherCharacter = false;
    }


    /**
     * Gets the length of the password.
     *
     * @return The length of the password.
     */
    protected int getLength() {
        return length;
    }


    /**
     * Sets the length of the password.
     *
     * @param length The length of the password.
     */
    public void setLength(int length) {
        this.length = length;
    }


    /**
     * Checks if the password contains digits.
     *
     * @return True if the password contains digits, otherwise false.
     */
    protected boolean isDigit() {return digit;}


    /**
     * Sets whether the password contains digits.
     *
     * @param digit True if the password contains digits, otherwise false.
     */
    public void setDigit(boolean digit) {
        this.digit = digit;
    }


    /**
     * Checks if the password contains characters other than letters and digits.
     *
     * @return True if the password contains other characters, otherwise false.
     */
    protected boolean isOtherCharacter() {return otherCharacter;}


    /**
     * Sets whether the password contains characters other than letters and digits.
     *
     * @param otherCharacter True if the password contains other characters, otherwise false.
     */
    public void setOtherCharacter(boolean otherCharacter) {
        this.otherCharacter = otherCharacter;
    }


    /**
     * Determines the security level of a password based on certain criteria.
     * <p>
     * This method evaluates the strength of a password based on its length, presence of digits, and other characters.
     * It categorizes the password into three levels: Strong, Medium, or Weak.
     * <p>
     * The password is considered Strong if it meets the following criteria:
     * - Length is greater than or equal to PASSWORD_LENGTH.
     * - Contains at least one digit.
     * - Contains at least one special character.
     * <p>
     * The password is considered Medium if it meets the following criteria:
     * - Length is greater than or equal to PASSWORD_LENGTH.
     * - Contains either a digit or special character.
     * <p>
     * If the password does not meet any of the above, then it is weak.
     *
     * @return A string representing the security level of the password. Possible values are:
     * - "Strong" for passwords meeting the strong criteria.
     * - "Medium" for passwords meeting the medium criteria.
     * - "Weak" for passwords not meeting any of the criteria.
     */
    public String securityLevel(){
        String passwordStrength = null;

        // Checks if password is greater than password length, has a number, and other character.
        if((getLength() >= PASSWORD_LENGTH) && (isDigit() && isOtherCharacter())){
            passwordStrength = SECURITY_LEVEL_STRONG;
        }
        // Checks if password is greater than password length, and has a number or other character.
        else if((getLength() >= PASSWORD_LENGTH) && (isDigit() || isOtherCharacter())){
            passwordStrength = SECURITY_LEVEL_MEDIUM;
        }
        // If they don't contain anything above then password is weak.
        else {
            passwordStrength = SECURITY_LEVEL_WEAK;
        }

        return passwordStrength;
    }


    /**
     * Processes a digit character.
     * <p>
     * This method is responsible for processing a digit character as part of password validation.
     * It increments the length of the password by 1 and sets the digit to true if the provided character is a digit.
     * <p>
     * If the character provided is not a digit, it throws an IllegalArgumentException with an appropriate message.
     *
     * @param digit The digit character to be processed.
     * @throws IllegalArgumentException If when an argument passed to a method doesn't fit within the logic of the usage of the argument.
     */
    @Override
    public void processDigit(char digit) {
        try {
            if(digit >= '0' && digit <= '9' ) {
                setLength(getLength() + 1); // Ups the length of the password by 1.
                setDigit(true); // sets digit to true;
            }
        } catch (IllegalArgumentException e){
            // Checks when an argument passed to a method doesn't fit within the logic of the usage of the argument.
            throw new IllegalArgumentException(" Invalid Character: " + digit);
        }
    }


    /**
     * Processes a letter character.
     * <p>
     * This method is responsible for processing a letter character as part of password validation.
     * It increments the length of the password by 1 if the provided character is a letter.
     * <p>
     * If the character provided is not a letter, it throws an IllegalArgumentException with an appropriate message.
     *
     * @param letter The letter character to be processed.
     * @throws IllegalArgumentException If when an argument passed to a method doesn't fit within the logic of the usage of the argument.
     */
    @Override
    public void processLetter(char letter) {
        try {
            if((letter >= 'A' && letter <= 'Z') || (letter >= 'a' && letter <= 'z')) {
                setLength(getLength() + 1); // Ups the length of the password by 1.
            }
        } catch (IllegalArgumentException e) {
            // Checks when an argument passed to a method doesn't fit within the logic of the usage of the argument.
            throw new IllegalArgumentException(" Invalid Character: " + letter);
        }
    }


    /**
     * Processes an other character.
     * <p>
     * This method is responsible for processing an other character as part of password validation.
     * It increments the length of the password by 1 if the provided character is an other character.
     * Additionally, it sets the otherCharacter to true if the character belongs to the category of other characters.
     * <p>
     * If the character provided does not belong to the category of other characters, it throws an IllegalArgumentException with an appropriate message.
     *
     * @param other The other character to be processed.
     * @throws IllegalArgumentException If when an argument passed to a method doesn't fit within the logic of the usage of the argument.
     */
    @Override
    public void processOther(char other) {
        try {
            // Check to see if other character is between '!' and '/', ':' and '@', '[' and '`', or '{' and '~'.
            if ((other >= '!' && other <= '/') || (other >= ':' && other <= '@') || (other >= '[' && other <= '`') || (other >= '{' && other <= '~')) {
                setLength(getLength() + 1); // Ups the length of the password by 1.
                setOtherCharacter(true); // sets otherCharacter to true;
            }
        } catch (IllegalArgumentException e){
            // Checks when an argument passed to a method doesn't fit within the logic of the usage of the argument.
            throw new IllegalArgumentException(" Invalid Character: " + other);
        }
    }
}
