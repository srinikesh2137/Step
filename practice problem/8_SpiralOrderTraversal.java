import java.util.*;

public class SpiralOrderTraversal {
    static ArrayList<Integer> spiralOrder(int[][] grid) {
        ArrayList<Integer> result = new ArrayList<>();
        int top = 0, bottom = grid.length - 1;
        int left = 0, right = grid[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) result.add(grid[top][j]);
            top++;
            for (int i = top; i <= bottom; i++) result.add(grid[i][right]);
            right--;
            if (top <= bottom) {
                for (int j = right; j >= left; j--) result.add(grid[bottom][j]);
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) result.add(grid[i][left]);
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) grid[i][j] = sc.nextInt();
        System.out.println(spiralOrder(grid));
    }
}
// Time: O(m*n); output space: O(m*n).