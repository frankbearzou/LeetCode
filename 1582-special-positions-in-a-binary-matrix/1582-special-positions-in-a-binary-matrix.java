class Solution {
    public int numSpecial(int[][] mat) {
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && isSpecial(mat, i, j))
                    count++;
            }
        }
        return count;
    }

    boolean isSpecial(int[][] mat, int r, int c) {
        for (int i = 0; i < mat.length; i++) {
            if (i == r)
                continue;
            if (mat[i][c] == 1)
                return false;
        }
        for (int j = 0; j < mat[0].length; j++) {
            if (j == c)
                continue;
            if (mat[r][j] == 1)
                return false;
        }
        return true;
    }
}