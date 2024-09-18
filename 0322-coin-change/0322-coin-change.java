class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans = amount + 1;
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        Arrays.fill(dp[0], amount + 1);
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j - coins[i - 1] < 0)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
            }
        }
        return dp[n][amount] == amount + 1 ? -1 : dp[n][amount];
    }
}