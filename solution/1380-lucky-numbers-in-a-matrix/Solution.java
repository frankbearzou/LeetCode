class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        // find min index in rows
        for (int i = 0; i < matrix.length; i++) {
            int min = matrix[i][0];
            int index = i * matrix[0].length;
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    index = i * matrix[0].length + j;
                }
            }
            set.add(index);
        }
        
        // find max index in columns
        for (int j = 0; j < matrix[0].length; j++) {
            int max = matrix[0][j];
            int index = j;
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    index = i * matrix[0].length + j;
                }
            }
            if (set.contains(index))
                ans.add(max);
        }
        
        return ans;
    }
}
