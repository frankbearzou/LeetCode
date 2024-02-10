class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int N = s.length();
        char[] arr = s.toCharArray();
        boolean[][] dp = new boolean[N][N];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i; j < N; j++) {
                if (arr[i] == arr[j]) {
                    if (i == j || i + 1 == j) {
                        dp[i][j] = true;
                        count++;
                    } else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}