class Solution {
    public int appendCharacters(String s, String t) {
        int count = 0, l = 0, r = 0;
        while (l < s.length() && r < t.length()) {
            if (s.charAt(l) == t.charAt(r)) {
                l++;
                r++;
            } else {
                l++;
            }
        }
        return t.length() - r;
    }
}