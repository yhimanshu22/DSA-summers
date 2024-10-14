package recursion;

import java.util.*;

public class toh {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t1 = sc.nextInt();
        int t2 = sc.nextInt();
        int t3 = sc.nextInt();

        solve(n, t1, t2, t3);

    }

    public static void solve(int n, int t1, int t2, int t3) {
        if (n == 0)
            return;

        solve(n - 1, t1, t3, t2);
        System.out.println("Move disk " + n + " from " + t1 + " to " + t2);
        solve(n - 1, t3, t2, t1);
    }
}
