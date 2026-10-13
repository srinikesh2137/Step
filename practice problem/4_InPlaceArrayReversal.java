import java.util.Arrays;
import java.util.Scanner;

public class InPlaceArrayReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        for (int left = 0, right = n - 1; left < right; left++, right--) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
        }

        System.out.println(Arrays.toString(a));
    }
}