package edu.uwp.cs.csci242.assignments.a03.stringhandler;

public class PasswordSecurityHandler implements StringHandler {
    private int length;
    private boolean digit;
    private boolean otherCharacter;



    private final String SECURITY_LEVEL_WEAK = "weak";
    private final String SECURITY_LEVEL_MEDIUM = "medium";
    private final String SECURITY_LEVEL_STRONG = "strong";


    public PasswordSecurityHandler(){
        length = 0;
        digit = false;
        otherCharacter = false;
    }

    protected int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    protected boolean isDigit() {return digit;}
    public void setDigit(boolean digit) {
        this.digit = digit;
    }

    protected boolean isOtherCharacter() {return otherCharacter;}
    public void setOtherCharacter(boolean otherCharacter) {
        this.otherCharacter = otherCharacter;
    }



    public String securityLevel(){
        String passwordStrength = null;

        if((length >= 8) && (digit && otherCharacter)){
            passwordStrength = SECURITY_LEVEL_STRONG;
        }
        else if((length >= 8) && (digit || otherCharacter)){
            passwordStrength = SECURITY_LEVEL_MEDIUM;
        }
        else {
            passwordStrength = SECURITY_LEVEL_WEAK;
        }

        return passwordStrength;
    }


    @Override
    public void processDigit(char digit) {
        try {
            if(digit >= '0' && digit <= '9' ) {
                length++;
                setLength(length++);
                setDigit(true);
            }
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(" Invalid Character: " + digit);
        }
    }

    @Override
    public void processLetter(char letter) {
        try {
            if((letter >= 'A' && letter <= 'Z') || (letter >= 'a' && letter <= 'z')) {
                length++;
                setLength(length);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(" Invalid Character: " + letter);
        }
    }

    @Override
    public void processOther(char other) {
        try {
            length++;
            setLength(length);
            setOtherCharacter(true);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(" Invalid Character: " + other);
        }
    }
}
