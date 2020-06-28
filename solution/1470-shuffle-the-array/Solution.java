class Solution {
    public int[] shuffle(int[] nums, int n) {
        if (n == 1)
            return nums;
        
        int[] ans = new int[nums.length];
        
        int index = 0;
        for (int i = 0; i < n; i++) {
            ans[index] = nums[i];
            index += 2;
        }
        
        index = 1;
        for (int i = n; i < 2 * n; i++) {
            ans[index] = nums[i];
            index += 2;
        }
        
        return ans;
    }
}
