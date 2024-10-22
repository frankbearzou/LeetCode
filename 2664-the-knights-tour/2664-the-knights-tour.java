class Solution {
    int[][] board;
    int m;
    int n;
    int[][] dirs = {{1, 2}, {2, 1}, {2, -1}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}};

    public int[][] tourOfKnight(int m, int n, int r, int c) {
        board = new int[m][n];
        this.m = m;
        this.n = n;
        for (int i = 0; i < m; i++)
            Arrays.fill(board[i], -1);
        board[r][c] = 0;
        backtracking(1, r, c);
        return board;
    }

    boolean backtracking(int count, int r, int c) {
        if (count == m * n)
            return true;
        for (int[] dir : dirs) {
            int newr = dir[0] + r;
            int newc = dir[1] + c;
            if (newr < 0 || newr >= m || newc < 0 || newc >= n)
                continue;
            if (board[newr][newc] != -1)
                continue;
            board[newr][newc] = count;
            if (backtracking(count + 1, newr, newc))
                return true;
            board[newr][newc] = -1;
        }
        return false;
    }
}