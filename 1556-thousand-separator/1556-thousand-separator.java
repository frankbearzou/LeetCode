class Solution {
    public String thousandSeparator(int n) {
        String s = String.valueOf(n);
        int len = s.length();
        if (len <= 3)
            return s;
        StringBuilder res = new StringBuilder();
        for (int i = len - 1; i >= 0; i -= 3) {
            if (i >= 0)
                res.insert(0, s.charAt(i));
            if (i - 1 >= 0)
                res.insert(0, s.charAt(i - 1));
            if (i - 2 >= 0) {
                res.insert(0, s.charAt(i - 2));
                res.insert(0, ".");
            }
        }
        if (res.charAt(0) == '.')
            return res.substring(1).toString();
        return res.toString();
    }
}