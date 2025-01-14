class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = binarySearch(nums, target);
        if (l == nums.length || nums[l] != target)
            return new int[]{-1, -1};
        int r = binarySearch(nums, target + 1) - 1;
        return new int[]{l, r};
    }

    int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (target <= nums[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}