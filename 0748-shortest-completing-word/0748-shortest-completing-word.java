class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String res = "";
        int len = 1001;
        int[] map = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (c >= 'a' && c <= 'z')
                map[c - 'a']++;
            else if (c >= 'A' && c <= 'Z')
                map[c - 'A']++;
        }
        for (String word : words) {
            if (contains(map, word)) {
                if (word.length() < len) {
                    len = word.length();
                    res = word;
                }
            }
        }
        return res;
    }

    boolean contains(int[] map, String word) {
        int[] arr = new int[26];
        for (char c : word.toCharArray())
            arr[c - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (map[i] > arr[i])
                return false;
        }
        return true;
    }
}