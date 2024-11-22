class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        for (int[] row : matrix) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < matrix[0].length; i++) {
                if (row[0] == row[i]) {
                    str.append("1");
                } else {
                    str.append("0");
                }
            }
            String key = str.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int max = 0;
        for (int value : map.values()) {
            max = Math.max(max, value);
        }
        return max;
    }
}