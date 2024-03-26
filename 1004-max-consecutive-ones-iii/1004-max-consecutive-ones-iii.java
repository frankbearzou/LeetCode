class Solution {
    public int longestOnes(int[] nums, int k) {
        int res = 0;
        int count0 = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0)
                count0++;
            while (count0 > k) {
                if (nums[l++] == 0)
                    count0--;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}