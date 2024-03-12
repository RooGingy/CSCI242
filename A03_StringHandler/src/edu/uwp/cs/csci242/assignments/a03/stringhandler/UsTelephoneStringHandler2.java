package edu.uwp.cs.csci242.assignments.a03.stringhandler;

public class UsTelephoneStringHandler2 implements StringHandler, Validator{
    public boolean validFormat;
    private int numberCounter;
    private int position;
    private boolean hyphen;



    private final String VALID_PHONE_NUMBER = "Valid";
    private final String INVALID_PHONE_NUMBER = "Invalid";
    private final int MAX_STRING_LENGTH = 12;
    private final int MAX_NUMBER_COUNT = 10;


    public UsTelephoneStringHandler2(){
        validFormat = true;
        position = 0;
        numberCounter = 0;
        hyphen = false;
    }

    public boolean isValidFormat() {
        return validFormat;
    }

    public void setValidFormat(boolean validFormat) {
        this.validFormat = validFormat;
    }

    public int getNumberCounter() {
        return numberCounter;
    }

    public void setNumberCounter(int numberCounter) {
        this.numberCounter = numberCounter;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    protected boolean hasHyphen() {
        return hyphen;
    }

    public void setHyphen(boolean hyphen) {
        this.hyphen = hyphen;
    }

    public String verifyPhoneNumber() {
        // Check if string is valid. If so then VALID_PHONE_NUMBER will be returned,
        // else INVALID_PHONE_NUMBER will be returned.
        if (getNumberCounter() == MAX_NUMBER_COUNT
                && getPosition() <= MAX_STRING_LENGTH
                && hasHyphen()){
            return VALID_PHONE_NUMBER;
        } else return INVALID_PHONE_NUMBER;
    }

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

    @Override
    public boolean isValid() {
        return isValidFormat();
    }
}
