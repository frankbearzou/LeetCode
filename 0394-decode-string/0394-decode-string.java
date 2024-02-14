class Solution {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int k = 0;
        Stack<Integer> times = new Stack<>();
        Stack<String> encoded = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                times.push(k);
                k = 0;
                encoded.push(res.toString());
                res = new StringBuilder();
            } else if (c == ']') {
                int i = times.pop();
                StringBuilder sb = new StringBuilder(encoded.pop());
                while (i-- > 0) {
                    sb.append(res);
                }
                res = sb;
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}