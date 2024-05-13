class Solution {
    public int maxDistToClosest(int[] seats) {
        int dis = 0;
        int n = seats.length;
        int start = -1;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                dis = Math.max(dis, (i - start) / 2);
                start = i;
            }
        }
        dis = Math.max(dis, n - 1 - start);
        return dis;
    }
}