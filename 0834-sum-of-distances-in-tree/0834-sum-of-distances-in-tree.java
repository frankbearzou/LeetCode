class Solution {
    int[] ans, count;
    List<Set<Integer>> graph = new ArrayList<>();
    int n;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        ans = new int[n];
        count = new int[n];
        Arrays.fill(count, 1);
        for (int i = 0; i < n; i++)
            graph.add(new HashSet<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfs(0, -1, 0);
        reroot(0, -1);
        return ans;
    }

    void dfs(int node, int parent, int depth) {
        ans[0] += depth;
        for (int child : graph.get(node)) {
            if (child != parent) {
                dfs(child, node, depth + 1);
                count[node] += count[child];
            }
        }
    }

    void reroot(int node, int parent) {
        for (int child : graph.get(node)) {
            if (child != parent) {
                ans[child] = ans[node] + n - 2 * count[child];
                reroot(child, node);
            }
        }
    }
}