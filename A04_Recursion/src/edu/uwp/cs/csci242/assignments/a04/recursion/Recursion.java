package edu.uwp.cs.csci242.assignments.a04.recursion;
public class Recursion{
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


    public static int countDigit (int num, int digit, int count){
        if(num > 0) {
            int holder = num % 10;

            if (holder == digit)
                count++;

            return countDigit(num/10, digit, count);
        } else return count;
    }


    public static boolean isBalanced(String str) {
        if (str.contains("()")) {
            str = str.replace("()", "");
        } else if (str.contains("[]")) {
            str = str.replace("[]", "");
        } else if (str.contains("{}")) {
            str = str.replace("{}", "");
        } else return str.isBlank();
        return isBalanced(str);
    }

    public static boolean splitArray(int[] array, int position, int sum1, int sum2){
        if (position < array.length) {
            if (sum1 == sum2) {
                sum1 += array[position];
            } else if (sum1 > sum2) {
                sum2 += array[position];
            } else {
                sum1 += array[position];
            }
        } else return sum1 == sum2;

        position++;
        return splitArray(array, position, sum1, sum2);
    }

    public static void trickyHanoi (int disks){
        if(disks == 0){
            return;
        }

        if (disks % 2 != 0) {
            System.out.println("Move disk from peg A to peg B.");
            System.out.println("Move disk from peg B to peg C.");
            trickyHanoi(disks - 1);
        } else {
            System.out.println("Move disk from peg A to peg B.");
            System.out.println("Move disk from peg B to peg C.");

            System.out.println("Move disk from peg A to peg B.");

            System.out.println("Move disk from peg C to peg B.");
            System.out.println("Move disk from peg B to peg A.");

            System.out.println("Move disk from peg B to peg C.");
            trickyHanoi(disks - 1);
        }
    }


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

