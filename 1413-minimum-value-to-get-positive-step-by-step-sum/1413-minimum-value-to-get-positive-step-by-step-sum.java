class Solution {
    public int minStartValue(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        int min = preSum[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
            min = Math.min(min, preSum[i]);
        }
        if (min >= 1)
            return 1;
        return 1 - min;
    }
}