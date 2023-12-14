class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = nums.length + 1;
        int l = 0, sum = 0;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= target) {
                int len = r - l + 1;
                ans = Math.min(ans, len);
                sum -= nums[l];
                l++;
            }
        }
        return ans == nums.length + 1 ? 0 : ans;
    }
}