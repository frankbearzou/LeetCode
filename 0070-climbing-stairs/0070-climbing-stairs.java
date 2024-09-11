class Solution {
    int[] cache;

    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        cache = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[1] = 1;
        cache[2] = 2;
        return dfs(n);
    }

    int dfs(int n) {
        if (n <= 0)
            return 0;
        if (cache[n] != -1)
            return cache[n];
        cache[n] = dfs(n - 1) + dfs(n - 2);
        return cache[n];
    }
}