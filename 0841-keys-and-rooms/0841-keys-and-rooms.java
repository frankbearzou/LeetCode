class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, 0, visited);
        for (boolean v : visited) {
            if (!v)
                return false;
        }
        return true;
    }

    void dfs(List<List<Integer>> rooms, int key, boolean[] visited) {
        if (visited[key])
            return;
        visited[key] = true;
        for (int k : rooms.get(key)) {
            dfs(rooms, k, visited);
        }
    }
}