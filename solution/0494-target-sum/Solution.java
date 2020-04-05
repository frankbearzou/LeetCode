class Solution {
    private int count = 0;
    private int[] nums;
    private int S;
    
    public int findTargetSumWays(int[] nums, int S) {
        this.nums = nums;
        this.S = S;
        calculate(0, 0);
        return count;
    }
    
    private void calculate(int i, int sum) {
        if (i == nums.length) {
            if (sum == S)
                ++count;
        } else {
            calculate(i + 1, sum + nums[i]);
            calculate(i + 1, sum - nums[i]);
        }
    }
}
