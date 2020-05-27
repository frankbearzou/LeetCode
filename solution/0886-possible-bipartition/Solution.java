class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[][] graph = new int[N][N];
        int[] group = new int[N];

        for (int[] dis : dislikes) {
            graph[dis[0] - 1][dis[1] - 1] = 1;
            graph[dis[1] - 1][dis[0] - 1] = 1;
        }

        for (int i = 0; i < N; i++) {
            if (group[i] == 0 && !dfs(graph, group, i, 1))
                return false;
        }

        return true;
    }

    private boolean dfs(int[][] graph, int[] group, int index, int g) {
        group[index] = g;

        for (int i = 0; i < graph.length; i++) {
            if (graph[index][i] == 1) {
                if (group[i] == g)
                    return false;
                if (group[i] == 0 && !dfs(graph, group, i, -g))
                    return false;
            }
        }

        return true;
    }
}
