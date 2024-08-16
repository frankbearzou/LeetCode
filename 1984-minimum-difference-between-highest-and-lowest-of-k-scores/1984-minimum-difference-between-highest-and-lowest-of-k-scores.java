class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1)
            return 0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i] - nums[i - 1]);
        }
        return min;
    }
}