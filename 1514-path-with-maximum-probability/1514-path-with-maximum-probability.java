class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] cost = new double[n];
        boolean[] visited = new boolean[n];
        cost[start_node] = 1;
        for (int i = 0; i < n; i++) {
            int cur = -1;
            double maxCost = 0;
            for (int j = 0; j < n; j++) {
                if (visited[j])
                    continue;
                if (cost[j] > maxCost) {
                    cur = j;
                    maxCost = cost[j];
                }
            }
            if (cur == -1)
                break;
            visited[cur] = true;
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                double c = succProb[j];
                if (u == cur && !visited[v]) {
                    if (cost[u] * c > cost[v])
                        cost[v] = cost[u] * c;
                }
                if (v == cur && !visited[u]) {
                    if (cost[v] * c > cost[u])
                        cost[u] = cost[v] * c;
                }
            }
        }
        return cost[end_node];
    }
}