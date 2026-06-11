class Solution {
    static final int MOD = 1_000_000_007;
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        int[] depth = new int[n + 1];
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : graph[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    depth[next] = depth[node] + 1;
                    queue.offer(next);
                }
            }
        }
        int maxDepth = 0;
        for (int i = 1; i <= n; i++) {
            maxDepth = Math.max(maxDepth, depth[i]);
        }
        long ans = 1;
        for (int i = 0; i < maxDepth - 1; i++) {
            ans = (ans * 2) % MOD;
        }
        return (int) ans;
    }
}