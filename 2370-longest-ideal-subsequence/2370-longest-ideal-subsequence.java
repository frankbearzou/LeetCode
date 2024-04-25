class Solution {
    public int longestIdealString(String s, int k) {
        int res = 0;
        int n = s.length();
        int[] dp = new int[26];
        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - 'a';
            dp[i] = dp[i] + 1;
            for (int j = Math.max(0, d - k); j <= Math.min(25, d + k); j++) {
                if (i != j)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}