class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int l = 0;
        int ans = 1;
        for (int r = 1; r < nums.length; r++) {
            if (nums[r - 1] < nums[r]) {
                ans = Math.max(ans, r - l + 1);
            } else {
                l = r;
            }
        }
        return ans;
    }
}