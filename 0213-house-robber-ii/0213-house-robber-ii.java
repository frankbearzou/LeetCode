class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }

    int rob(int[] nums, int start, int end) {
        if (end - start == 0)
            return nums[start];
        int[] dp = new int[end - start + 2];
        dp[1] = nums[start];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i + start - 1] + dp[i - 2]);
        }
        return dp[dp.length - 1];
    }
}