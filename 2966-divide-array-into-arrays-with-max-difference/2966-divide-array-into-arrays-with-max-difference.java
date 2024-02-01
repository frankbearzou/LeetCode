class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int[][] ans = new int[nums.length / 3][3];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 3) {
            if (nums[i + 1] - nums[i] <= k && nums[i + 2] - nums[i + 1] <= k && nums[i + 2] - nums[i] <= k) {
                ans[i / 3] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
            } else {
                return new int[0][0];
            }
        }
        return ans;
    }
}