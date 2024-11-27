class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            edges.add(new int[]{i, i + 1});
        }
        for (int k = 0; k < queries.length; k++) {
            int q1 = queries[k][0];
            int q2 = queries[k][1];
            edges.add(new int[]{q1, q2});
            for (int i = 0; i < n - 1; i++) {
                boolean changed = false;
                for (int[] edge : edges) {
                    int from = edge[0];
                    int to = edge[1];
                    if (dist[from] == Integer.MAX_VALUE)
                        continue;
                    if (dist[from] + 1 < dist[to]) {
                        dist[to] = dist[from] + 1;
                        changed = true;
                    }
                }
                if (!changed)
                    break;
            }
            ans[k] = dist[n - 1];
        }
        return ans;
    }
}