class Solution {
    public int maxAscendingSum(int[] nums) {
        int ans = 0;
        int cur = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                cur += nums[i];
            } else {
                cur = nums[i];
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}