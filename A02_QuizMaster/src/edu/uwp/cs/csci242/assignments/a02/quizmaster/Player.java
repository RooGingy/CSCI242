/**
 * Player Class
 * <p>
 * Class gets the players first name, last name, and score.
 * <p>
 * And even more explanations to follow in consecutive
 * paragraphs separated by HTML paragraph breaks.
 *
 * @author Austin Moser
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 002
 * @edu.uwp.cs.242.assignment 2
 * @bugs None
 */

package edu.uwp.cs.csci242.assignments.a02.quizmaster;

public class Player {
    /**
     * The first name of the player.
     */
    private String firstName;   // The first name of the player

    /**
     * The last name of the player.
     */
    private String lastName;    // The last name of the player

    /**
     * The score of that the player gets.
     */
    private int score;  // The current score of the player.


    /**
     * Constructs a new Player object with default values.
     * <p>
     * This constructor initializes a new Player object with default values
     * for the first name, last name, and score. The first name and last name
     * are set to empty strings, and the score is initialized to zero.
     */
    public Player(){
        this.firstName = "";
        this.lastName = "";
        this.score = 0;
    }


    /**
     * Constructs a new Player object with the specified first name and last name.
     * <p>
     * This constructor creates a new Player object with the provided first name
     * and last name.
     *
     * @param firstName The first name of the player.
     * @param lastName The last name of the player.
     */
    public Player(String firstName, String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }


    /**
     * Constructs a new Player object with the specified first name, last name, and score.
     * <p>
     * This constructor creates a new Player object with the provided first name, last name and score
     *
     * @param firstName The first name of the player.
     * @param lastName The last name of the player.
     * @param score The score of the player.
     */
    public Player(String firstName, String lastName, int score){
        this.firstName=firstName;
        this.lastName=lastName;
        this.score=score;
    }


    /**
     * Retrieves the first name of the person.
     *
     * @return The first name of the person.
     */
    public String getFirstName() {
        return firstName;
    }


    /**
     * Sets the first name of the player.
     *
     * @param firstName Set the first name for the player.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    /**
     * Retrieves the last name of the person.
     *
     * @return The last name of the person.
     */
    public String getLastName() { return lastName; }


    /**
     * Sets the last name of the player.
     *
     * @param lastName Set the last name for the player.
     */
    public void setLastName(String lastName) { this.lastName = lastName; }


    /**
     * Retrieves the score of the player.
     *
     * @return The score of the player.
     */
    public int getScore() {
        return score;
    }


    /**
     * Sets the score of the player.
     *
     * @param score The score for the player.
     */
    public void setScore(int score) {
        this.score = score;
    }


    /**
     * Converts the player object into a string.
     *
     * @return The string of the player's name.
     */
    public String toString(){
        return getFirstName() + " " + getLastName();
    }
}
