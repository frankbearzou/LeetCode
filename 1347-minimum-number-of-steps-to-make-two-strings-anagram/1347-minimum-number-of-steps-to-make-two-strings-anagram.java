class Solution {
    public int minSteps(String s, String t) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            map[c - 'a']--;
        }
        int ans = 0;
        for (int num : map) {
            if (num > 0) {
                ans += num;
            }
        }
        return ans;
    }
}