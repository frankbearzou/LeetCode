class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map.putIfAbsent(i - j, new PriorityQueue<Integer>());
                map.get(i - j).offer(mat[i][j]);
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] = map.get(i - j).poll();
            }
        }
        
        return mat;
    }
}
