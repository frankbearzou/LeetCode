class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        // row
        for (int i = 0; i < 9; i++) {
            set.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                if (!set.add(board[i][j]))
                    return false;
            }
        }
        
        // column
        for (int i = 0; i < 9; i++) {
            set.clear();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.')
                    continue;
                if (!set.add(board[j][i]))
                    return false;
            }
        }
        
        // sub box
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                set.clear();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[i+3*r][j+3*c] == '.')
                            continue;
                        if (!set.add(board[i+3*r][j+3*c]))
                            return false;
                    }
                }
            }
        }
        
        return true;
    }
}
