class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < Math.abs(target) || (sum + target) % 2 != 0)
            return 0;
        int bag = (sum + target) / 2;
        int[] dp = new int[(bag + 1)];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = bag; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bag];
    }
}