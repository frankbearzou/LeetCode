class Solution {
    public int minCut(String s) {
        int N = s.length();
        char[] arr = s.toCharArray();
        boolean[][] palindrome = new boolean[N][N];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i; j < N; j++) {
                if (arr[i] == arr[j]) {
                    if (i == j || i + 1 == j || palindrome[i + 1][j - 1]) {
                        palindrome[i][j] = true;
                    }
                }
            }
        }
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = i;
        }
        for (int i = 1; i < N; i++) {
            if (palindrome[0][i]) {
                dp[i] = 0;
                continue;
            }
            for (int j = 1; j <= i; j++) {
                if (palindrome[j][i]) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[N - 1];
    }
}