import java.util.*;

public class NextGreaterElement {

    public static int[] solve(int[] arr) {

        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        ans[n - 1] = -1;
        st.push(arr[n - 1]);

        for (int i = n - 2; i >= 0; i--) {

            while (!st.isEmpty() && arr[i] > st.peek()) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();

            }
            st.push(arr[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt(); // Read the number of elements
        int[] arr = new int[n];

        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); // Read each element
        }

        int[] result = solve(arr); // Call the solve method

        System.out.println("Next Greater Elements: ");
        for (int elem : result) {
            System.out.print(elem + " "); // Print the result
        }
        sc.close(); // Close the scanner
    }
}
