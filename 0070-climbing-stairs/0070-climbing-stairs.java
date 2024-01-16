class Solution {
    public int climbStairs(int n) {
        // unbounded knapsack
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int j = 0; j <= n; j++) {
            for (int i = 1; i <= 2; i++) {
                if (j - i >= 0)
                    dp[j] += dp[j - i];
            }
        }
        return dp[n];
    }
}