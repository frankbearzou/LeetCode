class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0)
            return false;
        Boolean[][] cache = new Boolean[nums.length][sum / 2 + 1];
        return dfs(nums, 0, sum / 2, cache);
    }

    boolean dfs(int[] nums, int index, int target, Boolean[][] cache) {
        if (index >= nums.length)
            return false;
        if (target < 0)
            return false;
        if (target == 0)
            return true;
        if (cache[index][target] != null)
            return cache[index][target];
        cache[index][target] = dfs(nums, index + 1, target, cache) || dfs(nums, index + 1, target - nums[index], cache);
        return cache[index][target];
    }
}