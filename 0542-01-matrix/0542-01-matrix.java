class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length, column = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = row * column;
                }
            }
        }
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            for (int[] d : dir) {
                int r = q[0] + d[0], c = q[1] + d[1];
                if (r >= 0 && r < row && c >= 0 && c < column && mat[r][c] > mat[q[0]][q[1]] + 1) {
                    queue.offer(new int[]{r, c});
                    mat[r][c] = mat[q[0]][q[1]] + 1;
                }
            }
        }
        return mat;
    }
}