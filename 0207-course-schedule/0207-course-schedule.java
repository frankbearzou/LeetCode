class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for (int[] pre : prerequisites) {
            List<Integer> list = map.getOrDefault(pre[0], new ArrayList<Integer>());
            list.add(pre[1]);
            map.put(pre[0], list);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, map, visited))
                return false;
        }
        return true;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> map, Set<Integer> visited) {
        if (visited.contains(course))
            return false;
        if (!map.containsKey(course))
            return true;
        visited.add(course);
        List<Integer> pre = map.get(course);
        for (int p : pre) {
            if (!dfs(p, map, visited))
                return false;
        }
        map.remove(course);
        visited.remove(course);
        return true;
    }
}