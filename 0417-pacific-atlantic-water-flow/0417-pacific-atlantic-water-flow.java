class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int r = heights.length;
        int c = heights[0].length;
        boolean[][] pacific = new boolean[r][c];
        boolean[][] atlantic = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            dfs(heights, i, 0, pacific);
            dfs(heights, i, c - 1, atlantic);
        }
        for (int j = 0; j < c; j++) {
            dfs(heights, 0, j, pacific);
            dfs(heights, r - 1, j, atlantic);
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(List.of(i, j));
                }
            }
        }
        return ans;
    }

    void dfs(int[][] heights, int row, int col, boolean[][] visited) {
        int r = heights.length;
        int c = heights[0].length;
        visited[row][col] = true;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : dirs) {
            int newx = row + dir[0];
            int newy = col + dir[1];
            if (newx < 0 || newx >= r || newy < 0 || newy >= c)
                continue;
            if (visited[newx][newy])
                continue;
            if (heights[newx][newy] >= heights[row][col]) {
                dfs(heights, newx, newy, visited);
            }
        }
    }
}