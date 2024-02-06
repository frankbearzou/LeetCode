class Solution {
    int[] arr;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        for (int[] edge : edges) {
            join(edge[0], edge[1]);
        }
        return isSame(source, destination);
    }

    int find(int u) {
        return u == arr[u] ? u : (arr[u] = find(arr[u]));
    }

    void join(int u, int v) {
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