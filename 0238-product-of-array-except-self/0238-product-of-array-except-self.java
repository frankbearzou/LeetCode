class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int post = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            res[i] *= post;
            post *= nums[i];
        }
        return res;
    }
}