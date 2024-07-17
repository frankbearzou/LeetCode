class Solution {
    public String modifyString(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                char pre = i == 0 ? '0' : s.charAt(i - 1);
                char post = i == s.length() - 1 ? '9' : s.charAt(i + 1);
                for (int j = 0; j < 26; j++) {
                    char c = (char)('a' + j);
                    if (c != pre && c != post) {
                        res.append(c);
                        break;
                    }
                }
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}