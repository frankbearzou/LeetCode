class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowMap.put(mat[i][j], i);
                colMap.put(mat[i][j], j);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int row = rowMap.get(arr[i]);
            int col = colMap.get(arr[i]);
            if (++rows[row] == n)
                return i;
            if (++cols[col] == m)
                return i;
        }
        return -1;
    }
}