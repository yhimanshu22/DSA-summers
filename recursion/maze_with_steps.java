package recursion;

import java.util.*;

public class maze_with_steps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<String> ans = solve(1, 1, n, m);
        System.out.println(ans);
        sc.close();
    }

    static ArrayList<String> solve(int sr, int sc, int dr, int dc) {
        // base case
        if (sr == dr && sc == dc) {
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        }

        ArrayList<String> res = new ArrayList<>();

        for (int hs = 1; hs <= dc - sc; hs++) {
            ArrayList<String> hPaths = solve(sr, sc + hs, dr, dc);
            for (String hPath : hPaths) {
                res.add("h" + hs + hPath);
            }
        }

        for (int vs = 1; vs <= dr - sr; vs++) {
            ArrayList<String> vPaths = solve(sr + vs, sc, dr, dc);
            for (String vPath : vPaths) {
                res.add("v" + vs + vPath);
            }
        }

        for (int d = 1; d <= dr - sr && d <= dc - sc; d++) {
            ArrayList<String> dPaths = solve(sr + d, sc + d, dr, dc);
            for (String dPath : dPaths) {
                res.add("d" + d + dPath);
            }
        }

        return res;
    }
}
