class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int k = n - i;
            if (nums[i] >= k) {
                if (i > 0) {
                    if (nums[i - 1] < k) {
                        return k;
                    }
                } else
                    return k;
            }
        }
        return -1;
    }
}