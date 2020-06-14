class Solution {
    private int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,1},{-1,-1},{1,-1}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        int ans = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == n - 1 && cur[1] == n - 1)
                    return ans;
                for (int[] dir : dirs) {
                    int x = cur[1] + dir[1];
                    int y = cur[0] + dir[0];
                    if (x >= 0 && x < n && y >= 0 && y < n && !visited[y][x] && grid[y][x] == 0) {
                        queue.offer(new int[]{y, x});
                        visited[y][x] = true;
                    }
                }
            }
            ans++;
        }
        
        return -1;
    }
}
