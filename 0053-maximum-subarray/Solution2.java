class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0], submax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            submax = Math.max(submax + nums[i], nums[i]);
            max = Math.max(max, submax);
        }
        return max;
    }
}
