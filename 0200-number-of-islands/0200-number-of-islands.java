class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    ans++;
                    bfs(grid, i, j, visited);
                }
            }
        }
        return ans;
    }

    void bfs(char[][] grid, int row, int col, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int[] dir : dirs) {
                int newx = poll[0] + dir[0];
                int newy = poll[1] + dir[1];
                if (newx < 0 || newx >= grid.length || newy < 0 || newy >= grid[0].length)
                    continue;
                if (!visited[newx][newy] && grid[newx][newy] == '1') {
                    queue.offer(new int[]{newx, newy});
                    visited[newx][newy] = true;
                }
            }
        }
    }
}