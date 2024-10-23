class Solution {
    List<Integer>[] adj;
    boolean[] visited;

    public int countComponents(int n, int[][] edges) {
        int ans = 0;
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans++;
                dfs(i);
            }
        }
        return ans;
    }

    void dfs(int i) {
        visited[i] = true;
        for (int v : adj[i]) {
            if (!visited[v])
                dfs(v);
        }
    }
}