class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            ans[i] = binarySearch(items, queries[i]);
        }
        return ans;
    }

    int binarySearch(int[][] items, int target) {
        int l = 0, r = items.length - 1;
        int max = 0;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (target < items[m][0]) {
                r = m - 1;
            } else {
                max = Math.max(max, items[m][1]);
                l = m + 1;
            }
        }
        return max;
    }
}