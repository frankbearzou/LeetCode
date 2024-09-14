class Solution {
    public int longestSubarray(int[] nums) {
        int count = 1;
        int max = nums[0];
        int cnt = 1;
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if ((cur & nums[i]) >= nums[i]) {
                cur = cur & nums[i];
                cnt++;
                if (cur >= max) {
                    max = cur;
                    count = cnt;
                }
            } else {
                cur = nums[i];
                cnt = 1;
            }
        }
        return count;
    }
}