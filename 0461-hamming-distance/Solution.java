class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int result = 0;
        while (xor != 0) {
            result += (xor & 1);
            xor >>= 1;
        }
        return result;
    }
}
