class Solution {
    public int findMinArrowShots(int[][] points) {
        int res = 1;
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int[] cur = points[0];
        for (int i = 1; i < points.length; i++) {
            if (cur[1] >= points[i][0]) {
                cur[0] = Math.max(cur[0], points[i][0]);
                cur[1] = Math.min(cur[1], points[i][1]);
            } else {
                cur = points[i];
                res++;
            }
        }
        return res;
    }
}