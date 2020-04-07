class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (map.containsKey(key)) {
                i = map.get(key);
                map.clear();
                count = 0;
                continue;
            } else {
                map.put(key, i);
                count++;
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
