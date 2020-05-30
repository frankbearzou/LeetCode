class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<Integer>();
        
        for (int[] courses : prerequisites) {
            graph[courses[1]].add(courses[0]);
        }
        
        for (int i = 0; i < numCourses; i++)
            if (!dfs(graph, visited, i))
                return false;
        
        return true;
    }
    
    private boolean dfs(List<Integer>[] graph, boolean[] visited, int course) {
        if (visited[course])
            return false;
        visited[course] = true;
        
        for (int i = 0; i < graph[course].size(); i++) {
            if (!dfs(graph, visited, graph[course].get(i)))
                return false;
        }
        
        visited[course] = false;
        return true;
    }
}
