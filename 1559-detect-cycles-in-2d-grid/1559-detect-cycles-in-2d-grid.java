class Solution {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, visited, i, j, -1, -1, grid[i][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] grid, boolean[][] visited,
                        int r, int c, int pr, int pc, char ch) {
        if (visited[r][c]) return true;
        visited[r][c] = true;
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length)
                continue;
            if (grid[nr][nc] != ch) continue;
            if (nr == pr && nc == pc) continue;
            if (dfs(grid, visited, nr, nc, r, c, ch)) return true;
        }
        return false;
    }
}