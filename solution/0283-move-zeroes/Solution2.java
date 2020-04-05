class Solution {
    public void moveZeroes(int[] nums) {
        int zero = 0, nonzero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && nums[zero] != 0) {
                zero = i;
            } else if (nums[i] != 0 && nums[zero] == 0) {
                // swap
                nums[zero] = nums[i];
                nums[i] = 0;
                zero++;
            }
        }
    }
}
