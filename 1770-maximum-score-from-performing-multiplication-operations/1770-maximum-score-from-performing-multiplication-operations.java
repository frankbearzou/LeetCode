class Solution {
    int[] nums;
    int[] multipliers;
    int n, m;
    Integer[][] cache;
    
    public int maximumScore(int[] nums, int[] multipliers) {
        this.nums = nums;
        this.multipliers = multipliers;
        n = nums.length;
        m = multipliers.length;
        cache = new Integer[n][m];
        return dfs(0, 0);
    }
    
    int dfs(int l, int i) {
        if (i == m)
            return 0;
        if (cache[l][i] != null)
            return cache[l][i];
        int r = n - 1 - (i - l);
        cache[l][i] = Math.max(nums[l] * multipliers[i] + dfs(l + 1, i + 1),
                              nums[r] * multipliers[i] + dfs(l, i + 1));
        return cache[l][i];
    }
}