class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        int max = Integer.MAX_VALUE;
        Arrays.fill(dist, max);
        dist[0] = dist[k] = 0;
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList());
        }
        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int w = time[2];
            graph.get(from).add(new int[]{to, w});
        }
        // dijkstra
        queue.add(new int[]{k, 0});
        while (!queue.isEmpty()) {
            int[] top = queue.remove();
            int from = top[0];
            visited[from] = true;
            for (int[] v : graph.get(from)) {
                int to = v[0];
                int w = v[1];
                if (visited[to])
                    continue;
                if (dist[from] + w < dist[to]) {
                    dist[to] = dist[from] + w;
                    queue.add(new int[]{to, dist[to]});
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == max)
                return -1;
            if (i == k)
                continue;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}