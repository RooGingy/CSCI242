/**
 * The QuestionTF class
 * <p>
 * This class extends the Question class and handles true/false-answer questions.
 * It provides constructors to create true/false-answer questions with default or specified answers,
 * as well as methods to retrieve and set the answer of the question.
 *
 * @author Austin Moser
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 002
 * @edu.uwp.cs.242.assignment 2
 * @bugs None
 */

package edu.uwp.cs.csci242.assignments.a02.quizmaster;

public class QuestionTF extends Question {
    /**
     * The answer of the question.
     */
    private boolean answer; // The questions answer.


    /**
     * Constructs a new true/false-answer question object with a default answer.
     * <p>
     * This constructor creates a new QuestionTF object with a set empty string.
     */
    public QuestionTF(){
        super();
        this.answer = true;
    }


    /**
     * Constructs a new true/false-answer question object with the specified answer.
     * <p>
     * This constructor creates a new QuestionTF object with the provided answer.
     *
     * @param answer The correct answer to the true/false question.
     */
    public QuestionTF(boolean answer){
        super();
        this.answer=answer;
    }


    /**
     * Constructs a new true/false-answer question object with the specified points, text, and answer.
     * <p>
     * This constructor creates a new QuestionTF object with the given points, text, and answer.
     *
     * @param points The point value of the short-answer question.
     * @param text The text of the true/false-answer question.
     * @param answer The correct answer to the true/false question.
     */
    public QuestionTF(int points, String text, boolean answer){
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
    public boolean getAnswer() {
        return answer;
    }


    /**
     * Sets the answer of the type of question.
     *
     * @param answer The text of the question.
     */
    public void setAnswer(boolean answer) {
        this.answer = answer;
    }


    /**
     * Converts a QuestionTF Object to a string.
     *
     * @return the answer of the object to as a string.
     */
    public String toString(){ return String.valueOf(getAnswer()); }
}
