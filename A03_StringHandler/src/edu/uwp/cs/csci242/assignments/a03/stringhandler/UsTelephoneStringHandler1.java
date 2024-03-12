package edu.uwp.cs.csci242.assignments.a03.stringhandler;

public class UsTelephoneStringHandler1 implements StringHandler, Validator {
    public boolean validFormat;
    private int position;
    private int numberCounter;
    private boolean openParenthesis;
    private boolean closeParenthesis;
    private boolean hyphen;
    private boolean space;


    private final String VALID_PHONE_NUMBER = "Valid";
    private final String INVALID_PHONE_NUMBER = "Invalid";
    private final int MAX_STRING_LENGTH = 14;
    private  final int MAX_NUMBER_COUNT = 10;


    public UsTelephoneStringHandler1() {
        validFormat = true;
        position = 0;
        numberCounter = 0;
        openParenthesis = false;
        closeParenthesis = false;
        space = false;
        hyphen = false;
    }

    public boolean isValidFormat() {
        return validFormat;
    }

    public void setValidFormat(boolean validFormat) {
        this.validFormat = validFormat;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getNumberCounter() {
        return numberCounter;
    }

    public void setNumberCounter(int numberCounter) {
        this.numberCounter = numberCounter;
    }

    protected boolean hasOpenParenthesis() {
        return openParenthesis;
    }

    public void setOpenParenthesis(boolean openParenthesis) {
        this.openParenthesis = openParenthesis;
    }

    protected boolean hasCloseParenthesis() {
        return closeParenthesis;
    }

    public void setHasCloseParenthesis(boolean hasClosParenthesis) {
        this.closeParenthesis = hasClosParenthesis;
    }

    protected boolean hasHyphen() {
        return hyphen;
    }

    public void setHyphen(boolean hyphen) {
        this.hyphen = hyphen;
    }

    protected boolean hasSpace() {
        return space;
    }

    public void setSpace(boolean space) {
        this.space = space;
    }

    public String verifyPhoneNumber() {
        // Check if string is valid. If so then VALID_PHONE_NUMBER will be returned,
        // else INVALID_PHONE_NUMBER will be returned.
        if (getNumberCounter() == MAX_NUMBER_COUNT
                && getPosition() <= MAX_STRING_LENGTH
                && hasOpenParenthesis() && hasCloseParenthesis()
                && hasSpace() && hasHyphen()){
            return VALID_PHONE_NUMBER;
        } else return INVALID_PHONE_NUMBER;
    }

    @Override
    public void processDigit(char digit) {
        try {
            // Checks if position is less than values of STRING_LENGTH,
            // else if position is greater than STRING_LENGTH then validFormat is false.
            if (getPosition() < MAX_STRING_LENGTH) {
                // If digit is '0' through '9' and digit position is equal to 1-3, 6-8, or 10-13.
                setValidFormat(digit >= '0' && digit <= '9'
                        && ((getPosition() >= 1 && getPosition() <= 3)
                        || (getPosition() >= 6 && getPosition() >= 8)
                        || (getPosition() >= 10 && getPosition() <= 13)));
                setNumberCounter(getNumberCounter() + 1); // Ups numberCounter by 1.
            } else setValidFormat(false);

            setPosition(getPosition() + 1); // Ups number of position by 1.

            // Notes:
            // 012345678901234 = MAX_STRING_LENGTH
            // (123) 123-1234  = position

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
                // If other equals said character, position equal equals said position, and counters does not equal 1
                // else validFormat is false.
                if (other == '(' && getPosition() == 0)
                    // Ups number of hasOpenParenthesisCount by 1.
                    setHasCloseParenthesis(true);
                else if (other == ')' && getPosition() == 4)
                    // Ups number of hasClosParenthesisCount by 1.
                    setOpenParenthesis(true);
                else if (other == ' ' && getPosition() == 5)
                    // Ups number of hasSpaceCounter by 1.
                    setSpace(true);
                else if (other == '-' && getPosition() == 9)
                    // Ups number of hasHyphenCounter by 1.
                    setHyphen(true);
                else setValidFormat(false);
            } else setValidFormat(false);

            setPosition(getPosition() + 1); // Ups number of position by 1.

            // Notes:
            // 012345678901234 = MAX_STRING_LENGTH
            // (123)-123-1234  = position

        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(" Invalid Character: " + other);
        }
    }

    @Override
    public boolean isValid() {
        return isValidFormat();
    }
}