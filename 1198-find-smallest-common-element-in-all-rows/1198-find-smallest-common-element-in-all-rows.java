class Solution {
    public int smallestCommonElement(int[][] mat) {
        for (int col = 0; col < mat[0].length; col++) {
            int k = mat[0][col];
            boolean found = true;
            for (int i = 1; i < mat.length; i++) {
                if (!binarySearch(mat[i], k)) {
                    found = false;
                    break;
                }
            }
            if (found)
                return k;
        }
        return -1;
    }

    boolean binarySearch(int[] arr, int k) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == k)
                return true;
            else if (arr[m] < k)
                l = m + 1;
            else
                r = m - 1;
        }
        return false;
    }
}