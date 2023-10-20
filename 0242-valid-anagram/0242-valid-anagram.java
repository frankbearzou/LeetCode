class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sMap = new int[26];
        int[] tMap = new int[26];
        for (char c : s.toCharArray()) {
            sMap[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            tMap[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sMap[i] != tMap[i]) {
                return false;
            }
        }
        return true;
    }
}