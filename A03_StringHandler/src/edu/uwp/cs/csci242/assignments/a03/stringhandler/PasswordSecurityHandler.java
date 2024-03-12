package edu.uwp.cs.csci242.assignments.a03.stringhandler;

public class PasswordSecurityHandler implements StringHandler {
    private int length = 0;
    private boolean digit = false;
    private boolean otherCharacter = false;



    private final String SECURITY_LEVEL_WEAK = "weak";
    private final String SECURITY_LEVEL_MEDIUM = "medium";
    private final String SECURITY_LEVEL_STRONG = "strong";
    private final int PASSWORD_LENGTH = 8;



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

        if((getLength() >= PASSWORD_LENGTH) && (isDigit() && isOtherCharacter())){
            passwordStrength = SECURITY_LEVEL_STRONG;
        }
        else if((getLength() >= PASSWORD_LENGTH) && (isDigit() || isOtherCharacter())){
            passwordStrength = SECURITY_LEVEL_MEDIUM;
        }
        else if (getLength() < PASSWORD_LENGTH){
            passwordStrength = SECURITY_LEVEL_WEAK;
        }

        return passwordStrength;
    }


    @Override
    public void processDigit(char digit) {
        try {
            if(digit >= '0' && digit <= '9' ) {
                setLength(getLength() + 1);
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
                setLength(getLength() + 1);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(" Invalid Character: " + letter);
        }
    }

    @Override
    public void processOther(char other) {
        try {
            if ((other >= '!' && other <= '/') || (other >= ':' && other <= '@') || (other >= '[' && other <= '`') || (other >= '{' && other <= '~')) {
                setLength(getLength() + 1);
                setOtherCharacter(true);
            }
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(" Invalid Character: " + other);
        }
    }
}
