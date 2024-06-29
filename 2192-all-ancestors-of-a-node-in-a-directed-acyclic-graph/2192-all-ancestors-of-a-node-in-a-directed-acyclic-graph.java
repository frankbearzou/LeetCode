class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adj[to].add(from);
        }
        for (int i = 0; i < n; i++) {
            Set<Integer> visited = new HashSet<>();
            dfs(i, adj, visited);
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (visited.contains(j))
                    list.add(j);
            }
            ans.add(list);
        }
        return ans;
    }

    void dfs(int i, List<Integer>[] adj, Set<Integer> visited) {
        if (visited.contains(i))
            return;
        visited.add(i);
        for (int node : adj[i]) {
            dfs(node, adj, visited);
        }
    }
}