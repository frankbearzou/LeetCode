class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        
        int max = heights[0];
        int[] dp = new int[heights.length];
        dp[0] = heights[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = heights[i];
            int lowest = heights[i];
            for (int j = i - 1; j >= 0; j--) {
                lowest = Math.min(lowest, heights[j]);
                dp[i] = Math.max(dp[i], lowest * (i - j + 1));
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
