class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        List<Integer> buffer = new ArrayList<>();
        for (int j = 0; j < matrix[0].length; j++)
            buffer.add(matrix[0][j]);
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (buffer.get(j - 1) != matrix[i][j])
                    return false;
            }
            buffer.remove(buffer.size() - 1);
            buffer.add(0, matrix[i][0]);
        }
        return true;
    }
}