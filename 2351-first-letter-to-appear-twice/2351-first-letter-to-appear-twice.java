class Solution {
    public char repeatedCharacter(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            if (map[index]++ == 1)
                return c;
        }
        return 0;
    }
}