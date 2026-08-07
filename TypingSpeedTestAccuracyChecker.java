import java.util.Scanner;

public class TypingSpeedTestAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {
        if (original.length() != typed.length()) {
            System.out.println("Error: Strings must be of equal length.");
            return;
        }

        int totalChars = original.length();
        int matchedChars = 0;
        int firstMismatchPosition = -1; 
        char originalMismatchChar = ' ';
        char typedMismatchChar = ' ';

        for (int i = 0; i < totalChars; i++) {
            char originalChar = original.charAt(i);
            char typedChar = typed.charAt(i);

            if (originalChar == typedChar) {
                matchedChars++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = i + 1;
                originalMismatchChar = originalChar;
                typedMismatchChar = typedChar;
            }
        }

        double accuracy = ((double) matchedChars / totalChars) * 100;

        StringBuilder result = new StringBuilder();
        result.append("Matched: ").append(matchedChars).append("/").append(totalChars);
        result.append(" | Accuracy: ").append(String.format("%.2f", accuracy)).append("%");

        if (firstMismatchPosition == -1) {
            result.append(" | No Mismatches");
        } else {
            result.append(" | First Mismatch at position ").append(firstMismatchPosition);
            result.append(" ('").append(originalMismatchChar).append("' vs '").append(typedMismatchChar).append("')");
        }

        System.out.println(result.toString());
    }

    public static void main(String[] args) {
        System.out.println("Test Case 1: ");
        checkTypingAccuracy("hello world", "hello worlt");

        System.out.println();

        System.out.println("Test Case 2: ");
        checkTypingAccuracy("coding", "coding");

        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the original passage (or press Enter to skip): ");
        String userOriginal = scanner.nextLine();

        if (!userOriginal.isEmpty()) {
            System.out.println("Enter your typed attempt (must be same length): ");
            String userTyped = scanner.nextLine();
            System.out.println("Test Case 3 (User Input): ");
            checkTypingAccuracy(userOriginal, userTyped);
        }

        scanner.close();
    }
}
