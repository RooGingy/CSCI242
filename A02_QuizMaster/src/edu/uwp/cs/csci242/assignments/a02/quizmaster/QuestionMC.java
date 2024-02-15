package edu.uwp.cs.csci242.assignments.a02.quizmaster;

public class QuestionMC extends Question {
    private char answer;    // The questions answer.

    /**
     * Default Constructor
     * <p>
     * aggg
     */
    public QuestionMC(){
        this.answer='a';
    }

    /**
     * One Argument Constructor
     * <p>
     * ahhh
     *
     * @param answer
     */
    public QuestionMC(char answer){
        this.answer=answer;
    }

    /**
     * Three Argument Constructor
     * <p>
     * ahhh
     *
     * @param points
     * @param text
     * @param answer
     */
    public QuestionMC(int points, String text, char answer){
        super();
        points = getPoints();
        text = getText();
        this.answer=answer;
    }

    /**
     *
     * @return
     */
    public char getAnswer() {
        return answer;
    }

    /**
     *
     * @param answer
     */
    public void setAnswer(char answer) { this.answer = answer; }

    /**
     *
     * @return
     */
    public String toString(){
        return "";
    }
}
