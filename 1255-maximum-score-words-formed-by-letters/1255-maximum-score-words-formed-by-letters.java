class Solution {
    int max = 0;
    int[] letterMap = new int[26];

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        for (char c : letters) {
            letterMap[c - 'a']++;
        }
        int[] map = new int[26];
        backtracking(words, map, score, 0, 0);
        return max;
    }

    void backtracking(String[] words, int[] map, int[] score, int start, int total) {
        if (start >= words.length) {
            max = Math.max(max, total);
            return;
        }
        // not add current word
        backtracking(words, map, score, start + 1, total);
        // add current word
        for (char c : words[start].toCharArray())  {
            map[c - 'a']++;
            total += score[c - 'a'];
        }
        if (isValidMap(map)) {
            backtracking(words, map, score, start + 1, total);
        }
        for (char c : words[start].toCharArray()) {
            map[c - 'a']--;
            total -= score[c - 'a'];
        }
    }

    boolean isValidMap(int[] map) {
        for (int i = 0; i < map.length; i++) {
            if (map[i] > letterMap[i])
                return false;
        }
        return true;
    }
}