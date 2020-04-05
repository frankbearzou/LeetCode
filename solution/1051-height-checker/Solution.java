class Solution {
    public int heightChecker(int[] heights) {
        int total = 0;
        int[] oldHeights = new int[heights.length];
        System.arraycopy(heights, 0, oldHeights, 0, heights.length);
        Arrays.sort(heights);
        
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != oldHeights[i])
                ++total;
        }
        
        return total;
    }
}
