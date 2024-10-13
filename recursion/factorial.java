package recursion;

import java.util.*;

public class factorial {

    public static int solve(int n) {
        if (n == 1)
            return 1;
        if (n == 0)
            return 1;

        return solve(n - 1) * n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int ans = solve(n);
        System.out.println(ans);
    }
}
