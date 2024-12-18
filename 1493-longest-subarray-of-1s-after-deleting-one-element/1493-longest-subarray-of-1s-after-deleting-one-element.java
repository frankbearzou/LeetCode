class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int zero = 0;
        int l = 0;
        for (int i = 0; i < n; i++) {
            zero += nums[i] == 0 ? 1 : 0;
            while (zero > 1) {
                zero -= nums[l] == 0 ? 1 : 0;
                l++;
            }
            ans = Math.max(ans, i - l);
        }
        return ans;
    }
}