/**
 * The QuestionMC class
 * <p>
 * This class extends the Question class and handles multiple-choice-answer questions.
 * It provides constructors to create multiple-choice-answer questions with default or specified answers,
 * as well as methods to retrieve and set the answer of the question.
 *
 * @author Austin Moser
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 002
 * @edu.uwp.cs.242.assignment 2
 * @bugs None
 */

package edu.uwp.cs.csci242.assignments.a02.quizmaster;

public class QuestionMC extends Question {

    /**
     * The answer of the question.
     */
    private char answer;    // The questions answer.

    /**
     * Constructs a new multiple-choice question object with a default answer.
     * <p>
     * This constructor creates a new QuestionMC object with a default answer 'A'.
     */
    public QuestionMC(){ this.answer = 'A'; }


    /**
     * Constructs a new short-answer question object with the specified answer.
     * <p>
     * This constructor creates a new QuestionMC object with the provided answer.
     *
     * @param answer The correct answer to the multiple-choice question.
     */
    public QuestionMC(char answer){
        this.answer = answer;
    }


    /**
     * Constructs a new multiple-choice question object with the specified points, text, and answer.
     * <p>
     * This constructor creates a new QuestionMC object with the given points, text, and answer.
     *
     * @param points The point value of the multiple-choice question.
     * @param text The text of the multiple-choice question.
     * @param answer The correct answer to the multiple-choice question.
     */
    public QuestionMC(int points, String text, char answer){
        super();
        super.setPoints(points);
        super.setText(text);
        this.answer = answer;
    }

    /**
     * Retrieves the answer of the question.
     *
     * @return The answer of the question.
     */
    public char getAnswer() {
        return answer;
    }


    /**
     * Sets the answer of the type of question.
     *
     * @param answer The text of the question.
     */
    public void setAnswer(char answer) { this.answer = answer; }


    /**
     * Converts a QuestionSA Object to a string.
     *
     * @return the answer of the object to as a string.
     */
    public String toString(){ return String.valueOf(getAnswer()); }
}