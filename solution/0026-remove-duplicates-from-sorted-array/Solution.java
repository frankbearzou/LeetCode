class Solution {
    public int removeDuplicates(int[] nums) {
        int len = 1, tail = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[tail]) {
                nums[++tail] = nums[i];
                ++len;
            }
        }
        
        return len;
    }
}
