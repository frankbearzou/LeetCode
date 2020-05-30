class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[][] ans = new int[K][2];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));

        for (int i = 0; i < points.length; i++) {
            queue.offer(points[i]);
            if (queue.size() > K)
                queue.poll();
        }

        for (int i = 0; i < K; i++)
            ans[i] = queue.poll();

        return ans;
    }
}
