class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < dp.length; i++) {
            int val = i < cost.length ? cost[i] : 0;
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + val;
        }
        return dp[cost.length];
    }
}
