class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        s = s.trim();
        if (s.isEmpty()) return 0;
        int space = s.lastIndexOf(" ");
        if (space == -1) return s.length();
        return s.length() - space - 1;
    }
}
