class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1, r = nums[0];
        for (int num : nums) {
            r = Math.max(r, num);
        }
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (binarySearch(nums, maxOperations, m)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    boolean binarySearch(int[] nums, int maxOperations, int m) {
        int count = 0;
        for (int num : nums) {
            count += num / m + (num % m == 0 ? 0 : 1) - 1;
            if (count > maxOperations)
                return false;
        }
        return true;
    }
}