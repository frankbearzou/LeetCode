class Solution {
    public int maxAscendingSum(int[] nums) {
        int max = nums[0];
        int cur = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                cur += nums[i];
                max = Math.max(max, cur);
            } else {
                cur = nums[i];
            }
        }
        return max;
    }
}