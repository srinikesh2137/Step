import java.util.Arrays;
import java.util.Scanner;

public class DutyRosterRotation {
    static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        String[] rotated = new String[n];
        int shift = k % n;
        for (int i = 0; i < n; i++)
            rotated[(i + shift) % n] = names[i];
        return rotated;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) names[i] = sc.next();
        int k = sc.nextInt();
        System.out.println(Arrays.toString(rotateRoster(names, k)));
    }
}
// Time: O(n), extra space: O(n).