class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int pos = lowerBound(nums, 1);
        int neg = lowerBound(nums, 0);
        return Math.max(n - pos, neg);
    }

    int lowerBound(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target)
                l = m + 1;
            else
                r = m - 1;
        }
        return l;
    }
}