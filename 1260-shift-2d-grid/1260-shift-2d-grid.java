class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] matrix = new int[m][n];
        k = k % (m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[(i + k / m + (j + k % n) / n) % m][(j + (k % n)) % n] = grid[i][j];
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(matrix[i][j]);
            }
            res.add(list);
        }
        return res;
    }
}