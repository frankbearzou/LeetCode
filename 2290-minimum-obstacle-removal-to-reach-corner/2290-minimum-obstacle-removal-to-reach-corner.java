class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] cost = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        cost[0][0] = 0;
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.add(new int[]{0, 0, 0});
        while (!queue.isEmpty()) {
            int[] top = queue.remove();
            int row = top[0];
            int col = top[1];
            int c = top[2];
            if (row == m - 1 && col == n - 1)
                return c;
            for (int[] dir : dirs) {
                int dr = row + dir[0];
                int dc = col + dir[1];
                if (dr < 0 || dr >= m || dc < 0 || dc >= n)
                    continue;
                int newcost = c + grid[dr][dc];
                if (newcost < cost[dr][dc]) {
                    cost[dr][dc] = newcost;
                    queue.add(new int[]{dr, dc, newcost});
                }
            }
        }
        return 0;
    }
}