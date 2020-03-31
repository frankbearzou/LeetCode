class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[]{};
        int row = matrix.length;
        int column = matrix[0].length;
        int[] result = new int[row * column];
        List<Integer> list = new ArrayList<>();
        int k = 0;
        
        for (int i = 0; i < row + column - 1; i++) {
            list.clear();
            int r = i < column ? 0 : i - column + 1;
            int c = i < column ? i : column - 1;
            while (r < row && c >= 0) {
                list.add(matrix[r][c]);
                r++;
                c--;
            }
            if (i % 2 == 0)
                Collections.reverse(list);
            for (int val : list)
                result[k++] = val;
        }
        
        return result;
    }
}
