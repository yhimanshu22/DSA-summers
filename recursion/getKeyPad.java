package recursion;

import java.util.*;

public class getKeyPad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solve(str));
        sc.close();
    }

    public static ArrayList<String> solve(String str) {

        // Base case
        if (str.length() == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        // Correct keypad mapping
        String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        // Get first character of the string and remaining string
        char ch = str.charAt(0);
        String crr = str.substring(1);

        // Recursively get combinations for the remaining string
        ArrayList<String> rarr = solve(crr);

        // List to store final combinations
        ArrayList<String> ans = new ArrayList<>();

        // Get the corresponding code for the current digit
        String code = codes[ch - '0']; // Convert character to integer index

        // Create combinations for the current digit and append to the result
        for (int i = 0; i < code.length(); i++) {
            char s = code.charAt(i);
            for (String rstr : rarr) {
                ans.add(s + rstr);
            }
        }

        return ans;
    }
}
