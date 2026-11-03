import java.util.*;

public class WarehouseBinGridScan {
    static int[] warehouseSummary(int[][] grid) {
        int total = 0, max = grid[0][0], maxRow = 0, maxCol = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
                if (grid[i][j] > max) {
                    max = grid[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        return new int[]{total, maxRow, maxCol};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) grid[i][j] = sc.nextInt();
        int[] ans = warehouseSummary(grid);
        System.out.println("Total: " + ans[0]);
        System.out.println("Max coordinate: (" + ans[1] + ", " + ans[2] + ")");
    }
}
// Time: O(m*n); extra space: O(1).