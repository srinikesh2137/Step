import java.util.*;

public class EmployeeIdLookup {
    static HashMap<String, String> buildLookup(String[][] records) {
        HashMap<String, String> map = new HashMap<>();
        for (String[] record : records) map.put(record[0], record[1]);
        return map;
    }

    static String getDepartment(HashMap<String, String> lookup, String id) {
        return lookup.getOrDefault(id, "Unknown");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] records = new String[n][2];
        for (int i = 0; i < n; i++) {
            records[i][0] = sc.next();
            records[i][1] = sc.next();
        }
        HashMap<String, String> lookup = buildLookup(records);
        System.out.println(getDepartment(lookup, sc.next()));
    }
}
// Build: O(n); getDepartment: O(1) average; extra space: O(n).