class Solution {
    static final int MOD = 1_000_000_007;
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int[] cnt = new int[n + 1];
        ArrayList<Integer> digits = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cnt[i + 1] = cnt[i];
            char c = s.charAt(i);
            if (c != '0') {
                digits.add(c - '0');
                cnt[i + 1]++;
            }
        }
        int k = digits.size();
        long[] pow10 = new long[k + 1];
        pow10[0] = 1;
        for (int i = 1; i <= k; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }
        long[] prefixValue = new long[k + 1];
        int[] prefixSum = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            int d = digits.get(i - 1);
            prefixValue[i] = (prefixValue[i - 1] * 10 + d) % MOD;
            prefixSum[i] = prefixSum[i - 1] + d;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int left = cnt[l] + 1;
            int right = cnt[r + 1];
            if (left > right) {
                ans[i] = 0;
                continue;
            }
            int len = right - left + 1;
            long x = (prefixValue[right] - (prefixValue[left - 1] * pow10[len]) % MOD + MOD) % MOD;
            long sum = prefixSum[right] - prefixSum[left - 1];
            ans[i] = (int) ((x * sum) % MOD);
        }
        return ans;
    }
}