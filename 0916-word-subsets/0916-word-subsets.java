class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        int[] map2 = new int[26];
        for (String word : words2) {
            int[] m = count(word);
            for (int i = 0; i < 26; i++) {
                map2[i] = Math.max(map2[i], m[i]);
            }
        }
        for (String word : words1) {
            int[] map = new int[26];
            for (char c : word.toCharArray()) {
                map[c - 'a']++;
            }
            if (universal(map, map2)) {
                ans.add(word);
            }
        }
        return ans;
    }

    int[] count(String word) {
        int[] map = new int[26];
        for (char c : word.toCharArray())
            map[c - 'a']++;
        return map;
    }

    boolean universal(int[] map, int[] map2) {
        for (int i = 0; i < 26; i++) {
            if (map[i] < map2[i])
                return false;
        }
        return true;
    }
}