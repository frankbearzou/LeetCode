class Solution {
    int[] nums;
    int[] multipliers;
    int n;
    int m;
    Integer[][][] cache;

    public int maximumScore(int[] nums, int[] multipliers) {
        this.nums = nums;
        this.multipliers = multipliers;
        n = nums.length;
        m = multipliers.length;
        cache = new Integer[m][m][m];
        return dfs(0, 0, 0);
    }

    int dfs(int l, int r, int k) {
        if (k == m)
            return 0;
        if (cache[l][r][k] != null)
            return cache[l][r][k];
        System.out.println(l + " " + r + " " + k);
        return cache[l][r][k] = Math.max(
            nums[l] * multipliers[k] + dfs(l + 1, r, k + 1), // choose left
            nums[n - 1 - r] * multipliers[k] + dfs(l, r + 1, k + 1)  // choose right
        );
    }
}