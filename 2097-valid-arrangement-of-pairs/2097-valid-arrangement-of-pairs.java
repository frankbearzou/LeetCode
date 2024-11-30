class Solution {
    Map<Integer, Deque<Integer>> adj = new HashMap<>();
    List<Integer> res = new ArrayList<>();

    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();
        for (int[] pair : pairs) {
            int start = pair[0];
            int end = pair[1];
            adj.computeIfAbsent(start, k -> new ArrayDeque<>()).add(end);
            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
        }
        int start = -1;
        for (int node : outDegree.keySet()) {
            if (outDegree.get(node) == inDegree.getOrDefault(node, 0) + 1) {
                start = node;
                break;
            }
        }
        if (start == -1)
            start = pairs[0][0];
        dfs(start);
        Collections.reverse(res);
        int[][] ans = new int[res.size() - 1][2];
        for (int i = 1; i < res.size(); i++) {
            ans[i - 1] = new int[]{res.get(i - 1), res.get(i)};
        }
        return ans;
    }

    void dfs(int start) {
        Deque<Integer> nei = adj.get(start);
        while (nei != null && !nei.isEmpty()) {
            int node = nei.remove();
            dfs(node);
        }
        res.add(start);
    }
}