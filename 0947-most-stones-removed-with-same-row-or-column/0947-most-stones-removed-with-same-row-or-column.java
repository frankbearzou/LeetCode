class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList());
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited);
                count++;
            }
        }
        return n - count; // n - number of connected components
    }

    void dfs(List<List<Integer>> graph, int i, boolean[] visited) {
        visited[i] = true;
        for (int neighbor : graph.get(i)) {
            if (visited[neighbor])
                continue;
            dfs(graph, neighbor, visited);
        }
    }
}