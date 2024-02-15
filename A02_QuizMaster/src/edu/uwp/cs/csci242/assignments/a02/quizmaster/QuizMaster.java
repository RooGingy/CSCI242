/**
 * QuizMaster Class
 * <p>
 *
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
    private static Player player = new Player();
    private static int maxNumberOfQuestions;


    /**
     *
     * @param question
     * @return
     */
    private String getAnswer(Question question){ return ""; }


    /**
     * Reads player information from the preset Scanner file.
     * <p>
     * This method reads the first name and last name of the player using a Scanner object
     * that reads from the file. If the Scanner object is initialized right it should read
     * and store the player information to the player class setters.
     * <p>
     * If there is no next line, then the file will close.
     *<p>
     *     Used Code that shows the pre-initialize Scanner Object:
     *      System.out.println("Please enter the name of the file containing the data:");
     *      String fileName = userInput.nextLine();
     *      // Instantiates a FileInOut object
     *      FileInOut fio = new FileInOut(fileName, "default_out.txt" , true);
     *
     * @param fileIn Scanner Object of the file that is being read.
     */
    private static void readPlayer(Scanner fileIn){
        if(fileIn.hasNext()){
            player = new Player();
            String firstname = fileIn.nextLine();
            player.setFirstName(firstname);
            String lastName = fileIn.nextLine();
            player.setLastName(lastName);
        }
        /* Look in FilesInOut and see if
        I can close if or if it already
        closes the file for me. */
    }


    /**
     * Reads Question information of a Short Answer Question from the preset Scanner file.
     * <p>
     * This method reads the question text and the answer text using the Scanner object
     * that reads from the file. If the Scanner object is initialized right it should read
     * and store the question text and the answer to the QuestionSA setters.
     * <p>
     * If there is no next line, then the file will close.
     *<p>
     *     Used Code that shows the pre-initialize Scanner Object:
     *      System.out.println("Please enter the name of the file containing the data:");
     *      String fileName = userInput.nextLine();
     *      // Instantiates a FileInOut object
     *      FileInOut fio = new FileInOut(fileName, "default_out.txt" , true);
     *
     * @param fileIn Scanner Object of the file that is being read.
     * @param points The points of the question type.
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
     * Reads Question information of a Short Answer Question from the preset Scanner file.
     * <p>
     * This method reads the question text and the answer text using the Scanner object
     * that reads from the file. If the Scanner object is initialized right it should read
     * and store the question text and the answer to the QuestionSA setters.
     * <p>
     * If there is no next line, then the file will close.
     *<p>
     *     Used Code that shows the pre-initialize Scanner Object:
     *      System.out.println("Please enter the name of the file containing the data:");
     *      String fileName = userInput.nextLine();
     *      // Instantiates a FileInOut object
     *      FileInOut fio = new FileInOut(fileName, "default_out.txt" , true);
     *
     * @param fileIn Scanner Object of the file that is being read.
     * @param points The points of the question type.
     */
    private static void readQuestionSA(Scanner fileIn, int points){
        if(fileIn.hasNext()){
            // Scans in the file question
            String question = fileIn.nextLine();

            // Scans in the files answer
            String answer = fileIn.nextLine();

            QuestionSA questionSA = new QuestionSA(points, question, answer);
            questionSA.setPoints(points);
            questionSA.setText(question);
            questionSA.setAnswer(answer);
            questionsDb.add(questionSA);
        }
    }


    /**
     * Reads Question information of a Short Answer Question from the preset Scanner file.
     * <p>
     * This method reads the question text and the answer text using the Scanner object
     * that reads from the file. If the Scanner object is initialized right it should read
     * and store the question text and the answer to the QuestionSA setters.
     * <p>
     * If there is no next line, then the file will close.
     *<p>
     *     Used Code that shows the pre-initialize Scanner Object:
     *      System.out.println("Please enter the name of the file containing the data:");
     *      String fileName = userInput.nextLine();
     *      // Instantiates a FileInOut object
     *      FileInOut fio = new FileInOut(fileName, "default_out.txt" , true);
     *
     * @param fileIn Scanner Object of the file that is being read.
     * @param points The points of the question type.
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
     * Reads QuestionDb information from the preset Scanner file.
     * <p>
     * This method reads in the maximum number of questions that the
     * data files has from the Scanner Object.It then used the max
     * number and walked thought each question type methods. For each
     * question it contains a type and how many points the question has.
     * Based on the type it then goes the method of that type and reads
     * the data form it.
     * <p>
     *     Used Code that shows the pre-initialize Scanner Object:
     *      System.out.println("Please enter the name of the file containing the data:");
     *      String fileName = userInput.nextLine();
     *      // Instantiates a FileInOut object
     *      FileInOut fio = new FileInOut(fileName, "default_out.txt" , true);
     *
     * @param fileIn Scanner Object of the file that is being read.
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

        // Instantiates a FileInOut object
        FileInOut fio = new FileInOut(fileName, "default_out.txt" , true);

        // Reads the player information from the input file by calling readPlayer().
        readPlayer(fio.getInFile());

        // Reads the questions from the input file by calling readQuestionDb()
        readQuestionDb(fio.getInFile());

        // Plays the quiz by calling play()
        play(userInput);
    }
}
