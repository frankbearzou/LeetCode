class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] prefix = new int[n + 1];
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int dir = shift[2];
            if (dir == 0) {
                prefix[start]--;
                prefix[end + 1]++;
            } else {
                prefix[start]++;
                prefix[end + 1]--;
            }
        }
        for (int i = 1; i < n; i++) {
            prefix[i] += prefix[i - 1];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int shift = prefix[i];
            shift = (shift % 26 + 26) % 26;
            char cur = (char)('a' + (c - 'a' + shift) % 26);
            sb.append(cur);
        }
        return sb.toString();
    }
}