class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = Math.max(max, sum);
                sum = 0;
            } else {
                ++sum;
            }
        }
        
        return Math.max(max, sum);
    }
}
