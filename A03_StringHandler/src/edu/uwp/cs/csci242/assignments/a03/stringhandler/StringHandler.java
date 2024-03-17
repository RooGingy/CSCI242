package edu.uwp.cs.csci242.assignments.a03.stringhandler;

/**
 * This interface defines methods for processing different types of characters within a string.
 * It provides functionality to handle digit characters, letter characters, and other characters.
 * <p>
 * Implementing classes are required to provide implementations for the processDigit,
 * processLetter, and processOther methods, which specify how each type of character should be processed.
 *
 * @author Austin Moser
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 003
 * @edu.uwp.cs.242.assignment 3
 * @bugs none
 */
public interface StringHandler {
    /**
     * Processes a digit character.
     *
     * @param digit The digit character to be processed.
     */
    public void processDigit(char digit);

    /**
     * Processes a letter character.
     *
     * @param letter The letter character to be processed.
     */
    public void processLetter(char letter);

    /**
     * Processes an other character.
     *
     * @param other The other character to be processed.
     */
    public void processOther(char other);
}
