class Solution {
    public int hIndex(int[] citations) {
        int res = 0;
        int l = 0, r = citations[citations.length - 1];
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (hIndex(citations, mid)) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    boolean hIndex(int[] citations, int mid) {
        int count = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] >= mid) {
                count++;
            } else
                break;
        }
        return count >= mid;
    }
}