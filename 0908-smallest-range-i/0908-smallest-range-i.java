class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int n = nums.length;
        int max = nums[0], min = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int diff = max - min - 2 * k;
        return diff <= 0 ? 0 : diff;
    }
}