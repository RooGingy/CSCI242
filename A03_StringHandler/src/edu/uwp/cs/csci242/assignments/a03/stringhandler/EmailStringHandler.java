package edu.uwp.cs.csci242.assignments.a03.stringhandler;

public class EmailStringHandler implements StringHandler, Validator{
    private final int MAX_STRING_LENGTH = 73;
    private final int MAX_USERNAME_LENGTH = 64;




    @Override
    public void processDigit(char digit) {

    }

    @Override
    public void processLetter(char letter) {

    }

    @Override
    public void processOther(char other) {

    }

    @Override
    public boolean isValid() {
        return false;
    }
}
