class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int ans = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    queue.offer(new int[]{i, j});
            }
        }
        while (!queue.isEmpty()) {
            ans++;
            int size = queue.size();
            while (size-- > 0) {
                int[] poll = queue.poll();
                int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                for (int[] dir : directions) {
                    int r = poll[0] + dir[0], c = poll[1] + dir[1];
                    if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 1)
                        continue;
                    grid[r][c] = 2;
                    queue.offer(new int[]{r, c});
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }
        return ans < 0 ? 0 : ans;
    }
}