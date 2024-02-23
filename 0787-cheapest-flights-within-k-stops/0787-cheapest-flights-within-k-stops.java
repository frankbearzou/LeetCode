class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] flight : flights) {
            map.putIfAbsent(flight[0], new ArrayList());
            map.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});
        int step = 0;
        while (!queue.isEmpty() && step <= k) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                if (!map.containsKey(cur[0]))
                    continue;
                for (int[] next : map.get(cur[0])) {
                    if (cur[1] + next[1] > cost[next[0]])
                        continue;
                    cost[next[0]] = cur[1] + next[1];
                    queue.offer(new int[]{next[0], cur[1] + next[1]});
                }
            }
            step++;
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}