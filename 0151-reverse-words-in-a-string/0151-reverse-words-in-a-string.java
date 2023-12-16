class Solution {
    public String reverseWords(String s) {
        int l = 0, r = s.length() - 1;
        // l start
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(l) == ' ')
                l++;
            else
                break;
        }
        // r end
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ')
                r--;
            else
                break;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = l; i <= r; i++) {
            char c = s.charAt(i);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
        }
        l = 0; r = sb.length() - 1;
        // reverse whole string
        while (l < r) {
            char c = sb.charAt(l);
            sb.setCharAt(l, sb.charAt(r));
            sb.setCharAt(r, c);
            l++; r--;
        }
        // reverse word
        int start = 0, end = start + 1;
        while (end < sb.length()) {
            while (end < sb.length() && sb.charAt(end) != ' ')
                end++;
            l = start; r = end - 1;
            while (l < r) {
                char c = sb.charAt(l);
                sb.setCharAt(l, sb.charAt(r));
                sb.setCharAt(r, c);
                l++; r--;
            }
            start = end + 1;
            end = start + 1;
        }
        return sb.toString();
    }
}