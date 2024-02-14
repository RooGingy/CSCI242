package edu.uwp.cs.csci242.assignments.a02.quizmaster;

import java.util.ArrayList;
import java.util.Scanner;

public class QuizMaster {

    private ArrayList<Question> questionsDb = new ArrayList<Question>();
    private static Player player;

    private String getAnswer(Question question){
        return toString();
    }

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

    private void readQuestionMC(Scanner fileIn, int points){


    }

    private void readQuestionSA(Scanner fileIn, int points){

    }

    private void readQuestionTF(Scanner fileIn, int points){

    }

    private static void readQuestionDb(Scanner fileIn){

    }

    private static void play(Scanner kbdIn){
        Scanner input = new Scanner(System.in);
        int maxNumberOfQuestions;
        int userInput;

        // Gets the next string of the file and converts it to an integer value.
        if(kbdIn.hasNext()) {
            maxNumberOfQuestions = Integer.parseInt(kbdIn.nextLine());

            // If userInput is out of the range of 1-maxNumberOfQuestions, then it will ask user the question again.
            do{
                System.out.println("How many questions would you like (out of " + maxNumberOfQuestions +")?");
                userInput = input.nextInt();

            } while (userInput < 1 || userInput > maxNumberOfQuestions );
        }
        else
            System.out.println("Error: Check play() method");

        // The user then assigned a random problem from the database.

    }

    public static void main(String[] args){
        System.out.println("***** QuizMaster *****");
        System.out.println();

        // Gets the name of the input file from the user/player.
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name of the file containing the data:");
        String fileName = sc.nextLine();

        // Instantiates a FileInOut object
        FileInOut fio = new FileInOut();
        fio.setInFilename(fileName);

        // Reads the player information from the input file by calling readPlayer().
        readPlayer();

        // Reads the questions from the input file by calling readQuestionDb()
        readQuestionDb();

        play();

    }


}
