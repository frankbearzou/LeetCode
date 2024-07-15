class Solution {
    public int numSub(String s) {
        int count = 0;
        int mod = 1_000_000_007;
        int l = -1;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (c == '0') {
                l = r;
            } else {
                count = (count + r - l) % mod;
            }
        }
        return count;
    }
}