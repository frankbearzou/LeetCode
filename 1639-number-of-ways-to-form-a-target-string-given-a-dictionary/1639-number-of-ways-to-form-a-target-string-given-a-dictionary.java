class Solution {
    int[][] freq;
    String target;
    int[][] dp;
    int mod = (int)1e9 + 7;

    public int numWays(String[] words, String target) {
        int n = words[0].length();
        freq = new int[n][26];
        for (String word : words) {
            for (int i = 0; i < n; i++) {
                freq[i][word.charAt(i) - 'a']++;
            }
        }
        this.target = target;
        dp = new int[n][target.length()];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return (int)dfs(0, 0);
    }

    long dfs(int wordIndex, int targetIndex) {
        if (targetIndex == target.length())
            return 1;
        if (wordIndex == freq.length)
            return 0;
        if (dp[wordIndex][targetIndex] != -1)
            return dp[wordIndex][targetIndex];
        long count = 0;
        // not choose 
        count = dfs(wordIndex + 1, targetIndex);
        count += freq[wordIndex][target.charAt(targetIndex) - 'a'] * dfs(wordIndex + 1, targetIndex + 1);
        count %= mod;
        return dp[wordIndex][targetIndex] = (int)count;
    }
}