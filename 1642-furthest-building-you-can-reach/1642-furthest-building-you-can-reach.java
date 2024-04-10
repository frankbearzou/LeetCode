class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        int count = 0;
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n - 1; i++) {
            int d = heights[i + 1] - heights[i];
            if (d <= 0)
                continue;
            queue.offer(d);
            bricks -= d;
            if (bricks < 0 && ladders == 0)
                return i;
            if (bricks < 0) {
                bricks += queue.poll();
                ladders--;
            }
        }
        return n - 1;
    }
}