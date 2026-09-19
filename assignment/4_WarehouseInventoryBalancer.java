import java.util.*;

public class WarehouseInventoryBalancer {
    static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        int totalB = 0;

        for (int value : sectionA) totalA += value;
        for (int value : sectionB) totalB += value;

        String status = totalA == totalB ? "Balanced" : "Not Balanced";

        int highest = sectionA[0];
        String highestSection = "Section A";
        int highestIndex = 0;

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > highest) {
                highest = sectionA[i];
                highestSection = "Section A";
                highestIndex = i;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > highest) {
                highest = sectionB[i];
                highestSection = "Section B";
                highestIndex = i;
            }
        }

        System.out.println("Section A Total: " + totalA);
        System.out.println("Section B Total: " + totalB);
        System.out.println("Status: " + status);
        System.out.println("Highest Quantity: " + highest + " (" + highestSection
                + ", Item " + (highestIndex + 1) + ")");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] sectionA = new int[n];
        int[] sectionB = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Section A, Item " + (i + 1) + ": ");
            sectionA[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            System.out.print("Section B, Item " + (i + 1) + ": ");
            sectionB[i] = sc.nextInt();
        }

        analyzeInventory(sectionA, sectionB);
        sc.close();
    }
}