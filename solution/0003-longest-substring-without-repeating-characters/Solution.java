class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int n = s.length();
        int i = 0, j = 0;
        HashSet<Character> set = new HashSet<>();
        
        while (i < n && j < n) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            } else {
                set.add(s.charAt(j));
                res = Math.max(res, j - i + 1);
                j++;
            }
        }
        
        return res;
    }
}
