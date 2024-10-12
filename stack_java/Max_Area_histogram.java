import java.util.*;

public class Max_Area_histogram {

    public static int solve(int[] arr) {
        int n = arr.length;

        int[] rb = new int[n]; // next smaller element on the right
        int[] lb = new int[n]; // next smaller element on the left

        Stack<Integer> st = new Stack<>();

        // Calculate left bounds
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            lb[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        // Clear the stack to reuse it for right bounds
        st.clear();

        // Calculate right bounds
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            rb[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        // Calculate the maximum area
        int maxArea = 0; // Initialize maxArea to 0
        for (int i = 0; i < n; i++) {
            int width = rb[i] - lb[i] - 1; // Calculate width
            int area = arr[i] * width; // Calculate area
            maxArea = Math.max(maxArea, area); // Update maxArea if needed
        }

        return maxArea; // Return the maximum area found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of bars: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the heights of the bars: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = solve(arr); // Call the method to find max area
        System.out.println("Maximum area of the rectangle in histogram: " + result); // Print the result

        sc.close(); // Close the scanner
    }
}
