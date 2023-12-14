class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int l = 0, r = nums.length - 1, index = ans.length - 1;
        while (l <= r) {
            if (nums[l] * nums[l] < nums[r] * nums[r]) {
                ans[index] = nums[r] * nums[r];
                index--;
                r--;
            } else {
                ans[index] = nums[l] * nums[l];
                index--;
                l++;
            }
        }
        return ans;
    }
}