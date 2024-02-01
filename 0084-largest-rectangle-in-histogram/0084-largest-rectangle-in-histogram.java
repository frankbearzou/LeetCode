class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int N = heights.length;
        // left min
        int[] lmin = new int[N];
        lmin[0] = -1;
        for (int i = 1; i < N; i++) {
            int l = i - 1;
            while (l >= 0 && heights[l] >= heights[i]) {
                l = lmin[l];
            }
            lmin[i] = l;
        }
        // right min
        int[] rmin = new int[N];
        rmin[N - 1] = N;
        for (int i = N - 2; i >= 0; i--) {
            int r = i + 1;
            while (r < N && heights[r] >= heights[i]) {
                r = rmin[r];
            }
            rmin[i] = r;
        }
        for (int i = 0; i < N; i++) {
            int sum = heights[i] * (rmin[i] - lmin[i] - 1);
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}