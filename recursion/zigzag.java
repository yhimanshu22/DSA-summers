package recursion;

import java.util.*;

public class zigzag {
    public static void solve(int n) {
        if (n == 0)
            return;
        System.out.println("pre" + n);
        solve(n - 1);
        System.out.println("in" + n);
        solve(n - 1);
        System.out.println("post" + n);
    }

    public static void solver(int n) {
        if (n == 0)
            return;
        System.out.print(n + " ");
        solver(n - 1);
        System.out.print(n + " ");
        solver(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solver(n);
        solve(n);
        sc.close();

    }
}
