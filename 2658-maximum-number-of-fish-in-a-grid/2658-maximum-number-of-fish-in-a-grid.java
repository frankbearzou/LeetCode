class Solution {
    public int findMaxFish(int[][] grid) {
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    continue;
                int sub = 0;
                queue.add(new int[]{i, j});
                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    int r = cur[0];
                    int c = cur[1];
                    sub += grid[r][c];
                    max = Math.max(max, sub);
                    grid[r][c] = 0;
                    for (int[] dir : dirs) {
                        int dr = r + dir[0];
                        int dc = c + dir[1];
                        if (dr < 0 || dr >= m || dc < 0 || dc >= n)
                            continue;
                        if (grid[dr][dc] == 0)
                            continue;
                        queue.add(new int[]{dr, dc});
                    }
                }
            }
        }
        return max;
    }
}