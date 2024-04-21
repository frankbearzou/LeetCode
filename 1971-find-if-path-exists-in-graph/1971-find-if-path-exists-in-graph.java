class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        for (int[] edge : edges) {
            union(parent, edge);
        }
        return isSame(parent, source, destination);
    }

    int find(int[] parent, int i) {
        return parent[i] == i ? i : find(parent, parent[i]);
    }

    void union(int[] parent, int[] edge) {
        int u = find(parent, edge[0]);
        int v = find(parent, edge[1]);
        parent[u] = v;
    }

    boolean isSame(int[] parent, int u, int v) {
        return find(parent, u) == find(parent, v);
    }
}