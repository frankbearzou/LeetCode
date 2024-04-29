class Solution {
    public int minOperations(int[] nums, int k) {
        int count = 0;
        int x = 0;
        for (int num : nums)
            x ^= num;
        x ^= k;
        while (x > 0) {
            count += x & 1;
            x >>= 1;
        }
        return count;
    }
}