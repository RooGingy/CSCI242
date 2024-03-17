package edu.uwp.cs.csci242.assignments.a03.stringhandler;

/**
 * This interface defines a method for checking whether data meets certain validation criteria.
 * Implementing classes are required to provide an implementation for the isValid method,
 * which returns true if the data is valid according to the defined criteria, and false otherwise.
 *
 * @author Austin Moser
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 003
 * @edu.uwp.cs.242.assignment 3
 * @bugs none
 */
public interface Validator {
    /**
     * Checks whether the data meets certain validation criteria.
     *
     * @return true if the data is valid according to the defined criteria, false otherwise.
     */
    boolean isValid();
}
