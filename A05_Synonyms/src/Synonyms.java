import javax.print.DocFlavor;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class Synonyms {
    private final HashMap<String, HashMap<String, Integer>> descriptors;

    public Synonyms(URL[] corpus) throws IOException {
        descriptors = new HashMap<>();
        parseString(corpus);
    }

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
