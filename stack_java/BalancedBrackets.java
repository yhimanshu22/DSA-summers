import java.util.*;

public class BalancedBrackets {

    public static boolean isBalanced(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                // Check if the stack is empty before popping
                if (st.isEmpty())
                    return false;
                char pop = st.pop();
                if (!isMatching(pop, ch))
                    return false;
            }
        }
        return st.isEmpty(); // Return true if stack is empty
    }

    static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to check for balanced brackets: ");
        String s = sc.nextLine();

        if (isBalanced(s)) {
            System.out.println("The string is balanced.");
        } else {
            System.out.println("The string is not balanced.");
        }

        sc.close(); // Close the scanner
    }
}
