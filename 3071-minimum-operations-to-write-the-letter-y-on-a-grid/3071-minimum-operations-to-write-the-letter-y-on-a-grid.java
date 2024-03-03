class Solution {
    public int minimumOperationsToWriteY(int[][] grid) {
        int[] a = new int[3]; // belong
        int[] b = new int[3]; // not belong
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i <= n / 2 && (i == j || i + j == n - 1)) || (i > n / 2 && j == n / 2)) {
                    a[grid[i][j]]++;
                } else {
                    b[grid[i][j]]++;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(a[i]);
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(b[i]);
        }
        int noChange = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    noChange = Math.max(noChange, a[i] + b[j]);
                }
            }
        }
        return n * n - noChange;
    }
}