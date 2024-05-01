class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, res = 0;
        int[] map = new int[26];
        for (int r = 0; r < s.length(); r++) {
            map[s.charAt(r) - 'A']++;
            while (r - l + 1 - max(map) > k) {
                map[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    int max(int[] map) {
        int res = 0;
        for (int i : map) {
            res = Math.max(res, i);
        }
        return res;
    }
}