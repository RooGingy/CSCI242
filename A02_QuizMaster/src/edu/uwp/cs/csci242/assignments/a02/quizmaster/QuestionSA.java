package edu.uwp.cs.csci242.assignments.a02.quizmaster;

public class QuestionSA extends Question {
    private String answer;


    /**
     * Default Constructor
     * <p>
     * aggg
     */
    public QuestionSA(){
        this.answer="";
    }

    /**
     * One Argument Constructor
     * <p>
     * ahhh
     *
     * @param answer
     */
    public QuestionSA(String answer){
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
    public QuestionSA(int points, String text, String answer){
        super();
        points = getPoints();
        text = getText();
        this.answer = answer;
    }

    /**
     *
     * @return
     */
    public String getAnswer() {
        return answer;
    }

    /**
     *
     * @param answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     *
     * @return
     */
    public String toString(){
        return "";
    }
}
