class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        String ans = "";
        int N = s.length();
        char[] arr = s.toCharArray();
        boolean[][] dp = new boolean[N][N];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i; j < N; j++) {
                if (arr[i] == arr[j]) {
                    if (i == j || i + 1 == j || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if (j - i + 1 > maxLen) {
                            maxLen = j - i + 1;
                            ans = s.substring(i, j + 1);
                        }
                    }
                }
            }
        }
        return ans;
    }
}