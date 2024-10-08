class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int cur = nums[0];
        int max = cur;
        for (int i = 1; i < n; i++) {
            cur = Math.max(nums[i], cur + nums[i]);
            max = Math.max(cur, max);
        }
        return max;
    }
}