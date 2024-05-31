class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int xor = 0;
        for (int num : nums)
            xor ^= num;
        xor = xor & -xor;
        for (int num : nums) {
            res[(num & xor) == 0 ? 0 : 1] ^= num;
        }
        return res;
    }
}