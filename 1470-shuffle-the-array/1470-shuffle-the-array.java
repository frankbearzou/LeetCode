class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        for (int i = 0; i < n; i++) {
            res[2 * i] = nums[i];
        }
        for (int i = n; i < nums.length; i++) {
            res[2 * (i - n) + 1] = nums[i];
        }
        return res;
    }
}