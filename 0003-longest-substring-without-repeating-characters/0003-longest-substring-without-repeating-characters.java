class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        char[] arr = s.toCharArray();
        int n = arr.length;
        int l = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int r = 0; r < n; r++) {
            if (map.containsKey(arr[r]))
                l = Math.max(l, map.get(arr[r]));
            map.put(arr[r], r);
            max = Math.max(max, r - l);
        }
        return max;
    }
}