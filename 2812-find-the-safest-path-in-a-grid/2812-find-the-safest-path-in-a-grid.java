class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] matrix = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = grid.get(i).get(j);
                if (matrix[i][j] == 1)
                    queue.offer(new int[]{i, j});
            }
        }
        // set min distance to thief
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int[] dir : dirs) {
                int newr = pos[0] + dir[0];
                int newc = pos[1] + dir[1];
                if (newr < 0 || newr >= n || newc < 0 || newc >= n)
                    continue;
                if (matrix[newr][newc] != 0)
                    continue;
                matrix[newr][newc] = matrix[pos[0]][pos[1]] + 1;
                queue.offer(new int[]{newr, newc});
            }
        }
        
        // first row
        for (int j = 1; j < n; j++) {
            matrix[0][j] = Math.min(matrix[0][j - 1], matrix[0][j]);
        }
        // first col
        for (int i = 1; i < n; i++) {
            matrix[i][0] = Math.min(matrix[i - 1][0], matrix[i][0]);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = Math.min(matrix[i][j], Math.max(matrix[i - 1][j], matrix[i][j - 1]));
            }
        }
        return matrix[n - 1][n - 1] - 1;
    }
}