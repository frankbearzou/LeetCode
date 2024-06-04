class Solution {
    public int countServers(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        Set<Integer> resSet = new HashSet<>();
        // row by row
        for (int i = 0; i < row; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1)
                    set.add(i * col + j);
            }
            if (set.size() > 1)
                resSet.addAll(set);
        }
        // column by column
        for (int j = 0; j < col; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < row; i++) {
                if (grid[i][j] == 1)
                    set.add(i * col + j);
            }
            if (set.size() > 1)
                resSet.addAll(set);
        }
        return resSet.size();
    }
}