package edu.uwp.cs.csci242.assignments.a02.quizmaster;


public class QuestionTF extends Question {
    private boolean answer; // The questions answer.

    /**
     * Default Constructor
     * <p>
     * aggg
     */
    public QuestionTF(){
        super();
        this.answer = true;
    }

    /**
     * One Argument Constructor
     * <p>
     * ahhh
     *
     * @param answer
     */
    public QuestionTF(boolean answer){
        super();
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
    public QuestionTF(int points, String text, boolean answer){
        super();
        super.setPoints(points);
        super.setText(text);
        this.answer = answer;
    }

    /**
     *
     * @return
     */
    public boolean getAnswer() {
        return answer;
    }

    /**
     *
     * @param answer
     */
    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    /**
     *
     * @return
     */
    public String toString(){ return String.valueOf(getAnswer()); }
}
