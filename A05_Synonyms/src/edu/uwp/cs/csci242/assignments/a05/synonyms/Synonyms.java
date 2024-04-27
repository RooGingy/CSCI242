package edu.uwp.cs.csci242.assignments.a05.synonyms;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;


/**
 * Synonyms Analyzer for Classic Literature Texts
 * <p>
 * This class provides functionality to analyze and determine synonym relationships between words across
 * various classic literary works. It utilizes a nested HashMap data structure to store and quantify
 * these relationships based on the occurrence of words in similar contexts within the provided texts.
 * <p>
 * The primary operations include parsing texts to build the synonym data structure, calculating dot products
 * and magnitudes for vectors represented by word counts, and determining cosine similarity between words
 * to evaluate their similarity. The application is interactive, prompting the user for input to analyze
 * relationships dynamically, which illustrates the practical application of data structures and algorithms
 * in a real-world text analysis context.
 * <p>
 * Usage involves initializing the class with URLs to the texts, which are then parsed to build the synonym
 * descriptors. Users can then query the relationships interactively via the command line interface.
 *
 * @author Austin Moser
 * @edu.uwp.cs.csci242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.csci242.section 005
 * @edu.uwp.cs.csci242.assignment 5
 * @bugs none
 */
public class Synonyms {
    /**
     * Stores a nested mapping of words to their associated synonym counts.
     * This structure utilizes a HashMap where each key is a word and its value
     * is another HashMap. The inner HashMap maps each synonym of the key word to
     * the number of times it occurs in similar contexts, effectively quantifying
     * the synonym relationships.
     */
    private final HashMap<String, HashMap<String, Integer>> descriptors;

    /**
     * Constructs a Synonyms object by initializing a data structure and parsing a given array of URLs.
     * <p>
     * This constructor sets up a key component of the Synonyms class—the descriptors HashMap, which is used
     * to store synonym relationships extracted from the contents of the URLs provided. Upon initialization
     * of the HashMap, the constructor immediately invokes the parseString method to process the textual
     * content from the URLs. This method fills the descriptors with words and their corresponding synonym counts,
     * forming a network of synonym relationships.
     * <p>
     * The process of parsing involves opening each URL, reading its content, and extracting words to determine
     * synonyms based on their co-occurrences in sentences. This requires handling IOExceptions that may arise
     * from reading the URLs, hence the necessity of declaring this exception in the constructor's signature.
     * The successful execution of this constructor ensures that the Synonyms object is ready for use with a
     * fully populated synonyms map.
     *
     * @param corpus An array of URL objects, each pointing to a text resource that will be parsed to extract synonyms.
     *               It is essential that each URL is valid and accessible, otherwise an IOException may be thrown.
     * @throws IOException If an error occurs during URL access or data reading, this exception is thrown to indicate
     *                     such problems, ensuring that the calling code can handle these errors appropriately.
     */
    public Synonyms(URL[] corpus) throws IOException {
        // Initializes HashMap
        descriptors = new HashMap<>();
        // Calls parseString.
        parseString(corpus);
    }

    /**
     * Parses the content of each URL to extract and map synonyms.
     * <p>
     * This method processes an array of URLs, where each URL is expected to point to textual content.
     * The content is scanned and parsed to identify and count words, storing them in a nested HashMap
     * structure. Each unique word found becomes a key in the main HashMap, and its value is another
     * HashMap that counts occurrences of other words appearing in the same context.
     * <p>
     * The method reads each sentence, cleans it up, and splits it into words. For each word, if it is
     * not already a key in the main HashMap, a new key-value pair is created. It then checks other words
     * in the same sentence and updates their count in relation to the key word. This mechanism is used
     * to potentially establish synonym relationships based on the context of word usage. The process involves
     * handling IO operations, thus an IOException might be thrown if any issues occur during the URL reading.
     *
     * @param corpus An array of URLs each expected to point to resources that are accessible and contain
     *               readable textual content.
     * @throws IOException Thrown if an error occurs while attempting to read from any of the provided URLs.
     */
    public void parseString(URL[] corpus) throws IOException {
        for (URL url : corpus) {
            // Opens the URL.
            InputStream inputStream = url.openStream();
            // Reads in the URL.
            Scanner urlReader = new Scanner(inputStream);
            urlReader.useDelimiter("[\\.\\?!]|\\Z");


            // Loops thought each line of text.
            while (urlReader.hasNext()) {
                // Gets sentence and adds them to the sentence Collection.
                String sentence = urlReader.next();
                sentence = sentence.replaceAll("\\W+", " ").toLowerCase().trim();
                // Adds all words to the words ArrayList.
                ArrayList<String> words = new ArrayList<>(Arrays.asList(sentence.split(" ")));

                for (String word : words) {
                    if (!descriptors.containsKey(word)) {
                        // Stores word as key in Hashmap
                        descriptors.put(word, new HashMap<>());
                    }
                    if (sentence.contains(word)) {

                        // Loops through the word list to get the words again.
                        for (String newWord : words) {
                            // Ignores keyed word.
                            if (!newWord.contains(word)) {
                                // Gets the inner map for word.
                                HashMap<String, Integer> innerMap = descriptors.get(word);
                                // Update the count each word 2 that has word one in it.
                                innerMap.put(newWord, innerMap.getOrDefault(newWord, 0) + 1);
                            }
                        }
                    }
                }
            }
        }
    }


