class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int dis = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x && Math.abs(y - points[i][1]) < dis) {
                dis = Math.abs(y - points[i][1]);
                index = i;
            }
            if (points[i][1] == y && Math.abs(x - points[i][0]) < dis) {
                dis = Math.abs(x - points[i][0]);
                index = i;
            }
        }
        return index;
    }
}