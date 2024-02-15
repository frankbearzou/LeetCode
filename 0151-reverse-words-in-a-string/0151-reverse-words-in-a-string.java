class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        int N = s.length();
        int l = N - 1, r = N - 1;
        while (l >= 0) {
            while (l >= 0 && s.charAt(l) != ' ')
                l--;
            sb.append(' ').append(s.substring(l + 1, r + 1));
            while (l >= 0 && s.charAt(l) == ' ')
                l--;
            r = l;
        }
        return sb.toString().trim();
    }
}