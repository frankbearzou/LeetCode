class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int a = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int b = Math.max(nums[i], a + nums[i]);
            max = Math.max(max, b);
            a = b;
        }
        return max;
    }
}