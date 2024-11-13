class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long ans = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int l = lowerBound(nums, i + 1, n - 1, lower - nums[i]);
            int r = lowerBound(nums, i + 1, n - 1, upper - nums[i] + 1);
            ans += r - l;
        }
        return ans;
    }

    int lowerBound(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= target)
                r = m - 1;
            else
                l = m + 1;
        }
        return l;
    }
}