class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList());
        }
        for (int[] pre : prerequisites) {
            int from = pre[1];
            int to = pre[0];
            map.get(from).add(to);
            inDegree[to]++;
        }
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }
        while (!queue.isEmpty()) {
            int v = queue.remove();
            list.add(v);
            for (int u : map.get(v)) {
                inDegree[u]--;
                if (inDegree[u] == 0) {
                    queue.add(u);
                }
            }
        }
        return list.size() == numCourses;
    }
}