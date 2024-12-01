class Solution {
    int[] parents;
    int[] rank;

    void init(int n) {
        parents = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            rank[i] = 1;
        }
    }

    int find(int u) {
        return (parents[u] == u) ? u : (parents[u] = find(parents[u]));
    }

    int union(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v)
            return 0;
        if (rank[u] < rank[v])
            parents[u] = v;
        else if (rank[v] < rank[u])
            parents[v] = u;
        else {
            parents[v] = u;
            u++;
        }
        return 1;
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        init(n);
        int count = 0;
        for (int i = 0; i < leftChild.length; i++) {
            if (leftChild[i] != -1) {
                if (union(i, leftChild[i]) == 0)
                    return false;
                else
                    count++;
            }
            if (rightChild[i] != -1) {
                if (union(i, rightChild[i]) == 0)
                    return false;
                else
                    count++;
            }
        }
        return count == n - 1;
    }
}