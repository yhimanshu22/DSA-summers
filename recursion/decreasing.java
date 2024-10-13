package recursion;

import java.util.*;

public class decreasing {

    public static void decreasing(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        decreasing(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        decreasing(n);
        sc.close();
    }
}
