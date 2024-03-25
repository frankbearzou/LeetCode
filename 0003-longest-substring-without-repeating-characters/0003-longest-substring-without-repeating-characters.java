class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int l = 0;
        Set<Character> set = new HashSet<>();
        for (int r = 0; r < s.length(); r++) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l++));
            }
            set.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}