class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int count = 0;
        int a = -1, b = -1;
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (++count > 2)
                    return false;
                if (count == 1) {
                    a = i;
                } else {
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