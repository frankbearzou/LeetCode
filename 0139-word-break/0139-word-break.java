class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < dp.length; i++) {
            for (String word : wordDict) {
                if (i >= word.length()) {
                    int start = i - word.length();
                    if (dp[start]) {
                        if (s.substring(start, start + word.length()).equals(word)) {
                            dp[i] = true;
                        }
                    }
                }
            }
        }
        return dp[s.length()];
    }
}