class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int res = 1;
        int pre = 0, cur = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                pre = cur;
                cur = i;
            }
            res = Math.max(res, i - pre + 1);
        }
        return res;
    }
}