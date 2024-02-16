class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int l = 0, r = matrix[0].length - 1, u = 0, d = matrix.length - 1;
        while (l <= r && u <= d) {
            print(matrix, list, l, r, u, d);
            l++;
            r--;
            u++;
            d--;
        }
        return list;
    }

    void print(int[][] matrix, List<Integer> list, int l, int r, int u, int d) {
        if (l == r) {
            for (int i = u; i <= d; i++) {
                list.add(matrix[i][l]);
            }
        } else if (u == d) {
            for (int j = l; j <= r; j++) {
                list.add(matrix[u][j]);
            }
        } else {
            // up
            for (int j = l; j < r; j++) {
                list.add(matrix[u][j]);
            }
            // right
            for (int i = u; i < d; i++) {
                list.add(matrix[i][r]);
            }
            // down
            for (int j = r; j > l; j--) {
                list.add(matrix[d][j]);
            }
            // left
            for (int i = d; i > u; i--) {
                list.add(matrix[i][l]);
            }
        }
    }
}