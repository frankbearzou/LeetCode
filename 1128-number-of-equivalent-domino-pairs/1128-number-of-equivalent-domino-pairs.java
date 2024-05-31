class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] domino : dominoes) {
            int key = Math.min(domino[0], domino[1]) * 10 + Math.max(domino[0], domino[1]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (int v : map.values()) {
            res += v * (v - 1) / 2;
        }
        return res;
    }
}