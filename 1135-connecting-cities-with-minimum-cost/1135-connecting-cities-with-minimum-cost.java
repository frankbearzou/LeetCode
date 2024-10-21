class Solution {
    public int minimumCost(int n, int[][] connections) {
        int max = Integer.MAX_VALUE;
        int[] cost = new int[n + 1];
        boolean[] tree = new boolean[n + 1];
        List<int[]>[] dist = new List[n + 1];

        for (int i = 2; i <= n; i++)
            cost[i] = max;
        
        for (int i = 0; i <= n; i++)
            dist[i] = new ArrayList<>();
        for (int[] conn : connections) {
            int u = conn[0];
            int v = conn[1];
            int d = conn[2];
            dist[u].add(new int[]{v, d});
            dist[v].add(new int[]{u, d});
        }

        // prim
        for (int i = 0; i < n; i++) {
            int min = max;
            int cur = -1;
            for (int j = 1; j <= n; j++) {
                if (!tree[j] && cost[j] < min) {
                    min = cost[j];
                    cur = j;
                }
            }
            if (cur == -1)
                break;
            tree[cur] = true;
            for (int[] ver : dist[cur]) {
                int v = ver[0];
                int d = ver[1];
                if (!tree[v] && d < cost[v])
                    cost[v] = d;
            }
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (cost[i] == max)
                return -1;
            sum += cost[i];
        }
        return sum;
    }
}