class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;
        int l = 0, r = 0, ans = 0, len = s.length();
        Set<Character> set = new HashSet<>();
        while (r < len) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}