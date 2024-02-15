/**
 * Quick, one line description of the assignment
 * <p>
 * Longer description. If there is any, it would be here.
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

import java.util.ArrayList;
import java.util.Scanner;

public class QuizMaster {

    private static final ArrayList<Question> questionsDb = new ArrayList<Question>();
    private static Player player;
    private static int maxNumberOfQuestions;


    /**
     *
     * @param question
     * @return
     */
    private String getAnswer(Question question){ return toString(); }


    /**
     *
     * @param fileIn
     */
    private static void readPlayer(Scanner fileIn){
        if(fileIn.hasNext()){
            String firstname = fileIn.nextLine();
            player.setFirstName(firstname);
            String lastName = fileIn.nextLine();
            player.setLastName(lastName);
        }
        else
            System.out.println("Error: Check readPlayer() method");
    }


    /**
     *
     * @param fileIn
     * @param points
     */
    private static void readQuestionMC(Scanner fileIn, int points){
        if(fileIn.hasNext()){
            String question = fileIn.nextLine();

            ArrayList<String> questionChoices = new ArrayList<String>();
            int numberOfAnswers = Integer.parseInt(fileIn.nextLine());
            for(int i = 0; i<numberOfAnswers; i++){
                if(fileIn.hasNext()){
                    questionChoices.add(fileIn.nextLine());
                }
            }
            String stringAnswer = fileIn.nextLine();
            char answer = stringAnswer.charAt(0);


            // Stores all data collected to the question database list.
            QuestionMC questionMC = new QuestionMC(points, question, answer);
            questionMC.setPoints(points);
            questionMC.setText(question);
            questionMC.setAnswer(answer);
            questionsDb.add(questionMC);
        }
    }


    /**
     *
     * @param fileIn
     * @param points
     */
    private static void readQuestionSA(Scanner fileIn, int points){
        if(fileIn.hasNext()){
            String question = fileIn.nextLine();
            String answer = fileIn.nextLine();


            QuestionSA questionSA = new QuestionSA(points, question, answer);
            questionSA.setPoints(points);
            questionSA.setText(question);
            questionSA.setAnswer(answer);
            questionsDb.add(questionSA);
        }
    }


    /**
     *
     * @param fileIn
     * @param points
     */
    private static void readQuestionTF(Scanner fileIn, int points){
        if(fileIn.hasNext()){
            String question = fileIn.nextLine();
            boolean answer = Boolean.parseBoolean(fileIn.nextLine());


            QuestionTF questionTF = new QuestionTF(points, question, answer);
            questionTF.setPoints(points);
            questionTF.setText(question);
            questionTF.setAnswer(answer);

            questionsDb.add(questionTF);
        }

    }


    /**
     *
     * @param fileIn
     */
    private static void readQuestionDb(Scanner fileIn) {
        maxNumberOfQuestions = Integer.parseInt(fileIn.nextLine());

        for (int i = 0; i < maxNumberOfQuestions; i++) {
            // Reads the next line from the file.
            String questionType = fileIn.nextLine();

            // Separates the question type and points in to 2 parts.a
            String qtype = questionType.split(" ")[0];
            String stringPoints = questionType.split(" ")[1];

            // Converts stringPoints to int.
            int points = Integer.parseInt(stringPoints);

            // Switch Case that looks for
            switch (qtype) {
                case "MC":
                    readQuestionMC(fileIn, points);
                    break;

                case "SA":
                    readQuestionSA(fileIn, points);
                    break;

                case "TF":
                    readQuestionTF(fileIn, points);
                    break;
            }
        }
    }


    /**
     *
     * @param kbdIn
     */
    private static void play(Scanner kbdIn){
        Scanner input = new Scanner(System.in);
        int userInput;
        // If userInput is out of the range of 1-maxNumberOfQuestions, then it will ask user the question again.
        do{
            System.out.println("How many questions would you like (out of " + maxNumberOfQuestions +")?");
            userInput = input.nextInt();

        } while (userInput < 1 || userInput > maxNumberOfQuestions );
        // The user then assigned a random problem from the database.
    }


    /**
     *
     * @param args
     */
    public static void main(String[] args){
        System.out.println("***** QuizMaster *****\n");

        // Gets the name of the input file from the user/player.
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter the name of the file containing the data:");
        String fileName = userInput.nextLine();

        // Delete later
        //fileName= "C:\\Users\\austi\\OneDrive\\Desktop\\CS242\\A02_QuizMaster\\src\\data.txt";

        // Instantiates a FileInOut object
        FileInOut fio = new FileInOut(fileName, "default_out.txt" , true);

        // Reads the player information from the input file by calling readPlayer().
        player = new Player();
        readPlayer(fio.getInFile());

        // Reads the questions from the input file by calling readQuestionDb()
        readQuestionDb(fio.getInFile());

        // Plays the quiz by calling play()
        play(userInput);
    }
}
