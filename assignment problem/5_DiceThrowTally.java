import java.util.Arrays;
import java.util.Scanner;

public class DiceThrowTally {
    static int[] diceSort(int[] rolls) {
        int[] count = new int[7];
        for (int roll : rolls) {
            if (roll >= 1 && roll <= 6) count[roll]++;
        }

        System.out.print("Counts: ");
        for (int i = 1; i <= 6; i++)
            System.out.print(i + ":" + count[i] + " ");
        System.out.println();

        int[] sorted = new int[rolls.length];
        int index = 0;
        for (int value = 1; value <= 6; value++)
            for (int j = 0; j < count[value]; j++)
                sorted[index++] = value;
        return sorted;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] rolls = new int[n];
        for (int i = 0; i < n; i++) rolls[i] = sc.nextInt();
        System.out.println("Sorted: " + Arrays.toString(diceSort(rolls)));
    }
}