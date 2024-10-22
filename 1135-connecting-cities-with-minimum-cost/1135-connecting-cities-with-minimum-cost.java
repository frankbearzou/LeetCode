class Solution {
    int n;
    int[] parent;

    void init() {
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    int find(int u) {
        return (parent[u] == u) ? u : (parent[u] = find(parent[u]));
    }

    boolean isSame(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }

    void union(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v)
            return;
        parent[u] = v;
    }

    public int minimumCost(int n, int[][] connections) {
        int ans = 0;
        int count = 0;
        this.n = n;
        init();
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        for (int[] conn : connections) {
            int u = conn[0];
            int v = conn[1];
            int w = conn[2];
            if (isSame(u, v))
                continue;
            ans += w;
            count++;
            union(u, v);
        }
        if (count != n - 1)
            return -1;
        return ans;
    }
}
