package recursion;

import java.util.*;

public class power_n {
    public static int solve(int n, int x) {
        if (n == 0)
            return 1;
        return solve(n - 1, x) * x;
    }

    public static int logSolve(int n, int x) {
        if (n == 0)
            return 1;
        return n % 2 == 0 ? logSolve(n / 2, x) * logSolve(n / 2, x) : logSolve(n / 2, x) * logSolve(n / 2, x) * x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(logSolve(n, k));
        System.out.println(solve(n, k));
        sc.close();
    }
}
