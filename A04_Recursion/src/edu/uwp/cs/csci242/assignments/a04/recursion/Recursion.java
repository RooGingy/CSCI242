package edu.uwp.cs.csci242.assignments.a04.recursion;

/**
 * Recursion class containing methods for various recursive operations.
 * <p>
 * This class provides static methods for performing recursive operations such as removing adjacent characters that are
 * the same from a string, counting occurrences of a digit in a number, checking the balance of parentheses,
 * square brackets, and curly braces in a string, splitting an array into two parts with equal sums, and solving
 * the Tower of Hanoi.
 * <p>
 * These methods uses recursion to solve the problems "efficiently".
 *
 * @author Austin Moser
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 004
 * @edu.uwp.cs.242.assignment 4
 * @bugs None
 */
public class Recursion{
    /**
     * Recursively removes adjacent characters that are the same, ignoring case.
     * <p>
     * This method takes a string as input and recursively removes adjacent characters that are the same,
     * ignoring case. It returns a new string with adjacent character removed.
     *
     * @param str The input string.
     * @param newStr The intermediate string to store the cleaned characters.
     * @return A new string with adjacent characters that are the same removed.
     */
    public static String stringClean(String str, String newStr) {
        int nextPosition = 1;

        if (nextPosition < str.length() - 1) {
            // Sets the first 2 charters to variables and lower cases them.
            char char1 = Character.toLowerCase(str.charAt(0));
            char char2 = Character.toLowerCase(str.charAt(nextPosition));

            // Moves the first index of each string to a new string.
            newStr += str.substring(0,1);

            // Counts how many charters are the same as the first one.
            while(char1 == char2){
                nextPosition++;
                char2 = Character.toLowerCase(str.charAt(nextPosition));
            }

            // Removes characters as in on big chunk.
            str = str.replace(str.substring(0, nextPosition), "");

            // Calls method again.
            return stringClean(str, newStr);

        }
        // Base Case: Returns newStr if nextPosition is out of bounds of string length.
        else return newStr + str.charAt(0);
    }


    /**
     * Recursively counts the occurrences of a digit in a number.
     * <p>
     * This method counts the number of times a particular digit appears in a number using recursion.
     *
     * @param num The input number.
     * @param digit The digit to look for.
     * @param count The count of occurrences of the digit.
     * @return The count of occurrences of the specified digit.
     */
    public static int countDigit (int num, int digit, int count){
        if(num > 0) {
            // Gets last digit of number.
            int holder = num % 10;

            // if holder equals the digit
            if (holder == digit) {
                count++;
            }

            // Returns everything as well as remove the last digit of number.
            return countDigit(num/10, digit, count);
        } else return count;    // Returned count when there is no more digits in number.
    }


    /**
     * Checks if a string containing only parentheses, square brackets, and curly braces is balanced.
     * <p>
     * This method checks if a string containing only parentheses, square brackets, and curly braces is balanced.
     * It returns true if the string is balanced, and false otherwise.
     *
     * @param str The input string.
     * @return True if the string is balanced, false otherwise.
     */
    public static boolean isBalanced(String str) {
        // Look in string to see if it contains "()", "[]", and "{}" and replaces it with a blank string.
        if (str.contains("()")) {
            str = str.replace("()", "");
        } else if (str.contains("[]")) {
            str = str.replace("[]", "");
        } else if (str.contains("{}")) {
            str = str.replace("{}", "");
        } else return str.isBlank();    // Returns true if string is blank or false if there is still characters in it.
        return isBalanced(str); // Continues recursion after if each if-statement.
    }

    /**
     * Recursively splits an array into two parts with equal sums.
     * <p>
     * This method recursively splits an array into two parts such that the sum of elements in each part is equal.
     * It returns true if such a split is possible, and false otherwise.
     *
     * @param array The input array.
     * @param position The current position in the array.
     * @param sum1 The sum of elements in the first part.
     * @param sum2 The sum of elements in the second part.
     * @return True if the array can be split into two parts with equal sums, false otherwise.
     */
    public static boolean splitArray(int[] array, int position, int sum1, int sum2){
        if (position < array.length) {
            if (sum1 == sum2) { // If both sums are equal then it will add to the next number to sum1.
                sum1 += array[position];
            } else if (sum1 > sum2) { // Sum1 is greater than sum2 are then it will add to the next number to sum2.
                sum2 += array[position];
            } else {    // else it will add to sum1.
                sum1 += array[position];
            }
        } else return sum1 == sum2; // If position is not less than array.length then it will return if sum is equal or not.

        return splitArray(array, position + 1, sum1, sum2); // Calls method again this time with a new index position.
    }


    /**
     * Prints the steps to solve the Tower of Hanoi problem with a twist.
     * <p>
     * This method prints the steps to solve the Tower of Hanoi problem with a twist: for an odd number of disks,
     * it uses a different sequence of moves. It prints the steps to move disks from one peg to another.
     *
     * @param disks The number of disks in the Tower of Hanoi.
     */
    public static void trickyHanoi (int disks){
        if(disks == 0){ // If disk number equals 0 then method ends.
            return;
        }

        if (disks % 2 != 0) {   // If disk is odd it will print its own instruction or add on to whatever was printed before.
            System.out.println("Move disk from peg A to peg B.");
            System.out.println("Move disk from peg B to peg C.");
            trickyHanoi(disks - 1); // Decrease disk number while calling method again.
        } else { // else if disk is even it will print its own instruction or add on to whatever was printed before.
            System.out.println("Move disk from peg A to peg B.");
            System.out.println("Move disk from peg B to peg C.");

            System.out.println("Move disk from peg A to peg B.");

            System.out.println("Move disk from peg C to peg B.");
            System.out.println("Move disk from peg B to peg A.");

            System.out.println("Move disk from peg B to peg C.");
            trickyHanoi(disks - 1); // Decrease disk number while calling method again.
        }
    }


    /**
     * Main Method
     * <p>
     * This method is used to test the recursion methods above.
     *
     * @param args uhhhhh...
     */
    public static void main(String[] args){
        // Method 1:
        String newStr = "";
        System.out.println("\nMethod 1:");
        System.out.println(stringClean("Hello", newStr));
        System.out.println(stringClean("aaaabbbccdaa", newStr));
        System.out.println(stringClean("yyzzza", newStr));


        // Method 2:
        int count = 0;
        System.out.println("\nMethod 2:");
        System.out.println(countDigit(222,2, count));
        System.out.println(countDigit (123414, 1, count));
        System.out.println(countDigit (123414, 5, count));


        // Method 3:
        System.out.println("\nMethod 3:");
        System.out.println(isBalanced("{([])([()])}"));
        System.out.println(isBalanced("[(){}]"));
        System.out.println(isBalanced("{(})"));


        // Method 4:
        int zero = 0;
        System.out.println("\nMethod 4:");
        System.out.println(splitArray(new int[]{2, 2}, zero, zero, zero));
        System.out.println(splitArray(new int[]{2, 3}, zero, zero, zero));
        System.out.println(splitArray(new int[]{5, 2, 3}, zero, zero, zero));
        System.out.println(splitArray(new int[]{2, 5, 3}, zero, zero, zero));


        // Method 5:
        System.out.println("\nMethod 5:");
        System.out.println("Disks = 2");
        trickyHanoi(2);
        System.out.println("Disks = 3");
        trickyHanoi(3);
    }
}

