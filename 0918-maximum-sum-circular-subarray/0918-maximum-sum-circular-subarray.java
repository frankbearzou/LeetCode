class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        // normal
        int sum = nums[0];
        int cur = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            sum += nums[i];
            cur = Math.max(nums[i], cur + nums[i]);
            max = Math.max(max, cur);
        }
        if (max < 0)
            return max;
        // wrap: two end
        // get middle min array first. 
        // two wrap + middle min = sum
        // two wrap = sum - middle min
        cur = nums[0];
        int min = nums[0];
        for (int i = 1; i < n; i++) {
            cur = Math.min(nums[i], cur + nums[i]);
            min = Math.min(min, cur);
        }
        return Math.max(max, sum - min);
    }
}