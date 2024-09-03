class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append((int)(c - 'a' + 1));
        }
        int sum = 0;
        while (k-- > 0) {
            sum = 0;
            for (int i = 0; i < sb.length(); i++) {
                sum += sb.charAt(i) - '0';
            }
            sb = new StringBuilder();
            while (sum > 0) {
                sb.append((int)(sum % 10));
                sum /= 10;
            }
        }
        return Integer.parseInt(sb.reverse().toString());
    }
}