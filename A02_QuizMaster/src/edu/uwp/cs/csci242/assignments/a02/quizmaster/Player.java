/**
 * Player Class
 * <p>
 * Class gets the players first name, last name, and score.
 * <p>
 * And even more explanations to follow in consecutive
 * paragraphs separated by HTML paragraph breaks.
 *
 *  * @author Austin Moser
 *  * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 *  * @edu.uwp.cs.242.section 002
 *  * @edu.uwp.cs.242.assignment 2
 *  * @bugs None
 */

package edu.uwp.cs.csci242.assignments.a02.quizmaster;

public class Player {
    private String firstName;   // The first name of the player
    private String lastName;    // The last name of the player
    private int score;  // The current score of the player.


    /**
     * Default Constructor
     * <p>
     * Presets all class attributes to
     */
    public Player(){
        this.firstName = "";
        this.lastName = "";
        this.score = 0;
    }


    /**
     * Two Argument Constructor
     * <p>
     * Ahhhhh
     * @param firstName
     * @param lastName
     */
    public Player(String firstName, String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }


    /**
     * Three Argument Constructor
     * <p>
     * Ahhhh
     * @param firstName
     * @param lastName
     * @param score
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
    public String getLastName() {return lastName;
    }


    /**
     * Sets the last name of the player.
     *
     * @param lastName Set the last name for the player.
     */
    public void setLastName(String lastName) {this.lastName = lastName;}


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
     * @return The string of the player's name.
     */
    public String toString(){
        return getFirstName();
    }
}
