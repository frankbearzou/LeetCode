class Solution {
    public String replaceDigits(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                res.append(s.charAt(i));
            } else {
                res.append(shift(s.charAt(i - 1), s.charAt(i) - '0'));
            }
        }
        return res.toString();
    }

    char shift(char c, int x) {
        return (char)(c + x);
    }
}