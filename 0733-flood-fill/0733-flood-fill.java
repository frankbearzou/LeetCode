class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        boolean[][] visited = new boolean[image.length][image[0].length];
        BFS(image, sr, sc, visited, image[sr][sc], color);
        return image;
    }

    private void BFS(int[][] image, int sr, int sc, boolean[][] visited, int oldColor, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return;
        }
        if (visited[sr][sc]) {
            return;
        }
        visited[sr][sc] = true;
        if (image[sr][sc] == oldColor) {
            image[sr][sc] = newColor;
        } else {
            return;
        }
        int[][] dir = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < dir.length; i++) {
            int row = sr + dir[i][0];
            int column = sc + dir[i][1];
            BFS(image, row, column, visited, oldColor, newColor);
        }
    }
}