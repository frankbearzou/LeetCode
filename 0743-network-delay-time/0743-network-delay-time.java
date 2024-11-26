class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int t = time[2];
            adj.get(from).add(new int[]{to, t});
        }
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int[]{k, 0});
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = dist[k] = 0;
        while (!queue.isEmpty()) {
            int[] top = queue.remove();
            int from = top[0];
            visited[from] = true;
            for (int[] nei : adj.get(from)) {
                int to = nei[0];
                int w = nei[1];
                if (visited[to])
                    continue;
                if (dist[from] + w < dist[to]) {
                    dist[to] = dist[from] + w;
                    queue.add(new int[]{to, dist[to]});
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (i == k)
                continue;
            if (dist[i] == Integer.MAX_VALUE)
                return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}