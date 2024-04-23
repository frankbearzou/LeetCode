class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        int[] degree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        // init degree and adjacent
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        // find all node with only 1 degree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        while (n > 2) {
            int size = queue.size();
            n -= size;
            while (size-- > 0) {
                int node = queue.poll();
                for (int i : adj.get(node)) {
                    degree[i]--;
                    if (degree[i] == 1) {
                        queue.offer(i);
                    }
                }
            }
        }
        return new ArrayList(queue);
    }
}