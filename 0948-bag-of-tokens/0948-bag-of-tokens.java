class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int ans = 0;
        int score = 0;
        Arrays.sort(tokens);
        int n = tokens.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            if (tokens[l] <= power) {
                power -= tokens[l++];
                score++;
                ans = Math.max(ans, score);
            } else if (score > 0) {
                power += tokens[r--];
                score--;
            } else
                break;
        }
        return ans;
    }
}