class Solution {
    public int maxProfit(int[] prices) {
        // 0: first time hold stock
        // 1: first time without stock
        // 2: second time hold stock
        // 3: second time without stock
        int[][] dp = new int[prices.length][4];
        dp[0][0] = dp[0][2] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
        }
        return dp[dp.length - 1][3];
    }
}