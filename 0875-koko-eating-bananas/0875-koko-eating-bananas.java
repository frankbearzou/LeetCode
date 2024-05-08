class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 1;
        for (int pile : piles)
            r = Math.max(r, pile);
        while (l < r) {
            int m = l + (r - l) / 2;
            int k = 0;
            for (int pile : piles) {
                k += Math.ceil(1.0 * pile / m);
            }
            if (k > h)
                l = m + 1;
            else
                r = m;
        }
        return l;
    }
}