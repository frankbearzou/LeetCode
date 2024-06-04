class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        int curX = points[0][0], curY = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int dx = Math.abs(curX - points[i][0]);
            int dy = Math.abs(curY - points[i][1]);
            res += Math.min(dx, dy) + Math.abs(dx - dy);
            curX = points[i][0];
            curY = points[i][1];
        }
        return res;
    }
}