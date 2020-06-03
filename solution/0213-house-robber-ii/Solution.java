class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        
        return Math.max(rob(nums, 0), rob(nums, 1));
    }
    
    private int rob(int[] nums, int lo) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = nums[lo];
        for (int i = 2; i < dp.length; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1 + lo]);
        return dp[dp.length - 1];
    }
}
