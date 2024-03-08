package edu.uwp.cs.csci242.assignments.a03.stringhandler;

public abstract class HexStringHandler implements Validator, StringHandler{
    public boolean validHex;
    public int number;


    private final int INVALID_NUMBER = -1;
    private final int NUMBER_SYSTEM = 16;
    private final int NUMBER_LETTER_MIN = 10;
    private final int NUMBER_LETTER_MAX = 16;



    public HexStringHandler() {
        validHex = false;
        number = 0;
    }

    public HexStringHandler(boolean validHex, int number) {
        this.validHex = validHex;
        this.number = number;
    }

    public boolean isValid() {
        return validHex;
    }
    public void setValidHex(boolean validHex) {
        this.validHex = validHex;
    }
    public int getNumber() {
        return (number > INVALID_NUMBER) ? number : INVALID_NUMBER;
    }
    public void setNumber(int number) {
        this.number = number;
    }


    @Override
    public void processDigit(char digit) {
        int min = '0';   //ASCII 48
        int max = '9';   //ASCII 57

        if(digit >= min && digit <= max){
            setNumber(number-= 48);
        }
    }

    @Override
    public void processLetter(char letter) {
        int min = 'A';   //ASCII 65
        int max = 'F';   //ASCII 70

        if(letter >= min && letter <= max){
            setNumber(number -= 55);
        }
    }

    @Override
    public void processOther(char other) {
        int min1 = '0';
        int max1 = '9';
        int min2 = 'A';
        int max2 = 'F';
        if (!(other >= min1 && other <= max1) ||
                !(other >= min2 && other <= max2)) {
            validHex = false;
        }
    }
}
