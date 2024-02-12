class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[rooms.size()];
        queue.offer(0);
        for (int first : rooms.get(0)) {
            queue.offer(first);
            visited[first] = true;
        }
        while (!queue.isEmpty()) {
            int top = queue.poll();
            for (int key : rooms.get(top)) {
                if (visited[key])
                    continue;
                queue.offer(key);
            }
            visited[top] = true;
        }
        for (boolean v : visited) {
            if (!v)
                return false;
        }
        return true;
    }
}