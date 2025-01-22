class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = isWater.length;
        int n = isWater[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] top = queue.poll();
                int r = top[0];
                int c = top[1];
                if (visited[r][c])
                    continue;
                isWater[r][c] = level;
                for (int[] dir : dirs) {
                    int dr = r + dir[0];
                    int dc = c + dir[1];
                    if (dr < 0 || dr >= m || dc < 0 || dc >= n)
                        continue;
                    if (visited[dr][dc])
                        continue;
                    queue.add(new int[]{dr, dc});
                }
                visited[r][c] = true;
            }
            level++;
        }
        return isWater;
    }
}