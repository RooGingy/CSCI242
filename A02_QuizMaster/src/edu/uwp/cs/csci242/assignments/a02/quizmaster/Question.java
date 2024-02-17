package edu.uwp.cs.csci242.assignments.a02.quizmaster;


public class Question {
    private int points;
    private String text;


    /**
     * Default Constructor
     * <p>
     * ahhh
     */
    public Question(){
        this.points = 0;
        this.text = "";
    }


    /**
     * Two Argument Constructor
     * <p>
     * aaaa
     *
     * @param points
     * @param text
     */
    public Question(int points, String text){
        this.points = points;
        this.text = text;
    }


    /**
     *
     * @return
     */
    public int getPoints() {
        return points;
    }


    /**
     *
     * @param points
     */
    public void setPoints(int points) {
        this.points = points;
    }


    /**
     *
     * @return
     */
    public String getText() {
        return text;
    }


    /**
     *
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }


    /**
     * Converts a Question Object to a string.
     * @return String of the question.
     */
    public String toString() { return getText(); }
}
