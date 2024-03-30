class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int row = 0, count = 0;
        for (int i = 0; i < mat.length; i++) {
            int cnt = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1)
                    cnt++;
            }
            if (cnt > count) {
                row = i;
                count = cnt;
            }
        }
        return new int[]{row, count};
    }
}