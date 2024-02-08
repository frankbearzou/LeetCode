class Solution {
    public int searchInsert(int[] nums, int target) {
        int N = nums.length;
        int l = 0, r = N - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return r + 1;
    }
}