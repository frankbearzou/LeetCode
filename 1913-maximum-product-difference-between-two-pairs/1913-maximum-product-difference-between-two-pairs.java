class Solution {
    public int maxProductDifference(int[] nums) {
        int max = nums[0], max2 = nums[0];
        int min = nums[0], min2 = nums[0];
        for (int num : nums) {
            if (num > max) {
                max2 = max;
                max = num;
            } else if (num > max2) {
                max2 = num;
            }
            if (num < min) {
                min2 = min;
                min = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return max * max2 - min * min2;
    }
}