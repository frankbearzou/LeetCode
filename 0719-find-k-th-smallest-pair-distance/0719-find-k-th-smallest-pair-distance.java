class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, l = 0, r = nums[n - 1] - nums[0];
        int ans = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            if (enough(nums, k, m)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    boolean enough(int[] nums, int k, int m) {
        int count = 0;
        int r = 0;
        for (int l = 0; l < nums.length; l++) {
            while (r < nums.length && nums[r] - nums[l] <= m)
                r++;
            count += r - l - 1;
        }
        return count >= k;
    }
}