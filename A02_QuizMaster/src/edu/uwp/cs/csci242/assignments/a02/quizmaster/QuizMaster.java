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
import java.util.Collections;
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
    private String getAnswer(Question question){
        return "";
    }


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
            // Create a player object
            player = new Player();
            String firstname = fileIn.nextLine();
            player.setFirstName(firstname);
            String lastName = fileIn.nextLine();
            player.setLastName(lastName);
        }
        //else FileInOut.closeFiles();
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
            // Scans the file question.
            StringBuilder question = new StringBuilder(fileIn.nextLine());

            // Gets the number of multiple choice options.
            int numberOfAnswers = Integer.parseInt(fileIn.nextLine());

            // Loops though all the options
            for(int i = 0; i<numberOfAnswers; i++){
                // Gets the letter order of the multiple choice options.
                char letter = 'A';
                char answerLetter = (char) (letter + i);

                // Reads in the multiple choice options.
                if(fileIn.hasNext()){
                    String mcAnswers = fileIn.nextLine();
                    mcAnswers = "\n(" + answerLetter + ") " + mcAnswers;
                    question.append(mcAnswers);
                }
            }

            // Scans the file question's answer.
            String stringAnswer = fileIn.nextLine();

            // Converts the answer to char.
            char answer = stringAnswer.charAt(0);

            // Stores all data collected to the question database list.
            QuestionMC questionMC = new QuestionMC(points, question.toString(), answer);

            // Sets each parameter of the object constructor.
            questionMC.setPoints(points);
            questionMC.setText(question.toString());
            questionMC.setAnswer(answer);

            // Adds object to question list.
            questionsDb.add(questionMC);
        }
        //else FileInOut.closeFiles();
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
            // Scans the file question.
            String question = fileIn.nextLine();

            // Scans the file question's answer.
            String answer = fileIn.nextLine();

            // Creates questionSA object.
            QuestionSA questionSA = new QuestionSA(points, question, answer);

            // Sets each parameter of the object constructor.
            questionSA.setPoints(points);
            questionSA.setText(question);
            questionSA.setAnswer(answer);

            // Adds object to question list.
            questionsDb.add(questionSA);
        }
        //else FileInOut.closeFiles();
    }


    /**
     * Reads Question information of a True/False Question from the preset Scanner file.
     * <p>
     * This method reads the question text and the answer text using the Scanner object
     * that reads from the file. If the Scanner object is initialized right it should read
     * and store the question text and the answer to the QuestionTF setters.
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
            // Scans the file question
            String question = fileIn.nextLine();

            // Scans the files answer.
            boolean answer = Boolean.parseBoolean(fileIn.nextLine());

            // Creates questionTF object
            QuestionTF questionTF = new QuestionTF(points, question, answer);

            // Sets each parameter of the object constructor.
            questionTF.setPoints(points);
            questionTF.setText(question);
            questionTF.setAnswer(answer);

            // Adds object to question list.
            questionsDb.add(questionTF);
        }
        //else FileInOut.closeFiles();
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
        if(fileIn.hasNext()) {
            maxNumberOfQuestions = Integer.parseInt(fileIn.nextLine());

            for (int i = 0; i < maxNumberOfQuestions; i++) {
                // Reads the next line from the file.
                String questionType = fileIn.nextLine();

                // Separates the question type and points in to 2 parts.a
                String qtype = questionType.split(" ")[0];
                String qPoints = questionType.split(" ")[1];

                // Converts stringPoints to int.
                int points = Integer.parseInt(qPoints);

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
        //else FileInOut.closeFiles();
    }


    /**
     *
     * @param kbdIn
     */
    private static void play(Scanner kbdIn){
        System.out.println("Welcome to QuizMaster, " + player.getFirstName() + "!");

        /* If user input is out of the range of 1 and the max number of questions in data file,
        then it will ask user the question again. */
        int questionUserWants;

        do{
            System.out.println("How many questions would you like (out of " + maxNumberOfQuestions +")?");
            questionUserWants = kbdIn.nextInt();

        } while (questionUserWants < 1 || questionUserWants > maxNumberOfQuestions );

        // The user then assigned a random problem from the database.
        // Randomizes the questions stored in the database.
        Collections.shuffle(questionsDb);

        // Loops though each shuffled question.
        for(int i = 1; i <= questionUserWants; i++){
            System.out.println("Question " + i);

            // Reduces the array array list number
            int indexNum = i - 1;

            // Creates question object.
            Question question = new Question();

            // Gets the question from the shuffled list.
            question = questionsDb.get(indexNum);

            // Sets the question points and text.
            //question.setPoints(questionsDb.get(indexNum).getPoints());
            ///question.setText(questionsDb.get(indexNum).getText());

            // Prints the question out.
            System.out.println(question.getText());

            // Gets user input to answer question.
            String userAnswer = kbdIn.next();
            System.out.println(userAnswer);
        }
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
