/**
 * 5. The Movie Review Word Length Profiler
 *
 * Splits a movie review into individual words and classifies each
 * word as Short, Medium, or Long based on its length.
 */
public class MovieReviewWordLengthProfiler {

    /**
     * Splits the review into words and classifies each word by length:
     * Short (1-4 letters), Medium (5-8 letters), or Long (9+ letters).
     * Prints the final counts for each category.
     *
     * @param review the movie review text
     */
    static void classifyWordLengths(String review) {
        // Split on one or more whitespace characters
        String[] words = review.trim().split("\\s+");

        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (int i = 0; i < words.length; i++) {
            int length = words[i].length();

            if (length == 0) {
                continue; // skip any empty tokens
            }

            if (length <= 4) {
                shortCount++;
            } else if (length <= 8) {
                mediumCount++;
            } else {
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount
                + " | Medium: " + mediumCount
                + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        // Sample Input -> Expected Output: Short: 3 | Medium: 1 | Long: 3
        System.out.println("Test Case 1: ");
        classifyWordLengths("This movie was absolutely fantastic and thrilling");

        System.out.println();

        // Additional test case
        System.out.println("Test Case 2: ");
        classifyWordLengths("A great film with an incredible storyline");

        System.out.println();

        // Optional: allow user to enter their own review
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Enter a movie review (or press Enter to skip): ");
        String userReview = scanner.nextLine();

        if (!userReview.isEmpty()) {
            System.out.println("Test Case 3 (User Input): ");
            classifyWordLengths(userReview);
        }

        scanner.close();
    }
}
