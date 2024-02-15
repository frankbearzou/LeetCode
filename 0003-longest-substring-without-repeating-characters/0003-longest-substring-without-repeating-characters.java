class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int l = 0;
        int N = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int r = 0; r < N; r++) {
            if (map.containsKey(s.charAt(r))) {
                l = Math.max(l, map.get(s.charAt(r)) + 1);
            }
            map.put(s.charAt(r), r);
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}