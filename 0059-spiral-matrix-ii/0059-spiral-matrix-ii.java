class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int left = 0, right = n - 1, up = 0, down = n - 1;
        int count = 1;
        while (left < right) {
            // 1 up, left to right
            for (int i = left; i < right; i++) {
                ans[up][i] = count++;
            }
            // 2 right, up to down
            for (int i = up; i < down; i++) {
                ans[i][right] = count++;
            }
            // 3 down, right to left
            for (int i = right; i > left; i--) {
                ans[down][i] = count++;
            }
            // 4 left, down to up
            for (int i = down; i > up; i--) {
                ans[i][left] = count++;
            }
            left++; right--; up++; down--;
        }
        if ((n & 1) == 1) {
            ans[up][left] = count++;
        }
        return ans;
    }
}