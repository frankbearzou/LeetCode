class Solution {
    public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int lowbit = xor & -xor;
        for (int num : nums) {
            ans[(num & lowbit) == 0 ? 0 : 1] ^= num;
        }
        return ans;
    }
}