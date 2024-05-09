class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(graph, list, 0);
        return res;
    }

    void dfs(int[][] graph, List<Integer> list, int pos) {
        if (pos == graph.length - 1) {
            res.add(new ArrayList(list));
            return;
        }
        for (int i : graph[pos]) {
            list.add(i);
            dfs(graph, list, i);
            list.remove(list.size() - 1);
        }
    }
}