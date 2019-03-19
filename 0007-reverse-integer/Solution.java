class Solution {
    public int reverse(int x) {
        int res = 0;
        // Integer.MAX_VALUE is 2147483647
        // Integer.MIN_VALUE is -2147483648
        while (x != 0) {
            int mod = x % 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && mod > 7)) return 0;
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && mod< -8)) return 0;
            res = res * 10 + mod;
            x = x / 10;
        }

        return res;
    }
}
