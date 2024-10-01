class Solution {
    String s;
    int n;
    Integer[][] dp;

    public int longestPalindromeSubseq(String s) {
        this.s = s;
        n = s.length();
        dp = new Integer[n][n];
        return dfs(0, n - 1);
    }

    int dfs(int i, int j) {
        if (i > j)
            return 0;
        if (i == j)
            return 1;
        if (dp[i][j] != null)
            return dp[i][j];
        if (s.charAt(i) == s.charAt(j))
            return dp[i][j] = dfs(i + 1, j - 1) + 2;
        else
            return dp[i][j] = Math.max(dfs(i, j - 1), dfs(i + 1, j));
    }
}