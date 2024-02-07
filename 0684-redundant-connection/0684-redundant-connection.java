class Solution {
    int[] arr = null;
    public int[] findRedundantConnection(int[][] edges) {
        arr = new int[edges.length + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int[] edge : edges) {
            if (isSame(edge[0], edge[1]))
                return edge;
            union(edge[0], edge[1]);
        }
        return new int[]{0, 0};
    }

    int find(int u) {
        return arr[u] == u ? u : (arr[u] = find(arr[u]));
    }

    void union(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v)
            return;
        arr[v] = u;
    }

    boolean isSame(int u, int v) {
        return find(u) == find(v);
    }
}