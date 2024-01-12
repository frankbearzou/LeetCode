class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return backtracking(nums, 0, target);
    }

    int backtracking(int[] nums, int start, int target) {
        if (start >= nums.length) {
            if (target == 0)
                return 1;
            return 0;
        }
        return backtracking(nums, start + 1, target + nums[start]) + backtracking(nums, start + 1, target - nums[start]);
    }
}