class Solution {
    public void moveZeroes(int[] nums) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                //swap
                int t = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = t;
                slow++;
            }
            fast++;
        }
    }
}