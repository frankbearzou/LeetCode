class Solution {
    public int pivotInteger(int n) {
        if (n == 1)
            return 1;
        int l = 1, r = (1 + n) * n / 2;
        for (int i = 2; i <= n; i++) {
            l += i;
            r -= i - 1;
            if (l == r)
                return i;
        }
        return -1;
    }
}