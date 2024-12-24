class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        List<List<Integer>> adj1 = build(n, edges1);
        List<List<Integer>> adj2 = build(m, edges2);
        int d1 = diameter(n, adj1);
        int d2 = diameter(m, adj2);
        return (d1 + 1) / 2 + (d2 + 1) / 2 + 1;
    }

    List<List<Integer>> build(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }

    int diameter(int n, List<List<Integer>> adj) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] degree = new int[n];
        int remain = n;
        int layers = 0;
        for (int i = 0; i < n; i++) {
            degree[i] = adj.get(i).size();
            if (adj.get(i).size() == 1) {
                queue.add(i);
            }
        }
        while (remain > 2) {
            int size = queue.size();
            remain -= size;
            layers++;
            for (int i = 0; i < size; i++) {
                int node = queue.remove();
                for (int nei : adj.get(node)) {
                    degree[nei]--;
                    if (degree[nei] == 1)
                        queue.add(nei);
                }
            }
        }
        if (remain == 2)
            return layers * 2 + 1;
        return layers * 2;
    }
}