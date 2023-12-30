class Solution {
    public boolean makeEqual(String[] words) {
        int[] map = new int[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                map[c - 'a']++;
            }
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] % words.length != 0)
                return false;
        }
        return true;
    }
}