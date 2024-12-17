class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        int index = 25;
        StringBuilder str = new StringBuilder();
        while (index >= 0) {
            while (index >= 0 && map[index] == 0) {
                index--;
            }
            if (index < 0)
                break;
            int use = Math.min(map[index], repeatLimit);
            for (int i = 0; i < use; i++) {
                str.append((char)('a' + index));
            }
            map[index] -= use;
            if (map[index] == 0)
                continue;
            int next = index - 1;
            while (next >= 0 && map[next] == 0) {
                next--;
            }
            if (next < 0)
                break;
            str.append((char)('a' + next));
            map[next]--;
        }
        return str.toString();
    }
}