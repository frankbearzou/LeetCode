class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        if (nums.length < 2)
            return -1;
        Arrays.sort(nums);
        if (nums[0] + nums[1] >= k)
            return -1;
        int n = nums.length, l = 0, r = n - 1;
        int res = -1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum < k) {
                res = Math.max(res, sum);
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}