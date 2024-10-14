package recursion;

import java.util.*;

public class print_subsequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        solve(str, "");
        sc.close();
    }

    static void solve(String s, String ans) {
        // base case
        if (s.length() == 0) {
            System.out.print(ans + " "); // print each subsequence on a new line
            return;
        }

        char ch = s.charAt(0);
        String str = s.substring(1);

        // Include the current character in the subsequence
        solve(str, ans + ch);

        // Exclude the current character from the subsequence
        solve(str, ans);
    }
}
