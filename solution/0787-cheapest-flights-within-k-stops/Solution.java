class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] graph = new int[n][n];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        for (int[] f : flights)
            graph[f[0]][f[1]] = f[2];
        
        // price, place, available steps: k
        queue.offer(new int[]{0, src, K + 1});
        
        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int price = info[0], place = info[1], k = info[2];
            
            if (place == dst)
                return price;
            
            if (k > 0) {
                for (int i = 0; i < n; i++) {
                    if (graph[place][i] > 0) {
                        queue.offer(new int[]{price + graph[place][i], i, k - 1});
                    }
                }
            }
        }
        
        return -1;
    }
}
