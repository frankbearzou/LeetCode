class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);
        int count = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                count += alice.union(edge[1], edge[2]) | bob.union(edge[1], edge[2]);
            }
        }
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                count += alice.union(edge[1], edge[2]);
            } else if (edge[0] == 2) {
                count += bob.union(edge[1], edge[2]);
            }
        }
        if (alice.isConnected() && bob.isConnected()) {
            return edges.length - count;
        }
        return -1;
    }
}

class UnionFind {
    int[] root;
    int component;

    UnionFind(int n) {
        component = n;
        root = new int[n + 1];
        for (int i = 0; i <= n; i++)
            root[i] = i;
    }

    int find(int x) {
        if (x == root[x])
            return x;
        return root[x] = find(root[x]);
    }

    int union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y)
            return 0;
        root[y] = x;
        component--;
        return 1;
    }

    boolean isConnected() {
        return component == 1;
    }
}