class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder str = new StringBuilder("0");
        for (int i = 0; i < n; i++) {
            if (k - 1 < str.length()) {
                return str.charAt(k - 1);
            }
            StringBuilder next = new StringBuilder(str);
            next.append("1");
            for (int j = str.length() - 1; j >= 0; j--) {
                char c = str.charAt(j);
                if (c == '0')
                    c = '1';
                else
                    c = '0';
                next.append(c);
            }
            str = next;
        }
        return '0';
    }
}