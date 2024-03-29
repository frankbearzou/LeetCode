class Solution {
    public int maximumCount(int[] nums) {
        return Math.max(binarySearch(nums, 0), nums.length - binarySearch(nums, 1));
    }

    int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target)
                l = m + 1;
            else
                r = m;
        }
        return l;
    }
}