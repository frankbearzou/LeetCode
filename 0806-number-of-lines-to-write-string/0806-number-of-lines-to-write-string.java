class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int[] res = {1, 0};
        for (char c : s.toCharArray()) {
            int d = widths[c - 'a'];
            if (d + res[1] > 100) {
                res[0]++;
                res[1] = 0;
            }
            res[1] += d;
        }
        return res;
    }
}