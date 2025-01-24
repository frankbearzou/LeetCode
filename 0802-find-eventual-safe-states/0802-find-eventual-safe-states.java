class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int n = graph.length;
        int[] outDegree = new int[n];
        for (int i = 0; i < n; i++) {
            outDegree[i] = graph[i].length;
        }
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int dest : graph[i]) {
                adj.get(dest).add(i);
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (outDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int to = queue.poll();
            ans.add(to);
            for (int from : adj.get(to)) {
                outDegree[from]--;
                if (outDegree[from] == 0) {
                    queue.add(from);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}