class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        if (s1.length() != s2.length())
            return false;
        int a = -1, b = -1, count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 2)
                    return false;
                if (count == 1) {
                    a = i;
                } else if (count == 2) {
                    b = i;
                }
            }
        }
        if (count == 0)
            return true;
        if (count == 1)
            return false;
        return s1.charAt(a) == s2.charAt(b) && s1.charAt(b) == s2.charAt(a);
    }
}