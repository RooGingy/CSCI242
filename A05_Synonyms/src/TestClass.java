/**
 * This class was used to test a smaller sample, so I can be sure I parse right and do the math right.
 */

import java.util.HashMap;
import java.util.Scanner;

public class TestClass {
    private final HashMap<String, HashMap<String, Integer>> descriptors;

    public TestClass(String str) {
        descriptors = new HashMap<>();
        parseString(str);
    }

    public void parseString(String text) {
        // Splits text into sentences.
        String[] sentences = text.split("[\\.\\?\\!]|\\Z");

        // Loops though the sentences
        for (String sentence : sentences) {
            // Splits sentences into words
            String[] words = sentence.toLowerCase().replaceAll("\\W+", " ").trim().split("\\s+");

            // Loops though the words
            for (String word : words) {
                // Check if the word is already in the main Hashmap
                if (!descriptors.containsKey(word)) {
                    // Stores word as key in Hashmap
                    descriptors.put(word, new HashMap<>());
                }
                // Finds the sentence that goes to the sentence that contain the key word.
                if (sentence.contains(word)) {
                    // Loops through the word list to get the words again.
                    for (String word2 : words) {
                        // Ignores keyed word.
                        if (!word2.contains(word)) {
                            // Gets the inner map for word.
                            HashMap<String, Integer> innerMap = descriptors.get(word);
                            // Update the count each word 2 that has word one in it.
                            innerMap.put(word2, innerMap.getOrDefault(word2, 0) + 1);
                        }
                    }
                }
            }
        }
    }


    private int dotProduct(HashMap<String, Integer> vector1, HashMap<String, Integer> vector2) {
        int sum = 0;
        for (String word : vector1.keySet()) {
            if (vector2.containsKey(word)) {
                sum += vector1.get(word) * vector2.get(word);
            }
        }
        return sum;
    }

    private double magnitude(HashMap<String, Integer> vector) {
        int sumOfSquares = 0;
        for (int value : vector.values()) {
            sumOfSquares += value * value;
        }
        return sumOfSquares;
    }

    public double calculateCosineSimilarity(String word1, String word2) {
        // If word1 or word2 doesn't exist then returns -1.
        if (!descriptors.containsKey(word1) || !descriptors.containsKey(word2)) {
            return -1.0;
        }

        // Gets the vectors of both words.
        HashMap<String, Integer> vector1 = descriptors.get(word1);
        HashMap<String, Integer> vector2 = descriptors.get(word2);

        // Calculates dotProduct
        int dotProduct = dotProduct(vector1, vector2);

        // Calculates magnitude.
        double magnitude1 = magnitude(vector1);
        double magnitude2 = magnitude(vector2);

        return dotProduct / (Math.sqrt(magnitude1) * Math.sqrt(magnitude2));
    }

    public static void main(String[] args) {
        String str = "I am a sick man. I am a spiteful man. I am an unattractive man. I believe " +
                "my liver is diseased. However, I know nothing at all about my disease, and " +
                "do not know for certain what ails me.";
        TestClass tc = new TestClass(str);

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a word:");
            String word = sc.nextLine();

            if(word.isBlank()) break;

            System.out.println("Enter the choices:");
            String choices = sc.nextLine();

            String[] choicesArr = choices.toLowerCase().split("\\s+");
            for (String s : choicesArr) {
                double similarity = tc.calculateCosineSimilarity(word, s);
                System.out.println(s + " " + similarity);
            }
        }
    }
}
