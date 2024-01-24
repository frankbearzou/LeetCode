class Solution {
    public int maxProfit(int[] prices) {
        //state
        //0: hold stock
        //1: sold stock
        //2: sell today
        //3: cooldown
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1] - prices[i], dp[i - 1][3] - prices[i]));
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
                dp[i][2] = dp[i - 1][0] + prices[i];
                dp[i][3] = dp[i - 1][2];
            }
        }
        int max = dp[dp.length - 1][0];
        for (int i = 1; i < 4; i++) {
            max = Math.max(max, dp[dp.length - 1][i]);
        }
        return max;
    }
}