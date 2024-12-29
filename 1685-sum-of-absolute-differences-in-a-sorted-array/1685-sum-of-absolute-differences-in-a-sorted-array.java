class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            int l = 0, r = 0;
            if (i > 0) {
                l = nums[i] * i - prefix[i - 1];
            }
            if (i < n - 1) {
                r = prefix[n - 1] - prefix[i] - (n - i - 1) * nums[i];
            }
            ans[i] = l + r;
        }
        return ans;
    }
}