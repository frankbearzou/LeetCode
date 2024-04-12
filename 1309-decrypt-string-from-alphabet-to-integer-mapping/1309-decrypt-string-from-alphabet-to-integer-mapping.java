class Solution {
    public String freqAlphabets(String s) {
        StringBuilder res = new StringBuilder();
        int i = 0, n = s.length();
        while (i < n) {
            if (i + 2 < n && s.charAt(i + 2) == '#') {
                char c = (char)('a' + (Integer.parseInt(s.substring(i, i + 2)) - 1));
                res.append(c);
                i += 3;
            } else {
                char c = (char)('a' + (s.charAt(i) - '1'));
                res.append(c);
                i++;
            }
        }
        return res.toString();
    }
}