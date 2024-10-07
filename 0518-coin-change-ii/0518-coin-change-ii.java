class Solution {
    int[] coins;
    int n;
    Integer[][] cache;

    public int change(int amount, int[] coins) {
        this.coins = coins;
        n = coins.length;
        cache = new Integer[amount + 1][n];
        return dfs(amount, 0);
    }

    int dfs(int amount, int i) {
        if (amount == 0)
            return 1;
        if (i == n)
            return 0;
        if (cache[amount][i] != null)
            return cache[amount][i];
        int ways = 0;
        // choose
        if (amount >= coins[i])
            ways += dfs(amount - coins[i], i);
        // not choose
        ways += dfs(amount, i + 1);
        return cache[amount][i] = ways;
    }
}