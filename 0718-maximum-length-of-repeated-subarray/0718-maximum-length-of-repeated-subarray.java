class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int ans = 0;
        int[] dp = new int[nums2.length + 1];
        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                }
                ans = Math.max(ans, dp[j]);
            }
        }
        return ans;
    }
}