class Solution {
    int[] piles;
    Map<String, Integer> cache = new HashMap<>();

    public int stoneGameII(int[] piles) {
        this.piles = piles;
        for (int i = piles.length - 2; i >= 0; i--)
            piles[i] += piles[i + 1];
        return dfs(0, 1);
    }

    int dfs(int i, int m) {
        if (i + m * 2 >= piles.length)
            return piles[i];
        String key = i + "_" + m;
        if (cache.containsKey(key))
            return cache.get(key);
        int bob = Integer.MAX_VALUE;
        for (int x = 1; x <= m * 2; x++) {
            bob = Math.min(bob, dfs(i + x, Math.max(m, x)));
        }
        int alice = piles[i] - bob;
        cache.put(key, alice);
        return alice;
    }
}