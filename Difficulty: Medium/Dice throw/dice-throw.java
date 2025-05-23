class Solution {
    static int noOfWays(int m, int n, int x) {
        // code here
        int[][] dp = new int[n + 1][x + 1];

        // Base case: One way to make sum 0 with 0 dice.
        dp[0][0] = 1;

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= x; j++) {
                dp[i][j] = 0;
                for (int k = 1; k <= m; k++) {
                    if (j - k >= 0) {
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }
        }

        return dp[n][x]; 
    }
}
