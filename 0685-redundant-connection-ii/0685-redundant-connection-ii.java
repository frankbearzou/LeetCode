class Solution {
    int[] parents = null;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        List<Integer> dup = new ArrayList<>();
        int[] inDegree = new int[edges.length + 1];
        for (int[] edge : edges) {
            inDegree[edge[1]]++;
        }
        for (int i = edges.length - 1; i >= 0; i--) {
            if (inDegree[edges[i][1]] == 2) {
                dup.add(i);
            }
        }
        if (!dup.isEmpty()) {
            if (isTree(edges, dup.get(0))) {
                return edges[dup.get(0)];
            } else {
                return edges[dup.get(1)];
            }
        }

        // union find
        parents = new int[edges.length + 1];
        for (int i = 1; i < parents.length; i++) {
            parents[i] = i;
        }
        for (int[] edge : edges) {
            if (isSame(edge[0], edge[1]))
                return edge;
            union(edge[0], edge[1]);
        }
        return new int[]{0, 0};
    }

    boolean isTree(int[][] edges, int deleteEdge) {
        parents = new int[edges.length + 1];
        for (int i = 1; i < parents.length; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            if (i == deleteEdge)
                continue;
            if (isSame(edges[i][0], edges[i][1]))
                return false;
            union(edges[i][0], edges[i][1]);
        }
        return true;
    }

    int find(int u) {
        return u == parents[u] ? u : (parents[u] = find(parents[u]));
    }

    void union(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v)
            return;
        parents[v] = u;
    }

    boolean isSame(int u, int v) {
        return find(u) == find(v);
    }
}