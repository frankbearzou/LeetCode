class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 4)
            return 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0, j = n - 4; i <= 3; i++, j++) {
            min = Math.min(min, nums[j] - nums[i]);
        }
        return min;
    }
}