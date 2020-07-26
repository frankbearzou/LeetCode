class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0, row = grid.length, column = grid[0].length, r = 0, c = column - 1;
        while (r < row && c >= 0) {
            if (grid[r][c] >= 0) {
                r++;
            } else {
                count += row - r;
                c--;
            }
        }
        return count;
    }
}
