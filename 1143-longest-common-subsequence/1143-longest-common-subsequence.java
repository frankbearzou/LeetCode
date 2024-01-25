class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[2][text2.length() + 1];
        for (int i = 0, k = 1; i < text1.length(); i++, k ^= 1) {
            for (int j = 0; j < text2.length(); j++) {
                dp[k][j + 1] = text1.charAt(i) == text2.charAt(j) ? dp[k ^ 1][j] + 1 : Math.max(dp[k][j], dp[k ^ 1][j + 1]);
            }
        }
        return dp[text1.length() % 2][text2.length()];
    }
}