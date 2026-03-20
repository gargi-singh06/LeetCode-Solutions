import java.util.*;

class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] result = new int[m - k + 1][n - k + 1];

        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {

                int[] arr = new int[k * k];
                int idx = 0;

                // collect elements
                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        arr[idx++] = grid[x][y];
                    }
                }

                Arrays.sort(arr);

                int minDiff = Integer.MAX_VALUE;

                for (int p = 1; p < arr.length; p++) {
                    if (arr[p] != arr[p - 1]) { // 🔥 distinct values only
                        minDiff = Math.min(minDiff, arr[p] - arr[p - 1]);
                    }
                }

                // 🔥 critical fix
                if (minDiff == Integer.MAX_VALUE) {
                    minDiff = 0;
                }

                result[i][j] = minDiff;
            }
        }

        return result;
    }
}