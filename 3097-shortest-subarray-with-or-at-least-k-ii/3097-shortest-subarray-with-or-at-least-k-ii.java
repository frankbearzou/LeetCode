class Solution {
    int[] bits = new int[32];

    public int minimumSubarrayLength(int[] nums, int k) {
        int left = 0, right = 0, n = nums.length;
        int ans = Integer.MAX_VALUE;
        while (right < n) {
            updateBits(nums[right], 1);
            while (left <= right && getBits() >= k) {
                ans = Math.min(ans, right - left + 1);
                updateBits(nums[left], -1);
                left++;
            }
            right++;
        }
        if (ans == Integer. MAX_VALUE)
            return -1;
        return ans;
    }

    void updateBits(int num, int delta) {
        int pos = 0;
        while (num > 0) {
            if ((num & 1) == 1)
                bits[pos] += delta;
            num >>= 1;
            pos++;
        }
    }

    int getBits() {
        int num = 0;
        for (int i = 0; i < 32; i++) {
            num |= (bits[i] > 0) ? (1 << i) : 0;
        }
        return num;
    }
}