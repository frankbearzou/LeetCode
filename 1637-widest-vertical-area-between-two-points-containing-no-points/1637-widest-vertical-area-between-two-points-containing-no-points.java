class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int ans = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int[] point : points) {
            queue.offer(point[0]);
        }
        int first = queue.poll();
        while (!queue.isEmpty()) {
            int second = queue.poll();
            ans = Math.max(ans, second - first);
            first = second;
        }
        return ans;
    }
}