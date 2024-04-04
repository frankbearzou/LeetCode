class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0)
            return 1;
        int res = 0;
        int shift = 0;
        while (n > 0) {
            res |= ((n & 1) ^ 1) << shift;
            n >>= 1;
            shift++;
        }
        return res;
    }
}