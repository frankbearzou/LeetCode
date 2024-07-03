class Solution {
    public int minSteps(String s, String t) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            map[c - 'a']--;
        }
        int count = 0;
        for (int i : map) {
            if (i > 0)
                count += i;
        }
        return count;
    }
}