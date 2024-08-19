class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = dp[1] = 0;
        for (int i = 1; i <= n; i++) {
            int start = dp[i] + 1;
            for (int j = 2; i * j <= n; j++) {
                dp[i * j] = Math.min(dp[i * j], ++start);
            }
        }
        return dp[n];
    }
}