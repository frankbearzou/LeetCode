class Solution {
    public int[] sortedSquares(int[] A) {
        int begin = 0;
        int end = A.length - 1;
        int[] result = new int[A.length];
        int i = A.length - 1;
        while (begin <= end) {
            if (Math.abs(A[begin]) >= Math.abs(A[end])) {
                result[i--] = A[begin] * A[begin];
                ++begin;
            }
            else {
                result[i--] = A[end] * A[end];
                --end;
            }
        }
        return result;
    }
}
