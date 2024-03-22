class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int cur = -(k + 1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (i - cur <= k)
                    return false;
                cur = i;
            }
        }
        return true;
    }
}