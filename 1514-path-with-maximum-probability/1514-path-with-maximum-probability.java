class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair<Integer, Double>>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double c = succProb[i];
            graph.get(u).add(new Pair(v, c));
            graph.get(v).add(new Pair(u, c));
        }
        double[] cost = new double[n];
        cost[start_node] = 1;
        boolean[] visited = new boolean[n];
        PriorityQueue<Pair<Integer, Double>> queue = new PriorityQueue<>((a, b) -> Double.compare(b.getValue(), a.getValue()));
        queue.add(new Pair(start_node, 1.0));
        while (!queue.isEmpty()) {
            Pair<Integer, Double> top = queue.remove();
            int cur = top.getKey();
            double c = top.getValue();

            if (cur == end_node)
                return cost[end_node];

            visited[cur] = true;
            for (Pair<Integer, Double> vec : graph.get(cur)) {
                int to = vec.getKey();
                double toCost = vec.getValue();
                if (visited[to])
                    continue;
                if (c * toCost > cost[to]) {
                    cost[to] = c * toCost;
                    queue.add(new Pair(to, cost[to]));
                }
            }
        }
        return cost[end_node];
    }
}