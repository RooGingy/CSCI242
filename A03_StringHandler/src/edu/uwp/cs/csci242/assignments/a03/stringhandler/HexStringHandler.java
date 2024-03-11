package edu.uwp.cs.csci242.assignments.a03.stringhandler;

import java.util.ArrayList;

public class HexStringHandler implements Validator, StringHandler{
    public boolean validHex = true;
    public int number = 0;

    private final int INVALID_NUMBER = -1;
    private final int NUMBER_SYSTEM = 16;
    private final int NUMBER_LETTER_MIN = 10;
    private final int NUMBER_LETTER_MAX = 16;



    public static ArrayList<Integer> numberList = new ArrayList<>();

    @Override
    public boolean isValid() {
        return validHex;
    }

    public int getNumber() {
        int result = 0;

        if(isValid()){
            for(int i = 1; i <= numberList.size(); i++){
                result+= numberList.get(i-1) * ((int) Math.pow(NUMBER_SYSTEM, numberList.size() - i));
            }
        }
        else result = INVALID_NUMBER;

        return result;
    }

    @Override
    public void processDigit(char digit) {
        try {
            numberList.add(number = digit - '0');
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(" Invalid Character: " + digit);
        }
    }

    @Override
    public void processLetter(char letter) {
        try {
            String letterString = letter + "";
            letter = letterString.toUpperCase().charAt(0);
            number = letter - 'A'+ NUMBER_LETTER_MIN;
            if(number >= NUMBER_LETTER_MIN && number <= NUMBER_LETTER_MAX){
                numberList.add(number);
            }
            else validHex = false;
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(" Invalid Character: " + letter);
        }
    }

    @Override
    public void processOther(char other) {
        try {
            validHex = false;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(" Invalid Character: " + other);
        }
    }
}
