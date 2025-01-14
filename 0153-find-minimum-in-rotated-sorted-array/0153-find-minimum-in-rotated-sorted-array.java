class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] <= nums[n - 1]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }
}