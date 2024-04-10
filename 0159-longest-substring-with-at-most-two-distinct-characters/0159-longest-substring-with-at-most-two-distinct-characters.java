class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            while (map.size() > 2) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if (map.get(s.charAt(l)) == 0)
                    map.remove(s.charAt(l));
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}