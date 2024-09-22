class Solution {
    public int orangesRotting(int[][] grid) {
        int ans = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    queue.offer(new int[]{i, j});
            }
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int newX = cur[1] + dir[1];
                    int newY = cur[0] + dir[0];
                    if (newY >= 0 && newY < grid.length 
                        && newX >= 0 && newX < grid[0].length
                        && grid[newY][newX] == 1
                       ) {
                        grid[newY][newX] = 2;
                        queue.offer(new int[]{newY, newX});
                    }
                }
            }
            ans++;
        }
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }
        
        return ans - 1;
    }
}