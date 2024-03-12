package edu.uwp.cs.csci242.assignments.a03.stringhandler;

public class UsTelephoneStringHandler2 implements StringHandler, Validator{
    public boolean validFormat = true;


    private int position = 0;
    private int hasHyphenCounter = 0;



    private final String VALID_PHONE_NUMBER = "Valid";
    private final String INVALID_PHONE_NUMBER = "Invalid";
    private final int STRING_LENGTH = 12;



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
                // If digit is '0' through '9' and digit position is equal to 0-2, 6-8, or 10-13.
                validFormat = digit >= '0' && digit <= '9'
                        && ((position >= 1 && position <= 3)
                        || (position >= 4 && position >= 6)
                        || (position >= 8 && position <= 11));
            } else validFormat = false;

            position++; // Ups number of position by 1.

            // Notes:
            // 012345678901234 = STRING_LENGTH
            // 123-123-1234  = String

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
                if (other == '-' && (position == 3 || position == 7) && hasHyphenCounter != 2)
                    // Ups number of hasHyphenCounter by 1.
                    hasHyphenCounter++;
                else validFormat = false;
            } else validFormat = false;

            position++; // Ups number of position by 1.

            // Notes:
            // 012345678901234 = STRING_LENGTH
            // 123-123-1234  = String

        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(" Invalid Character: " + other);
        }
    }

    @Override
    public boolean isValid() {
        return validFormat;
    }
}
