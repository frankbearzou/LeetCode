class Solution {
    List<List<Integer>> adj = new ArrayList<>();
    int[] parents;
    int[] rank;
    int n;

    public int magnificentSets(int n, int[][] edges) {
        parents = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }
        this.n = n;
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            union(u, v);
        }
        
        int[] rootToCount = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int groups = getNumberOfGroup(i);
            if (groups == -1)
                return -1;
            int root = find(i);
            rootToCount[root] = Math.max(rootToCount[root], groups);
        }
        int ans = 0;
        for (int count : rootToCount) {
            ans += count;
        }
        return ans;
    }

    int find(int u) {
        return (parents[u] == u) ? u : (parents[u] = find(parents[u]));
    }

    void union(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v)
            return;
        if (rank[u] == rank[v]) {
            parents[v] = u;
            rank[u]++;
        } else if (rank[u] > rank[v]) {
            parents[v] = u;
        } else {
            parents[u] = v;
        }
    }

    int getNumberOfGroup(int u) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(u);
        int[] groups = new int[n + 1];
        Arrays.fill(groups, -1);
        int curGroup = 0;
        groups[u] = curGroup;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int nei : adj.get(cur)) {
                    if (groups[nei] == -1) {
                        groups[nei] = curGroup + 1;
                        queue.add(nei);
                    } else {
                        if (groups[nei] == curGroup)
                            return -1;
                    }
                }
            }
            curGroup++;
        }
        return curGroup;
    }
}