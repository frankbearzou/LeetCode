class Solution {
    public int minimumLength(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        int count = 0;
        for (int m : map) {
            if (m < 3) {
                count += m;
            } else {
                count += ((m % 2) == 0) ? 2 : 1;
            }
        }
        return count;
    }
}