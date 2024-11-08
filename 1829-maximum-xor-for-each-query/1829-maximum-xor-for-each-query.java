class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] ans = new int[n];
        int k = (int)Math.pow(2, maximumBit) - 1;
        int cur = 0;
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            cur ^= nums[i];
            ans[j] = cur ^ k;
        }
        return ans;
    }
}