class Solution {
    public void rotate(int[] nums, int k) {
        int N = nums.length;
        k %= N;
        reverse(nums, 0, N - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, N - 1);
    }

    void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start++; end--;
        }
    }
}