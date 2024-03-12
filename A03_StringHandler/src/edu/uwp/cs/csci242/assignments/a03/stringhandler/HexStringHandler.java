package edu.uwp.cs.csci242.assignments.a03.stringhandler;

import java.util.ArrayList;

public class HexStringHandler implements Validator, StringHandler{
    public boolean validHex = true;
    public int number = 0;



    private final ArrayList<Integer> numberList = new ArrayList<>();
    private final int INVALID_NUMBER = -1;
    private final int NUMBER_SYSTEM = 16;
    private final int NUMBER_LETTER_MIN = 10;
    private final int NUMBER_LETTER_MAX = 16;




    @Override
    public boolean isValid() {
        return validHex;
    }

    public int getNumber() {
        int result = 0;
        // Check if string is valid. If so then result will be calculated,
        // else result will equal INVALID_NUMBER.
        if(isValid()){
            // Loops thought numberList and calculates the result.
            for(int i = 1; i <= numberList.size(); i++){
                result+= numberList.get(i-1) * ((int) Math.pow(NUMBER_SYSTEM, numberList.size() - i));
            }
        } else result = INVALID_NUMBER;

        return result;
    }

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
            throw new IllegalArgumentException(" Invalid Character: " + digit);
        }
    }

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
                } else validHex = false;
            }
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(" Invalid Character: " + letter);
        }
    }

    @Override
    public void processOther(char other) {
        try {
            // If there is an other the case is automatically false.
            validHex = false;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(" Invalid Character: " + other);
        }
    }
}
