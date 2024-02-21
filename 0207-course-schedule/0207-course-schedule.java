class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList());
        }
        for (int[] pre : prerequisites) {
            edges.get(pre[1]).add(pre[0]);
        }
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(edges, i, visited))
                return false;
        }
        return true;
    }

    boolean dfs(List<List<Integer>> edges, int i, boolean[] visited) {
        if (visited[i])
            return false;
        visited[i] = true;
        for (int nei : edges.get(i)) {
            if (!dfs(edges, nei, visited))
                return false;
        }
        visited[i] = false;
        edges.get(i).clear();
        return true;
    }
}