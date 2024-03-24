class Solution {
    public int maxProduct(int[] nums) {
        int first = Math.max(nums[0], nums[1]);
        int second = Math.min(nums[0], nums[1]);
        int res = (first - 1) * (second - 1);
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > first) {
                second = first;
                first = nums[i];
            } else if (nums[i] > second) {
                second = nums[i];
            }
            res = Math.max(res, (first - 1) * (second - 1));
        }
        return res;
    }
}