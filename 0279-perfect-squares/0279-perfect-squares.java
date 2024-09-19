class Solution {
    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            list.add(i * i);
        }
        int m = list.size();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++)
                dp[i][j] = n + 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int num = list.get(i - 1);
                if (j - num < 0)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - num] + 1);
            }
        }
        return dp[m][n];
    }
}