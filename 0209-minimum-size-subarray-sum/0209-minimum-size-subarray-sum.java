class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int res = n + 1;
        int l = 0;
        int sum = 0;
        for (int r = 0; r < n; r++) {
            sum += nums[r];
            while (sum >= target) {
                res = Math.min(res, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }
        return res > n ? 0 : res;
    }
}