class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] post = new int[n];
        for (int i = 1; i < n; i++) {
            pre[i] = nums[i - 1] + pre[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            post[i] = nums[i + 1] + post[i + 1];
        }
        for (int i = 0; i < n; i++) {
            if (pre[i] == post[i])
                return i;
        }
        return -1;
    }
}