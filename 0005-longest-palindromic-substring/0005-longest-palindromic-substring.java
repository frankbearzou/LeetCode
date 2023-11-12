class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 2; j++) {
                int l = i, r = i + j;
                while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                    if (r - l + 1 > len) {
                        len = r - l + 1;
                        ans = s.substring(l, r + 1);
                    }
                    l--;
                    r++;
                }
            }
        }
        return ans;
    }
}