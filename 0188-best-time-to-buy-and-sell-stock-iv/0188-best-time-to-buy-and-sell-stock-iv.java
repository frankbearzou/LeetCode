class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][k + 1][2];
        for (int j = 0; j <= k; j++)
            dp[0][j][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                // not hold
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                // hold
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        int max = 0;
        for (int j = 1; j <= k; j++) {
            max = Math.max(max, dp[n - 1][j][0]);
        }
        return max;
    }
}