class Solution {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        if (nums.length == 1)
            return 0;
        
        int left = 0, right = 0;
        
        for (int i = 1; i < nums.length; i++) {
            right += nums[i];
        }
        
        if (left == right)
            return 0;
        
        for (int i = 1; i < nums.length; i++) {
            left += nums[i - 1];
            right -= nums[i];
            if (left == right)
                return i;
        }
        
        return -1;
    }
}
