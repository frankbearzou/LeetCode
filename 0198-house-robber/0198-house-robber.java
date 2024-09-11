class Solution {
    int[] nums;
    int[] dp;

    public int rob(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        dfs(n - 1);
        return dp[n - 1];
    }

    int dfs(int i) {
        if (i < 0)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        dp[i] = Math.max(nums[i] + dfs(i - 2), dfs(i - 1));
        return dp[i];
    }
}