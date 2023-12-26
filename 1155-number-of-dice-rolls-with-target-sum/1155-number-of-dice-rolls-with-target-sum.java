class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        Map<String, Integer> cache = new HashMap<>();
        return backtracking(n, k, target, cache);
    }

    int backtracking(int n, int k, int target, Map<String, Integer> cache) {
        if (n == 0) {
            return target == 0 ? 1 : 0;
        }
        if (cache.get(n + " " + target) != null)
            return cache.get(n + " " + target);
        int res = 0;
        for (int i = 1; i <= k; i++) {
            res = (res + backtracking(n - 1, k, target - i, cache)) % (1_000_000_000 + 7);
        }
        cache.put(n + " " + target, res);
        return res;
    }
}