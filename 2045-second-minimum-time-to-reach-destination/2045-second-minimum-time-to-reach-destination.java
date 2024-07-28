class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] dist1 = new int[n + 1];
        int[] dist2 = new int[n + 1];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0];
            int curTime = cur[1];
            int actualTime = curTime;
            if ((actualTime / change) % change == 1) {
                actualTime = (actualTime / change + 1) * change;
            }
            actualTime += time;
            for (int neighbor : graph.get(node)) {
                if (actualTime < dist1[neighbor]) {
                    dist2[neighbor] = dist1[neighbor];
                    dist1[neighbor] = actualTime;
                    queue.offer(new int[]{neighbor, actualTime});
                } else if (actualTime >= dist1[neighbor] && actualTime < dist2[neighbor]) {
                    dist2[neighbor] = actualTime;
                    queue.offer(new int[]{neighbor, actualTime});
                }
            }
        }
        return dist2[n];
    }
}