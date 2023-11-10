class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new ArrayList<>();
        int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length -1;
        List<Integer> result = new ArrayList<>();
        while (left <= right && up <= down) {
            //up
            for (int i = left; i <= right; i++)
                result.add(matrix[up][i]);
            up++;
            //right
            for (int i = up; i <= down; i++)
                result.add(matrix[i][right]);
            right--;
            //down
            if (up <= down) {
                for (int i = right; i >= left; i--)
                    result.add(matrix[down][i]);
                down--;
            }
            //left
            if (left <= right) {
                for (int i = down; i >= up; i--)
                    result.add(matrix[i][left]);
                left++;
            }
        }
        return result;
    }
}