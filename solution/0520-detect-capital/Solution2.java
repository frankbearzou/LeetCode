class Solution {
    public boolean detectCapitalUse(String word) {
        char first = word.charAt(0);
        
        // first upper
        if (first >= 'A' && first <= 'Z') {
            if (word.length() == 1)
                return true;
            // second upper
            char second = word.charAt(1);
            if (second >= 'A' && second <= 'Z') {
                for (int i = 2; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    if (ch >= 'a' && ch <= 'z')
                        return false;
                }
                return true;
            } else {
                // second lower
                for (int i = 2; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    if (ch >= 'A' && ch <= 'Z')
                        return false;
                }
                return true;
            }
        } else {
            // first lower
            for (int i = 1; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (ch >= 'A' && ch <= 'Z')
                    return false;
            }
            return true;
        }
        
    }
}
