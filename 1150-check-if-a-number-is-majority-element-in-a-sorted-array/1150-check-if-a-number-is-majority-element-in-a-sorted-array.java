class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int l = binarySearch(nums, target);
        int r = binarySearch(nums, target + 1);
        return r - l > nums.length / 2;
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