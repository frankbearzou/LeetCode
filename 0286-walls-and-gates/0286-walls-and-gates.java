class Solution {
    public void wallsAndGates(int[][] rooms) {
        int row = rooms.length, col = rooms[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) {
                    boolean[][] visited = new boolean[row][col];
                    dfs(rooms, i, j, 0, visited);
                }
            }
        }
    }
    
    void dfs(int[][] rooms, int i, int j, int step, boolean[][] visited) {
        int row = rooms.length, col = rooms[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col)
            return;
        if (visited[i][j])
            return;
        if (rooms[i][j] < 0)
            return;
        rooms[i][j] = Math.min(rooms[i][j], step);
        visited[i][j] = true;
        dfs(rooms, i + 1, j, step + 1, visited);
        dfs(rooms, i - 1, j, step + 1, visited);
        dfs(rooms, i, j + 1, step + 1, visited);
        dfs(rooms, i, j - 1, step + 1, visited);
        visited[i][j] = false;
    }
}