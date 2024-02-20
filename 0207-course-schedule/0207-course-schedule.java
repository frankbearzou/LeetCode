class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for (int[] pre : prerequisites) {
            List<Integer> list = map.getOrDefault(pre[0], new ArrayList());
            list.add(pre[1]);
            map.put(pre[0], list);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(map, i, visited))
                return false;
        }
        return true;
    }

    boolean dfs(Map<Integer, List<Integer>> map, int i, Set<Integer> visited) {
        if (visited.contains(i))
            return false;
        if (!map.containsKey(i))
            return true;
        visited.add(i);
        for (int nei : map.get(i)) {
            if (!dfs(map, nei, visited))
                return false;
        }
        visited.remove(i);
        map.remove(i);
        return true;
    }
}