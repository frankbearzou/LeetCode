class Solution {
    public int longestPalindrome(String s) {
        int ans = 0;
        int[] map = new int[128];
        int one = 0;
        for (char c : s.toCharArray()) {
            map[(int)c]++;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] % 2 == 0) {
                ans += map[i];
            } else {
                ans += map[i] - 1;
                one = 1;
            }
        }
        return ans + one;
    }
}