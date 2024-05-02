class Solution {
    public boolean isPrefixString(String s, String[] words) {
        int i = 0;
        for (String word : words) {
            if (i == s.length())
                return true;
            if (i + word.length() > s.length())
                return false;
            for (int j = 0; j < word.length(); j++, i++) {
                if (s.charAt(i) != word.charAt(j))
                    return false;
            }
        }
        return i == s.length();
    }
}