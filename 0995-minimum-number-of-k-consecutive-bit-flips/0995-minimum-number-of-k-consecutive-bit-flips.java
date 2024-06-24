class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int curFlip = 0;
        int[] flip = new int[n];

        for (int i = 0; i < n; i++) {
            if (i >= k) {
                curFlip -= flip[i - k];
            }
            if ((nums[i] + curFlip) % 2 == 0) {
                if (i + k > n)
                    return -1;
                flip[i] = 1;
                curFlip++;
                count++;
            }
        }
        return count;
    }
}