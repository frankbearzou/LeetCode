class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n - 1; i++) {
            int d = heights[i + 1] - heights[i];
            if (d <= 0)
                continue;
            queue.offer(d);
            if (queue.size() > ladders) {
                bricks -= queue.poll();
            }
            if (bricks < 0)
                return i;
        }
        return n - 1;
    }
}