class Solution {
    Integer[][] cache;
    public int findRotateSteps(String ring, String key) {
        cache = new Integer[ring.length()][key.length()];
        return dfs(ring, key, 0, 0);
    }

    int dfs(String ring, String key, int ringIndex, int keyIndex) {
        if (keyIndex == key.length())
            return 0;
        if (cache[ringIndex][keyIndex] != null)
            return cache[ringIndex][keyIndex];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ring.length(); i++) {
            if (ring.charAt(i) == key.charAt(keyIndex)) {
                int clockwise = Math.abs(i - ringIndex);
                int anticlockwise = ring.length() - clockwise;
                int steps = Math.min(clockwise, anticlockwise);
                int total = steps + 1 + dfs(ring, key, i, keyIndex + 1);
                min = Math.min(min, total);
                cache[ringIndex][keyIndex] = min;
            }
        }
        return min;
    }
}