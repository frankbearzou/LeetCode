class Solution {
    public int countCharacters(String[] words, String chars) {
        int count = 0;
        int[] map = construct(chars);
        for (String word : words) {
            count += compare(construct(word), map);
        }
        return count;
    }

    int[] construct(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray())
            map[c - 'a']++;
        return map;
    }

    int compare(int[] word, int[] map) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (word[i] > map[i])
                return 0;
            else
                count += word[i];
        }
        return count;
    }
}