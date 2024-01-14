class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        Map<Integer, Integer> map = new HashMap<>();
        for (char c : word1.toCharArray()) {
            map1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            map2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (map1[i] > 0) {
                if (map2[i] == 0)
                    return false;
                map.put(map1[i], map.getOrDefault(map1[i], 0) + 1);
            }
            if (map2[i] > 0) {
                if (map1[i] == 0)
                    return false;
                map.put(map2[i], map.getOrDefault(map2[i], 0) - 1);
            }
        }
        for (int val : map.values()) {
            if (val != 0)
                return false;
        }
        return true;
    }
}