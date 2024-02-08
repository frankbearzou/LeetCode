class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1])
            return new int[]{-1, -1};
        // left
        int left = -1, right = -1;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (r >= 0 && r < nums.length && nums[r] == target)
            left = r;
        else if (l >= 0 && l < nums.length && nums[l] == target)
            left = l;
        else
            return new int[]{-1, -1};
        // right
        l = 0; r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (l >= 0 && l < nums.length && nums[l] == target)
            right = l;
        else if (r >= 0 && r < nums.length && nums[r] == target)
            right = r;
        else
            return new int[]{-1, -1};
        return new int[]{left, right};
    }
}