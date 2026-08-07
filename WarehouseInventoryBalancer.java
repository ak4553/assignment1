import java.util.Scanner;

public class WarehouseInventoryBalancer {

    static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA.length != sectionB.length) {
            System.out.println("Error: Arrays must be of equal length.");
            return;
        }

        int totalA = 0;
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
        }

        int totalB = 0;
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        int highestValue = Integer.MIN_VALUE;
        String highestSection = "";
        int highestIndex = -1; 

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > highestValue) {
                highestValue = sectionA[i];
                highestSection = "Section A";
                highestIndex = i + 1;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > highestValue) {
                highestValue = sectionB[i];
                highestSection = "Section B";
                highestIndex = i + 1;
            }
        }

        System.out.println("Section A Total: " + totalA
                + " | Section B Total: " + totalB
                + " | Status: " + status
                + " | Highest Quantity: " + highestValue
                + " (" + highestSection + ", Item " + highestIndex + ")");
    }

    public static void main(String[] args) {
        System.out.println("Test Case 1: ");
        analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 30});

        System.out.println();

        System.out.println("Test Case 2: ");
        analyzeInventory(new int[]{10, 40, 5}, new int[]{20, 10, 5});

        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of items per section (or 0 to skip): ");
        int n = scanner.hasNextInt() ? scanner.nextInt() : 0;

        if (n > 0) {
            int[] userSectionA = new int[n];
            int[] userSectionB = new int[n];

            System.out.println("Enter " + n + " quantities for Section A: ");
            for (int i = 0; i < n; i++) {
                userSectionA[i] = scanner.nextInt();
            }

            System.out.println("Enter " + n + " quantities for Section B: ");
            for (int i = 0; i < n; i++) {
                userSectionB[i] = scanner.nextInt();
            }

            System.out.println("Test Case 3 (User Input): ");
            analyzeInventory(userSectionA, userSectionB);
        }

        scanner.close();
    }
}
