class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (m * k > n)
            return -1;
        int l = 0, r = 1_000_000_000;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int flower = 0, bouquet = 0;
            for (int i : bloomDay) {
                if (i > mid) {
                    flower = 0;
                } else if (++flower >= k) {
                    flower = 0;
                    bouquet++;
                }
            }
            if (bouquet >= m)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}