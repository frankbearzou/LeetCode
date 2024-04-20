class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int max = 0, count = 0;
        for (int[] r : rectangles) {
            int len = Math.min(r[0], r[1]);
            if (len > max) {
                max = len;
                count = 1;
            } else if (len == max) {
                count++;
            }
        }
        return count;
    }
}