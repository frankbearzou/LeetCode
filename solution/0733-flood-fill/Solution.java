class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor)
            return image;
        BFS(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void BFS(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length || image[sr][sc] != oldColor)
            return;
        image[sr][sc] = newColor;
        BFS(image, sr, sc - 1, oldColor, newColor);
        BFS(image, sr, sc + 1, oldColor, newColor);
        BFS(image, sr - 1, sc, oldColor, newColor);
        BFS(image, sr + 1, sc, oldColor, newColor);
    }
}
