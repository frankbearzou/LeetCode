class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans = 1;
        int n = nums.length;
        int inc = 1, dec = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                inc++;
                ans = Math.max(ans, inc);
            } else
                inc = 1;
            if (nums[i - 1] > nums[i]) {
                dec++;
                ans = Math.max(ans, dec);
            } else
                dec = 1;
        }
        return ans;
    }
}