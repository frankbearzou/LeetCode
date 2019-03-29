class Solution {
    public int[] sortArrayByParity(int[] A) {
        int begin = 0;
        int end = A.length - 1;
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0)
                result[begin++] = A[i];
            else
                result[end--] = A[i];
        }
        return result;
    }
}
