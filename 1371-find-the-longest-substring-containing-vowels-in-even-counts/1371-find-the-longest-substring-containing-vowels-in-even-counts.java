class Solution {
    public int findTheLongestSubstring(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('e', 2);
        map.put('i', 4);
        map.put('o', 8);
        map.put('u', 16);
        Map<Integer, Integer> pos = new HashMap<>();
        pos.put(0, -1);
        int mask = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                mask ^= c;
            }
            if (pos.containsKey(mask)) {
                ans = Math.max(ans, i - pos.get(mask));
            } else {
                pos.put(mask, i);
            }
        }
        return ans;
    }
}