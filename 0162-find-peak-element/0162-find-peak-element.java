class Solution {
    public int findPeakElement(int[] nums) {
        int l = -1, r = nums.length - 1;
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < nums[m + 1])
                l = m;
            else
                r = m;
        }
        return r;
    }
}