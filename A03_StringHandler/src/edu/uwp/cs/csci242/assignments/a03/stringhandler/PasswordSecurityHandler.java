package edu.uwp.cs.csci242.assignments.a03.stringhandler;

public class PasswordSecurityHandler implements StringHandler {
    private int length = 0;
    private boolean digit = true;
    private boolean otherCharacter = true;



    private final String SECURITY_LEVEL_WEAK = "weak";
    private final String SECURITY_LEVEL_MEDIUM = "medium";
    private final String SECURITY_LEVEL_STRONG = "strong";


//    public PasswordSecurityHandler(int length, boolean digit, boolean otherCharacter) {
//        this.length = length;
//        this.digit = digit;
//        this.otherCharacter = otherCharacter;
//    }


    protected int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    protected boolean isDigit() {
        return digit;
    }
    public void setDigit(boolean digit) {
        this.digit = digit;
    }
    protected boolean isOtherCharacter() {
        return otherCharacter;
    }
    public void setOtherCharacter(boolean otherCharacter) {
        this.otherCharacter = otherCharacter;
    }



    public String securityLevel(){
        String passwordStrenght = null;

        if ((length >= 8) && (digit && otherCharacter))
            passwordStrenght = SECURITY_LEVEL_STRONG;
        else if ((length >= 8) && (digit || otherCharacter))
            passwordStrenght = SECURITY_LEVEL_MEDIUM;
        else
            passwordStrenght = SECURITY_LEVEL_WEAK;

        return passwordStrenght;
    }


    @Override
    public void processDigit(char digit) {
        try {
            this.digit = true;
            this.length++;
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(" Invalid Character: " + digit);
        }
    }

    @Override
    public void processLetter(char letter) {
        try {
            this.length++;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(" Invalid Character: " + letter);
        }
    }

    @Override
    public void processOther(char other) {
        try {
            this.otherCharacter = true;
            this.length++;
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(" Invalid Character: " + other);
        }
    }
}
