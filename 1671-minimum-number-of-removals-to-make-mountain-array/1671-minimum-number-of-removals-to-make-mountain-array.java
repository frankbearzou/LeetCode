class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int ans = n;
        int[] pre = new int[n];
        int[] post = new int[n];
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, pre[j]);
                }
            }
            pre[i] = max + 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            int max = 0;
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, post[j]);
                }
            }
            post[i] = max + 1;
        }
        for (int i = 1; i < n - 1; i++) {
            int len = pre[i] + post[i] - 1;
            ans = Math.min(ans, n - len);
        }
        return ans;
    }
}