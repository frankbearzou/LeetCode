class Solution {
    public String minWindow(String s, String t) {
        int len = Integer.MAX_VALUE;
        String res = "";
        int[] map = new int[128];
        for (char c : t.toCharArray())
            map[c]++;
        int count = t.length();
        int l = 0, n = s.length();
        char[] arr = s.toCharArray();
        for (int r = 0; r < n; r++) {
            if (map[arr[r]]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    res = s.substring(l, r + 1);
                }
                if (map[arr[l]] == 0)
                    count++;
                map[arr[l++]]++;
            }
        }
        return res;
    }
}