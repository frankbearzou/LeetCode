class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int row = image.length, col = image[0].length;
        for (int i = 0; i < row; i++) {
            int l = 0, r = col - 1;
            while (l <= r) {
                if (image[i][l] == image[i][r]) {
                    if (image[i][l] == 1) {
                        image[i][l] = image[i][r] = 0;
                    } else {
                        image[i][l] = image[i][r] = 1;
                    }
                }
                l++;
                r--;
            }
        }
        return image;
    }
}