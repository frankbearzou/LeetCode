class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 == 1)
            return false;
        dp = new Boolean[nums.length + 1][sum / 2 + 1];
        return canPartition(nums, 0, sum / 2);
    }

    boolean canPartition(int[] nums, int index, int target) {
        if (target == 0)
            return true;
        if (target < 0 || index >= nums.length)
            return false;
        if (dp[index][target] != null)
            return dp[index][target];
        dp[index][target] = canPartition(nums, index + 1, target - nums[index]) || canPartition(nums, index + 1, target);
        return dp[index][target];
    }
}