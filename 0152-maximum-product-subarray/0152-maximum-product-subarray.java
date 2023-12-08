class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0], max = 1, min = 1;
        for (int n : nums) {
            int t = n * max;
            max = Math.max(n, Math.max(n * max, n * min));
            min = Math.min(n, Math.min(t, n * min));
            ans = Math.max(ans, max);
        }
        return ans;
    }
}