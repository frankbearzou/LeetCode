class Solution {
    int m;
    int n;
    int[][] matrix;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        this.m = m;
        this.n = n;
        matrix = new int[m][n];
        for (int[] guard : guards) {
            matrix[guard[0]][guard[1]] = 1;
        }
        for (int[] wall : walls) {
            matrix[wall[0]][wall[1]] = 2;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    for (int[] dir : dirs) {
                        dfs(i, j, dir[0], dir[1]);
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(int row, int col, int dy, int dx) {
        int dr = row + dy;
        int dc = col + dx;
        if (dr < 0 || dr >= m || dc < 0 || dc >= n)
            return;
        if (matrix[dr][dc] == 1 || matrix[dr][dc] == 2)
            return;
        matrix[dr][dc] = 3;
        dfs(dr, dc, dy, dx);
    }
}