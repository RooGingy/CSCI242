import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Synonyms {

    private static HashMap<String, HashMap<String, Integer>> descriptors;

    public Synonyms(URL[] corpus) throws IOException {
        descriptors = new HashMap<>();
        parseCorpus(corpus);
    }

    public void parseCorpus ( URL[] corpus ) throws IOException {
        for (URL url : corpus) {
            Scanner scanner = new Scanner(url.openStream());
            scanner.useDelimiter("[\\.\\?\\!]|\\Z");    // Splits prompt into sentences.

            while (scanner.hasNextLine()) {
                String sentence = scanner.next().toLowerCase().replaceAll("\\W+", " ");
                String[] words = sentence.split("\\s+");    // Splits sentences into words.
                descriptorUpdate(words);
            }
            scanner.close();
        }
    }

    public void descriptorUpdate (String[] words ){
        for(int i = 0; i < words.length; i++){
            descriptors.put(words[i],new HashMap<>());
            HashMap<String, Integer> wordCount= descriptors.get(words[i]);
            for(String word : words){
                //count the times each word appears
                wordCount.put(word,wordCount.getOrDefault(word,0)+1);
            }
        }
    }

    public double calculateCosineSimilarity(String word1, String word2) {
        if (!descriptors.containsKey(word1) || !descriptors.containsKey(word2)) {
            return -1.0; // return -1 if either word is not in the descriptors
        }

        HashMap<String, Integer> desc1 = descriptors.get(word1);
        HashMap<String, Integer> desc2 = descriptors.get(word2);

        double dotProduct = 0.0;
        double norm1 = 0.0;
        double norm2 = 0.0;

        for (String key : desc1.keySet()) {
            norm1 += Math.pow(desc1.get(key), 2);
            if (desc2.containsKey(key)) {
                dotProduct += desc1.get(key) * desc2.get(key);
            }
        }

        for (int value : desc2.values()) {
            norm2 += Math.pow(value, 2);
        }

        if (norm1 == 0.0 || norm2 == 0.0) {
            return 0.0; // return 0 if either vector is zero vector
        }

        return dotProduct / (Math.sqrt(norm1) * Math.sqrt(norm2)); // calculating cosine similarity
    }

    public static void main(String[] args) throws IOException {
        URL[] corpus = {
                // Pride and Prejudice, by Jane Austen
                new URL("https://www.gutenberg.org/files/1342/1342-0.txt"),
                // The Adventures of Sherlock Holmes, by A. Conan Doyle
                new URL("https://www.gutenberg.org/cache/epub/1661/pg1661.txt"),
                // A Tale of Two Cities, by Charles Dickens
                new URL("https://www.gutenberg.org/files/98/98-0.txt"),
                // Alice's Adventures In Wonderland, by Lewis Carroll
                new URL("https://www.gutenberg.org/files/11/11-0.txt"),
                // Moby Dick; or The Whale, by Herman Melville
                new URL("https://www.gutenberg.org/files/2701/2701-0.txt"),
                // War and Peace, by Leo Tolstoy
                new URL("https://www.gutenberg.org/files/2600/2600-0.txt"),
                // The Importance of Being Earnest, by Oscar Wilde
                new URL("https://www.gutenberg.org/cache/epub/844/pg844.txt"),
                // The Wisdom of Father Brown, by G.K. Chesterton
                new URL("https://www.gutenberg.org/files/223/223-0.txt"),
        };

        Synonyms synonyms = new Synonyms(corpus);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word:");
        String word = sc.nextLine();

        System.out.println("Enter the choices");
        String choices = sc.nextLine();


        String[] choicesArr = choices.toLowerCase().split("\\s+");
        for (String s : choicesArr){
            double similarity = synonyms.calculateCosineSimilarity(word, s);
            System.out.println(s + " " + similarity);
        }
    }
}