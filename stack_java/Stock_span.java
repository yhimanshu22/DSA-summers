import java.util.*;

public class Stock_span {

    public static int[] solve(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();

        int ans[] = new int[n];

        ans[0] = 1;
        st.push(0);

        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[i] = i + 1;
                st.push(i);
            } else {
                ans[i] = i - st.peek();
                st.push(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of days: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the stock prices: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] res = solve(arr); // Call the solve method

        System.out.println("Stock Spans: ");
        for (int num : res) {
            System.out.print(num + " "); // Print the result
        }
        sc.close(); // Close the scanner
    }
}
