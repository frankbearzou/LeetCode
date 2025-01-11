class Solution {
    public boolean canConstruct(String s, int k) {
        int odd = 0, even = 0;
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        for (int num : map) {
            if (num > 0) {
                if (num % 2 == 0)
                    even++;
                else
                    odd++;
            }
        }
        return k >= odd && k <= s.length();
    }
}