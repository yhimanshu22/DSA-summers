package recursion;

import java.util.*;

public class decreasing_increasing {

    public static void solve(int n) {

        if (n == 0)
            return;
        System.out.println(n);
        solve(n - 1);
        System.out.println(n);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solve(n);
        sc.close();
    }
}
