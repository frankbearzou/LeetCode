class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> ans = new ArrayList<>(); 
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adj.get(pre[0]).add(pre[1]);
            indegree[pre[1]]++;
        }
        List<Set<Integer>> map = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            map.add(new HashSet<>());
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int nei : adj.get(cur)) {
                map.get(nei).add(cur);
                for (int pre : map.get(cur)) {
                    map.get(nei).add(pre);
                }
                if (--indegree[nei] == 0)
                    queue.add(nei);
            }
        }
        for (int[] q : queries) {
            if (map.get(q[1]).contains(q[0]))
                ans.add(true);
            else
                ans.add(false);
        }
        return ans;
    }
}