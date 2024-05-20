class Solution {
    public int numRookCaptures(char[][] board) {
        int res = 0;
        int r = -1, c = -1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    r = i;
                    c = j;
                }
            }
        }
        // up
        for (int i = r - 1; i >= 0; i--) {
            if (board[i][c] == 'p') {
                res++;
                break;
            } else if (board[i][c] == 'B')
                break;
        }
        // down
        for (int i = r + 1; i < 8; i++) {
            if (board[i][c] == 'p') {
                res++;
                break;
            } else if (board[i][c] == 'B')
                break;
        }
        // left
        for (int j = c - 1; j >= 0; j--) {
            if (board[r][j] == 'p') {
                res++;
                break;
            } else if (board[r][j] == 'B')
                break;
        }
        // right
        for (int j = c + 1; j < 8; j++) {
            if (board[r][j] == 'p') {
                res++;
                break;
            } else if (board[r][j] == 'B')
                break;
        }
        return res;
    }
}