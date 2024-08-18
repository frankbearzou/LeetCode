class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        dfs(rooms, 0, visited);
        return visited.size() == rooms.size();
    }

    void dfs(List<List<Integer>> rooms, int room, Set<Integer> visited) {
        for (int r : rooms.get(room)) {
            if (visited.contains(r))
                continue;
            visited.add(r);
            dfs(rooms, r, visited);
        }
    }
}