class Solution {
    List<List<Integer>> adj = new ArrayList<>();
    int[] values;
    int k;
    int count = 0;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.values = values;
        this.k = k;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        dfs(0, -1);
        return count;
    }

    int dfs(int cur, int parent) {
        int sum = 0;
        for (int nei : adj.get(cur)) {
            if (nei != parent) {
                sum += dfs(nei, cur);
                sum %= k;
            }
        }
        sum += values[cur];
        sum %= k;
        if (sum == 0)
            count++;
        return sum;
    }
}