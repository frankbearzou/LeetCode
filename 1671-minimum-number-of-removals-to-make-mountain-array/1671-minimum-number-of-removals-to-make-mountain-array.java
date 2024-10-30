class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n]; // longest increasing subsequence LIS
        int[] post = new int[n]; // LDS
        Arrays.fill(pre, 1);
        Arrays.fill(post, 1);
        // LIS
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    pre[i] = Math.max(pre[i], pre[j] + 1);
            }
        }
        // LDS
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i])
                    post[i] = Math.max(post[i], post[j] + 1);
            }
        }
        int longest = 0;
        for (int i = 1; i < n - 1; i++) {
            if (pre[i] > 1 && post[i] > 1)
                longest = Math.max(longest, pre[i] + post[i] - 1);
        }
        return n - longest;
    }
}