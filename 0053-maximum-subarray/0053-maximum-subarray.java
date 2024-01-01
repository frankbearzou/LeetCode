class Solution {
    public int maxSubArray(int[] nums) {
        int curMax = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(curMax + nums[i], nums[i]);
            max = Math.max(max, curMax);
        }
        return max;
    }
}