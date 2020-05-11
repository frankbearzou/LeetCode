class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor)
            fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void fill(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if (sr < 0 || sc > image.length || image[sr][sc] != oldColor)
            return;
        image[sr][sc] = newColor;
        if (sr > 0)
            fill(image, sr - 1, sc, oldColor, newColor);
        if (sr < image.length - 1)
            fill(image, sr + 1, sc, oldColor, newColor);
        if (sc > 0)
            fill(image, sr, sc - 1, oldColor, newColor);
        if (sc < image[0].length - 1)
            fill(image, sr, sc + 1, oldColor, newColor);
    }
}
