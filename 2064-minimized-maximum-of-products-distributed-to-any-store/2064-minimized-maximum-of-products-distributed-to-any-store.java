class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int r = quantities[0];
        for (int q : quantities) {
            r = Math.max(r, q);
        }
        int l = 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (success(n, quantities, m))
                r = m - 1;
            else
                l = m + 1;
        }
        return l;
    }

    boolean success(int n, int[] quantities, int m) {
        for (int q : quantities) {
            int k = q / m;
            if (q % m > 0)
                k++;
            if (k > n)
                return false;
            n -= k;
        }
        return true;
    }
}