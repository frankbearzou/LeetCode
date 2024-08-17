class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        long[] prevDp = new long[n];
        for (int j = 0; j < n; j++)
            prevDp[j] = points[0][j];
        for (int i = 1; i < m; i++) {
            long[] left = new long[n];
            long[] right = new long[n];
            long[] curDp = new long[n];

            left[0] = prevDp[0];
            for (int j = 1; j < n; j++) {
                left[j] = Math.max(prevDp[j], prevDp[j - 1] - 1);
            }

            right[n - 1] = prevDp[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                right[j] = Math.max(prevDp[j], prevDp[j + 1] - 1);
            }
            for (int j = 0; j < n; j++) {
                curDp[j] = points[i][j] + Math.max(left[j], right[j]);
            }
            prevDp = curDp;
        }
        long max = 0;
        for (int j = 0; j < n; j++)
            max = Math.max(max, prevDp[j]);
        return max;
    }
}