class Solution {
    public int lengthOfLongestSubstring(String s) {
        // if dp[j - 1] < j - i: dp[j] = dp[j - 1] + 1
        // if dp[j - 1] >= j - i: dp[j] = j - i
        int ans = 1;
        int N = s.length();
        if (N == 0)
            return 0;
        int[] dp = new int[N];
        dp[0] = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        for (int j = 1; j < N; j++) {
            int i = map.getOrDefault(s.charAt(j), -1);
            map.put(s.charAt(j), j);
            if (dp[j - 1] < j - i) {
                dp[j] = dp[j - 1] + 1;
            } else {
                dp[j] = j - i;
            }
            ans = Math.max(ans, dp[j]);
        }
        return ans;
    }
}