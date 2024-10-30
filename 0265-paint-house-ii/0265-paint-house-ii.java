class Solution {
    int[][] costs;
    int n;
    int k;
    Integer[][] cache;

    public int minCostII(int[][] costs) {
        this.costs = costs;
        n = costs.length;
        k = costs[0].length;
        cache = new Integer[n][k];
        int ans = Integer.MAX_VALUE;
        for (int c = 0; c < k; c++)
            ans = Math.min(ans, dfs(0, c));
        return ans;
    }

    int dfs(int index, int color) {
        if (index == n)
            return 0;
        if (cache[index][color] != null)
            return cache[index][color];
        int sum = Integer.MAX_VALUE;
        for (int c = 0; c < k; c++) {
            if (c == color)
                continue;
            sum = Math.min(sum, costs[index][c] + dfs(index + 1, c));
        }
        return cache[index][color] = sum;
    }
}