class Solution {
    int count = 0;
    int label = 1;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int largestIsland(int[][] grid) {
        int ans = 0;
        int row = grid.length, col = grid[0].length;
        boolean isAllIsland = true;
        Map<Integer, Integer> islandLabelCount = new HashMap<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    isAllIsland = false;
                }
                if (grid[i][j] == 1) {
                    count = 0;
                    label++;
                    dfs(grid, i, j, label);
                    islandLabelCount.put(label, count);
                }
            }
        }
        if (isAllIsland) {
            return row * col;
        }
        Set<Integer> visited = new HashSet<>();
        int cnt = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != 0)
                    continue;
                cnt = 1;
                visited.clear();
                for (int[] dir : dirs) {
                    int newx = i + dir[0];
                    int newy = j + dir[1];
                    if (newx < 0 || newx >= row || newy < 0 || newy >= col)
                        continue;
                    if (visited.contains(grid[newx][newy]))
                        continue;
                    visited.add(grid[newx][newy]);
                    cnt += islandLabelCount.getOrDefault(grid[newx][newy], 0);
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }

    void dfs(int[][] grid, int r, int c, int label) {
        if (grid[r][c] == 0 || grid[r][c] != 1)
            return;
        grid[r][c] = label;
        count++;
        for (int[] dir : dirs) {
            int newx= r + dir[0];
            int newy = c + dir[1];
            if (newx < 0 || newx >= grid.length || newy < 0 || newy >= grid[0].length)
                continue;
            dfs(grid, newx, newy, label);
        }
    }
}