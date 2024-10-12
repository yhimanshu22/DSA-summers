import java.util.*;

public class DuplicateCharacters {

    public static boolean hasDuplicates(String s) {
        Set<Character> charSet = new HashSet<>();

        for (char ch : s.toCharArray()) {
            // If the character is already in the set, we found a duplicate
            if (!charSet.add(ch)) {
                return true; // Duplicate found
            }
        }
        return false; // No duplicates found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to check for duplicates: ");
        String s = sc.nextLine();

        if (hasDuplicates(s)) {
            System.out.println("The string has duplicate characters.");
        } else {
            System.out.println("The string has no duplicate characters.");
        }

        sc.close(); // Close the scanner
    }
}
