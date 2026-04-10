class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int MOD = 1_000_000_007;
        long[][][] dp = new long[zero + 1][one + 1][2];
        for (int i = 1; i <= Math.min(limit, zero); i++) {
            dp[i][0][0] = 1;
        }
        for (int j = 1; j <= Math.min(limit, one); j++) {
            dp[0][j][1] = 1;
        }
        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                if (i > 0) {
                    for (int k = 1; k <= Math.min(limit, i); k++) {
                        dp[i][j][0] = (dp[i][j][0] + dp[i - k][j][1]) % MOD;
                    }
                }
                if (j > 0) {
                    for (int k = 1; k <= Math.min(limit, j); k++) {
                        dp[i][j][1] = (dp[i][j][1] + dp[i][j - k][0]) % MOD;
                    }
                }
            }
        }
        return (int)((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}