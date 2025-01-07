class Solution {
    public String maximumNumber(String num, int[] change) {
        StringBuilder str = new StringBuilder(num);
        boolean started = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int d = c - '0';
            if (!started) {
                if (d < change[d]) {
                    started = true;
                    char ch = (char)('0' + change[d]);
                    str.setCharAt(i, ch);
                }
            } else {
                if (d <= change[d]) {
                    started = true;
                    char ch = (char)('0' + change[d]);
                    str.setCharAt(i, ch);
                } else
                    break;
            }
        }
        return str.toString();
    }
}