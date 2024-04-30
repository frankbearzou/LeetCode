class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        // row
        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.')
                    continue;
                if (set.contains(board[i][j]))
                    return false;
                set.add(board[i][j]);
            }
        }
        // column
        for (int j = 0; j < n; j++) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (board[i][j] == '.')
                    continue;
                if (set.contains(board[i][j]))
                    return false;
                set.add(board[i][j]);
            }
        }
        // 3 * 3 area
        for (int i = 0; i < n; i += 3) {
            for (int j = 0; j < n; j += 3) {
                Set<Character> set = new HashSet<>();
                for (int r = i; r < i + 3; r++) {
                    for (int c = j; c < j + 3; c++) {
                        if (board[r][c] == '.')
                            continue;
                        if (set.contains(board[r][c]))
                            return false;
                        set.add(board[r][c]);
                    }
                }
            }
        }
        return true;
    }
}