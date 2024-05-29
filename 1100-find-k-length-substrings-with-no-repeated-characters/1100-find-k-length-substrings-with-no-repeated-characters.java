class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int res = 0;
        int[] map = new int[26];
        int l = 0;
        int n = s.length();
        for (int r = 0; r < n; r++) {
            map[s.charAt(r) - 'a']++;
            if (r - l == k) {
                map[s.charAt(l) - 'a']--;
                l++;
            }
            if (r - l + 1 == k) {
                if (count(map) == k)
                    res++;
            }
        }
        return res;
    }

    int count(int[] map) {
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += map[i] == 1 ? 1 : 0;
        }
        return res;
    }
}