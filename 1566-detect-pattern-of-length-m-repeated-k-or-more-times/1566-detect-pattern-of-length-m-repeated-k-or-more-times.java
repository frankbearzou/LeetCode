class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        for (int i = 0; i < arr.length - m * k + 1; i++) {
            if (valid(arr, i, m, k))
                return true;
        }
        return false;
    }

    boolean valid(int[] arr, int start, int m, int k) {
        for (int kk = 1; kk < k; kk++) {
            for (int i = 0; i < m; i++) {
                if (arr[start + i] != arr[start + i + m * kk])
                    return false;
            }
        }
        return true;
    }
}