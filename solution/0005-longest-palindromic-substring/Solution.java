class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0)
            return "";
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i + 1 > ans.length()) {
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }
        
        return "".equals(ans) ? s.substring(0, 1) : ans;
    }
}
