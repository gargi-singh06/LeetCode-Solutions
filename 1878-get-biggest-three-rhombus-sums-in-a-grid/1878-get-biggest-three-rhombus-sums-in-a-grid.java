import java.util.*;
class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                set.add(grid[i][j]);
                for (int k = 1; i - k >= 0 && i + k < m && j - k >= 0 && j + k < n; k++) {
                    int sum = 0;
                    int r = i - k, c = j;
                    for (int t = 0; t < k; t++) sum += grid[r + t][c + t];
                    for (int t = 0; t < k; t++) sum += grid[r + k + t][c + k - t];
                    for (int t = 0; t < k; t++) sum += grid[r + 2 * k - t][c - t];
                    for (int t = 0; t < k; t++) sum += grid[r + k - t][c - k + t];
                    set.add(sum);
                }
            }
        }
        int size = Math.min(3, set.size());
        int[] res = new int[size];
        int idx = 0;
        while (size-- > 0) {
            res[idx++] = set.pollLast();
        }
        return res;
    }
}