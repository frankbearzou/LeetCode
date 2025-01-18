class Solution {
    public int minCost(int[][] grid) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = grid.length;
        int n = grid[0].length;
        int[][] costs = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(costs[i], Integer.MAX_VALUE);
        }
        costs[0][0] = 0;
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.add(new int[]{0, 0, 0});
        while (!queue.isEmpty()) {
            int[] top = queue.remove();
            int r = top[0];
            int c = top[1];
            int cur = top[2];
            if (r == m - 1 && c == n - 1)
                return cur;
            for (int i = 0; i < 4; i++) {
                int dr = r + dirs[i][0];
                int dc = c + dirs[i][1];
                if (dr < 0 || dr >= m || dc < 0 || dc >= n)
                    continue;
                int newCost = ((i + 1 == grid[r][c]) ? 0 : 1);
                if (cur + newCost < costs[dr][dc]) {
                    costs[dr][dc] = cur + newCost;
                    queue.add(new int[]{dr, dc, costs[dr][dc]});
                }
            }
        }
        return -1;
    }
}