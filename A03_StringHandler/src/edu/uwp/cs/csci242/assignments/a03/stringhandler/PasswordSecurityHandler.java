package edu.uwp.cs.csci242.assignments.a03.stringhandler;

public abstract class PasswordSecurityHandler implements StringHandler {
    private int length;
    private boolean digit;
    private boolean otherCharacter;



    private final String SECURITY_LEVEL_WEAK = "weak";
    private final String SECURITY_LEVEL_MEDIUM = "medium";
    private final String SECURITY_LEVEL_STRONG = "strong";



    public PasswordSecurityHandler() {
    }

    public PasswordSecurityHandler(int length, boolean digit, boolean otherCharacter) {
        this.length = length;
        this.digit = digit;
        this.otherCharacter = otherCharacter;
    }



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



    public String securityLevel() throws IllegalArgumentException {
        String passwordStrenght = null;

        if (length < 8) {
            passwordStrenght = SECURITY_LEVEL_WEAK;
        } else if ((length >= 8) && (digit || otherCharacter)) {
            passwordStrenght = SECURITY_LEVEL_MEDIUM;
        } else if ((length >= 8) && (digit && otherCharacter)) {
            passwordStrenght = SECURITY_LEVEL_STRONG;
        }

        return passwordStrenght;
    }
}
