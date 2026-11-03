import java.util.*;

public class RemoveDuplicatesSortedArray {
    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int unique = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[unique - 1])
                nums[unique++] = nums[i];
        }
        return unique;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        int k = removeDuplicates(nums);
        System.out.println("Length: " + k);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, k)));
    }
}
// Time: O(n); extra space: O(1). Modifies the input array in place.