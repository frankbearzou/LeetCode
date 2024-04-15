class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < nums[r])
                r = m;
            else if (nums[m] > nums[r])
                l = m + 1;
            else
                r = r - 1;
        }
        return nums[l];
    }
}