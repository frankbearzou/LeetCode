class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, ans, path, 0);
        return ans;
    }

    void dfs(int[][] graph, List<List<Integer>> ans, List<Integer> path, int v) {
        if (v == graph.length - 1) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int p : graph[v]) {
            path.add(p);
            dfs(graph, ans, path, p);
            path.remove(path.size() - 1);
        }
    }
}