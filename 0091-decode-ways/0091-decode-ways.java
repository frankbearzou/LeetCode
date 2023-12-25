class Solution {
    public int numDecodings(String s) {
        char[] arr = s.toCharArray();
        int[] dp = new int[arr.length + 1];
        dp[dp.length - 1] = 1;
        dp[dp.length - 2] = arr[arr.length - 1] == '0' ? 0 : 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
                if (arr[i] == '1' || (arr[i] == '2' && arr[i + 1] <= '6')) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }
}