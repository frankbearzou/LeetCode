class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k < 2)
            return 0;
        int n = nums.length;
        int l = 0;
        int prod = 1;
        int res = 0;
        for (int r = 0; r < n; r++) {
            prod *= nums[r];
            while (prod >= k) {
                prod /= nums[l++];
            }
            res += r - l + 1;
        }
        return res;
    }
}