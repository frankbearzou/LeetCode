class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        for (int pile : piles)
            r = Math.max(r, pile);
        while (l < r) {
            int m = l + (r - l) / 2;
            if (check(piles, h, m))
                r = m;
            else
                l = m + 1;
        }
        return l;
    }

    boolean check(int[] piles, int h, int m) {
        int sum = 0;
        for (int pile : piles) {
            sum += (pile - 1) / m + 1;
            if (sum > h)
                return false;
        }
        return true;
    }
}