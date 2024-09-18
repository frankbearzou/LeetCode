class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                int num = nums.get(i - 1);
                dp[i][j] = dp[i - 1][j];
                if (j - num >= 0 && dp[i - 1][j - num] != -1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - num] + 1);
                }
            }
        }
        return dp[n][target];
    }
}