class Solution {
    public int longestContinuousSubstring(String s) {
        int max = 1;
        int n = s.length();
        int l = 0;
        for (int r = 1; r < n; r++) {
            if (s.charAt(r) - s.charAt(r - 1) == 1) {
                max = Math.max(max, r - l + 1);
            } else {
                l = r;
            }
        }
        return max;
    }
}