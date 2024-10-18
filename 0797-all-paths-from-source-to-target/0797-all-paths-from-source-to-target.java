class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[][] graph;
    int n;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        n = graph.length - 1;
        dfs(0);
        return ans;
    }

    void dfs(int vertex) {
        path.add(vertex);
        if (vertex == n) {
            ans.add(new ArrayList(path));
            return;
        }
        for (int v : graph[vertex]) {
            dfs(v);
            path.removeLast();
        }
    }
}