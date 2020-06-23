class Solution {
    public int titleToNumber(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int d = (c - 'A' + 1) * (int)Math.pow(26, s.length() - i - 1);
            ans += d;
        }
        return ans;
    }
}
