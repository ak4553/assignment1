
public class SeatDuplicationChecker {

    // Method to check duplicate seats
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;

        // Nested loops to compare each seat with every other seat
        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                }
            }
        }

        // If no duplicates were found
        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    // Main method to test the program
    public static void main(String[] args) {
        int[] seats1 = {101, 102, 103, 102, 105};
        int[] seats2 = {101, 102, 103, 104, 105};

        System.out.println("Test Case 1:");
        checkDuplicateSeats(seats1);

        System.out.println("\nTest Case 2:");
        checkDuplicateSeats(seats2);
    }
}
