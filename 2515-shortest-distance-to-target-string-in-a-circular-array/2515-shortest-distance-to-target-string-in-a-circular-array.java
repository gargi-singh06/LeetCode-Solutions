class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int dist = Math.abs(i - startIndex);
                dist = Math.min(dist, n - dist);
                res = Math.min(res, dist);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}