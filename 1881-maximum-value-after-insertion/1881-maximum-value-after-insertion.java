class Solution {
    public String maxValue(String n, int x) {
        if (n.charAt(0) != '-') {
            for (int i = 0; i < n.length(); i++) {
                if (x > n.charAt(i) - '0') {
                    return n.substring(0, i) + (char)('0' + x) + n.substring(i);
                }
            }
        } else {
            for (int i = 1; i < n.length(); i++) {
                if (x < n.charAt(i) - '0') {
                    return n.substring(0, i) + (char)('0' + x) + n.substring(i);
                }
            }
        }
        return n + (char)('0' + x);
    }
}