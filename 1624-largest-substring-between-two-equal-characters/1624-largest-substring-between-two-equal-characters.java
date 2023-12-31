class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int max = -1;
        int[] map = new int[26];
        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            if (map[pos] == -1) {
                map[pos] = i;
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            int pos = s.charAt(i) - 'a';
            if (map[pos] != -1) {
                max = Math.max(max, i - map[pos] - 1);
            }
        }
        return max;
    }
}