/**
 * QuizMaster Class
 * <p>
 * QuizMaster is a Java program that allows players to participate in a quiz game.
 * Players can answer a specified number of questions from a database containing
 * various question types such as multiple-choice, short answer, and true/false.
 * Players earn points for correct answers and lose points for incorrect answers.
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
    /**
     * Name of ArrayList database.
     */
    private static final ArrayList<Question> questionsDb = new ArrayList<>();

    /**
     * player object participating in the QuizMaster game.
     */
    private static Player player = new Player();

    /**
     * Max number of questions in the quiz database.
     */
    private static int maxNumberOfQuestions;


    /**
     * Retrieves the answer corresponding to the given question.
     * <p>
     * This method takes a Question object as input and returns the answer
     * associated with that question. If the question is of type QuestionMC,
     * it retrieves the answer as a char and converts it to a string. If the
     * question is of type QuestionSA, it retrieves the answer without having
     * to convert it to string. If the question is of type QuestionTF, it retrieves
     * the answer as a bool and converts it to a string as a string.
     * <p>
     * Note: For multiple-choice questions (QuestionMC), the answer is converted
     * to a string before returning.
     *
     * @param question The question object for which the answer is retrieved.
     * @return The answer to the given question.
     */
    private static String getAnswer(Question question){
        String answer;
        if(question instanceof QuestionMC){
           answer = (((QuestionMC) question).getAnswer()) + "";
        }
        else if (question instanceof QuestionSA) {
            answer = (((QuestionSA) question).getAnswer());
        }
        else{
            answer = (((QuestionTF) question).getAnswer()) + "";
        }
        return answer;
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
     * @return the question object.
     */
    private static QuestionMC readQuestionMC(Scanner fileIn, int points){
        StringBuilder question =new StringBuilder();
        char answer = 'A';

        if(fileIn.hasNext()){
            // Scans the file question.
            question = new StringBuilder(fileIn.nextLine());

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

            // Scans the file question's answer and coverts it to a char.
            String stringAnswer = fileIn.nextLine();
            answer = stringAnswer.charAt(0);
        }
        // Creates questionMC object and returns it.
        return new QuestionMC(points, question.toString(), answer);
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
     * @return the question object.
     */
    private static QuestionSA readQuestionSA(Scanner fileIn, int points){
        String question = " ";
        String answer = " ";
        if(fileIn.hasNext()){
            // Scans the file question.
            question = fileIn.nextLine();

            // Scans the file question's answer.
            answer = fileIn.nextLine();
        }
        // Creates questionSA object and returns it.
        return new QuestionSA(points, question, answer);
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
     * @return the question object.
     */
    private static QuestionTF readQuestionTF(Scanner fileIn, int points){
        String question = "null";
        boolean answer = false;

        if(fileIn.hasNext()) {
            // Scans the file question
            question = fileIn.nextLine();

            // Scans the files answer.
            answer = Boolean.parseBoolean(fileIn.nextLine());

        }
        // Creates questionTF object and returns it.
        return new QuestionTF(points, question, answer);
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

                // Separates the question type and points in to 2 parts.
                String qtype = questionType.split(" ")[0];
                String qPoints = questionType.split(" ")[1];

                // Converts stringPoints to int.
                int points = Integer.parseInt(qPoints);

                // Switch Case that looks for
                switch (qtype) {
                    case "MC":
                        questionsDb.add(readQuestionMC(fileIn, points));
                        break;

                    case "SA":
                        questionsDb.add(readQuestionSA(fileIn, points));
                        break;

                    case "TF":
                        questionsDb.add(readQuestionTF(fileIn, points));
                        break;
                }
            }
        }
    }


    /**
     * Starts the quiz game.
     * <p>
     * This method prompts the player to specify how many questions they would like to answer
     * from the available database. The user input is validated to ensure it falls
     * within the range of 1 and the maximum number of questions in the database. Then, it shuffles
     * the questions in the database and presents each question to the player in a randomized order.
     * For each question, the player provides an answer, which is compared to the correct answer
     * retrieved from questionDb. If the player chooses to skip the question, no points are gained
     * or lost. If the player answers correctly, they gain points corresponding to the question's
     * point value. If the player answers incorrectly, they lose points corresponding to the
     * question's point value. After answering all the questions, the player's final score is displayed.
     *
     * @param kbdIn The Scanner object used to read player input.
     */
    private static void play(Scanner kbdIn){
        int score = 0;
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
        for(int listIndex = 1; listIndex <= questionUserWants; listIndex++){
            System.out.println("\nQuestion " + listIndex);

            // Reduces the array list number
            int indexNum = listIndex - 1;

            // Creates question object and gets the question from the shuffled list.
            Question question = questionsDb.get(indexNum);

            // Prints the question out.
            System.out.println(question.getText());

            // Gets user input to answer question.
            String userAnswer = kbdIn.next();

            //Converts answer to string.
            String answer = getAnswer(question);

            // If user types 'SKIP' then the question gets skipped else if they answer correct/wrong they will gain/lose points
            if(userAnswer.equalsIgnoreCase("SKIP")){
                System.out.println("You have elected to skip that question.");
            }
            else if(userAnswer.equalsIgnoreCase(answer)){
                score += questionsDb.get(indexNum).getPoints();
                player.setScore(score);
                System.out.println("Correct! You get " + questionsDb.get(indexNum).getPoints() + " points.");
                System.out.println("Your current score is: " + player.getScore() + " points.");
            }
            else{
                score -= questionsDb.get(indexNum).getPoints();
                player.setScore(score);
                System.out.println("Incorrect, the answer was '" + answer.toUpperCase() + "'. You loose " + questionsDb.get(indexNum).getPoints() + " points.");
                System.out.println("Your current score is: " + player.getScore() + " points.");
            }
        }
    }


    /**
     * The main point of the QuizMaster program.
     * <p>
     * This method initializes the QuizMaster game by asking the user to input a quiz file name
     * containing the data. It then creates a FileInOut object with the specified input file name
     * and calls readPlayer() to read player information from the input file. Next, it calls readQuestionDb()
     * to read the questions from the input file. Finally, it initiates the quiz by calling play() and
     * passing a Scanner object for user input.
     *
     * @param args The command-line arguments passed to the program
     */
    public static void main(String[] args) {
        System.out.println("***** QuizMaster *****\n");

        // Gets the name of the input file from the user/player.
        System.out.println("Please enter the name of the file containing the data:");
        Scanner userInput = new Scanner(System.in);
        String fileName = userInput.nextLine();

        // Instantiates a FileInOut object
        FileInOut fio = new FileInOut(fileName, "default_out.txt", true);

        // Reads the player information from the input file by calling readPlayer().
        readPlayer(fio.getInFile());

        // Reads the questions from the input file by calling readQuestionDb().
        readQuestionDb(fio.getInFile());

        // Plays the quiz by calling play().
        play(userInput);
    }
}
