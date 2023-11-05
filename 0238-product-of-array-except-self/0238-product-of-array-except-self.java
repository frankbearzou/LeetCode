class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int[] post = new int[nums.length];
        int[] ans = new int[nums.length];
        pre[0] = nums[0];
        post[post.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < pre.length; i++) {
            pre[i] = pre[i - 1] * nums[i];
        }
        for (int i = post.length - 2; i >= 0; i--) {
            post[i] = post[i + 1] * nums[i];
        }
        ans[0] = post[1];
        ans[ans.length - 1] = pre[pre.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            ans[i] = pre[i - 1] * post[i + 1];
        }
        return ans;
    }
}