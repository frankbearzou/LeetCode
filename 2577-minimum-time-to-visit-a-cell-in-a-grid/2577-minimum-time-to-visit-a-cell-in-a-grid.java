class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1)
            return -1;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.add(new int[]{0, 0, 0});
        while (!queue.isEmpty()) {
            int[] top = queue.remove();
            int time = top[0];
            int row = top[1];
            int col = top[2];
            if (row == m - 1 && col == n - 1)
                return time;
            if (visited[row][col])
                continue;
            visited[row][col] = true;
            for (int[] dir : dirs) {
                int dr = row + dir[0];
                int dc = col + dir[1];
                if (dr < 0 || dr >= m || dc < 0 || dc >= n)
                    continue;
                if (visited[dr][dc])
                    continue;
                int newTime = 0;
                if (time > grid[dr][dc]) {
                    newTime = time + 1;
                } else {
                    int diff = (grid[dr][dc] - time) % 2 == 0 ? 1 : 0;
                    newTime = grid[dr][dc] + diff;
                }
                queue.add(new int[]{newTime, dr, dc});
            }
        }
        return -1;
    }
}