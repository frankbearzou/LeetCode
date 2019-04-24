class Solution {
    public void moveZeroes(int[] nums) {
        int fast = 0, slow = 0;
        
        while (fast < nums.length) {
            if (nums[slow] == 0 && nums[fast] != 0) {
                nums[slow] = nums[fast];
                nums[fast] = 0;
                ++slow;
            } else if (nums[slow] != 0) {
                ++slow;
            }
            ++fast;
        }
        
        while (slow < nums.length && nums[slow] != 0) {
            nums[slow] = 0;
            ++slow;
        }
    }
}
