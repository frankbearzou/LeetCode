class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = binarySearch(nums, nums[i] + 2 * k);
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

    int binarySearch(int[] nums, int val) {
        int l = 0, r = nums.length - 1;
        int ans = 0;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] <= val) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }
}