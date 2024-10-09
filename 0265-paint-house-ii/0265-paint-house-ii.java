class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int m = costs[0].length;
        for (int i = 1; i < n; i++) {
            int min = -1, secondMin = -1;
            for (int j = 0; j < m; j++) {
                if (min == -1 || costs[i - 1][j] <= costs[i - 1][min]) {
                    secondMin = min;
                    min = j;
                } else if (secondMin == -1 || costs[i - 1][j] < costs[i - 1][secondMin]) {
                    secondMin = j;
                }
            }
            for (int j = 0; j < m; j++) {
                if (j != min)
                    costs[i][j] += costs[i - 1][min];
                else
                    costs[i][j] += costs[i - 1][secondMin];
            }
        }
        int min = costs[n - 1][0];
        for (int j = 1; j < m; j++)
            min = Math.min(min, costs[n - 1][j]);
        return min;
    }
}