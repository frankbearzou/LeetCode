class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] res = new double[n];
        res[start_node] = 1;
        for (int i = 0; i < n - 1; i++) {
            boolean changed = false;
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                double p = succProb[j];
                if (res[u] * p > res[v]) {
                    res[v] = res[u] * p;
                    changed = true;
                }
                if (res[v] * p > res[u]) {
                    res[u] = res[v] * p;
                    changed = true;
                }
            }
            if (!changed)
                break;
        }
        return res[end_node];
    }
}