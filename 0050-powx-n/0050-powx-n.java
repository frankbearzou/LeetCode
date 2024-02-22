class Solution {
    public double myPow(double x, int n) {
        double res = 1;
        if (x == 0)
            return 0;
        long m = n;
        if (m < 0) {
            x = 1 / x;
            m = -m;
        }
        while (m > 0) {
            if ((m & 1) == 1) {
                res *= x;
            }
            x *= x;
            m >>= 1;
        }
        return res;
    }
}