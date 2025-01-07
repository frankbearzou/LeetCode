class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) {
                count++;
                if (i > 1 && nums[i] <= nums[i - 2]) {
                    nums[i] = nums[i - 1];
                }
            }
        }
        return count < 2;
    }
}