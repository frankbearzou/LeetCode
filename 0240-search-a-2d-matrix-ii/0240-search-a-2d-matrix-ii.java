class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int r = 0, c = col - 1;
        while (r < row && c >= 0) {
            if (target < matrix[r][c]) {
                c--;
            } else if (target > matrix[r][c]) {
                r++;
            } else {
                return true;
            }
        }
        return false;
    }
}