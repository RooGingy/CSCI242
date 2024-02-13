package edu.uwp.cs.csci242.assignments.a02.quizmaster;

public class Player {
    private String firstName;   // The first name of the player
    private String lastName;    // The last name of the player
    private int score;  // The players current score.

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
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     */
    public int getScore() {
        return score;
    }

    /**
     *
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Converts the Player Object into a string.
     * @return String of the players name.
     */
    public String toString(){
        return "";
    }
}
