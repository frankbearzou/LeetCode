class Solution {
    public String customSortString(String order, String s) {
        StringBuilder res = new StringBuilder();
        int[] map = new int[26];
        for (char c : s.toCharArray())
            map[c - 'a']++;
        for (char c : order.toCharArray()) {
            int index = c - 'a';
            while (map[index]-- > 0) {
                res.append(c);
            }
        }
        for (int i = 0; i < 26; i++) {
            while (map[i]-- > 0) {
                res.append((char)('a' + i));
            }
        }
        return res.toString();
    }
}