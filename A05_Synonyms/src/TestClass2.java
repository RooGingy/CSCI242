import java.util.Scanner;

public class TestClass2 {
    public static void main(String[] args) {
        // Example string input; in practice, this could be read from a file, user input, etc.
        String inputText = "Hello! How are you? I hope\nyou're doing well. This is a test.";

        // Create a scanner instance with the input text
        try (Scanner scanner = new Scanner(inputText)) {
            // Set the delimiter to split the input into sentences based on punctuation
            scanner.useDelimiter("[\\.\\?\\!]+|\\Z");

            // Read and process each sentence
            while (scanner.hasNext()) {
                String sentence = scanner.next().trim(); // Trim to remove leading/trailing whitespace
                if (!sentence.isEmpty()) {
                    System.out.println("Sentence: " + sentence);
                }
            }
        }
    }
}
