class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length / 2; j++) {
                int t = A[i][j];
                A[i][j] = A[i][A[i].length - 1 - j] == 0 ? 1 : 0;
                A[i][A[i].length - 1 - j] = t == 0 ? 1 : 0;
            }
            if (A[i].length % 2 == 1) {
                A[i][A[i].length / 2] = A[i][A[i].length / 2] == 0 ? 1 : 0;
            }
        }
        return A;
    }
}
