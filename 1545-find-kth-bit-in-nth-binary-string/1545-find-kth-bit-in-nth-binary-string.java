class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder str = new StringBuilder("0");
        for (int i = 2; i <= n; i++) {
            StringBuilder reverse = new StringBuilder(str);
            reverse.reverse();
            str.append(1);
            for (int j = 0; j < reverse.length(); j++) {
                char c = reverse.charAt(j) == '0' ? '1' : '0';
                str.append(c);
            }
        }
        return str.charAt(k - 1);
    }
}