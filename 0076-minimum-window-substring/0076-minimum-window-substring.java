class Solution {
    public String minWindow(String s, String t) {
        int l = 0, r = 0, minLen = Integer.MAX_VALUE, count = t.length();
        String ans = "";
        int[] map = new int[128];

        for (int c : t.toCharArray()) {
            map[c]++;
        }

        char[] chs = s.toCharArray();
        while (r < chs.length) {
            if (map[chs[r++]]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (r - l < minLen) {
                    minLen = r - l;
                    ans = s.substring(l, r);
                }
                if (map[chs[l++]]++ == 0) {
                    count++;
                }
            }
        }

        return ans;
    }
}