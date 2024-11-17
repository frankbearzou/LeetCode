class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;
        int len = n + 1;
        int l = 0;
        for (int r = 0; r < n; r++) {
            sum += nums[r];
            while (l <= r && sum >= k) {
                len = Math.min(len, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }
        if (len == n + 1)
            return -1;
        return len;
    }
}