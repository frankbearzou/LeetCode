class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int zeros = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            zeros++;
        }
        m <<= zeros;
        return m;
    }
}
