class Solution {
    public boolean isPalindrome(String s) {
        int begin = 0;
        int end = s.length() - 1;
        while (begin < end) {
            while (begin < s.length() && !isLetter(s.charAt(begin))) ++begin;
            if (begin >= end) return true;
            while (!isLetter(s.charAt(end))) --end;
            if (begin >= end) return true;
            if (s.charAt(begin) == s.charAt(end) || 
                    Character.toLowerCase(s.charAt(begin)) == Character.toLowerCase(s.charAt(end))) {
                ++begin; --end;
            } else {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
