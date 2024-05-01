class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            char a = s.charAt(l);
            while (l < r && !((a >= 'a' && a <= 'z') || (a >= '0' && a <= '9'))) {
                l++;
                a = s.charAt(l);
            }
            char b = s.charAt(r);
            while (l < r && !((b >= 'a' && b <= 'z') || (b >= '0' && b <= '9'))) {
                r--;
                b = s.charAt(r);
            }
            if (a != b)
                return false;
            l++;
            r--;
        }
        return true;
    }
}