class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] cache = new int[arr.length];
        Arrays.fill(cache, -1);
        return dfs(arr, k, arr.length - 1, cache);
    }

    int dfs(int[] arr, int k, int i, int[] cache) {
        if (i < 0)
            return 0;
        if (cache[i] != -1)
            return cache[i];
        int res = 0;
        for (int j = i, mx = 0; j >= 0 && j >= i - k + 1; j--) {
            mx = Math.max(mx, arr[j]);
            res = Math.max(res, dfs(arr, k, j - 1, cache) + mx * (i - j + 1));
        }
        return cache[i] = res;
    }
}