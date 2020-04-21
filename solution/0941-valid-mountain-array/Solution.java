class Solution {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3)
            return false;
        int hill = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                hill = i;
                break;
            } else if (A[i] == A[i + 1]) {
                return false;
            }
        }
        if (hill == 0)
            return false;
        for (int i = hill + 1; i < A.length - 1; i++) {
            if (A[i] <= A[i + 1])
                return false;
        }
        return true;
    }
}
