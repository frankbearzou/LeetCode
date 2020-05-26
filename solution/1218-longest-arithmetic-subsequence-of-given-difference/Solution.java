class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int v : arr) {
            int val = Math.max(map.getOrDefault(v - difference, 0) + 1, map.getOrDefault(v, 1));
            max = Math.max(max, val);
            map.put(v, val);
        }
        return max;
    }
}
