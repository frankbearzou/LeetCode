class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        dp[0] = 1;
        int mod = (int)1e9 + 7;
        int ans = 0;
        for (int i = 1; i <= high; i++) {
            if (i - zero >= 0)
                dp[i] = (dp[i] + dp[i - zero]) % mod;
            if (i - one >= 0)
                dp[i] = (dp[i] + dp[i - one]) % mod;
            if (ans >= low)
                ans = (ans + dp[i]) % mod;
        }
        return ans;
    }
}