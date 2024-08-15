class Solution {
    public String makeFancyString(String s) {
        if (s.length() < 3)
            return s;
        StringBuilder res = new StringBuilder();
        res.append(s.substring(0, 2));
        for (int i = 2; i < s.length(); i++) {
            if (res.charAt(res.length() - 1) == res.charAt(res.length() - 2) &&
                res.charAt(res.length() - 1) == s.charAt(i))
                continue;
            res.append(s.charAt(i));
        }
        return res.toString();
    }
}