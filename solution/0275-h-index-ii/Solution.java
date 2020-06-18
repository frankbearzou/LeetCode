class Solution {
    public int hIndex(int[] citations) {
        int lo = 0, hi = citations.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int val = citations.length - mid;
            if (val == citations[mid])
                return val;
            else if (citations[mid] > val)
                hi = mid;
            else
                lo = mid + 1;
        }
        return citations.length - lo;
    }
}
