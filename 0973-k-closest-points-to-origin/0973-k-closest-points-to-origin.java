class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1]);
        for (int[] p : points) {
            queue.offer(p);
            if (queue.size() > k)
                queue.poll();
        }
        int[][] res = new int[queue.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}