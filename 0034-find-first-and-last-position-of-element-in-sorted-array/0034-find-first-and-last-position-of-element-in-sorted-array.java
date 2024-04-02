class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = lowerBound(nums, target);
        if (l == nums.length || nums[l] != target)
            return new int[]{-1, -1};
        int r = lowerBound(nums, target + 1) - 1;
        return new int[]{l, r};
    }

    int lowerBound(int[] nums, int target) {
        int l = 0 , r = nums.length - 1;
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