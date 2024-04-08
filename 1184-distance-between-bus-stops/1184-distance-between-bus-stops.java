class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int res = 0;
        int dis = 0;
        for (int i = start; i < destination; i++) {
            dis += distance[i];
        }
        res = dis;
        dis = 0;
        for (int i = destination; (i % distance.length) != start; i++) {
            dis += distance[i % distance.length];
        }
        res = Math.min(res, dis);
        return res;
    }
}