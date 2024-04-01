class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean b = true;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                b = false;
                break;
            }
        }
        if (b)
            return true;

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i])
                return false;
        }
        return true;
    }
}