    /**
     * Calculates the dot product of two vectors.
     * <p>
     * This method computes the dot product by summing the products of corresponding entries
     * in the two provided HashMaps. Each entry in the HashMaps represents a dimension in the vector,
     * with the key as the dimension identifier and the value as the dimension's magnitude.
     * <p>
     * Only matching dimensions (keys present in both HashMaps) contribute to the dot product,
     * aligning with the mathematical definition of a dot product in a sparse vector space.
     *
     * @param vector1 The first vector represented as a HashMap.
     * @param vector2 The second vector represented as a HashMap.
     * @return The resulting dot product as an integer.
     */
    private int dotProduct(HashMap<String, Integer> vector1, HashMap<String, Integer> vector2) {
        int sum = 0;
        for (String word : vector1.keySet()) {
            if (vector2.containsKey(word)) {
                sum += vector1.get(word) * vector2.get(word);
            }
        }
        return sum;
    }

    /**
     * Calculates the magnitude of a vector.
     * <p>
     * The magnitude is calculated as the square root of the sum of the squares of all vector
     * values. This operation corresponds to the Euclidean norm of a vector in n-dimensional space,
     * which is essential in many vector-based calculations, such as computing cosine similarity.
     *
     * @param vector The vector whose magnitude is to be calculated, represented as a HashMap.
     * @return The magnitude as a double.
     */
    private double magnitude(HashMap<String, Integer> vector) {
        int sumOfSquares = 0;
        for (int value : vector.values()) {
            sumOfSquares += value * value;
        }
        return sumOfSquares;
    }

    /**
     * Computes the cosine similarity between the vectors of two words.
     * <p>
     * Cosine similarity is a measure used in text mining and information retrieval to quantify
     * the similarity between two vectors. If either word does not exist in the descriptor mappings,
     * the method returns -1.0, indicating non-comparability. This method leverages the dotProduct and
     * magnitude methods to calculate the similarity.
     * <p>
     * The similarity is computed as the dot product of the two vectors divided by the product of their magnitudes,
     * which corresponds to the cosine of the angle between the vectors in a multi-dimensional space.
     *
     * @param word1 The first word to compare, corresponding to a key in the descriptor HashMap.
     * @param word2 The second word to compare, also a key in the descriptor HashMap.
     * @return The cosine similarity as a double, or -1.0 if either word is not present.
     */
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

    /**
     * The entry point of the application which processes a predefined list of literary works to build synonym relationships.
     * <p>
     * This method sets up an array of URLs pointing to various public domain texts, initializes a Synonyms object with these URLs,
     * and then enters a loop to process user input. Users are prompted to enter a word and a set of choices, and the program
     * calculates the cosine similarity between the user's word and each choice. It displays the similarity scores and identifies
     * the choice with the highest similarity.
     * <p>
     * This program demonstrates how cosine similarity can be used in text analysis, particularly in evaluating which words
     * from a set of choices are most similar to a given word based on their usage in literature. The loop continues until
     * a blank word is entered, allowing for multiple queries during execution.
     *
     * @param args The command line arguments (not used in this application).
     * @throws IOException If there is an issue accessing the URLs or reading from them.
     */
    public static void main(String[] args) throws IOException {
        URL[] corpus = {
                // Pride and Prejudice, by Jane Austen
                new URL("https://www.gutenberg.org/files/1342/1342-0.txt"),
                // The Adventures of Sherlock Holmes, by A. Conan Doyle
                new URL("http://www.gutenberg.org/cache/epub/1661/pg1661.txt"),
                // A Tale of Two Cities, by Charles Dickens
                new URL("https://www.gutenberg.org/files/98/98-0.txt"),
                // Alice's Adventures In Wonderland, by Lewis Carroll
                new URL("https://www.gutenberg.org/files/11/11-0.txt"),
                // Moby Dick; or The Whale, by Herman Melville
                new URL("https://www.gutenberg.org/files/2701/2701-0.txt"),
                // War and Peace, by Leo Tolstoy
                new URL("https://www.gutenberg.org/files/2600/2600-0.txt"),
                // The Importance of Being Earnest, by Oscar Wilde
                new URL("http://www.gutenberg.org/cache/epub/844/pg844.txt"),
                // The Wisdom of Father Brown, by G.K. Chesterton
                new URL("https://www.gutenberg.org/files/223/223-0.txt"),
        };

        Synonyms tc = new Synonyms(corpus);

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a word:");
            String word = sc.nextLine();

            if (word.isBlank()) break;

            System.out.println("Enter the choices:");
            String choices = sc.nextLine();

            double higest = -1.0 ;
            String mostSimular= "";

            String[] choicesArr = choices.toLowerCase().split("\\s+");
            for (String s : choicesArr) {
                double similarity = tc.calculateCosineSimilarity(word, s);
                System.out.println(s + " " + similarity);

                if (similarity > higest) {
                    higest = similarity;
                    mostSimular = s;
                }
            }
            System.out.println(mostSimular + "\n");
        }
    }
}
