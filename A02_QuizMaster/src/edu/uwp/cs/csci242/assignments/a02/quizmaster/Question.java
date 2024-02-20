/**
 * Question Class
 * <p>
 * This class includes functionality to handle questions with points and text.
 * It provides constructors to create questions with default or specified points and text,
 * as well as methods to retrieve and set the points and text of the question.
 *
 * @author Austin Moser
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 002
 * @edu.uwp.cs.242.assignment 2
 * @bugs None
 */

package edu.uwp.cs.csci242.assignments.a02.quizmaster;


public class Question {
    private int points;
    private String text;


    /**
     * Constructs a new Question object with default values.
     * <p>
     * This constructor initializes a new Question object with default values
     * for the point and the text. The text is set to empty strings
     * and the points is initialized to zero.
     */
    public Question(){
        this.points = 0;
        this.text = "";
    }


    /**
     * Constructs a new Player object with the specified points and text.
     * <p>
     * This constructor creates a new Question object with the provided points
     * and text.
     *
     * @param points The points of the question
     * @param text The text of the question.
     */
    public Question(int points, String text){
        this.points = points;
        this.text = text;
    }


    /**
     * Retrieves the points of the question.
     *
     * @return The point that the question was worth.
     */
    public int getPoints() {
        return points;
    }


    /**
     * Sets the points of the question.
     *
     * @param points The points of the question.
     */
    public void setPoints(int points) {
        this.points = points;
    }


    /**
     * Retrieves the text of the question.
     *
     * @return The text of the question.
     */
    public String getText() {
        return text;
    }


    /**
     * Sets the text of the question.
     *
     * @param text The text of the question.
     */
    public void setText(String text) {
        this.text = text;
    }


    /**
     * Converts a Question Object to a string.
     *
     * @return String of the question.
     */
    public String toString() { return getText(); }
}
