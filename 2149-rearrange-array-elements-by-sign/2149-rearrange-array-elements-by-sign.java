class Solution {
    public int[] rearrangeArray(int[] nums) {
        int N = nums.length;
        int[] ans = new int[N];
        int pos = 0, neg = 1;
        for (int i = 0; i < N; i++) {
            if (nums[i] < 0) {
                ans[neg] = nums[i];
                neg += 2;
            } else {
                ans[pos] = nums[i];
                pos += 2;
            }
        }
        return ans;
    }
}