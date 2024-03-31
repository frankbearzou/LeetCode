class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int min = -1, max = -1, start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                min = -1;
                max = -1;
                start = i + 1;
            }
            if (nums[i] == minK) {
                min = i;
            }
            if (nums[i] == maxK) {
                max = i;
            }
            if (min != -1 && max != -1) {
                res += Math.min(min, max) - start + 1;
            }
        }
        return res;
    }
}