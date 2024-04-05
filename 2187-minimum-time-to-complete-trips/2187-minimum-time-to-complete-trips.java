class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long r = 0;
        for (int t : time)
            r = Math.max(r, t);
        r *= totalTrips;
        long l = 1;
        while (l <= r) {
            long m = l + (r - l) / 2;
            long sum = 0;
            for (int t : time) {
                sum += m / t;
            }
            if (sum < totalTrips)
                l = m + 1;
            else
                r = m - 1;
        }
        return l;
    }
}