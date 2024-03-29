class Solution {
    public int minOperations(int[] nums, int x) {
        int res = -1;
        int sum = 0, n = nums.length;
        for (int num : nums)
            sum += num;
        if (sum < x)
            return -1;
        int target = sum - x;
        int l = 0;
        sum = 0;
        for (int r = 0; r < n; r++) {
            sum += nums[r];
            while (sum > target) {
                sum -= nums[l++];
            }
            if (sum == target) {
                res = Math.max(res, r - l + 1);
            }
        }
        return res == -1 ? -1 : n - res;
    }
}