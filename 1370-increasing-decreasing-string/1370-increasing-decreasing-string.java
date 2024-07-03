class Solution {
    public String sortString(String s) {
        int n = s.length();
        int[] map = new int[26];
        for (char c : s.toCharArray())
            map[c - 'a']++;
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            for (int i = 0, count = 0; i < 26 && count < 3; i++) {
                if (map[i] > 0) {
                    res.append((char)(i + 'a'));
                    count++;
                    map[i]--;
                    n--;
                }
            }
            for (int i = 25, count = 0; i >= 0 && count < 3; i--) {
                if (map[i] > 0) {
                    res.append((char)(i + 'a'));
                    count++;
                    map[i]--;
                    n--;
                }
            }
        }
        return res.toString();
    }
}