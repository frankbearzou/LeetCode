class Solution {
    Map<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        return dfs(n);
    }

    int dfs(int n) {
        if (n <= 2)
            return n;
        if (cache.containsKey(n))
            return cache.get(n);
        int ret = dfs(n - 1) + dfs(n - 2);
        cache.put(n, ret);
        return ret;
    }
}