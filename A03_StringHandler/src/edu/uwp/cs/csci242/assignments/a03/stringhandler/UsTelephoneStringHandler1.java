package edu.uwp.cs.csci242.assignments.a03.stringhandler;

public class UsTelephoneStringHandler1 implements StringHandler, Validator {
    public boolean validFormat = true;


    private int position = 0;
    private int hasOpenParenthesisCount = 0;
    private int hasClosParenthesisCount = 0;
    private int hasHyphenCounter = 0;
    private int hasSpaceCounter = 0;


    private final String VALID_PHONE_NUMBER = "Valid";
    private final String INVALID_PHONE_NUMBER = "Invalid";
    private final int STRING_LENGTH = 14;


    public String getString() {
        // Check if string is valid. If so then VALID_PHONE_NUMBER will be returned,
        // else INVALID_PHONE_NUMBER will be returned.
        if (isValid())
            return VALID_PHONE_NUMBER;
        else return INVALID_PHONE_NUMBER;
    }

    @Override
    public void processDigit(char digit) {
        try {
            // Checks if position is less than values of STRING_LENGTH,
            // else if position is greater than STRING_LENGTH then validFormat is false.
            if (position < STRING_LENGTH) {
                // If digit is '0' through '9' and digit position is equal to 1-3, 6-8, or 10-13.
                validFormat = digit >= '0' && digit <= '9'
                        && ((position >= 1 && position <= 3)
                        || (position >= 6 && position >= 8)
                        || (position >= 10 && position <= 13));
            } else validFormat = false;

            position++; // Ups number of position by 1.

            // Notes:
            // 012345678901234 = STRING_LENGTH
            // (123) 123-1234  = String

        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(" Invalid Character: " + digit);
        }
    }

    @Override
    public void processLetter(char letter) {
        try {
            // Checks to see if letter is a letter. If so then validFormat will be false.
            if ((letter >= 'A' && letter <= 'Z') || (letter >= 'a' && letter <= 'z')) {
                validFormat = false;
            }

            position++; // Ups number of position by 1.

        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(" Invalid Character: " + letter);
        }
    }

    @Override
    public void processOther(char other) {
        try {
            // Checks if position is less than values of STRING_LENGTH,
            // else if position is greater than STRING_LENGTH then validFormat is false.
            if (position < STRING_LENGTH) {
                // If other equals said character, position equal equals said position, and counters does not equal 1
                // else validFormat is false.
                if (other == '(' && position == 0 && hasOpenParenthesisCount != 1)
                    // Ups number of hasOpenParenthesisCount by 1.
                    hasOpenParenthesisCount++;
                else if (other == ')' && position == 4 && hasClosParenthesisCount != 1)
                    // Ups number of hasClosParenthesisCount by 1.
                    hasClosParenthesisCount++;
                else if (other == ' ' && position == 5 && hasSpaceCounter != 1)
                    // Ups number of hasSpaceCounter by 1.
                    hasSpaceCounter++;
                else if (other == '-' && position == 9 && hasHyphenCounter != 1)
                    // Ups number of hasHyphenCounter by 1.
                    hasHyphenCounter++;
                else validFormat = false;
            } else validFormat = false;

            position++; // Ups number of position by 1.

            // Notes:
            // 012345678901234 = STRING_LENGTH
            // (123)-123-1234  = String

        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(" Invalid Character: " + other);
        }
    }


    @Override
    public boolean isValid() {
        return validFormat;
    }
}