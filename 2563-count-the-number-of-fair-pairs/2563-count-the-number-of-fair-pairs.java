class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int l = lowerBound(nums, i, lower - nums[i]);
            int r = lowerBound(nums, i, upper - nums[i] + 1);
            res += r - l;
        }
        return res;
    }

    int lowerBound(int[] nums, int r, int target) {
        int l = 0;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target)
                l = m + 1;
            else
                r = m;
        }
        return l;
    }
}