package recursion;

import java.util.*;

public class all_subsequence {

    public static void main(String[] args) {
        // Scanner to take input from the user
        Scanner sc = new Scanner(System.in);
        // Reading the input string
        String str = sc.next();

        // Calling the function to find all subsequences
        ArrayList<String> ans = solve(str);

        // Printing the result
        System.out.println(ans);

        // Closing the scanner to avoid resource leak
        sc.close();
    }

    // Recursive function to find all subsequences of the given string
    public static ArrayList<String> solve(String s) {

        // Base case: If the string is empty, return an ArrayList with an empty string
        if (s.length() == 0) {
            ArrayList<String> mstr = new ArrayList<>();
            mstr.add("");
            return mstr;
        }

        // First character of the string
        char ch = s.charAt(0);
        // Remaining part of the string after the first character
        String str = s.substring(1);

        // Recursively find all subsequences of the remaining string
        ArrayList<String> rarr = solve(str);

        // To store the result including subsequences with and without the first
        // character
        ArrayList<String> result = new ArrayList<>();

        // Adding all subsequences without the first character
        for (String r : rarr) {
            result.add("" + r); // Empty addition to keep original subsequence
        }

        // Adding all subsequences with the first character included
        for (String r : rarr) {
            result.add(ch + r); // First character added to each subsequence
        }

        // Returning the final result with all subsequences
        return result;
    }
}
