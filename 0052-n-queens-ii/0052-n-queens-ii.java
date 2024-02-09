class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        char[][] arr = new char[n][n];
        for (char[] array : arr) {
            Arrays.fill(array, '.');
        }
        backtracking(arr, 0, n);
        return count;
    }

    void backtracking(char[][] arr, int row, int n) {
        if (row == n) {
            count++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isValid(arr, row, j, n)) {
                arr[row][j] = 'Q';
                backtracking(arr, row + 1, n);
                arr[row][j] = '.';
            }
        }
    }

    boolean isValid(char[][] arr, int row, int col, int n) {
        // up, same column
        for (int i = 0; i < row; i++) {
            if (arr[i][col] == 'Q')
                return false;
        }
        // up left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 'Q')
                return false;
        }
        // up right
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (arr[i][j] == 'Q')
                return false;
        }
        return true;
    }
}