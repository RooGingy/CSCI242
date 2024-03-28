package edu.uwp.cs.csci242.assignments.a04.recursion;
public class Recursion{
    public static String stringClean(String str, String newStr){
        try {
            int position = 0;
            int nextPosition = 1;

            newStr += str.toLowerCase().charAt(position);

            while (str.charAt(position) == str.charAt(nextPosition)) {
                nextPosition++;
            }

            str = str.replace(str.substring(position, nextPosition), "");

            return stringClean(str, newStr);

        } catch (IndexOutOfBoundsException e){
            return newStr;
        }
    }

    public static int countDigit (int num, int digit, int count){
        if(num > 0) {
            int holder = num % 10;
            if (holder == digit) {
                count++;
            }
            return countDigit(num/10, digit, count);
        } else {return count;}
    }


    public static boolean isBalanced(String str) {
        if (str.contains("()")) {
            str = str.replace("()", "");
        } else if (str.contains("[]")) {
            str = str.replace("[]", "");
        } else if (str.contains("{}")) {
            str = str.replace("{}", "");
        } else {
            return str.isBlank();
        }
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
        }else { return sum1 == sum2; }

        position++;
        return splitArray(array, position, sum1, sum2);
    }



    public static void main(String[] args){
        // Method 1:
        String newStr = "";
        System.out.println("\nMethod 1:");
        System.out.println(stringClean("aaaabbbccd", newStr));
        System.out.println(stringClean("yyzzza", newStr));
        System.out.println(stringClean("Hello", newStr));


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

    }
}

