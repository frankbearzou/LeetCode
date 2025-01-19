class Solution {
    public int trapRainWater(int[][] heightMap) {
        int ans = 0;
        int m = heightMap.length;
        int n = heightMap[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[m][n];
        // first and last row
        for (int j = 0; j < n; j++) {
            queue.add(new int[]{0, j, heightMap[0][j]});
            queue.add(new int[]{m - 1, j, heightMap[m - 1][j]});
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }
        // first and last column
        for (int i = 1; i < m - 1; i++) {
            queue.add(new int[]{i, 0, heightMap[i][0]});
            queue.add(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        while (!queue.isEmpty()) {
            int[] top = queue.remove();
            int r = top[0];
            int c = top[1];
            int h = top[2];
            for (int[] dir : dirs) {
                int dr = r + dir[0];
                int dc = c + dir[1];
                if (dr < 0 || dr >= m || dc < 0 || dc >= n)
                    continue;
                if (visited[dr][dc])
                    continue;
                visited[dr][dc] = true;
                if (heightMap[dr][dc] < h) {
                    ans += h - heightMap[dr][dc];
                    queue.add(new int[]{dr, dc, h});
                } else {
                    queue.add(new int[]{dr, dc, heightMap[dr][dc]});
                }
            }
        }
        return ans;
    }
}