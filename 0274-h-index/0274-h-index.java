class Solution {
    public int hIndex(int[] citations) {
        int min = citations[0], max = citations[0];
        for (int i = 0; i < citations.length; i++) {
            min = Math.min(min, citations[i]);
            max = Math.max(max, citations[i]);
        }
        int res = 0;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (hIndex(citations, mid)) {
                res = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return res;
    }

    boolean hIndex(int[] citations, int mid) {
        int count = 0;
        for (int cit : citations) {
            if (cit >= mid) {
                count++;
            }
        }
        return count >= mid;
    }
}