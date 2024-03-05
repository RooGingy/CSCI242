package edu.uwp.cs.csci242.assignments.a03.stringhandler;

public abstract class HexStringHandler implements Validator, StringHandler{
    public boolean validHex;
    public int number;


    private final int INVALID_NUMBER = -1;
    private final int NUMBER_SYSTEM = 16;
    private final int NUMBER_LITTER_MIN = 10;
    private final int NUMBER_LITTER_MAX = 16;



    public HexStringHandler() {
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
        return INVALID_NUMBER;
    }
    public void setNumber(int number) {
        this.number = number;
    }
}
