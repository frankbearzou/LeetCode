class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] cost = new int[n + 1];
        int max = Integer.MAX_VALUE;
        Arrays.fill(cost, max);
        cost[0] = cost[k] = 0;
        //bellman ford
        for (int i = 1; i < n; i++) {
            for (int[] time : times) {
                int from = time[0];
                int to = time[1];
                int t = time[2];
                if (cost[from] != max && cost[from] + t < cost[to]) {
                    cost[to] = cost[from] + t;
                }
            }
        }
        int min = 0;
        for (int i = 1; i <= n; i++) {
            if (i == k)
                continue;
            if (cost[i] == max)
                return -1;
            min = Math.max(min, cost[i]);
        }
        return min;
    }
}