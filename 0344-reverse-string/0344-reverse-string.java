class Solution {
    public void reverseString(char[] s) {
        reverse(s, 0, s.length - 1);
    }

    void reverse(char[] s, int l, int r) {
        if (l >= r)
            return;
        char t = s[l];
        s[l] = s[r];
        s[r] = t;
        reverse(s, l + 1, r - 1);
    }
}