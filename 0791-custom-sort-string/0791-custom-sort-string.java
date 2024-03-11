class Solution {
    public String customSortString(String order, String s) {
        StringBuilder ans = new StringBuilder();
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        for (char c : order.toCharArray()) {
            while (map[c - 'a'] > 0) {
                ans.append(c);
                map[c - 'a']--;
            }
        }
        for (int i = 0; i < 26; i++) {
            while (map[i] > 0) {
                ans.append((char)('a' + i));
                map[i]--;
            }
        }
        return ans.toString();
    }
}