class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> orderRow = topologicalSort(rowConditions, k);
        List<Integer> orderCol = topologicalSort(colConditions, k);
        if (orderRow.size() != k || orderCol.size() != k)
            return new int[0][0];
        int[][] matrix = new int[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (orderRow.get(i) == orderCol.get(j)) {
                    matrix[i][j] = orderRow.get(i);
                }
            }
        }
        return matrix;
    }

    List<Integer> topologicalSort(int[][] edges, int k) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            graph.add(new ArrayList());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= k; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int v = queue.poll();
            order.add(v);
            for (int u : graph.get(v)) {
                inDegree[u]--;
                if (inDegree[u] == 0) {
                    queue.offer(u);
                }
            }
        }
        return order;
    }
}