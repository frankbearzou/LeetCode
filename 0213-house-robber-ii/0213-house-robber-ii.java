class Solution {
    public int rob(int[] nums) {
        return Math.max(nums[0], Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length)));
    }

    int rob(int[] nums, int start, int end) {
        // r1, r2, 0, 1, ...
        int r1 = 0, r2 = 0;
        for (int i = start; i < end; i++) {
            int t = Math.max(r1 + nums[i], r2);
            r1 = r2;
            r2 = t;
        }
        return r2;
    }
}