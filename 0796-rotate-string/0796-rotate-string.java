class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == goal.charAt(0)) {
                if (isSame(s, i, goal))
                    return true;
            }
        }
        return false;
    }

    boolean isSame(String s, int start, String goal) {
        for (int j = 0; j < goal.length(); j++) {
            if (s.charAt(start) != goal.charAt(j))
                return false;
            if (++start == s.length()) {
                start = 0;
            }
        }
        return true;
    }
}