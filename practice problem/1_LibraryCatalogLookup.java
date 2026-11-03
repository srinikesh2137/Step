import java.util.*;

public class LibraryCatalogLookup {
    static String findBook(String[][] catalog, String targetIsbn) {
        int left = 0, right = catalog.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = catalog[mid][0].compareTo(targetIsbn);
            if (cmp == 0) return catalog[mid][1];
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[][] catalog = new String[n][2];
        for (int i = 0; i < n; i++) {
            catalog[i][0] = sc.nextLine();
            catalog[i][1] = sc.nextLine();
        }
        String target = sc.nextLine();
        System.out.println(findBook(catalog, target));
    }
}
// Time: O(log n) per query; extra space: O(1).