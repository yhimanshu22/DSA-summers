package recursion;

import java.util.*;

public class maze_paths {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<String> ans = solve(1, 1, n, m);
        System.out.println("Number of ways: " + ans.size());
        System.out.println(ans);
        sc.close();
    }

    static ArrayList<String> solve(int sr, int sc, int dr, int dc) {

        if (sr == dc && sc == dc) {
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        ArrayList<String> paths1 = new ArrayList<>();
        ArrayList<String> paths2 = new ArrayList<>();

        if (sc < dc) {
            paths1 = solve(sr, sc + 1, dr, dc);
        }

        if (sr < dr) {
            paths2 = solve(sr + 1, sc, dr, dc);
        }

        ArrayList<String> ans = new ArrayList<>();

        for (String p : paths1) {
            ans.add('h' + p);
        }

        for (String p : paths2) {
            ans.add('v' + p);
        }

        return ans;
    }
}
