class Solution1 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = Integer.toString(x);
        int len = s.length();
        int round = s.length() / 2;
        int i = 0;
        while (i < round) {
            if (s.charAt(i) != s.charAt(len - i - 1)) return false;
            ++i;
        }
        return true;
    }
}
