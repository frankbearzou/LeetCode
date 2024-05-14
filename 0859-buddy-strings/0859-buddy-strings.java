class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        boolean duplicate = false;
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            if (++map[c - 'a'] > 1)
                duplicate = true;
        }
        for (char c : goal.toCharArray())
            map[c - 'a']--;
        for (int i : map)
            if (i != 0)
                return false;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i))
                count++;
        }
        return count == 2 || (count == 0 && duplicate);
    }
}