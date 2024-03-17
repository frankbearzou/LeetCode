class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] map = new int[26];
        for (char c : text.toCharArray()) {
            map[c - 'a']++;
        }
        int min = 10000;
        min = Math.min(min, map[0]); // a
        min = Math.min(min, map[1]); // b
        min = Math.min(min, map[(int)('l' - 'a')] / 2);
        min = Math.min(min, map[(int)('o' - 'a')] / 2);
        min = Math.min(min, map[(int)('n' - 'a')]);
        return min;
    }
}