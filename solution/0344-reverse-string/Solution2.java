class Solution {
    public void reverseString(char[] s) {
        int begin = 0, end = s.length - 1;
        while (begin < end) {
            char c = s[begin];
            s[begin] = s[end];
            s[end] = c;
            begin++;
            end--;
        }
    }
}
