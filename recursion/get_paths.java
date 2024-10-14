package recursion;

import java.util.*;

public class get_paths {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<String> ans = solve(n);

        System.out.println(ans);
    }

    public static ArrayList<String> solve(int n) {
        // base case
        if (n == 0) {
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        } else if (n < 0) {
            return new ArrayList<>();
        }
        ArrayList<String> paths1 = solve(n - 1);
        ArrayList<String> paths2 = solve(n - 2);
        ArrayList<String> paths3 = solve(n - 3);

        ArrayList<String> path = new ArrayList<>();

        for (String p : paths1) {
            path.add(1 + p);
        }

        for (String p : paths2) {
            path.add(2 + p);
        }

        for (String s : paths3) {
            path.add(3 + s);
        }

        return path;

    }
}
