class Solution {
    public boolean isArmstrong(int n) {
        int res = 0;
        int power = digit(n);
        int m = n;
        while (m > 0) {
            int d = m % 10;
            res += power(d, power);
            m /= 10;
        }
        return res == n;
    }

    int digit(int n) {
        int res = 0;
        while (n > 0) {
            res++;
            n /= 10;
        }
        return res;
    }

    int power(int n, int power) {
        int res = n;
        for (int i = 1; i < power; i++) {
            res *= n;
        }
        return res;
    }
}